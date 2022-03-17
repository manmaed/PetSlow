package net.manmaed.petslow.client.render.model;


/**
 * ModelPlayer - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelSlowpoke_old/*<T extends Entity> extends EntityModel<T>*/ {
   /* public ModelRenderer headhat;
    public ModelRenderer arm2;
    public ModelRenderer leg1;
    public ModelRenderer leg2;
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer arm1;

    //SittingLegs
    public ModelRenderer leg1sit;
    public ModelRenderer leg2ssit;*/

   /* public ModelSlowpoke_old() {
        this.texHeight = 64;
        this.texWidth = 32;
        this.headhat = new ModelRenderer(this, 32, 0);
        this.headhat.setPos(0.0F, 12.0F, 0.0F);
        this.headhat.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F);
        this.body = new ModelRenderer(this, 16, 16);
        this.body.setPos(0.0F, 12.0F, 0.0F);
        this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setPos(0.0F, 12.0F, 0.0F);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.arm2 = new ModelRenderer(this, 40, 16);
        this.arm2.setPos(-2.5F, 13.0F, 0.0F);
        this.arm2.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.arm1 = new ModelRenderer(this, 40, 16);
        this.arm1.mirror = true;
        this.arm1.setPos(2.5F, 13.0F, 0.0F);
        this.arm1.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.leg1 = new ModelRenderer(this, 0, 16);
        this.leg1.mirror = true;
        this.leg1.setPos(1.0F, 18.0F, 0.0F);
        this.leg1.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.leg2 = new ModelRenderer(this, 0, 16);
        this.leg2.setPos(-1.0F, 18.0F, 0.0F);
        this.leg2.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);

        this.leg2ssit = new ModelRenderer(this, 0, 16);
        this.leg2ssit.setPos(-1.0F, 17.0F, -1.0F);
        this.leg2ssit.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(leg2ssit, -1.5707963267948966F, 0.0F, 0.0F);
        this.leg1sit = new ModelRenderer(this, 0, 16);
        this.leg1sit.mirror = true;
        this.leg1sit.setPos(1.0F, 17.0F, -1.0F);
        this.leg1sit.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(leg1sit, -1.5707963267948966F, 0.0F, 0.0F);

        //head.addChild(headhat);

    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.xRot = headPitch / (180F / (float) Math.PI);
        this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.headhat.xRot = headPitch / (180F / (float) Math.PI);
        this.headhat.yRot = netHeadYaw / (180F / (float) Math.PI);
        this.arm1.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg2.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.arm2.xRot = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.leg1.xRot = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(headhat, arm2, leg1, leg2, head, body, arm1, leg1sit, leg2ssit);
    }

    @Override
    public void prepareMobModel(T entity, float limbSwing, float limbSwingAmount, float partialTick) {
        MatrixStack matrixStack = new MatrixStack();
        EntityMiniSlow entityMiniSlow = (EntityMiniSlow) entity;
        if (entityMiniSlow.isOrderedToSit()) {
            //No Slow
        }
        this.arm1.render(matrixStack, );
    }
*//*
    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        if ()
    }*//*

    *//**
     * This is a helper function from Tabula to set the rotation of model parts
     *//*
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }*/
}