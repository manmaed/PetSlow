package net.manmaed.petslow.client.render.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.manmaed.petslow.PetSlow;
import net.manmaed.petslow.client.model.PSModels;
import net.manmaed.petslow.client.render.model.ModelChair;
import net.manmaed.petslow.client.render.model.ModelSlowpoke;
import net.manmaed.petslow.entity.EntityPetSlow;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

/**
 * Created by manmaed on 14/10/2021.
 */
public class ChairLayerRenderer extends RenderLayer<EntityPetSlow, ModelSlowpoke> {
    private static final ResourceLocation CHAIR = ResourceLocation.fromNamespaceAndPath(PetSlow.MOD_ID, "textures/entity/chair.png");
    private final ModelChair hat;

    public ChairLayerRenderer(RenderLayerParent layerParent, EntityModelSet modelSet) {
        super(layerParent);
        this.hat = new ModelChair(modelSet.bakeLayer(PSModels.CHAIR));
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, EntityPetSlow entity, float p_117353_, float p_117354_, float p_117355_, float p_117356_, float p_117357_, float p_117358_) {
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entitySolid(CHAIR));
        poseStack.pushPose();
        poseStack.scale((float) 2.0D, (float) 2.0D, (float) 2.0D);
        poseStack.translate(0.0F, -0.75F, 0F);
        if (entity.isInSittingPose()) {
            hat.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, -1);
        }
        poseStack.popPose();
    }
}