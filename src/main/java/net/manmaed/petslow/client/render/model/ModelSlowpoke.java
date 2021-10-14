package net.manmaed.petslow.client.render.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelSlowpoke - manmaed
 * Created using Tabula 7.0.0 -> 8.0.0
 */
public class ModelSlowpoke<T extends Entity> extends SegmentedModel<T> {
    public ModelRenderer head;
    public ModelRenderer leg1;
    public ModelRenderer leg2;
    public ModelRenderer arm1;
    public ModelRenderer arm2;
    public ModelRenderer headhat;
    public ModelRenderer body;
    //Sitting Down:
    public ModelRenderer leg1sit;
    public ModelRenderer leg2sit;

    public ModelSlowpoke() {
        this.texWidth = 64;
        this.texHeight = 32;
        this.leg2 = new ModelRenderer(this, 0, 16);
        this.leg2.setPos(-2.0F, 12.0F, 0.0F);
        this.leg2.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.leg1 = new ModelRenderer(this, 0, 16);
        this.leg1.mirror = true;
        this.leg1.setPos(2.0F, 12.0F, 0.0F);
        this.leg1.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setPos(0.0F, 0.0F, 0.0F);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.leg2sit = new ModelRenderer(this, 0, 16);
        this.leg2sit.setPos(-2.0F, 10.0F, -1.0F);
        this.leg2sit.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(leg2sit, -1.5707963267948966F, 0.0F, 0.0F);
        this.arm2 = new ModelRenderer(this, 40, 16);
        this.arm2.setPos(-5.0F, 2.0F, 0.0F);
        this.arm2.addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.headhat = new ModelRenderer(this, 32, 0);
        this.headhat.setPos(0.0F, 0.0F, 0.0F);
        this.headhat.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.5F, 0.5F, 0.5F);
        this.leg1sit = new ModelRenderer(this, 0, 16);
        this.leg1sit.mirror = true;
        this.leg1sit.setPos(0.0F, 10.0F, -1.0F);
        this.leg1sit.addBox(0.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(leg1sit, -1.5707963267948966F, 0.0F, 0.0F);
        this.arm1 = new ModelRenderer(this, 40, 16);
        this.arm1.mirror = true;
        this.arm1.setPos(5.0F, 2.0F, 0.0F);
        this.arm1.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 16, 16);
        this.body.setPos(0.0F, 0.0F, 0.0F);
        this.body.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, 0.0F, 0.0F);
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(this.leg2, this.leg1, this.head, this.leg2sit, this.arm2, this.headhat, this.leg1sit, this.arm1, this.body);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.xRot = headPitch / (180F / (float) Math.PI);
        this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.headhat.xRot = headPitch / (180F / (float) Math.PI);
        this.headhat.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.arm1.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg2.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.arm2.xRot = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.leg1.xRot = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
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
