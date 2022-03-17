package net.manmaed.petslow.client.render.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.manmaed.petslow.client.render.layers.ChairFeatureRenderer;
import net.manmaed.petslow.client.render.model.ModelSlowpoke;
import net.manmaed.petslow.client.render.model.ModelSlowpoke_old;
import net.manmaed.petslow.entity.EntityMiniSlow;
import net.manmaed.petslow.libs.LogHelper;
import net.manmaed.petslow.libs.Reference;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.jline.utils.Log;

;

/**
 * Created by manmaed on 26/02/2017.
 */
public class RenderSlowpoke extends MobRenderer<EntityMiniSlow, ModelSlowpoke<EntityMiniSlow>> {

    private static final ResourceLocation SLOWPOKE = new ResourceLocation(Reference.MOD_ID, "textures/entity/slowpoke.png");

    public RenderSlowpoke(EntityRendererManager manager) {
        super(manager, new ModelSlowpoke(), 0.25F);
        //this.addlayer();
        this.addLayer(new ChairFeatureRenderer(this));
        /*this.addLayer(new SignFeatureRenderer(this));*/
    }

    @Override
    public void render(EntityMiniSlow entity, float entityYaw, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLight) {
        IVertexBuilder vertexBuilder = buffer.getBuffer(this.model.renderType(SLOWPOKE));
        Boolean sittingDown = entity.isOrderedToSit();
        Boolean zzz = entity.isSleeping();
        /*super.render(entity, entityYaw, partialTicks, matrixStack, buffer, packedLight);*/
        matrixStack.pushPose();
        matrixStack.scale((float) -0.5D, (float) -0.5D, (float) -0.5D);
        matrixStack.translate(0f, -1.5f, 0f);
        /*LogHelper.fatal("isSleeping: " + entity.isSleeping() + " : isOrderdToSit: " + entity.isOrderedToSit());*/
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
    }
}
