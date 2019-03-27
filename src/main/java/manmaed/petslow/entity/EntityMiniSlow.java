package manmaed.petslow.entity;

import manmaed.petslow.libs.LogHelper;
import manmaed.petslow.libs.SoundHandler;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by manmaed on 26/02/2017.
 */
public class EntityMiniSlow extends EntityTameable {

    private static final int NOT_IN_USE = -1;

    private int torch = 0;
    private boolean isAway = false;

    private int returnCooldown = NOT_IN_USE;
    private int stayCooldown = NOT_IN_USE;

    public EntityMiniSlow(World worldIn) {
        super(worldIn);
        this.setSize(0.5F, 1.0F);
        this.setTamed(false);
    }

    private void addtorch(World world, BlockPos pos) {
        if(!world.isRemote) {
            if(isTamed() && !isSitting()) {
                if (world.getLight(pos) < 3) {
                    if(Blocks.AIR.getDefaultState() != world.getBlockState(pos.down())) {
                        //LogHelper.info(torch);
                        if (torch >= 1) {
                            torch--;
                            world.setBlockState(pos, Blocks.TORCH.getDefaultState());
                            playSound(SoundEvents.BLOCK_NOTE_BELL, getSoundVolume(), 0.01F);
                        }
                    }
                }
            }
        }
    }
    private void shouldafk(World world) {
        if (!world.isRemote) {
            if (isTamed() && isSitting()) {
                if (stayCooldown == 0 && returnCooldown == -1) {
                    int bool = this.world.rand.nextInt(2500) + 100;
                    this.returnCooldown = bool;
                    this.stayCooldown = NOT_IN_USE;
                    setAway(false);
                }
                if (returnCooldown == 0 && stayCooldown == -1) {
                    int bool = this.world.rand.nextInt(25000) + 1000;
                    this.stayCooldown = bool;
                    this.returnCooldown = NOT_IN_USE;
                    setAway(true);
                }
            }
        }
    }

    private void countdown(World world) {
        if (this.isTamed() && this.isSitting()) {
            if (!world.isRemote) {
                if (stayCooldown != NOT_IN_USE) {
                    this.stayCooldown--;
                }
                if (returnCooldown != NOT_IN_USE) {
                    this.returnCooldown--;
                }
            }
        }
    }

    private void chooseafk(World world) {
        if (!world.isRemote) {
            if (stayCooldown == -1 && returnCooldown == -1) {
                boolean tobeornottobe = world.rand.nextBoolean();
                if (tobeornottobe) {
                    this.returnCooldown = this.world.rand.nextInt(2500) + 100;
                    this.stayCooldown = NOT_IN_USE;
                    setAway(false);
                } else {
                    this.stayCooldown = this.world.rand.nextInt(25000) + 1000;
                    this.returnCooldown = NOT_IN_USE;
                    setAway(true);
                }
            }
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);
        nbtTagCompound.setInteger("torchCount", this.torch);
        nbtTagCompound.setBoolean("slowAway", this.isAway);
        nbtTagCompound.setInteger("returnCooldown", this.returnCooldown);
        nbtTagCompound.setInteger("stayCooldown", this.stayCooldown);

        return nbtTagCompound;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);
        torch = nbtTagCompound.getInteger("torchCount");
        isAway = nbtTagCompound.getBoolean("slowAway");
        returnCooldown = nbtTagCompound.getInteger("returnCooldown");
        stayCooldown = nbtTagCompound.getInteger("stayCooldown");


    }

    @Override
    protected void initEntityAI() {
        this.aiSit = new EntityAISit(this);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, this.aiSit);
        this.tasks.addTask(2, new EntityAIFollowOwner(this, 1.0D, 4.0F, 2.0F));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true, new Class[0]));
        this.tasks.addTask(4, new EntityAIWander(this, 0.8D,10));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.35D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
    }

    @Override
    public void onEntityUpdate() {
        super.onEntityUpdate();
        addtorch(world, this.getPosition());
        getAway();
        chooseafk(world);
        shouldafk(world);
        countdown(world);
        LogHelper.info("stayCooldown: " + stayCooldown + " returnCooldown: " + returnCooldown + " Away:" + this.getAway());
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
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_PLAYER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundHandler.SLOWDEATH;
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    @Override
    protected float getSoundVolume() {
        return 1.0F;
    }

    @Override
    public void setTamed(boolean tamed) {
        super.setTamed(tamed);
    }

    //Away Stuff
    public boolean getAway() {
        return isAway;
    }
    private void setAway(boolean b){
        this.isAway = b;
    }

    @Override
    protected boolean canDespawn() {
        return false;
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
        ItemStack stack = player.getHeldItemMainhand();
        if(stack.getItem().equals(Items.NAME_TAG)) {
            this.setCustomNameTag(stack.getDisplayName());
        }
        if(stack.getItem().equals(Item.getItemFromBlock(Blocks.TORCH))) {
            torch++;
            stack.shrink(1);
            playSound(SoundEvents.ENTITY_GENERIC_EAT, getSoundVolume(), 1.00F);
            if(this.rand.nextInt(25) == 0 ){
                playSound(SoundEvents.ENTITY_PLAYER_BURP, getSoundVolume(), 1F);
            }
        }
        if (this.isTamed()) {
            if (this.isOwner(player) && !this.world.isRemote && !stack.getItem().equals(Items.APPLE) && !stack.getItem().equals(Items.GOLDEN_APPLE) && !stack.getItem().equals(Item.getItemFromBlock(Blocks.TORCH))) {
                this.aiSit.setSitting(!this.isSitting());
                this.isJumping = false;
                this.navigator.clearPath();
            }
            if(stack.getItem() == Items.GOLDEN_APPLE && getHealth() < 20.0F) {
                if (!player.capabilities.isCreativeMode) {
                    stack.shrink(1);
                }
                this.heal(3.0F);
                return true;
            }
        }
        else if (!this.isTamed()) {
            if (stack.getItem() == Items.APPLE ){
                if (!player.capabilities.isCreativeMode) {
                    stack.shrink(1);
                }

                if (!this.world.isRemote) {
                    if (this.rand.nextInt(3) == 0) {
                        this.setTamedBy(player);
                        this.navigator.clearPath();
                        this.aiSit.setSitting(true);
                        this.setHealth(20.0F);
                        this.playTameEffect(true);
                        this.world.setEntityState(this, (byte) 7);
                    } else {
                        this.playTameEffect(false);
                        this.world.setEntityState(this, (byte) 6);
                    }
                }

            }
            return true;
        }
        return super.processInteract(player, hand);
    }

    @Override
    public EntityMiniSlow createChild(EntityAgeable ageable) {
        EntityMiniSlow miniSlow = new EntityMiniSlow(this.world);
        return miniSlow;
    }

    @Override
    public boolean canMateWith(EntityAnimal otherAnimal) {
        return false;
    }
}