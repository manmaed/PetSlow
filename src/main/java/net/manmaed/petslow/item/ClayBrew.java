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
public class ClayBrew extends Item {

    private static String tt;

    public ClayBrew(Settings settings, String itemname) {
        super(settings);
        tt = "item.petslow." + itemname + ".tooltip";
    }

    private static String gettooltip() {
        return tt;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void appendTooltip(ItemStack itemStack, World world, List<Text> list, TooltipContext tooltipContext) {
        list.add(new TranslatableText(gettooltip()));
    }
}
