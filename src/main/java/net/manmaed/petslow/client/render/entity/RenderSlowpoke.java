package net.manmaed.petslow.client.render.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Quaternion;
import net.manmaed.petslow.PetSlow;
import net.manmaed.petslow.client.model.PSModels;
import net.manmaed.petslow.client.render.layers.ChairLayerRenderer;
import net.manmaed.petslow.client.render.layers.HatLayerRender;
import net.manmaed.petslow.client.render.layers.SignLayerRenderer;
import net.manmaed.petslow.client.render.model.ModelSlowpoke;
import net.manmaed.petslow.entity.EntityPetSlow;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

/**
 * Created by manmaed on 26/02/2017.
 */
public class RenderSlowpoke extends MobRenderer<EntityPetSlow, ModelSlowpoke<EntityPetSlow>> {

    private static final ResourceLocation SLOWPOKE = new ResourceLocation(PetSlow.MOD_ID, "textures/entity/slowpoke.png");

    public RenderSlowpoke(EntityRendererProvider.Context context) {
        super(context, new ModelSlowpoke<EntityPetSlow>(context.bakeLayer(PSModels.PETSLOW)), 0.25F);
        //this.addLayer(new LayerClass<>(this, context.getModelSet)
        this.addLayer(new HatLayerRender<>(this, context.getModelSet()));
        this.addLayer(new ChairLayerRenderer<>(this, context.getModelSet()));
        this.addLayer(new SignLayerRenderer<>(this, context.getModelSet()));
    }

    @Override
    public void render(EntityPetSlow entityPetSlow, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight) {
        super.render(entityPetSlow, entityYaw, partialTicks, poseStack, multiBufferSource, packedLight);
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entitySolid(SLOWPOKE));
        poseStack.pushPose();
        /*poseStack.scale((float) 0.5D, (float) 0.5D, (float) 0.5D);
        poseStack.translate(0f, 1.5f, 0f);
        poseStack.mulPose(new Quaternion(1, 0, 0, 0));*/
        if(entityPetSlow.isInSittingPose()) {
            model.setOnChair(true);
            if(entityPetSlow.isAway()) {
                model.setAwayFromChair(true);
            } else {
                model.setAwayFromChair(false);
            }
        } else {
            model.setOnChair(false);
        }
        poseStack.popPose();
        /*super.render(entityPetSlow, entityYaw, partialTicks, poseStack, multiBufferSource, packedLight);*/
    }

    @Override
    public ResourceLocation getTextureLocation(EntityPetSlow entityPetSlow) {
        return SLOWPOKE;
    }
}

