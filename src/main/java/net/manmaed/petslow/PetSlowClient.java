package net.manmaed.petslow;


import net.manmaed.petslow.client.model.PSModels;
import net.manmaed.petslow.client.render.entity.RenderSlowpoke;
import net.manmaed.petslow.client.render.model.*;
import net.manmaed.petslow.entity.PSEntityTypes;
import net.manmaed.petslow.hats.PSHats;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * Created by manmaed on 12/10/2021.
 */
public class PetSlowClient {

    public static boolean iChunHatsLoaded;

    public static void doEntityRendering(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(PSEntityTypes.SLOWPOKE.get(), RenderSlowpoke::new);
    }

    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(PSModels.PETSLOW, ModelSlowpoke::createBodyLayer);
        event.registerLayerDefinition(PSModels.SIGN, ModelSign::createBodyLayer);
        event.registerLayerDefinition(PSModels.CHAIR, ModelChair::createBodyLayer);
        event.registerLayerDefinition(PSModels.SANTA, ModelSantaHat::createBodyLayer);
        event.registerLayerDefinition(PSModels.CREEPER, ModelCreeperHat::createBodyLayer);
        event.registerLayerDefinition(PSModels.CAKE, ModelCakeHat::createBodyLayer);
    }

    public static void doClientStuff(final FMLClientSetupEvent event) {
        iChunHatsLoaded = ModList.get().isLoaded("hats");
        if (!iChunHatsLoaded) {
            new Thread(PSHats::load).start();
        }
    }
}
