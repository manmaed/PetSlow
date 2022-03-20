package net.manmaed.petslow.client.render.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.manmaed.petslow.PetSlow;
import net.manmaed.petslow.client.model.PSModels;
import net.manmaed.petslow.client.render.model.ModelSlowpoke;
import net.manmaed.petslow.client.render.model.ModelSlowpokeHat;
import net.manmaed.petslow.entity.EntityPetSlow;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

/**
 * Created by manmaed on 19/03/2022.
 */
public class HatLayerRender<T extends EntityPetSlow, M extends ModelSlowpoke<T>> extends RenderLayer<T, M> {

    private static final ResourceLocation SLOWPOKE = new ResourceLocation(PetSlow.MOD_ID, "textures/entity/slowpoke.png");
    private final ModelSlowpokeHat<T> hat;

    public HatLayerRender(RenderLayerParent<T, M> layerParent, EntityModelSet modelSet) {
        super(layerParent);
        this.hat = new ModelSlowpokeHat<>(modelSet.bakeLayer(PSModels.HAT));
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, T entity, float p_117353_, float p_117354_, float p_117355_, float p_117356_, float p_117357_, float p_117358_) {
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(SLOWPOKE));
        poseStack.pushPose();
        getParentModel().head.translateAndRotate(poseStack);
        poseStack.scale((float) 0.55D, (float) 0.55D, (float) 0.55D);
        poseStack.translate(0f, -0.12f, 0f);
        if (!entity.isAway()) {
            hat.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY,1f,1f,1f,1f);
        }
        poseStack.popPose();
    }
}
