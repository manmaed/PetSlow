package manmaed.petslow.blocks;

import manmaed.petslow.entity.EntityBigSlow;
import manmaed.petslow.items.PSItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by manmaed on 15/04/2019.
 */
public class ClawBrewKeg extends Block {
    public ClawBrewKeg(String name) {
        super(Material.WOOD);
        setCreativeTab(CreativeTabs.DECORATIONS);
        setHarvestLevel("pickaxe",2);
        setHardness(3.0F);
        setResistance(5.0F);
        setUnlocalizedName(name);
        setRegistryName(name);
    }
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if(!worldIn.isRemote) {
            ItemStack itemStack = playerIn.getHeldItem(hand);
            if(itemStack.getItem() == PSItems.slowbrew) {
                itemStack.shrink(1);
                worldIn.setBlockToAir(pos);
                EntityBigSlow bossSlow = new EntityBigSlow(worldIn);
                bossSlow.setLocationAndAngles(pos.getX(), pos.getY(), pos.getZ(), 10, 10);
                worldIn.spawnEntity(new EntityLightningBolt(worldIn, pos.getX(), pos.getY(), pos.getZ(), false));
                worldIn.spawnEntity(bossSlow);
                for (EntityPlayerMP entityplayermp : worldIn.getEntitiesWithinAABB(EntityPlayerMP.class, bossSlow.getEntityBoundingBox().grow(50.0D)))
                {
                    CriteriaTriggers.SUMMONED_ENTITY.trigger(entityplayermp, bossSlow);
                }
                return true;
            }
            if(itemStack.getItem() == PSItems.mug) {
                itemStack.shrink(1);
                playerIn.addItemStackToInventory(new ItemStack(PSItems.claybrew));
            }
        }
        return false;
    }
}
