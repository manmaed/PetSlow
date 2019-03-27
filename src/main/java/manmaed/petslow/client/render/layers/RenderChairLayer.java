package manmaed.petslow.client.render.layers;

import manmaed.petslow.client.render.entity.RenderSlowpoke;
import manmaed.petslow.client.render.model.ModelChair;
import manmaed.petslow.entity.EntityMiniSlow;
import manmaed.petslow.libs.Textures;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;

/**
 * Created by manmaed on 14/01/2019.
 */
public class RenderChairLayer implements LayerRenderer<EntityMiniSlow> {

    private final RenderSlowpoke renderer;
    private final ModelChair chair = new ModelChair();

    public RenderChairLayer(RenderSlowpoke renderer) {
        this.renderer = renderer;
    }

    @Override
    public void doRenderLayer(EntityMiniSlow entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        if (entitylivingbaseIn.isSitting()) {
            GlStateManager.pushMatrix();
            bindTexture(Textures.CHAIR);
            GlStateManager.translate(0F, 0F, 0F);
            float pitch = interpolateValues(entitylivingbaseIn.prevRotationPitch, entitylivingbaseIn.rotationPitch, partialTicks);
            //GlStateManager.rotate(pitch, 1.0F, 0.0F, 0.0F);
            chair.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
            GlStateManager.popMatrix();
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
}
