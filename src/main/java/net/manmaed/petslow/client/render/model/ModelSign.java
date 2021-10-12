package net.manmaed.petslow.client.render.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

/**
 * test - Undefined
 * Created using Tabula 7.0.0
 */
public class ModelSign extends ModelBase {
    public ModelRenderer sign;

    public ModelSign() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.sign = new ModelRenderer(this, 0, 0);
        this.sign.setRotationPoint(-3.0F, 12.2F, 1.0F);
        this.sign.addBox(0.0F, 0.0F, 0.0F, 64, 39, 1, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.sign.offsetX, this.sign.offsetY, this.sign.offsetZ);
        GlStateManager.translate(this.sign.rotationPointX * f5, this.sign.rotationPointY * f5, this.sign.rotationPointZ * f5);
        GlStateManager.scale(0.1D, 0.1D, 0.5D);
        GlStateManager.translate(-this.sign.offsetX, -this.sign.offsetY, -this.sign.offsetZ);
        GlStateManager.translate(-this.sign.rotationPointX * f5, -this.sign.rotationPointY * f5, -this.sign.rotationPointZ * f5);
        this.sign.render(f5);
        GlStateManager.popMatrix();
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
