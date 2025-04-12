package net.manmaed.petslow.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

/**
 * Created by manmaed on 09/04/2019.
 */
public class Mug extends Item {

    public Mug() {
        super(new Properties());
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext tooltipContext, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(Component.translatable("item.petslow.mug.tooltip"));
    }
}
