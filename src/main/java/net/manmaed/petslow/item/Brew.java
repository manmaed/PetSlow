package net.manmaed.petslow.item;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by manmaed on 14/09/2019.
 */
public class Brew extends Item {

    public static  String tt;

    public Brew(Settings settings, String itemname) {
        super(settings);
        this.tt = "item.petslow." + itemname + ".tooltip";
    }

    private static String gettooltip() {
        return tt;
    }

    /*@Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity livingEntity, int int_1) {
        if(world.isClient) {
            livingEntity.clearPotionEffects();
        }
        if (livingEntity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) livingEntity;
        }
    }*/

    @Override
    @Environment(EnvType.CLIENT)
    public void appendTooltip(ItemStack itemStack, World world, List<Text> list, TooltipContext tooltipContext) {
        list.add(new TranslatableText(gettooltip()));
    }
}
