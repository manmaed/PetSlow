package net.manmaed.petslow.client.render.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.manmaed.petslow.PetSlow;
import net.manmaed.petslow.client.model.PSModels;
import net.manmaed.petslow.client.render.layers.*;
import net.manmaed.petslow.client.render.model.ModelSlowpoke;
import net.manmaed.petslow.entity.EntityPetSlow;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

/**
 * Created by manmaed on 26/02/2017.
 */
public class RenderSlowpoke extends MobRenderer<EntityPetSlow, ModelSlowpoke> {

    public static final ResourceLocation SLOWPOKE = ResourceLocation.fromNamespaceAndPath(PetSlow.MOD_ID, "textures/entity/slowpoke.png");

    public RenderSlowpoke(EntityRendererProvider.Context context) {
        super(context, new ModelSlowpoke(context.bakeLayer(PSModels.PETSLOW)), 0.25F);
        //this.addLayer(new LayerClass(this, context.getModelSet)
        this.addLayer(new ChairLayerRenderer(this, context.getModelSet()));
        this.addLayer(new SignLayerRenderer(this, context.getModelSet()));
        this.addLayer(new BirthdayLayer(this, context.getModelSet()));
        this.addLayer(new HalloweenLayer(this, context.getModelSet()));
        this.addLayer(new ChristmasLayer(this, context.getModelSet()));
    }

    @Override
    public void render(EntityPetSlow p_115455_, float p_115456_, float p_115457_, PoseStack poseStack, MultiBufferSource p_115459_, int p_115460_) {
        poseStack.pushPose();
        poseStack.scale((float) 0.5D, (float) 0.5D, (float) 0.5D);
        //poseStack.translate(0f, 1.5f, 0f);
        super.render(p_115455_, p_115456_, p_115457_, poseStack, p_115459_, p_115460_);
        poseStack.popPose();
    }

    private ResourceLocation getloc(String filename){
        return ResourceLocation.fromNamespaceAndPath(PetSlow.MOD_ID, "textures/entity/" + filename + ".png");
    }

    @Override
    public ResourceLocation getTextureLocation(EntityPetSlow entityPetSlow) {
        String name = String.valueOf(entityPetSlow.getCustomName());
        if (name.contains("manmaed")) {
            return getloc("manmaed");
        } else return getloc("slowpoke");
    }
}
