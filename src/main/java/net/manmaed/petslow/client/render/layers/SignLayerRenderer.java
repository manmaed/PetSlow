package net.manmaed.petslow.client.render.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.manmaed.petslow.PetSlow;
import net.manmaed.petslow.client.model.PSModels;
import net.manmaed.petslow.client.render.model.ModelSign;
import net.manmaed.petslow.client.render.model.ModelSlowpoke;
import net.manmaed.petslow.client.render.model.ModelSlowpokeHat;
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
//TODO: FIX CLASS

public class SignLayerRenderer<T extends EntityPetSlow, M extends ModelSlowpoke<T>> extends RenderLayer<T, M> {

    private static final ResourceLocation SIGN = new ResourceLocation(PetSlow.MOD_ID, "textures/entity/sign.png");
    private final ModelSign<T> hat;

    public SignLayerRenderer(RenderLayerParent<T, M> layerParent, EntityModelSet entityModelSet) {
        super(layerParent);
        this.hat = new ModelSign<>(entityModelSet.bakeLayer(PSModels.SIGN));
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, T entity, float p_117353_, float p_117354_, float p_117355_, float p_117356_, float p_117357_, float p_117358_) {
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entitySolid(SIGN));
        poseStack.pushPose();
        float size = 0.15F;
        /*getParentModel().head.translateAndRotate(poseStack);*/
        poseStack.scale(size, size, size);
        poseStack.translate(0f, 5.65f, 0.56f);
        //TODO: remove true
        if(entity.isInSittingPose() && entity.isAway()) {
            hat.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1f, 1f, 1f, 1f);
        }
        poseStack.popPose();
    }
}
/*
public class SignLayerRenderer */
/*implements LayerRenderer<EntityMiniSlow>*//*
 {

   */
/* private final RenderSlowpoke renderer;
    private final ModelSign sign = new ModelSign();

    public RenderSignLayer(RenderSlowpoke renderer) {
        this.renderer = renderer;
    }

    @Override
    public void doRenderLayer(EntityMiniSlow entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        if (entitylivingbaseIn.isSitting()) {
            if (entitylivingbaseIn.getAway()) {
                GlStateManager.pushMatrix();
                bindTexture(Textures.SIGN);
                GlStateManager.translate(0F, 0F, 0F);
                float pitch = interpolateValues(entitylivingbaseIn.prevRotationPitch, entitylivingbaseIn.rotationPitch, partialTicks);
                //GlStateManager.rotate(pitch, 1.0F, 0.0F, 0.0F);
                sign.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
                GlStateManager.popMatrix();
            }
        }
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }

    private float interpolateValues(float prevVal, float nextVal, float partialTick) {
        return prevVal + partialTick * (nextVal - prevVal);
    }

    private void bindTexture(ResourceLocation rl) {
        Minecraft.getMinecraft().renderEngine.bindTexture(rl);
    }
*//*

}
*/
