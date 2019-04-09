package manmaed.petslow.items;

import manmaed.petslow.entity.EntityMiniSlow;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

/**
 * Created by manmaed on 24/02/2017.
 */
public class SlowSpawn extends Item {

    Random rand = new Random();

    public SlowSpawn(String name) {
        super();
        setUnlocalizedName(name);
        setCreativeTab(CreativeTabs.MISC);
        setMaxStackSize(1);
        setRegistryName(name);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
        if (!worldIn.isRemote) {
            ItemStack itemStack = playerIn.getHeldItem(hand);
            itemStack.shrink(1);
            EntityMiniSlow miniSlow = new EntityMiniSlow(worldIn);
            miniSlow.setLocationAndAngles(playerIn.posX, playerIn.posY, playerIn.posZ, 10, 10);
            worldIn.spawnEntity(miniSlow);
        }
        return super.onItemRightClick(worldIn, playerIn, hand);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("To tame a Mini Slowpoke give it a Slow brew, to heal it give it a Clay brew");
    }


}
