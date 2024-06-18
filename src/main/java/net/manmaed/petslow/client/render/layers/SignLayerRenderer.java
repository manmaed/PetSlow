package net.manmaed.petslow.client.render.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.manmaed.petslow.PetSlow;
import net.manmaed.petslow.client.model.PSModels;
import net.manmaed.petslow.client.render.model.ModelSign;
import net.manmaed.petslow.client.render.model.ModelSlowpoke;
import net.manmaed.petslow.entity.EntityPetSlow;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

/**
 * Created by manmaed on 14/01/2019.
 */

public class SignLayerRenderer extends RenderLayer<EntityPetSlow, ModelSlowpoke> {

    private static final ResourceLocation SIGN = ResourceLocation.fromNamespaceAndPath(PetSlow.MOD_ID, "textures/entity/sign.png");
    private final ModelSign hat;

    public SignLayerRenderer(RenderLayerParent layerParent, EntityModelSet entityModelSet) {
        super(layerParent);
        this.hat = new ModelSign(entityModelSet.bakeLayer(PSModels.SIGN));
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, EntityPetSlow entity, float p_117353_, float p_117354_, float p_117355_, float p_117356_, float p_117357_, float p_117358_) {
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entitySolid(SIGN));
        poseStack.pushPose();
        poseStack.scale((float) 2.0D, (float) 2.0D, (float) 2.0D);
        float size = 0.125F;
        poseStack.scale(size, size, size);
        poseStack.translate(0.0f, 0.85f, 0.70f);
        if (entity.isInSittingPose() && entity.isAway()) {
            hat.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, -1);
        }
        poseStack.popPose();
    }
}
