package net.manmaed.petslow.client.render.layers;

/**
 * Created by manmaed on 14/10/2021.
 */
public class ChairFeatureRenderer/* extends LayerRenderer<EntityMiniSlow, ModelSlowpoke<EntityMiniSlow>>*/ {

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
}
