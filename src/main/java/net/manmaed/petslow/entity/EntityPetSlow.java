package net.manmaed.petslow.entity;

import net.manmaed.petslow.PetSlow;
import net.manmaed.petslow.item.PSItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.UUID;

/**
 * Created by manmaed on 14/09/2019.
 */
public class EntityPetSlow extends TameableEntity {

    private static final int NOT_IN_USE = -1;
    private static final TrackedData<Integer> RETURN_COOLDOWN;
    private static final TrackedData<Integer> STAY_COOLDOWN;
    private static final TrackedData<Boolean> AWAY;
    private int torch = 0;

    protected EntityPetSlow(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
        this.setTamed(false);
    }

    protected void initGoals() {
        this.sitGoal = new SitGoal(this);
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, this.sitGoal);
        this.goalSelector.add(3, new FollowOwnerGoal(this, 1D, 4F, 2F));
        this.goalSelector.add(4, new WanderAroundGoal(this, 0.8D, 10));
        this.targetSelector.add(1, new RevengeGoal(this, new Class[0]).setGroupRevenge(new Class[0]));
    }

    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.35D);
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(20.0D);
    }

    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(RETURN_COOLDOWN, NOT_IN_USE);
        this.dataTracker.startTracking(STAY_COOLDOWN, NOT_IN_USE);
        this.dataTracker.startTracking(AWAY, false);
    }

    static {
        RETURN_COOLDOWN = DataTracker.registerData(EntityPetSlow.class, TrackedDataHandlerRegistry.INTEGER);
        STAY_COOLDOWN = DataTracker.registerData(EntityPetSlow.class, TrackedDataHandlerRegistry.INTEGER);
        AWAY = DataTracker.registerData(EntityPetSlow.class, TrackedDataHandlerRegistry.BOOLEAN);
    }

    @Override
    public void tick() {
        super.tick();
        addtorch(world, this.getBlockPos());
        getAway();
        chooseafk(world);
        shouldafk(world);
        countdown(world);
    }

    private void addtorch(World world, BlockPos pos) {
        if (world.isClient) {
            if (isTamed() && !isSitting()) {
                //LogHelper.info(world.getAmbientDarkness() + " : " + world.getLightLevel(pos));
                if (world.getLightLevel(pos) < 3) {
                    if (Blocks.AIR.getDefaultState() != world.getBlockState(pos.down())) {
                        //LogHelper.info(torch);
                        if (torch >= 1) {
                            torch--;
                            world.setBlockState(pos, Blocks.TORCH.getDefaultState());
                            playSound(SoundEvents.BLOCK_NOTE_BLOCK_BELL, getSoundVolume(), 0.01F);
                        }
                    }
                }
            }
        }
    }

    private void shouldafk(World world) {
        if (world.isClient) {
            if (isTamed() && isSitting()) {
                if (this.dataTracker.get(STAY_COOLDOWN) == 0 && this.dataTracker.get(RETURN_COOLDOWN) == -1) {
                    int bool = this.world.random.nextInt(2500) + 100;
                    this.dataTracker.set(STAY_COOLDOWN, NOT_IN_USE);
                    this.dataTracker.set(RETURN_COOLDOWN, bool);
                    setAway(false);
                }
                if (this.dataTracker.get(RETURN_COOLDOWN) == 0 && this.dataTracker.get(STAY_COOLDOWN) == -1) {
                    int bool = this.world.random.nextInt(25000) + 1000;
                    this.dataTracker.set(RETURN_COOLDOWN, NOT_IN_USE);
                    this.dataTracker.set(STAY_COOLDOWN, bool);
                    setAway(true);
                }
            }
        }
    }

    private void countdown(World world) {
        if (this.isTamed() && this.isSitting()) {
            if (world.isClient) {
                if (this.dataTracker.get(STAY_COOLDOWN) != NOT_IN_USE) {
                    int sc = this.dataTracker.get(STAY_COOLDOWN);
                    int nsc = --sc;
                    this.dataTracker.set(STAY_COOLDOWN, nsc);
                }
                if (this.dataTracker.get(RETURN_COOLDOWN) != NOT_IN_USE) {
                    int rc = this.dataTracker.get(RETURN_COOLDOWN);
                    int nrc = --rc;
                    this.dataTracker.set(RETURN_COOLDOWN, nrc);
                }
            }
        }
    }

    private void chooseafk(World world) {
        if (world.isClient) {
            if (this.dataTracker.get(STAY_COOLDOWN) == -1 && this.dataTracker.get(RETURN_COOLDOWN) == -1) {
                boolean tobeornottobe = world.random.nextBoolean();
                if (tobeornottobe) {
                    this.dataTracker.set(RETURN_COOLDOWN, (this.world.random.nextInt(2500) + 100));
                    this.dataTracker.set(STAY_COOLDOWN, NOT_IN_USE);
                    setAway(false);
                } else {
                    this.dataTracker.set(STAY_COOLDOWN, (this.world.random.nextInt(25000) + 1000));
                    this.dataTracker.set(RETURN_COOLDOWN, NOT_IN_USE);
                    setAway(true);
                }
            }
        }
    }

    public void writeCustomDataToTag(CompoundTag compoundTag) {
        super.writeCustomDataToTag(compoundTag);
        compoundTag.putInt("torchCount", torch);
    }

    public void readCustomDataFromTag(CompoundTag compoundTag) {
        super.readCustomDataFromTag(compoundTag);
        torch = compoundTag.getInt("torchCount");
    }

    @Override
    protected SoundEvent getSwimSound() {
        return SoundEvents.ENTITY_PLAYER_SWIM;
    }

    @Override
    protected SoundEvent getSplashSound() {
        return SoundEvents.ENTITY_PLAYER_SPLASH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.ENTITY_PLAYER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return PetSlow.SLOW_DEATH;
    }

    @Override
    public void setTamed(boolean tamed) {
        super.setTamed(tamed);
    }

    //Away Stuff
    public boolean getAway() {
        return this.dataTracker.get(AWAY);
    }

    private void setAway(boolean b) {
        this.dataTracker.set(AWAY, b);
    }

    @Override
    public boolean cannotDespawn() {
        return true;
    }

    @Override
    public boolean interactMob(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        if(stack.getItem().equals(Items.NAME_TAG)) {
            this.setCustomName(stack.getName());
        }
        if (stack.getItem() == Blocks.TORCH.asItem() && stack.getItem() == Items.TORCH) {
            torch++;
            stack.decrement(1);
            playSound(SoundEvents.ENTITY_GENERIC_EAT, getSoundVolume(), 1.00F);
            if (this.random.nextInt(25) == 0) {
                playSound(SoundEvents.ENTITY_PLAYER_BURP, getSoundVolume(), 1F);
            }
        }
        if (this.isTamed()) {
            if (this.isOwner(player)) {
                if (!this.world.isClient) {
                    if (stack.getItem() != PSItems.slowbrew) {
                        if (stack.getItem() != PSItems.claybrew) {
                            if (stack.getItem() != Blocks.TORCH.asItem()) {
                                if (stack.getItem() != Items.TORCH.asItem()) {
                                    this.sitGoal.setEnabledWithOwner(!this.isSitting());
                                    this.jumping = false;
                                    this.navigation.stop();
                                }
                            }
                        }
                    }
                }
            }
            if (stack.getItem() == PSItems.claybrew && getHealth() < 20.0F) {
                if (!player.abilities.creativeMode) {
                    stack.decrement(1);
                    player.inventory.insertStack(new ItemStack(PSItems.mug));
                }
                playSound(SoundEvents.ENTITY_GENERIC_DRINK, getSoundVolume(), 1.00F);
                if (this.random.nextInt(25) == 0) {
                    playSound(SoundEvents.ENTITY_PLAYER_BURP, getSoundVolume(), 1F);
                }
                this.heal(3.0F);
                return true;
            }
        } else if (!this.isTamed()) {
            if (stack.getItem() == PSItems.slowbrew) {
                if (!player.abilities.creativeMode) {
                    stack.decrement(1);
                    player.inventory.insertStack(new ItemStack(PSItems.mug));
                }
                playSound(SoundEvents.ENTITY_GENERIC_DRINK, getSoundVolume(), 1.00F);
                if (this.random.nextInt(25) == 0) {
                    playSound(SoundEvents.ENTITY_PLAYER_BURP, getSoundVolume(), 1F);
                }

                if (!this.world.isClient) {
                    if (this.random.nextInt(3) == 0) {
                        this.setOwner(player);
                        this.navigation.stop();
                        this.sitGoal.setEnabledWithOwner(true);
                        this.setHealth(20.0F);
                        this.showEmoteParticle(true);
                        this.world.sendEntityStatus(this, (byte) 7);
                    } else {
                        this.showEmoteParticle(false);
                        this.world.sendEntityStatus(this, (byte) 6);
                    }
                }

            }
            return true;
        }
        return super.interactMob(player, hand);
    }

    @Override
    public PassiveEntity createChild(PassiveEntity passiveEntity) {
        EntityPetSlow petSlow = new EntityPetSlow((PSEntitys.petslow), this.world);
        UUID uuid = this.getOwnerUuid();
        if (uuid != null){
            petSlow.setOwnerUuid(uuid);
            petSlow.setTamed(true);
        }
        return petSlow;
    }
}
