package net.manmaed.petslow;

import net.manmaed.petslow.entity.PSEntityTypes;
import net.manmaed.petslow.client.render.entity.RenderSlowpoke;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * Created by manmaed on 12/10/2021.
 */
public class PetSlowClient {

    public static void doClientStuff(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(PSEntityTypes.SLOWPOKE.get(), RenderSlowpoke::new);
    }
}
