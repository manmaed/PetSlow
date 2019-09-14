package net.manmaed.petslow.client.render.model;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.model.Cuboid;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.Entity;

/**
 * test - Undefined
 * Created using Tabula 7.0.0
 */
public class ModelSign<T extends Entity> extends EntityModel<T> {

    public Cuboid sign;

    public ModelSign() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.sign = new Cuboid(this, 0, 0);
        this.sign.setRotationPoint(-3.0F, 12.2F, 1.0F);
        this.sign.addBox(0.0F, 0.0F, 0.0F, 64, 39, 1, 0.0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.pushMatrix();
        GlStateManager.translatef(this.sign.pitch, this.sign.yaw, this.sign.roll);
        GlStateManager.translatef(this.sign.rotationPointX * f5, this.sign.rotationPointY * f5, this.sign.rotationPointZ * f5);
        GlStateManager.scaled(0.1D, 0.1D, 0.5D);
        GlStateManager.translatef(-this.sign.pitch, -this.sign.yaw, -this.sign.roll);
        GlStateManager.translatef(-this.sign.rotationPointX * f5, -this.sign.rotationPointY * f5, -this.sign.rotationPointZ * f5);
        this.sign.render(f5);
        GlStateManager.popMatrix();
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(Cuboid model, float x, float y, float z) {
        model.pitch = x;
        model.yaw = y;
        model.roll = z;
    }
}
