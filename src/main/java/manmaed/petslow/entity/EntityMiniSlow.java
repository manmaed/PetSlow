package manmaed.petslow.entity;

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

import java.util.UUID;

/**
 * Created by manmaed on 26/02/2017.
 */
public class EntityMiniSlow extends EntityTameable {


    private int torch = 0;

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

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbtTagCompound) {
        if (nbtTagCompound == null) {
            nbtTagCompound = new NBTTagCompound();
        }
        nbtTagCompound.setInteger("torchCount", this.torch);
        return nbtTagCompound;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        torch = nbtTagCompound.getInteger("torchCount");
    }

    protected void initEntityAI()
    {
        this.aiSit = new EntityAISit(this);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, this.aiSit);
        this.tasks.addTask(2, new EntityAIFollowOwner(this, 1.0D, 4.0F, 2.0F));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true, new Class[0]));
        this.tasks.addTask(4, new EntityAIWander(this, 0.8D,10));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.35D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
    }

    protected void entityInit()
    {
        super.entityInit();
    }

    public void onEntityUpdate() {
        super.onEntityUpdate();
        addtorch(world, this.getPosition());
    }

    protected SoundEvent getSwimSound()
    {

        return SoundEvents.ENTITY_PLAYER_SWIM;
    }

    protected SoundEvent getSplashSound()
    {

        return SoundEvents.ENTITY_PLAYER_SPLASH;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundEvents.ENTITY_PLAYER_HURT;
    }

    protected SoundEvent getDeathSound()
    {
        return SoundHandler.SLOWDEATH;
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 1.0F;
    }

    public void setTamed(boolean tamed)
    {
        super.setTamed(tamed);
    }
        public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
        ItemStack stack = player.getHeldItemMainhand();
        /*LogHelper.info("getLightBrightness: " + world.getLightBrightness(getPosition()) + " - " + "getLight: " + world.getLight(getPosition()) );*/
        //LogHelper.info(this.isSitting() + " " + this.isTamed());
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
        if (this.isTamed())
        {
            if (this.isOwner(player) && !this.world.isRemote && !stack.getItem().equals(Items.APPLE) && !stack.getItem().equals(Items.GOLDEN_APPLE) && !stack.getItem().equals(Item.getItemFromBlock(Blocks.TORCH)))
            {
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
        UUID uuid = this.getOwnerId();

        if(uuid != null) {
            miniSlow.setOwnerId(uuid);
            miniSlow.setTamed(true);

        }
    return miniSlow;
    }

    public boolean canMateWith(EntityAnimal otherAnimal)
    {
        if (otherAnimal == this)
        {
            return false;
        }
        else if (!this.isTamed())
        {
            return false;
        }
        else if (!(otherAnimal instanceof EntityMiniSlow))
        {
            return false;
        }
        else
        {
            EntityMiniSlow miniSlow = (EntityMiniSlow)otherAnimal;

            if (!miniSlow.isTamed())
            {
                return false;
            }
            else if (miniSlow.isSitting())
            {
                return false;
            }
            else
            {
                return this.isInLove() && miniSlow.isInLove();
            }
        }
    }
}
