package net.manmaed.petslow;


import net.manmaed.petslow.items.PSItems;
import net.manmaed.petslow.libs.LogHelper;
import net.manmaed.petslow.libs.Reference;
import net.manmaed.petslow.libs.util.RegistryHelper;
import net.minecraft.client.audio.SoundHandler;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * Created by manmaed on 24/02/2017.
 */

@Mod(Reference.MOD_ID)

public class PetSlow {

    public PetSlow() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        PSItems.ITEMS.register(eventBus);
    }

}