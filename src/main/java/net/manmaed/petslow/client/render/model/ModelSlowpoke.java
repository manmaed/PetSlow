package net.manmaed.petslow.client.render.model;

import com.mojang.blaze3d.platform.GlStateManager;
import net.manmaed.petslow.entity.EntityPetSlow;
import net.minecraft.client.model.Cuboid;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelPlayer - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelSlowpoke<T extends Entity> extends EntityModel<T>{
    public Cuboid headhat;
    public Cuboid arm2;
    public Cuboid leg1;
    public Cuboid leg2;
    public Cuboid head;
    public Cuboid body;
    public Cuboid arm1;

    //SittingLegs
    public Cuboid leg1sit;
    public Cuboid leg2ssit;

    public ModelSlowpoke() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.headhat = new Cuboid(this, 32, 0);
        this.headhat.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.headhat.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F);
        this.body = new Cuboid(this, 16, 16);
        this.body.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.head = new Cuboid(this, 0, 0);
        this.head.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.arm2 = new Cuboid(this, 40, 16);
        this.arm2.setRotationPoint(-2.5F, 13.0F, 0.0F);
        this.arm2.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.arm1 = new Cuboid(this, 40, 16);
        this.arm1.mirror = true;
        this.arm1.setRotationPoint(2.5F, 13.0F, 0.0F);
        this.arm1.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.leg1 = new Cuboid(this, 0, 16);
        this.leg1.mirror = true;
        this.leg1.setRotationPoint(1.0F, 18.0F, 0.0F);
        this.leg1.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.leg2 = new Cuboid(this, 0, 16);
        this.leg2.setRotationPoint(-1.0F, 18.0F, 0.0F);
        this.leg2.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);

        this.leg2ssit = new Cuboid(this, 0, 16);
        this.leg2ssit.setRotationPoint(-1.0F, 17.0F, -1.0F);
        this.leg2ssit.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(leg2ssit, -1.5707963267948966F, 0.0F, 0.0F);
        this.leg1sit = new Cuboid(this, 0, 16);
        this.leg1sit.mirror = true;
        this.leg1sit.setRotationPoint(1.0F, 17.0F, -1.0F);
        this.leg1sit.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(leg1sit, -1.5707963267948966F, 0.0F, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        if (entity instanceof EntityPetSlow) {
            EntityPetSlow petSlow = (EntityPetSlow) entity;
            if (petSlow.isSitting()) {
                if (petSlow.getAway()) {
                    //Make Slow invisable
                } else {
                    //Slow is Sitting Down
                    //HeadHat
                    GlStateManager.pushMatrix();
                    GlStateManager.translatef(this.headhat.x, this.headhat.y, this.headhat.z);
                    GlStateManager.translatef(this.headhat.rotationPointX * f5, this.headhat.rotationPointY * f5, this.headhat.rotationPointZ * f5);
                    GlStateManager.scaled(0.5D, 0.5D, 0.5D);
                    GlStateManager.translatef(-this.headhat.x, -this.headhat.y, -this.headhat.z);
                    GlStateManager.translatef(-this.headhat.rotationPointX * f5, -this.headhat.rotationPointY * f5, -this.headhat.rotationPointZ * f5);
                    this.headhat.render(f5);
                    GlStateManager.popMatrix();

                    //Body
                    GlStateManager.pushMatrix();
                    GlStateManager.translatef(this.body.x, this.body.y, this.body.z);
                    GlStateManager.translatef(this.body.rotationPointX * f5, this.body.rotationPointY * f5, this.body.rotationPointZ * f5);
                    GlStateManager.scaled(0.5D, 0.5D, 0.5D);
                    GlStateManager.translatef(-this.body.x, -this.body.y, -this.body.z);
                    GlStateManager.translatef(-this.body.rotationPointX * f5, -this.body.rotationPointY * f5, -this.body.rotationPointZ * f5);
                    this.body.render(f5);
                    GlStateManager.popMatrix();

                    //Head
                    GlStateManager.pushMatrix();
                    GlStateManager.translatef(this.head.x, this.head.y, this.head.z);
                    GlStateManager.translatef(this.head.rotationPointX * f5, this.head.rotationPointY * f5, this.head.rotationPointZ * f5);
                    GlStateManager.scaled(0.5D, 0.5D, 0.5D);
                    GlStateManager.translatef(-this.head.x, -this.head.y, -this.head.z);
                    GlStateManager.translatef(-this.head.rotationPointX * f5, -this.head.rotationPointY * f5, -this.head.rotationPointZ * f5);
                    this.head.render(f5);
                    GlStateManager.popMatrix();

                    //Arm2
                    GlStateManager.pushMatrix();
                    GlStateManager.translatef(this.arm2.x, this.arm2.y, this.arm2.z);
                    GlStateManager.translatef(this.arm2.rotationPointX * f5, this.arm2.rotationPointY * f5, this.arm2.rotationPointZ * f5);
                    GlStateManager.scaled(0.5D, 0.5D, 0.5D);
                    GlStateManager.translatef(-this.arm2.x, -this.arm2.y, -this.arm2.z);
                    GlStateManager.translatef(-this.arm2.rotationPointX * f5, -this.arm2.rotationPointY * f5, -this.arm2.rotationPointZ * f5);
                    this.arm2.render(f5);
                    GlStateManager.popMatrix();

                    //Arm1
                    GlStateManager.pushMatrix();
                    GlStateManager.translatef(this.arm1.x, this.arm1.y, this.arm1.z);
                    GlStateManager.translatef(this.arm1.rotationPointX * f5, this.arm1.rotationPointY * f5, this.arm1.rotationPointZ * f5);
                    GlStateManager.scaled(0.5D, 0.5D, 0.5D);
                    GlStateManager.translatef(-this.arm1.x, -this.arm1.y, -this.arm1.z);
                    GlStateManager.translatef(-this.arm1.rotationPointX * f5, -this.arm1.rotationPointY * f5, -this.arm1.rotationPointZ * f5);
                    this.arm1.render(f5);
                    GlStateManager.popMatrix();

                    //Leg1
                    GlStateManager.pushMatrix();
                    GlStateManager.translatef(this.leg1sit.x, this.leg1sit.y, this.leg1sit.z);
                    GlStateManager.translatef(this.leg1sit.rotationPointX * f5, this.leg1sit.rotationPointY * f5, this.leg1sit.rotationPointZ * f5);
                    GlStateManager.scaled(0.5D, 0.5D, 0.5D);
                    GlStateManager.translatef(-this.leg1sit.x, -this.leg1sit.y, -this.leg1sit.z);
                    GlStateManager.translatef(-this.leg1sit.rotationPointX * f5, -this.leg1sit.rotationPointY * f5, -this.leg1sit.rotationPointZ * f5);
                    this.leg1sit.render(f5);
                    GlStateManager.popMatrix();

                    //Leg2
                    GlStateManager.pushMatrix();
                    GlStateManager.translatef(this.leg2ssit.x, this.leg2ssit.y, this.leg2ssit.z);
                    GlStateManager.translatef(this.leg2ssit.rotationPointX * f5, this.leg2ssit.rotationPointY * f5, this.leg2ssit.rotationPointZ * f5);
                    GlStateManager.scaled(0.5D, 0.5D, 0.5D);
                    GlStateManager.translatef(-this.leg2ssit.x, -this.leg2ssit.y, -this.leg2ssit.z);
                    GlStateManager.translatef(-this.leg2ssit.rotationPointX * f5, -this.leg2ssit.rotationPointY * f5, -this.leg2ssit.rotationPointZ * f5);
                    this.leg2ssit.render(f5);
                    GlStateManager.popMatrix();
                }
            } else {

                //HeadHat
                GlStateManager.pushMatrix();
                GlStateManager.translatef(this.headhat.x, this.headhat.y, this.headhat.z);
                GlStateManager.translatef(this.headhat.rotationPointX * f5, this.headhat.rotationPointY * f5, this.headhat.rotationPointZ * f5);
                GlStateManager.scaled(0.5D, 0.5D, 0.5D);
                GlStateManager.translatef(-this.headhat.x, -this.headhat.y, -this.headhat.z);
                GlStateManager.translatef(-this.headhat.rotationPointX * f5, -this.headhat.rotationPointY * f5, -this.headhat.rotationPointZ * f5);
                this.headhat.render(f5);
                GlStateManager.popMatrix();

                //Body
                GlStateManager.pushMatrix();
                GlStateManager.translatef(this.body.x, this.body.y, this.body.z);
                GlStateManager.translatef(this.body.rotationPointX * f5, this.body.rotationPointY * f5, this.body.rotationPointZ * f5);
                GlStateManager.scaled(0.5D, 0.5D, 0.5D);
                GlStateManager.translatef(-this.body.x, -this.body.y, -this.body.z);
                GlStateManager.translatef(-this.body.rotationPointX * f5, -this.body.rotationPointY * f5, -this.body.rotationPointZ * f5);
                this.body.render(f5);
                GlStateManager.popMatrix();

                //Head
                GlStateManager.pushMatrix();
                GlStateManager.translatef(this.head.x, this.head.y, this.head.z);
                GlStateManager.translatef(this.head.rotationPointX * f5, this.head.rotationPointY * f5, this.head.rotationPointZ * f5);
                GlStateManager.scaled(0.5D, 0.5D, 0.5D);
                GlStateManager.translatef(-this.head.x, -this.head.y, -this.head.z);
                GlStateManager.translatef(-this.head.rotationPointX * f5, -this.head.rotationPointY * f5, -this.head.rotationPointZ * f5);
                this.head.render(f5);
                GlStateManager.popMatrix();

                //Arm2
                GlStateManager.pushMatrix();
                GlStateManager.translatef(this.arm2.x, this.arm2.y, this.arm2.z);
                GlStateManager.translatef(this.arm2.rotationPointX * f5, this.arm2.rotationPointY * f5, this.arm2.rotationPointZ * f5);
                GlStateManager.scaled(0.5D, 0.5D, 0.5D);
                GlStateManager.translatef(-this.arm2.x, -this.arm2.y, -this.arm2.z);
                GlStateManager.translatef(-this.arm2.rotationPointX * f5, -this.arm2.rotationPointY * f5, -this.arm2.rotationPointZ * f5);
                this.arm2.render(f5);
                GlStateManager.popMatrix();

                //Arm1
                GlStateManager.pushMatrix();
                GlStateManager.translatef(this.arm1.x, this.arm1.y, this.arm1.z);
                GlStateManager.translatef(this.arm1.rotationPointX * f5, this.arm1.rotationPointY * f5, this.arm1.rotationPointZ * f5);
                GlStateManager.scaled(0.5D, 0.5D, 0.5D);
                GlStateManager.translatef(-this.arm1.x, -this.arm1.y, -this.arm1.z);
                GlStateManager.translatef(-this.arm1.rotationPointX * f5, -this.arm1.rotationPointY * f5, -this.arm1.rotationPointZ * f5);
                this.arm1.render(f5);
                GlStateManager.popMatrix();
                //Leg1
                GlStateManager.pushMatrix();
                GlStateManager.translatef(this.leg1.x, this.leg1.y, this.leg1.z);
                GlStateManager.translatef(this.leg1.rotationPointX * f5, this.leg1.rotationPointY * f5, this.leg1.rotationPointZ * f5);
                GlStateManager.scaled(0.5D, 0.5D, 0.5D);
                GlStateManager.translatef(-this.leg1.x, -this.leg1.y, -this.leg1.z);
                GlStateManager.translatef(-this.leg1.rotationPointX * f5, -this.leg1.rotationPointY * f5, -this.leg1.rotationPointZ * f5);
                this.leg1.render(f5);
                GlStateManager.popMatrix();
                //Leg 2
                GlStateManager.pushMatrix();
                GlStateManager.translatef(this.leg2.x, this.leg2.y, this.leg2.z);
                GlStateManager.translatef(this.leg2.rotationPointX * f5, this.leg2.rotationPointY * f5, this.leg2.rotationPointZ * f5);
                GlStateManager.scaled(0.5D, 0.5D, 0.5D);
                GlStateManager.translatef(-this.leg2.x, -this.leg2.y, -this.leg2.z);
                GlStateManager.translatef(-this.leg2.rotationPointX * f5, -this.leg2.rotationPointY * f5, -this.leg2.rotationPointZ * f5);
                this.leg2.render(f5);
                GlStateManager.popMatrix();
            }
        }
    }
    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(Cuboid model, float x, float y, float z) {
        model.pitch = x;
        model.yaw = y;
        model.roll = z;
    }
    @Override
    public void setAngles(T entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.head.pitch = f4 / (180F / (float) Math.PI);
        this.head.yaw = f3 / (180F / (float) Math.PI);
        this.headhat.pitch = f4 / (180F / (float) Math.PI);
        this.headhat.yaw = f3 / (180F / (float) Math.PI);
        this.arm1.pitch = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.leg2.pitch = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.arm2.pitch = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
        this.leg1.pitch = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
    }
}