/*@Override
    public void render(EntityPetSlow petSlow, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight) {
        *//*VertexConsumer vertexConsumer = multiBufferSource.getBuffer(this.model.renderType(SLOWPOKE));
        poseStack.pushPose();
        poseStack.scale(0.1F,0.1F,0.1F);
        this.model.hat.render(poseStack, vertexConsumer, packedLight, OverlayTexture.RED_OVERLAY_V);*//*

    }*/

    /*@Override
    public void render(EntityPetSlow petSlow, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight) {
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(this.model.renderType(SLOWPOKE));
        boolean onChair = petSlow.isInSittingPose();
        boolean isAway = petSlow.isAway();
        poseStack.pushPose();
        poseStack.scale((float) -0.5D, (float) -0.5D, (float) -0.5D);
        poseStack.translate(0f, -1.5f, 0f);
        if(onChair) {
            if (isAway) {
                //Slow is away! no need to render him
            }
            this.model.hat.render(poseStack, vertexConsumer,packedLight, OverlayTexture.NO_OVERLAY);
            this.model.head.render(poseStack, vertexConsumer,packedLight, OverlayTexture.NO_OVERLAY);
            this.model.body.render(poseStack, vertexConsumer,packedLight, OverlayTexture.NO_OVERLAY);
            this.model.left_arm.render(poseStack, vertexConsumer,packedLight, OverlayTexture.NO_OVERLAY);
            this.model.right_arm.render(poseStack, vertexConsumer,packedLight, OverlayTexture.NO_OVERLAY);
            this.model.left_leg_sit.render(poseStack, vertexConsumer,packedLight, OverlayTexture.NO_OVERLAY);
            this.model.right_leg_sit.render(poseStack, vertexConsumer,packedLight, OverlayTexture.NO_OVERLAY);
        }
        this.model.hat.render(poseStack, vertexConsumer,packedLight, OverlayTexture.NO_OVERLAY);
        this.model.head.render(poseStack, vertexConsumer,packedLight, OverlayTexture.NO_OVERLAY);
        this.model.body.render(poseStack, vertexConsumer,packedLight, OverlayTexture.NO_OVERLAY);
        this.model.left_arm.render(poseStack, vertexConsumer,packedLight, OverlayTexture.NO_OVERLAY);
        this.model.right_arm.render(poseStack, vertexConsumer,packedLight, OverlayTexture.NO_OVERLAY);
        this.model.left_leg.render(poseStack, vertexConsumer,packedLight, OverlayTexture.NO_OVERLAY);
        this.model.right_leg.render(poseStack, vertexConsumer,packedLight, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
    }*/

    /*private static final ResourceLocation SLOWPOKE = new ResourceLocation(Reference.MOD_ID, "textures/entity/slowpoke.png");

    public RenderSlowpoke(EntityRendererManager manager) {
        super(manager, new ModelSlowpoke(), 0.25F);
        //this.addlayer();
        this.addLayer(new ChairFeatureRenderer(this));
        *//*this.addLayer(new SignFeatureRenderer(this));*//*
    }

    @Override
    public void render(EntityMiniSlow entity, float entityYaw, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLight) {
        IVertexBuilder vertexBuilder = buffer.getBuffer(this.model.renderType(SLOWPOKE));
        Boolean sittingDown = entity.isOrderedToSit();
        Boolean zzz = entity.isSleeping();
        *//*super.render(entity, entityYaw, partialTicks, matrixStack, buffer, packedLight);*//*
        matrixStack.pushPose();
        matrixStack.scale((float) -0.5D, (float) -0.5D, (float) -0.5D);
        matrixStack.translate(0f, -1.5f, 0f);
        *//*LogHelper.fatal("isSleeping: " + entity.isSleeping() + " : isOrderdToSit: " + entity.isOrderedToSit());*//*
        if (zzz) {
            LogHelper.fatal("RS: is Sleeping");
        }
        if (sittingDown) {
            LogHelper.fatal("RS: is Sitting");
            if (entity.getAway()) {
                LogHelper.fatal("RS: is Away");
                //404 Slowpoke Not Found
            } else {
                LogHelper.fatal("RS: is Sitting and isnt away");
                this.model.head.render(matrixStack, vertexBuilder, packedLight, OverlayTexture.NO_OVERLAY);
                this.model.headhat.render(matrixStack, vertexBuilder, packedLight, OverlayTexture.NO_OVERLAY);
                this.model.body.render(matrixStack, vertexBuilder, packedLight, OverlayTexture.NO_OVERLAY);
                this.model.arm1.render(matrixStack, vertexBuilder, packedLight, OverlayTexture.NO_OVERLAY);
                this.model.arm2.render(matrixStack, vertexBuilder, packedLight, OverlayTexture.NO_OVERLAY);
                this.model.leg1sit.render(matrixStack, vertexBuilder, packedLight, OverlayTexture.NO_OVERLAY);
                this.model.leg2sit.render(matrixStack, vertexBuilder, packedLight, OverlayTexture.NO_OVERLAY);
            }
        } else {
            this.model.head.render(matrixStack, vertexBuilder, packedLight, OverlayTexture.NO_OVERLAY);
            this.model.headhat.render(matrixStack, vertexBuilder, packedLight, OverlayTexture.NO_OVERLAY);
            this.model.body.render(matrixStack, vertexBuilder, packedLight, OverlayTexture.NO_OVERLAY);
            this.model.arm1.render(matrixStack, vertexBuilder, packedLight, OverlayTexture.NO_OVERLAY);
            this.model.arm2.render(matrixStack, vertexBuilder, packedLight, OverlayTexture.NO_OVERLAY);
            this.model.leg1.render(matrixStack, vertexBuilder, packedLight, OverlayTexture.NO_OVERLAY);
            this.model.leg2.render(matrixStack, vertexBuilder, packedLight, OverlayTexture.NO_OVERLAY);
        }
        matrixStack.popPose();
    }

    @Override
    public ResourceLocation getTextureLocation(EntityMiniSlow pEntity) {
        return SLOWPOKE;
    }*/
