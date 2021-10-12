package net.manmaed.petslow.client.render.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.manmaed.petslow.client.render.model.ModelSlowpoke;
import net.manmaed.petslow.entity.EntityMiniSlow;
import net.manmaed.petslow.libs.Reference;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;

;

/**
 * Created by manmaed on 26/02/2017.
 */
public class RenderSlowpoke extends MobRenderer<EntityMiniSlow, ModelSlowpoke<EntityMiniSlow>> {

    private static final ResourceLocation SLOWPOKE = new ResourceLocation(Reference.MOD_ID, "textures/entity/slowpoke.png");

    public RenderSlowpoke(EntityRendererManager manager) {
        super(manager, new ModelSlowpoke(), 0.25F);
    }

    @Override
    public void render(EntityMiniSlow entityMiniSlow, float entityYaw, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLight) {
        IVertexBuilder ivertexbuilder = buffer.getBuffer(this.model.renderType(SLOWPOKE));
        if (entityMiniSlow.isOrderedToSit()) {
            if (entityMiniSlow.getAway()) {
                //404 Slowpoke Not Found
            } else {
                //Slow is Sitting Down
                //HeadHat
                matrixStack.pushPose();
                matrixStack.translate(this.model.headhat.x, this.model.headhat.y, this.model.headhat.z);
                matrixStack.translate(this.model.headhat.xRot * entityYaw, this.model.headhat.yRot * entityYaw, this.model.headhat.zRot * entityYaw);
                matrixStack.scale((float) 0.5D, (float) 0.5D, (float) 0.5D);
                matrixStack.translate(-this.model.headhat.x, -this.model.headhat.x, -this.model.headhat.z);
                matrixStack.translate(-this.model.headhat.xRot * entityYaw, -this.model.headhat.yRot * entityYaw, -this.model.headhat.zRot * entityYaw);
                this.model.headhat.render(matrixStack, ivertexbuilder, packedLight, OverlayTexture.NO_OVERLAY);
                matrixStack.popPose();

                /*//Body
                matrixStack.pushPose();
                matrixStack.translate(this.model.body.offsetX, this.model.body.offsetY, this.model.body.offsetZ);
                matrixStack.translate(this.model.body.rotationPointX * f5, this.model.body.rotationPointY * f5, this.model.body.rotationPointZ * f5);
                matrixStack.scale(0.5D, 0.5D, 0.5D);
                matrixStack.translate(-this.model.body.offsetX, -this.model.body.offsetY, -this.model.body.offsetZ);
                matrixStack.translate(-this.model.body.rotationPointX * f5, -this.model.body.rotationPointY * f5, -this.model.body.rotationPointZ * f5);
                this.model.body.render(matrixStack, ivertexbuilder, packedLight, OverlayTexture.NO_OVERLAY);
                matrixStack.popPose();

                //Head
                matrixStack.pushPose();
                matrixStack.translate(this.model.head.offsetX, this.model.head.offsetY, this.model.head.offsetZ);
                matrixStack.translate(this.model.head.rotationPointX * f5, this.model.head.rotationPointY * f5, this.model.head.rotationPointZ * f5);
                matrixStack.scale(0.5D, 0.5D, 0.5D);
                matrixStack.translate(-this.model.head.offsetX, -this.model.head.offsetY, -this.model.head.offsetZ);
                matrixStack.translate(-this.model.head.rotationPointX * f5, -this.model.head.rotationPointY * f5, -this.model.head.rotationPointZ * f5);
                this.model.head.render(matrixStack, ivertexbuilder, packedLight, OverlayTexture.NO_OVERLAY);
                matrixStack.popPose();

                //Arm2
                matrixStack.pushPose();
                matrixStack.translate(this.model.arm2.offsetX, this.model.arm2.offsetY, this.model.arm2.offsetZ);
                matrixStack.translate(this.model.arm2.rotationPointX * f5, this.model.arm2.rotationPointY * f5, this.model.arm2.rotationPointZ * f5);
                matrixStack.scale(0.5D, 0.5D, 0.5D);
                matrixStack.translate(-this.model.arm2.offsetX, -this.model.arm2.offsetY, -this.model.arm2.offsetZ);
                matrixStack.translate(-this.model.arm2.rotationPointX * f5, -this.model.arm2.rotationPointY * f5, -this.model.arm2.rotationPointZ * f5);
                this.model.arm2.render(matrixStack, ivertexbuilder, packedLight, OverlayTexture.NO_OVERLAY);
                matrixStack.popPose();

                //Arm1
                matrixStack.pushPose();
                matrixStack.translate(this.model.arm1.offsetX, this.model.arm1.offsetY, this.model.arm1.offsetZ);
                matrixStack.translate(this.model.arm1.rotationPointX * f5, this.model.arm1.rotationPointY * f5, this.model.arm1.rotationPointZ * f5);
                matrixStack.scale(0.5D, 0.5D, 0.5D);
                matrixStack.translate(-this.model.arm1.offsetX, -this.model.arm1.offsetY, -this.model.arm1.offsetZ);
                matrixStack.translate(-this.model.arm1.rotationPointX * f5, -this.model.arm1.rotationPointY * f5, -this.model.arm1.rotationPointZ * f5);
                this.model.arm1.render(matrixStack, ivertexbuilder, packedLight, OverlayTexture.NO_OVERLAY);
                matrixStack.popPose();

                //Leg1
                matrixStack.pushPose();
                matrixStack.translate(this.model.leg1sit.offsetX, this.model.leg1sit.offsetY, this.model.leg1sit.offsetZ);
                matrixStack.translate(this.model.leg1sit.rotationPointX * f5, this.model.leg1sit.rotationPointY * f5, this.model.leg1sit.rotationPointZ * f5);
                matrixStack.scale(0.5D, 0.5D, 0.5D);
                matrixStack.translate(-this.model.leg1sit.offsetX, -this.model.leg1sit.offsetY, -this.model.leg1sit.offsetZ);
                matrixStack.translate(-this.model.leg1sit.rotationPointX * f5, -this.model.leg1sit.rotationPointY * f5, -this.model.leg1sit.rotationPointZ * f5);
                this.model.leg1sit.render(matrixStack, ivertexbuilder, packedLight, OverlayTexture.NO_OVERLAY);
                matrixStack.popPose();

                //Leg2
                matrixStack.pushPose();
                matrixStack.translate(this.model.leg2ssit.offsetX, this.model.leg2ssit.offsetY, this.model.leg2ssit.offsetZ);
                matrixStack.translate(this.model.leg2ssit.rotationPointX * f5, this.model.leg2ssit.rotationPointY * f5, this.model.leg2ssit.rotationPointZ * f5);
                matrixStack.scale(0.5D, 0.5D, 0.5D);
                matrixStack.translate(-this.model.leg2ssit.offsetX, -this.model.leg2ssit.offsetY, -this.model.leg2ssit.offsetZ);
                matrixStack.translate(-this.model.leg2ssit.rotationPointX * f5, -this.model.leg2ssit.rotationPointY * f5, -this.model.leg2ssit.rotationPointZ * f5);
                this.model.leg2ssit.render(matrixStack, ivertexbuilder, packedLight, OverlayTexture.NO_OVERLAY);
                matrixStack.popPose();*/
            }
        }
    }

