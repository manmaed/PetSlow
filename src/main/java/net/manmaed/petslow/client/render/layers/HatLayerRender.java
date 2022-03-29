package net.manmaed.petslow.client.render.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.manmaed.petslow.PetSlow;
import net.manmaed.petslow.client.model.PSModels;
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
import net.minecraft.world.entity.Entity;

/**
 * Created by manmaed on 19/03/2022.
 */
public class HatLayerRender extends RenderLayer<EntityPetSlow, ModelSlowpoke> {

    private static final ResourceLocation SLOWPOKE = new ResourceLocation(PetSlow.MOD_ID, "textures/entity/slowpoke.png");
    private final ModelSlowpokeHat hat;

    public HatLayerRender(RenderLayerParent layerParent, EntityModelSet modelSet) {
        super(layerParent);
        this.hat = new ModelSlowpokeHat(modelSet.bakeLayer(PSModels.HAT));
    }

    /*@Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, EntityPetSlow entity, float p_117353_, float p_117354_, float p_117355_, float p_117356_, float p_117357_, float p_117358_) {
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(SLOWPOKE));
        poseStack.pushPose();
        *//*poseStack.scale((float) 0.55D, (float) 0.55D, (float) 0.55D);
        poseStack.translate(0f, -0.12f, 0f);*//*
        this.getParentModel().head.translateAndRotate(poseStack);
        *//*hat.hat.copyFrom(this.getParentModel().head);*//*
        if (!entity.isAway()) {
            hat.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY,1f,1f,1f,1f);
        }
        poseStack.popPose();
    }*/

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, EntityPetSlow entity, float p_117353_, float p_117354_, float p_117355_, float p_117356_, float p_117357_, float p_117358_) {
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(SLOWPOKE));
        poseStack.pushPose();
       /* poseStack.translate(0f, -0.07f, 0f);
        poseStack.scale((float) 0.55D, (float) 0.55D, (float) 0.55D);*/
        /*hat.hat.copyFrom(getParentModel().head);
        */this.getParentModel().head.translateAndRotate(poseStack);
        if (!entity.isAway()) {
            hat.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY,1f,1f,1f,1f);
        }
        poseStack.popPose();
    }

}
