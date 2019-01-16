package manmaed.petslow.client.render.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelPlayer - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelChair extends ModelBase {
    public ModelRenderer chairbase;
    public ModelRenderer chairback;
    public ModelRenderer leg1;
    public ModelRenderer leg2;
    public ModelRenderer leg3;
    public ModelRenderer leg4;

    public ModelChair() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.chairback = new ModelRenderer(this, 0, 9);
        this.chairback.setRotationPoint(0.0F, 12.5F, 2.0F);
        this.chairback.addBox(-2.5F, 0.0F, -0.5F, 5, 6, 1, 0.0F);
        this.leg2 = new ModelRenderer(this, 0, 0);
        this.leg2.setRotationPoint(-1.5F, 19.0F, 0.4F);
        this.leg2.addBox(-0.5F, 0.0F, 0.5F, 1, 5, 1, 0.0F);
        this.leg3 = new ModelRenderer(this, 0, 0);
        this.leg3.setRotationPoint(1.5F, 19.0F, 0.4F);
        this.leg3.addBox(-0.5F, 0.0F, -2.5F, 1, 5, 1, 0.0F);
        this.leg1 = new ModelRenderer(this, 0, 0);
        this.leg1.setRotationPoint(1.5F, 19.0F, 0.4F);
        this.leg1.addBox(-0.5F, 0.0F, 0.5F, 1, 5, 1, 0.0F);
        this.leg4 = new ModelRenderer(this, 0, 0);
        this.leg4.setRotationPoint(-1.5F, 19.0F, 0.4F);
        this.leg4.addBox(-0.5F, 0.0F, -2.5F, 1, 5, 1, 0.0F);
        this.chairbase = new ModelRenderer(this, 0, 2);
        this.chairbase.setRotationPoint(0.0F, 18.0F, -0.3F);
        this.chairbase.addBox(-2.5F, 0.0F, -2.5F, 5, 1, 5, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.chairback.render(f5);
        this.leg2.render(f5);
        this.leg3.render(f5);
        this.leg1.render(f5);
        this.leg4.render(f5);
        this.chairbase.render(f5);
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
