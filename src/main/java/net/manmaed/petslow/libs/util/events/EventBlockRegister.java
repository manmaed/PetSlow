package net.manmaed.petslow.libs.util.events;

import net.manmaed.petslow.PetSlow;
import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by manmaed on 03/07/2017.
 */
public class EventBlockRegister {

    public EventBlockRegister() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        for (Block block : PetSlow.getRegistryHelper().getRegisteredBlocks()) {
            event.getRegistry().registerAll(block);
        }
    }

}