    @Override
    public ResourceLocation getTextureLocation(EntityMiniSlow entityMiniSlow) {
        return SLOWPOKE;
    }

}

 /*@Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        if (entity instanceof EntityMiniSlow) {
            EntityMiniSlow entityMiniSlow = (EntityMiniSlow) entity;
            if (entityMiniSlow.isSitting()) {
                if (entityMiniSlow.getAway()) {
                    //Make Slow invisable
                } else { Slow is Sitting Down
                    //HeadHat
                    GlStateManager.pushMatrix();
                    GlStateManager.translate(this.headhat.offsetX, this.headhat.offsetY, this.headhat.offsetZ);
                    GlStateManager.translate(this.headhat.rotationPointX * f5, this.headhat.rotationPointY * f5, this.headhat.rotationPointZ * f5);
                    GlStateManager.scale(0.5D, 0.5D, 0.5D);
                    GlStateManager.translate(-this.headhat.offsetX, -this.headhat.offsetY, -this.headhat.offsetZ);
                    GlStateManager.translate(-this.headhat.rotationPointX * f5, -this.headhat.rotationPointY * f5, -this.headhat.rotationPointZ * f5);
                    this.headhat.render(f5);
                    GlStateManager.popMatrix();

                    //Body
                    GlStateManager.pushMatrix();
                    GlStateManager.translate(this.body.offsetX, this.body.offsetY, this.body.offsetZ);
                    GlStateManager.translate(this.body.rotationPointX * f5, this.body.rotationPointY * f5, this.body.rotationPointZ * f5);
                    GlStateManager.scale(0.5D, 0.5D, 0.5D);
                    GlStateManager.translate(-this.body.offsetX, -this.body.offsetY, -this.body.offsetZ);
                    GlStateManager.translate(-this.body.rotationPointX * f5, -this.body.rotationPointY * f5, -this.body.rotationPointZ * f5);
                    this.body.render(f5);
                    GlStateManager.popMatrix();

                    //Head
                    GlStateManager.pushMatrix();
                    GlStateManager.translate(this.head.offsetX, this.head.offsetY, this.head.offsetZ);
                    GlStateManager.translate(this.head.rotationPointX * f5, this.head.rotationPointY * f5, this.head.rotationPointZ * f5);
                    GlStateManager.scale(0.5D, 0.5D, 0.5D);
                    GlStateManager.translate(-this.head.offsetX, -this.head.offsetY, -this.head.offsetZ);
                    GlStateManager.translate(-this.head.rotationPointX * f5, -this.head.rotationPointY * f5, -this.head.rotationPointZ * f5);
                    this.head.render(f5);
                    GlStateManager.popMatrix();

                    //Arm2
                    GlStateManager.pushMatrix();
                    GlStateManager.translate(this.arm2.offsetX, this.arm2.offsetY, this.arm2.offsetZ);
                    GlStateManager.translate(this.arm2.rotationPointX * f5, this.arm2.rotationPointY * f5, this.arm2.rotationPointZ * f5);
                    GlStateManager.scale(0.5D, 0.5D, 0.5D);
                    GlStateManager.translate(-this.arm2.offsetX, -this.arm2.offsetY, -this.arm2.offsetZ);
                    GlStateManager.translate(-this.arm2.rotationPointX * f5, -this.arm2.rotationPointY * f5, -this.arm2.rotationPointZ * f5);
                    this.arm2.render(f5);
                    GlStateManager.popMatrix();

                    //Arm1
                    GlStateManager.pushMatrix();
                    GlStateManager.translate(this.arm1.offsetX, this.arm1.offsetY, this.arm1.offsetZ);
                    GlStateManager.translate(this.arm1.rotationPointX * f5, this.arm1.rotationPointY * f5, this.arm1.rotationPointZ * f5);
                    GlStateManager.scale(0.5D, 0.5D, 0.5D);
                    GlStateManager.translate(-this.arm1.offsetX, -this.arm1.offsetY, -this.arm1.offsetZ);
                    GlStateManager.translate(-this.arm1.rotationPointX * f5, -this.arm1.rotationPointY * f5, -this.arm1.rotationPointZ * f5);
                    this.arm1.render(f5);
                    GlStateManager.popMatrix();

                    //Leg1
                    GlStateManager.pushMatrix();
                    GlStateManager.translate(this.leg1sit.offsetX, this.leg1sit.offsetY, this.leg1sit.offsetZ);
                    GlStateManager.translate(this.leg1sit.rotationPointX * f5, this.leg1sit.rotationPointY * f5, this.leg1sit.rotationPointZ * f5);
                    GlStateManager.scale(0.5D, 0.5D, 0.5D);
                    GlStateManager.translate(-this.leg1sit.offsetX, -this.leg1sit.offsetY, -this.leg1sit.offsetZ);
                    GlStateManager.translate(-this.leg1sit.rotationPointX * f5, -this.leg1sit.rotationPointY * f5, -this.leg1sit.rotationPointZ * f5);
                    this.leg1sit.render(f5);
                    GlStateManager.popMatrix();

                    //Leg2
                    GlStateManager.pushMatrix();
                    GlStateManager.translate(this.leg2ssit.offsetX, this.leg2ssit.offsetY, this.leg2ssit.offsetZ);
                    GlStateManager.translate(this.leg2ssit.rotationPointX * f5, this.leg2ssit.rotationPointY * f5, this.leg2ssit.rotationPointZ * f5);
                    GlStateManager.scale(0.5D, 0.5D, 0.5D);
                    GlStateManager.translate(-this.leg2ssit.offsetX, -this.leg2ssit.offsetY, -this.leg2ssit.offsetZ);
                    GlStateManager.translate(-this.leg2ssit.rotationPointX * f5, -this.leg2ssit.rotationPointY * f5, -this.leg2ssit.rotationPointZ * f5);
                    this.leg2ssit.render(f5);
                    GlStateManager.popMatrix();
                }
            } else {

                //HeadHat
                GlStateManager.pushMatrix();
                GlStateManager.translate(this.headhat.offsetX, this.headhat.offsetY, this.headhat.offsetZ);
                GlStateManager.translate(this.headhat.rotationPointX * f5, this.headhat.rotationPointY * f5, this.headhat.rotationPointZ * f5);
                GlStateManager.scale(0.5D, 0.5D, 0.5D);
                GlStateManager.translate(-this.headhat.offsetX, -this.headhat.offsetY, -this.headhat.offsetZ);
                GlStateManager.translate(-this.headhat.rotationPointX * f5, -this.headhat.rotationPointY * f5, -this.headhat.rotationPointZ * f5);
                this.headhat.render(f5);
                GlStateManager.popMatrix();

                //Body
                GlStateManager.pushMatrix();
                GlStateManager.translate(this.body.offsetX, this.body.offsetY, this.body.offsetZ);
                GlStateManager.translate(this.body.rotationPointX * f5, this.body.rotationPointY * f5, this.body.rotationPointZ * f5);
                GlStateManager.scale(0.5D, 0.5D, 0.5D);
                GlStateManager.translate(-this.body.offsetX, -this.body.offsetY, -this.body.offsetZ);
                GlStateManager.translate(-this.body.rotationPointX * f5, -this.body.rotationPointY * f5, -this.body.rotationPointZ * f5);
                this.body.render(f5);
                GlStateManager.popMatrix();

                //Head
                GlStateManager.pushMatrix();
                GlStateManager.translate(this.head.offsetX, this.head.offsetY, this.head.offsetZ);
                GlStateManager.translate(this.head.rotationPointX * f5, this.head.rotationPointY * f5, this.head.rotationPointZ * f5);
                GlStateManager.scale(0.5D, 0.5D, 0.5D);
                GlStateManager.translate(-this.head.offsetX, -this.head.offsetY, -this.head.offsetZ);
                GlStateManager.translate(-this.head.rotationPointX * f5, -this.head.rotationPointY * f5, -this.head.rotationPointZ * f5);
                this.head.render(f5);
                GlStateManager.popMatrix();

                //Arm2
                GlStateManager.pushMatrix();
                GlStateManager.translate(this.arm2.offsetX, this.arm2.offsetY, this.arm2.offsetZ);
                GlStateManager.translate(this.arm2.rotationPointX * f5, this.arm2.rotationPointY * f5, this.arm2.rotationPointZ * f5);
                GlStateManager.scale(0.5D, 0.5D, 0.5D);
                GlStateManager.translate(-this.arm2.offsetX, -this.arm2.offsetY, -this.arm2.offsetZ);
                GlStateManager.translate(-this.arm2.rotationPointX * f5, -this.arm2.rotationPointY * f5, -this.arm2.rotationPointZ * f5);
                this.arm2.render(f5);
                GlStateManager.popMatrix();

                //Arm1
                GlStateManager.pushMatrix();
                GlStateManager.translate(this.arm1.offsetX, this.arm1.offsetY, this.arm1.offsetZ);
                GlStateManager.translate(this.arm1.rotationPointX * f5, this.arm1.rotationPointY * f5, this.arm1.rotationPointZ * f5);
                GlStateManager.scale(0.5D, 0.5D, 0.5D);
                GlStateManager.translate(-this.arm1.offsetX, -this.arm1.offsetY, -this.arm1.offsetZ);
                GlStateManager.translate(-this.arm1.rotationPointX * f5, -this.arm1.rotationPointY * f5, -this.arm1.rotationPointZ * f5);
                this.arm1.render(f5);
                GlStateManager.popMatrix();
                //Leg1
                GlStateManager.pushMatrix();
                GlStateManager.translate(this.leg1.offsetX, this.leg1.offsetY, this.leg1.offsetZ);
                GlStateManager.translate(this.leg1.rotationPointX * f5, this.leg1.rotationPointY * f5, this.leg1.rotationPointZ * f5);
                GlStateManager.scale(0.5D, 0.5D, 0.5D);
                GlStateManager.translate(-this.leg1.offsetX, -this.leg1.offsetY, -this.leg1.offsetZ);
                GlStateManager.translate(-this.leg1.rotationPointX * f5, -this.leg1.rotationPointY * f5, -this.leg1.rotationPointZ * f5);
                this.leg1.render(f5);
                GlStateManager.popMatrix();
                //Leg 2
                GlStateManager.pushMatrix();
                GlStateManager.translate(this.leg2.offsetX, this.leg2.offsetY, this.leg2.offsetZ);
                GlStateManager.translate(this.leg2.rotationPointX * f5, this.leg2.rotationPointY * f5, this.leg2.rotationPointZ * f5);
                GlStateManager.scale(0.5D, 0.5D, 0.5D);
                GlStateManager.translate(-this.leg2.offsetX, -this.leg2.offsetY, -this.leg2.offsetZ);
                GlStateManager.translate(-this.leg2.rotationPointX * f5, -this.leg2.rotationPointY * f5, -this.leg2.rotationPointZ * f5);
                this.leg2.render(f5);
                GlStateManager.popMatrix();
            }
        }
    }*/
