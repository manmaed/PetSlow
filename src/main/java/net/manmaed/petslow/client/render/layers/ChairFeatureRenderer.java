package net.manmaed.petslow.client.render.layers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.manmaed.petslow.client.render.model.ModelChair;
import net.manmaed.petslow.client.render.model.ModelSlowpoke;
import net.manmaed.petslow.entity.EntityMiniSlow;
import net.manmaed.petslow.libs.LogHelper;
import net.manmaed.petslow.libs.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;

/**
 * Created by manmaed on 14/10/2021.
 */
public class ChairFeatureRenderer extends LayerRenderer<EntityMiniSlow, ModelSlowpoke<EntityMiniSlow>> {

    private final ModelChair modelChair = new ModelChair();
    private static final ResourceLocation CHAIR = new ResourceLocation(Reference.MOD_ID, "textures/entity/chair.png");

    public ChairFeatureRenderer(IEntityRenderer entityRenderer) {
        super(entityRenderer);
    }

    @Override
    public void render(MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLight, EntityMiniSlow entity, float pLimbSwing, float pLimbSwingAmount, float pPartialTicks, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        IVertexBuilder vertexBuilder = buffer.getBuffer(this.modelChair.renderType(CHAIR));
        LogHelper.fatal("CFR: " + entity.isOrderedToSit());
        if (true) {
            /*matrixStack.pushPose();*/
            bindTexture(CHAIR);
            modelChair.renderChair(matrixStack, vertexBuilder , packedLight, OverlayTexture.NO_OVERLAY);
            /*matrixStack.popPose();*/
        }
    }

    private void bindTexture(ResourceLocation rl) {
        Minecraft.getInstance().renderBuffers().bufferSource().getBuffer(this.modelChair.renderType(rl));
    }
}
