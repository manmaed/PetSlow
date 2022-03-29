package net.manmaed.petslow.client.render.layers;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.manmaed.petslow.PetSlow;
import net.manmaed.petslow.client.model.PSModels;
import net.manmaed.petslow.client.render.model.ModelCreeperHat;
import net.manmaed.petslow.client.render.model.ModelSlowpoke;
import net.manmaed.petslow.entity.EntityPetSlow;
import net.manmaed.petslow.hats.PSHats;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

/**
 * Created by manmaed on 24/01/2022.
 */
public class HalloweenLayer extends RenderLayer<EntityPetSlow, ModelSlowpoke> {

    private static final ResourceLocation CREEPER = new ResourceLocation(PetSlow.MOD_ID, "textures/entity/event/creeper.png");
    private final ModelCreeperHat hat;

    public HalloweenLayer(RenderLayerParent layerParent, EntityModelSet entityModelSet) {
        super(layerParent);
        this.hat = new ModelCreeperHat(entityModelSet.bakeLayer(PSModels.CREEPER));

    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, EntityPetSlow entity, float p_117353_, float p_117354_, float p_117355_, float p_117356_, float p_117357_, float p_117358_) {
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(CREEPER));
        poseStack.pushPose();
        if (PSHats.halloween) {
            if (entity.isAway()) {
                poseStack.translate(0.0F, -0.75F, -0.15F);
            } else {
                this.getParentModel().getHead().translateAndRotate(poseStack);
                poseStack.translate(0F, -2F, 0F);
            }
            hat.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        }
        poseStack.popPose();
    }
}
