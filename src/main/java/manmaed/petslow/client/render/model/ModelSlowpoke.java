package manmaed.petslow.client.render.model;

import manmaed.petslow.entity.EntityMiniSlow;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelPlayer - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelSlowpoke extends ModelBase {
    public ModelRenderer headhat;
    public ModelRenderer arm2;
    public ModelRenderer leg1;
    public ModelRenderer leg2;
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer arm1;

    //SittingLegs
    public ModelRenderer leg1sit;
    public ModelRenderer leg2ssit;

    //Chair
    public ModelRenderer chairbase;
    public ModelRenderer chairback;
    public ModelRenderer chairleg1;
    public ModelRenderer chairleg2;
    public ModelRenderer chairleg3;
    public ModelRenderer chairleg4;

    public ModelSlowpoke() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.headhat = new ModelRenderer(this, 32, 0);
        this.headhat.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.headhat.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F);
        this.body = new ModelRenderer(this, 16, 16);
        this.body.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.arm2 = new ModelRenderer(this, 40, 16);
        this.arm2.setRotationPoint(-2.5F, 13.0F, 0.0F);
        this.arm2.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.arm1 = new ModelRenderer(this, 40, 16);
        this.arm1.mirror = true;
        this.arm1.setRotationPoint(2.5F, 13.0F, 0.0F);
        this.arm1.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.leg1 = new ModelRenderer(this, 0, 16);
        this.leg1.mirror = true;
        this.leg1.setRotationPoint(1.0F, 18.0F, 0.0F);
        this.leg1.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.leg2 = new ModelRenderer(this, 0, 16);
        this.leg2.setRotationPoint(-1.0F, 18.0F, 0.0F);
        this.leg2.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);

        this.leg2ssit = new ModelRenderer(this, 0, 16);
        this.leg2ssit.setRotationPoint(-1.0F, 17.0F, -1.0F);
        this.leg2ssit.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(leg2ssit, -1.5707963267948966F, 0.0F, 0.0F);
        this.leg1sit = new ModelRenderer(this, 0, 16);
        this.leg1sit.mirror = true;
        this.leg1sit.setRotationPoint(1.0F, 17.0F, -1.0F);
        this.leg1sit.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(leg1sit, -1.5707963267948966F, 0.0F, 0.0F);

        //head.addChild(headhat);

    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        if(entity instanceof EntityMiniSlow) {
            EntityMiniSlow entityMiniSlow = (EntityMiniSlow) entity;
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
            if (entityMiniSlow.isSitting()) {

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
            } else {
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
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.head.rotateAngleX = f4 / (180F / (float)Math.PI);
        this.head.rotateAngleY = f3 / (180F / (float)Math.PI);
        this.headhat.rotateAngleX = f4 / (180F / (float)Math.PI);
        this.headhat.rotateAngleY = f3 / (180F / (float)Math.PI);
        this.arm1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.leg2.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.arm2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
        this.leg1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    }
}