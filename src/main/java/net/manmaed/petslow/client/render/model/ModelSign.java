package net.manmaed.petslow.client.render.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * test - Undefined
 * Created using Tabula 7.0.0
 */
public class ModelSign<T extends Entity> extends SegmentedModel<T> {
    public ModelRenderer sign;

    public ModelSign() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.sign = new ModelRenderer(this, 0, 0);
        this.sign.setPos(-3.0F, 12.2F, 1.0F);
        this.sign.addBox(0.0F, 0.0F, 0.0F, 64, 39, 1, 0.0F);
    }

    @Override
    public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {

    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(
                this.sign
        );
    }

    /*@Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.sign.offsetX, this.sign.offsetY, this.sign.offsetZ);
        GlStateManager.translate(this.sign.rotationPointX * f5, this.sign.rotationPointY * f5, this.sign.rotationPointZ * f5);
        GlStateManager.scale(0.1D, 0.1D, 0.5D);
        GlStateManager.translate(-this.sign.offsetX, -this.sign.offsetY, -this.sign.offsetZ);
        GlStateManager.translate(-this.sign.rotationPointX * f5, -this.sign.rotationPointY * f5, -this.sign.rotationPointZ * f5);
        this.sign.render(f5);
        GlStateManager.popMatrix();
    }*/

    @Override
    public void renderToBuffer(MatrixStack pMatrixStack, IVertexBuilder pBuffer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha) {
        this.sign.render(pMatrixStack, pBuffer, pPackedLight, pPackedOverlay);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
