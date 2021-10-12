package net.manmaed.petslow.client.render.layers;

/**
 * Created by manmaed on 14/01/2019.
 */
//TODO: FIX CLASS
public class RenderSignLayer /*implements LayerRenderer<EntityMiniSlow>*/ {

   /* private final RenderSlowpoke renderer;
    private final ModelSign sign = new ModelSign();

    public RenderSignLayer(RenderSlowpoke renderer) {
        this.renderer = renderer;
    }

    @Override
    public void doRenderLayer(EntityMiniSlow entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        if (entitylivingbaseIn.isSitting()) {
            if (entitylivingbaseIn.getAway()) {
                GlStateManager.pushMatrix();
                bindTexture(Textures.SIGN);
                GlStateManager.translate(0F, 0F, 0F);
                float pitch = interpolateValues(entitylivingbaseIn.prevRotationPitch, entitylivingbaseIn.rotationPitch, partialTicks);
                //GlStateManager.rotate(pitch, 1.0F, 0.0F, 0.0F);
                sign.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
                GlStateManager.popMatrix();
            }
        }
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }

    private float interpolateValues(float prevVal, float nextVal, float partialTick) {
        return prevVal + partialTick * (nextVal - prevVal);
    }

    private void bindTexture(ResourceLocation rl) {
        Minecraft.getMinecraft().renderEngine.bindTexture(rl);
    }
*/
}
