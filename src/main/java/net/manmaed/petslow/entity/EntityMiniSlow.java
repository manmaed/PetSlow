package net.manmaed.petslow.entity;

import net.manmaed.petslow.items.PSItems;
import net.manmaed.petslow.libs.SoundHandler;
import net.minecraft.block.Blocks;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.ForgeEventFactory;

import javax.annotation.Nullable;

/**
 * Created by manmaed on 26/02/2017.
 */
public class EntityMiniSlow extends TameableEntity {

    private static final DataParameter<Integer> RETURN_COOLDOWN = EntityDataManager.defineId(EntityMiniSlow.class, DataSerializers.INT);
    private static final DataParameter<Integer> STAY_COOLDOWN = EntityDataManager.defineId(EntityMiniSlow.class, DataSerializers.INT);
    private static final DataParameter<Boolean> AWAY = EntityDataManager.defineId(EntityMiniSlow.class, DataSerializers.BOOLEAN);
    private int torch = 0;


    protected EntityMiniSlow(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
        this.setTame(false);
    }

    protected void registerGoals() {
        //Goal Selectors
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(2, new SitGoal(this));
        this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(4, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        //Target Selectors
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this).setAlertOthers(EntityMiniSlow.class));
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.D)
                .add(Attributes.MOVEMENT_SPEED, 0.35D);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(RETURN_COOLDOWN, -1);
        this.entityData.define(STAY_COOLDOWN, -1);
        this.entityData.define(AWAY, false);
    }

    private void addtorch(World world, BlockPos pos) {
        if (!world.isClientSide) {
            if (isTame() && !isOrderedToSit()) {
                if (world.getLightEmission(pos) < 3) {
                    if (Blocks.AIR.defaultBlockState() != world.getBlockState(pos.below())) {
                        //LogHelper.info(torch);
                        if (torch >= 1) {
                            torch--;
                            /*world.setBlock(pos, Blocks.TORCH.getStateForPlacement());*/
                            playSound(SoundEvents.NOTE_BLOCK_BELL, getSoundVolume(), 0.01F);
                        }
                    }
                }
            }
        }
    }

    private void shouldafk(World world) {
        if (!world.isClientSide()) {
            if (isTame() && isOrderedToSit()) {
                if (this.entityData.get(STAY_COOLDOWN) == 0 && this.entityData.get(RETURN_COOLDOWN) == -1) {
                    int bool = this.level.random.nextInt(2500) + 100;
                    this.entityData.set(STAY_COOLDOWN, -1);
                    this.entityData.set(RETURN_COOLDOWN, bool);
                    setAway(false);
                }
                if (this.entityData.get(RETURN_COOLDOWN) == 0 && this.entityData.get(STAY_COOLDOWN) == -1) {
                    int bool = this.level.random.nextInt(25000) + 1000;
                    this.entityData.set(RETURN_COOLDOWN, -1);
                    this.entityData.set(STAY_COOLDOWN, bool);
                    setAway(true);
                }
            }
        }
    }

    private void countdown(World world) {
        if (this.isTame() && this.isOrderedToSit()) {
            if (!world.isClientSide()) {
                if (this.entityData.get(STAY_COOLDOWN) != -1) {
                    int sc = this.entityData.get(STAY_COOLDOWN);
                    int nsc = --sc;
                    this.entityData.set(STAY_COOLDOWN, nsc);
                }
                if (this.entityData.get(RETURN_COOLDOWN) != -1) {
                    int rc = this.entityData.get(RETURN_COOLDOWN);
                    int nrc = --rc;
                    this.entityData.set(RETURN_COOLDOWN, nrc);
                }
            }
        }
    }

    private void chooseafk(World world) {
        if (!world.isClientSide()) {
            if (this.entityData.get(STAY_COOLDOWN) == -1 && this.entityData.get(RETURN_COOLDOWN) == -1) {
                boolean tobeornottobe = world.random.nextBoolean();
                if (tobeornottobe) {
                    this.entityData.set(RETURN_COOLDOWN, (this.level.random.nextInt(2500) + 100));
                    this.entityData.set(STAY_COOLDOWN, -1);
                    setAway(false);
                } else {
                    this.entityData.set(STAY_COOLDOWN, (this.level.random.nextInt(25000) + 1000));
                    this.entityData.set(RETURN_COOLDOWN, -1);
                    setAway(true);
                }
            }
        }
    }

    public void addAdditionalSaveData(CompoundNBT nbtTagCompound) {
        super.addAdditionalSaveData(nbtTagCompound);
        nbtTagCompound.putInt("torchCount", this.torch);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readAdditionalSaveData(CompoundNBT nbtTagCompound) {
        super.readAdditionalSaveData(nbtTagCompound);
        if (nbtTagCompound.contains("torchCount")) {
            torch = nbtTagCompound.getInt("torchCount");
        }
    }



    @Override
    protected SoundEvent getSwimHighSpeedSplashSound() {
        return SoundEvents.PLAYER_SPLASH_HIGH_SPEED;
    }

    @Override
    protected SoundEvent getSwimSplashSound() {
        return SoundEvents.PLAYER_SPLASH;
    }

    @Override
    protected SoundEvent getSwimSound() {
        return SoundEvents.PLAYER_SWIM;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.PLAYER_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundHandler.SLOWDEATH;
    }

    @Override
    public void setTame(boolean tamed) {
        super.setTame(tamed);
    }

    @Override
    public void tick() {
        super.tick();
        addtorch(level, this.getOnPos());
        getAway();
        chooseafk(level);
        shouldafk(level);
        countdown(level);
    }

    //Slow Brew - Tames
    //Clay Brew - Heals

    @Override
    public ActionResultType mobInteract(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        Item item = itemStack.getItem();
        if (this.level.isClientSide) {
            boolean flag = this.isOwnedBy(player) || this.isTame() || item == PSItems.slow_Brew.get() && !this.isTame();
            return flag ? ActionResultType.CONSUME : ActionResultType.PASS;
        } else {
            if (this.isTame()) {
                if (item == PSItems.clay_Brew.get() && this.getHealth() < this.getMaxHealth()) {
                    if (!player.isCreative()) {
                        itemStack.shrink(1);
                        player.inventory.add(new ItemStack(PSItems.mug.get()));
                    }
                    playSound(SoundEvents.GENERIC_DRINK, getSoundVolume(), 1F);
                    if (this.random.nextInt(25) == 0) {
                        playSound(SoundEvents.PLAYER_BURP, getSoundVolume(), 1F);
                    }
                    this.heal(3.0F);
                    return ActionResultType.SUCCESS;
                }
                if (item == Items.TORCH) {
                    torch++;
                    itemStack.shrink(1);
                    playSound(SoundEvents.GENERIC_EAT, getSoundVolume(), 1F);
                    if (this.random.nextInt(25) == 0) {
                        playSound(SoundEvents.PLAYER_BURP, getSoundVolume(), 1F);
                    }
                }
                if (!(item instanceof DyeItem)) {
                    ActionResultType actionresulttype = super.mobInteract(player, hand);
                    if ((!actionresulttype.consumesAction() || this.isBaby()) && this.isOwnedBy(player)) {
                        this.setOrderedToSit(!this.isOrderedToSit());
                        this.jumping = false;
                        this.navigation.stop();
                        return ActionResultType.SUCCESS;
                    }
                    return actionresulttype;
                }
            } else if (item == PSItems.slow_Brew.get()) {
                if (!player.isCreative()) {
                    itemStack.shrink(1);
                    player.inventory.add(new ItemStack(PSItems.mug.get()));
                }
                playSound(SoundEvents.GENERIC_DRINK, getSoundVolume(), 1F);
                if (this.random.nextInt(25) == 0) {
                    playSound(SoundEvents.PLAYER_BURP, getSoundVolume(), 1F);
                }
                if (this.random.nextInt(3) == 0 && !ForgeEventFactory.onAnimalTame(this, player)) {
                    this.tame(player);
                    this.navigation.stop();
                    this.setOrderedToSit(true);
                    this.level.broadcastEntityEvent(this, (byte)7);
                } else {
                    this.level.broadcastEntityEvent(this, (byte)6);
                }
                return ActionResultType.SUCCESS;
            }
            return super.mobInteract(player, hand);
        }
    }

    //Away Stuff
    public boolean getAway() {
        return this.entityData.get(AWAY);
    }

    private void setAway(boolean b) {
        this.entityData.set(AWAY, b);
    }


    @Nullable
    @Override
    public AgeableEntity getBreedOffspring(ServerWorld serverWorld, AgeableEntity ageableEntity) {
        return null;
    }
}