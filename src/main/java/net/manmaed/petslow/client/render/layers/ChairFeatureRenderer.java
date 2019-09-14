package net.manmaed.petslow.client.render.layers;

import com.mojang.blaze3d.platform.GlStateManager;
import net.manmaed.petslow.client.render.model.ModelChair;
import net.manmaed.petslow.client.render.model.ModelSlowpoke;
import net.manmaed.petslow.entity.EntityPetSlow;
import net.manmaed.petslow.libs.Reference;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.util.Identifier;

/**
 * Created by manmaed on 14/01/2019.
 */
public class ChairFeatureRenderer extends FeatureRenderer<EntityPetSlow, ModelSlowpoke<EntityPetSlow>> {

    private final ModelChair chair = new ModelChair();
    private static final Identifier skin = new Identifier(Reference.MOD_ID, "textures/entity/chair.png");

    public ChairFeatureRenderer(FeatureRendererContext<EntityPetSlow, ModelSlowpoke<EntityPetSlow>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public void render(EntityPetSlow petSlow, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        if (petSlow.isSitting()) {
            GlStateManager.pushMatrix();
            bindTexture(skin);
            GlStateManager.translatef(0F, 0F, 0F);
            float pitch = interpolateValues(petSlow.prevPitch, petSlow.pitch, partialTicks);
            //GlStateManager.rotate(pitch, 1.0F, 0.0F, 0.0F);
            chair.render(petSlow, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
            GlStateManager.popMatrix();
        }
    }

    private float interpolateValues(float prevVal, float nextVal, float partialTick) {
        return prevVal + partialTick * (nextVal - prevVal);
    }

    @Override
    public boolean hasHurtOverlay() {
        return false;
    }
}
