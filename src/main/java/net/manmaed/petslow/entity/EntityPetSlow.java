package net.manmaed.petslow.entity;

import net.manmaed.petslow.sounds.PSSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * Created by manmaed on 26/02/2017.
 */
public class EntityPetSlow extends TamableAnimal {

    private static final EntityDataAccessor<Integer> RETURN_COOLDOWN = SynchedEntityData.defineId(EntityPetSlow.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> STAY_COOLDOWN = SynchedEntityData.defineId(EntityPetSlow.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> AWAY = SynchedEntityData.defineId(EntityPetSlow.class, EntityDataSerializers.BOOLEAN);
    private int torch = 0;
    private static final int NOT_IN_USE = -1;

    protected EntityPetSlow(EntityType<? extends TamableAnimal> type, Level level) {
        super(type, level);
        this.setTame(false);
    }

    @Override
    protected void registerGoals() {
        //Goal Selectors
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(4, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        //Target Selectors
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setAlertOthers());
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(RETURN_COOLDOWN, NOT_IN_USE);
        this.entityData.define(STAY_COOLDOWN, NOT_IN_USE);
        this.entityData.define(AWAY, false);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt("torchCount", this.torch);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if (compoundTag.contains("torchCount")) {
            torch = compoundTag.getInt("torchCount");
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    //Away Stuff
    public boolean isAway() {
        return this.entityData.get(AWAY);
    }

    private void setAway(boolean b) {
        this.entityData.set(AWAY, b);
    }

    public boolean onChair() {
        return this.isInSittingPose();
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        EntityPetSlow slowpoke = new EntityPetSlow((PSEntityTypes.SLOWPOKE.get()), serverLevel);
        UUID uuid = this.getOwnerUUID();
        if (uuid != null) {
            slowpoke.setOwnerUUID(uuid);
            slowpoke.setTame(true);
        }
        return slowpoke;
    }

    //Sounds
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
    protected SoundEvent getHurtSound(DamageSource p_21239_) {
        return SoundEvents.PLAYER_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return PSSounds.SLOW_DEATH.get();
    }

    //This is Where the Magic Happens

    private void addtorch(Level world, BlockPos pos) {
        if (!this.level.isClientSide) {
            if (isTame() && !isOrderedToSit()) {
                if (world.getLightEmission(pos) < 3) {
                    if (Blocks.AIR.defaultBlockState() != world.getBlockState(pos.below())) {
                        //LogHelper.info(torch);
                        if (torch >= 1) {
                            torch--;
                            world.setBlockAndUpdate(pos.above(), Blocks.TORCH.defaultBlockState());
                            playSound(SoundEvents.NOTE_BLOCK_BELL, getSoundVolume(), 0.01F);
                        }
                    }
                }
            }
        }
    }

    private void shouldafk(Level world) {
        if (!world.isClientSide) {
            if (isTame() && isOrderedToSit()) {
                if (this.entityData.get(STAY_COOLDOWN) == 0 && this.entityData.get(RETURN_COOLDOWN) == NOT_IN_USE) {
                    int bool = this.level.random.nextInt(2500) + 100;
                    this.entityData.set(STAY_COOLDOWN, NOT_IN_USE);
                    this.entityData.set(RETURN_COOLDOWN, bool);
                    setAway(false);
                }
                if (this.entityData.get(RETURN_COOLDOWN) == 0 && this.entityData.get(STAY_COOLDOWN) == NOT_IN_USE) {
                    int bool = this.level.random.nextInt(25000) + 1000;
                    this.entityData.set(RETURN_COOLDOWN, NOT_IN_USE);
                    this.entityData.set(STAY_COOLDOWN, bool);
                    setAway(true);
                }
            }
        }
    }

    private void countdown(Level world) {
        if (this.isTame() && this.isOrderedToSit()) {
            if (!world.isClientSide) {
                if (this.entityData.get(STAY_COOLDOWN) != NOT_IN_USE) {
                    int sc = this.entityData.get(STAY_COOLDOWN);
                    int nsc = --sc;
                    this.entityData.set(STAY_COOLDOWN, nsc);
                }
                if (this.entityData.get(RETURN_COOLDOWN) != NOT_IN_USE) {
                    int rc = this.entityData.get(RETURN_COOLDOWN);
                    int nrc = --rc;
                    this.entityData.set(RETURN_COOLDOWN, nrc);
                }
            }
        }
    }

    private void chooseafk(Level world) {
        if (!world.isClientSide) {
            if (this.entityData.get(STAY_COOLDOWN) == NOT_IN_USE && this.entityData.get(RETURN_COOLDOWN) == NOT_IN_USE) {
                boolean tobeornottobe = world.random.nextBoolean();
                if (tobeornottobe) {
                    this.entityData.set(RETURN_COOLDOWN, (this.level.random.nextInt(2500) + 100));
                    this.entityData.set(STAY_COOLDOWN, NOT_IN_USE);
                    setAway(false);
                } else {
                    this.entityData.set(STAY_COOLDOWN, (this.level.random.nextInt(25000) + 1000));
                    this.entityData.set(RETURN_COOLDOWN, NOT_IN_USE);
                    setAway(true);
                }
            }
        }
    }

    @Override
    public void tick() {
        super.tick();

    }
}

//Sounds


/*public class EntityMiniSlow*//* extends TameableEntity*/

   /*



    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(RETURN_COOLDOWN, NOT_IN_USE);
        this.entityData.define(STAY_COOLDOWN, NOT_IN_USE);
        this.entityData.define(AWAY, false);
    }

    private void addtorch(World world, BlockPos pos) {
        if (!this.level.isClientSide) {
            if (isTame() && !isOrderedToSit()) {
                if (world.getLightEmission(pos) < 3) {
                    if (Blocks.AIR.defaultBlockState() != world.getBlockState(pos.below())) {
                        //LogHelper.info(torch);
                        if (torch >= 1) {
                            torch--;
                            world.setBlockAndUpdate(pos.above(), Blocks.TORCH.defaultBlockState());
                            playSound(SoundEvents.NOTE_BLOCK_BELL, getSoundVolume(), 0.01F);
                        }
                    }
                }
            }
        }
    }

    private void shouldafk(World world) {
        if (!world.isClientSide) {
            if (isTame() && isOrderedToSit()) {
                if (this.entityData.get(STAY_COOLDOWN) == 0 && this.entityData.get(RETURN_COOLDOWN) == NOT_IN_USE) {
                    int bool = this.level.random.nextInt(2500) + 100;
                    this.entityData.set(STAY_COOLDOWN, NOT_IN_USE);
                    this.entityData.set(RETURN_COOLDOWN, bool);
                    setAway(false);
                }
                if (this.entityData.get(RETURN_COOLDOWN) == 0 && this.entityData.get(STAY_COOLDOWN) == NOT_IN_USE) {
                    int bool = this.level.random.nextInt(25000) + 1000;
                    this.entityData.set(RETURN_COOLDOWN, NOT_IN_USE);
                    this.entityData.set(STAY_COOLDOWN, bool);
                    setAway(true);
                }
            }
        }
    }

    private void countdown(World world) {
        if (this.isTame() && this.isOrderedToSit()) {
            if (!world.isClientSide) {
                if (this.entityData.get(STAY_COOLDOWN) != NOT_IN_USE) {
                    int sc = this.entityData.get(STAY_COOLDOWN);
                    int nsc = --sc;
                    this.entityData.set(STAY_COOLDOWN, nsc);
                }
                if (this.entityData.get(RETURN_COOLDOWN) != NOT_IN_USE) {
                    int rc = this.entityData.get(RETURN_COOLDOWN);
                    int nrc = --rc;
                    this.entityData.set(RETURN_COOLDOWN, nrc);
                }
            }
        }
    }

    private void chooseafk(World world) {
        if (!world.isClientSide) {
            if (this.entityData.get(STAY_COOLDOWN) == NOT_IN_USE && this.entityData.get(RETURN_COOLDOWN) == NOT_IN_USE) {
                boolean tobeornottobe = world.random.nextBoolean();
                if (tobeornottobe) {
                    this.entityData.set(RETURN_COOLDOWN, (this.level.random.nextInt(2500) + 100));
                    this.entityData.set(STAY_COOLDOWN, NOT_IN_USE);
                    setAway(false);
                } else {
                    this.entityData.set(STAY_COOLDOWN, (this.level.random.nextInt(25000) + 1000));
                    this.entityData.set(RETURN_COOLDOWN, NOT_IN_USE);
                    setAway(true);
                }
            }
        }
    }

    public void addAdditionalSaveData(CompoundNBT nbtTagCompound) {
        super.addAdditionalSaveData(nbtTagCompound);
        nbtTagCompound.putInt("torchCount", this.torch);
    }

    *//**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     *//*
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
        return PSSounds.SLOW_DEATH.get();
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
        if (!this.level.isClientSide) {
            boolean flag = this.isOwnedBy(player) || this.isTame() || item == PSItems.SLOW_BREW.get() && !this.isTame();
            return flag ? ActionResultType.CONSUME : ActionResultType.PASS;
        } else {
            if (this.isTame()) {
                if (item == PSItems.CLAY_BREW.get() && this.getHealth() < this.getMaxHealth()) {
                    if (!player.abilities.instabuild) {
                        itemStack.shrink(1);
                        player.inventory.add(new ItemStack(PSItems.MUG.get()));
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
                    ActionResultType actionresulttype = super.mobInteract(player, hand);
                    if ((!actionresulttype.consumesAction() || this.isBaby()) && this.isOwnedBy(player)) {
                        this.setOrderedToSit(!this.isOrderedToSit());
                        this.jumping = false;
                        this.navigation.stop();
                        LogHelper.warn(this.isOrderedToSit() + " " + this.isSleeping());
                        return ActionResultType.SUCCESS;
                    }
                    return actionresulttype;
            } else if (item == PSItems.SLOW_BREW.get()) {
                if (!player.abilities.instabuild) {
                    itemStack.shrink(1);
                    player.inventory.add(new ItemStack(PSItems.MUG.get()));
                }
                playSound(SoundEvents.GENERIC_DRINK, getSoundVolume(), 1F);
                if (this.random.nextInt(25) == 0) {
                    playSound(SoundEvents.PLAYER_BURP, getSoundVolume(), 1F);
                }
                if (this.random.nextInt(3) == 0 && !ForgeEventFactory.onAnimalTame(this, player)) {
                    this.tame(player);
                    this.navigation.stop();
                    this.setOrderedToSit(true);
                    this.level.broadcastEntityEvent(this, (byte) 7);
                } else {
                    this.level.broadcastEntityEvent(this, (byte) 6);
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
*/