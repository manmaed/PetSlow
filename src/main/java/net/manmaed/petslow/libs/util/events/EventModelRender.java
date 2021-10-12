package net.manmaed.petslow.libs.util.events;

import net.manmaed.petslow.PetSlow;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by manmaed on 03/07/2017.
 */
public class EventModelRender {

    public EventModelRender() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void renderModels(ModelRegistryEvent event) {
        for (Block block : PetSlow.getRegistryHelper().getRegisteredBlocks()) {
            ResourceLocation rl = block.getRegistryName();
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(rl, "inventory"));
        }
        for (Item item : PetSlow.getRegistryHelper().getRegisteredItems()) {
            ResourceLocation rl = item.getRegistryName();
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(rl, "inventory"));
        }
    }
}