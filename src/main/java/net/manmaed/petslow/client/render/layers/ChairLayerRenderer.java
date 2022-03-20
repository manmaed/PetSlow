package net.manmaed.petslow.client.render.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.manmaed.petslow.PetSlow;
import net.manmaed.petslow.client.model.PSModels;
import net.manmaed.petslow.client.render.model.ModelChair;
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
 * Created by manmaed on 14/10/2021.
 */
public class ChairLayerRenderer<T extends EntityPetSlow, M extends ModelSlowpoke<T>> extends RenderLayer<T, M> {
    private static final ResourceLocation CHAIR = new ResourceLocation(PetSlow.MOD_ID, "textures/entity/chair.png");
    private final ModelChair<T> hat;

    public ChairLayerRenderer(RenderLayerParent<T, M> layerParent, EntityModelSet modelSet) {
        super(layerParent);
        this.hat = new ModelChair<>(modelSet.bakeLayer(PSModels.CHAIR));
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, T entity, float p_117353_, float p_117354_, float p_117355_, float p_117356_, float p_117357_, float p_117358_) {
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entitySolid(CHAIR));
        poseStack.pushPose();
        if (true/*entity.isInSittingPose()*/) {
            hat.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1f, 1f, 1f, 1f);
        }
        poseStack.popPose();
    }
}


/* extends LayerRenderer<EntityMiniSlow, ModelSlowpoke<EntityMiniSlow>>*/ /*{*/

    /*private final ModelChair modelChair = new ModelChair();
    private static final ResourceLocation CHAIR = new ResourceLocation(Reference.MOD_ID, "textures/entity/chair.png");

    public ChairFeatureRenderer(IEntityRenderer entityRenderer) {
        super(entityRenderer);
    }

    @Override
    public void render(MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLight, EntityMiniSlow entity, float pLimbSwing, float pLimbSwingAmount, float pPartialTicks, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        IVertexBuilder vertexBuilder = buffer.getBuffer(this.modelChair.renderType(CHAIR));
        LogHelper.fatal("CFR: " + entity.isOrderedToSit());
        if (true) {
            *//*matrixStack.pushPose();*//*
            bindTexture(CHAIR);
            modelChair.renderChair(matrixStack, vertexBuilder , packedLight, OverlayTexture.NO_OVERLAY);
            *//*matrixStack.popPose();*//*
        }
    }

    private void bindTexture(ResourceLocation rl) {
        Minecraft.getInstance().renderBuffers().bufferSource().getBuffer(this.modelChair.renderType(rl));
    }*/
/*}*/
