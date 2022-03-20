package net.manmaed.petslow;


import net.manmaed.petslow.client.model.PSModels;
import net.manmaed.petslow.client.render.entity.RenderSlowpoke;
import net.manmaed.petslow.client.render.model.ModelChair;
import net.manmaed.petslow.client.render.model.ModelSign;
import net.manmaed.petslow.client.render.model.ModelSlowpoke;
import net.manmaed.petslow.client.render.model.ModelSlowpokeHat;
import net.manmaed.petslow.entity.PSEntityTypes;
import net.minecraftforge.client.event.EntityRenderersEvent;

/**
 * Created by manmaed on 12/10/2021.
 */
public class PetSlowClient {

    public static void doEntityRendering(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(PSEntityTypes.SLOWPOKE.get(), RenderSlowpoke::new);
    }

    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(PSModels.PETSLOW, ModelSlowpoke::createBodyLayer);
        event.registerLayerDefinition(PSModels.HAT, ModelSlowpokeHat::createBodyLayer);
        event.registerLayerDefinition(PSModels.SIGN, ModelSign::createBodyLayer);
        event.registerLayerDefinition(PSModels.CHAIR, ModelChair::createBodyLayer);
        /*event.registerLayerDefinition(PRModels.CAKE, ModelCakeHat::createBodyLayer);
        event.registerLayerDefinition(PRModels.CREEPER, ModelCreeperHat::createBodyLayer);
        event.registerLayerDefinition(PRModels.SANTA, ModelSantaHat::createBodyLayer);
        event.registerLayerDefinition(PRModels.SLOWPOKE, ModelSlowpokeHat::createBodyLayer);
        event.registerLayerDefinition(PRModels.CAGE, ModelCageHat::createBodyLayer);
        event.registerLayerDefinition(PRModels.SIGN, ModelSignHat::createBodyLayer);*/


    }

    /*public static void doClientStuff(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(PSEntityTypes.SLOWPOKE.get(), RenderSlowpoke::new);
    }*/
}
