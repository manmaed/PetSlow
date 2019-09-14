package net.manmaed.petslow.client.render.entity;

import net.manmaed.petslow.client.render.layers.ChairFeatureRenderer;
import net.manmaed.petslow.client.render.layers.SignFeatureRenderer;
import net.manmaed.petslow.client.render.model.ModelSlowpoke;
import net.manmaed.petslow.entity.EntityPetSlow;
import net.manmaed.petslow.libs.Reference;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Created by manmaed on 14/09/2019.
 */
public class EntityRendererPetSlow extends MobEntityRenderer<EntityPetSlow, ModelSlowpoke<EntityPetSlow>> {
    public EntityRendererPetSlow(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new ModelSlowpoke<>(), 0.25F);
        this.addFeature(new ChairFeatureRenderer(this));
        this.addFeature(new SignFeatureRenderer(this));
        /*this.addFeature(new BirthdayFeatureRenderer(this));
        this.addFeature(new ChristmasFeatureRenderer(this));
        this.addFeature(new HalloweenFeatureRenderer(this));
        this.addFeature(new SlowpokeFeatureRenderer(this));*/
        /*this.addFeature(toString());*/
    }

    private static final Identifier skinuntame = new Identifier(Reference.MOD_ID, "textures/entity/slowpoke.png");

    @Override
    protected Identifier getTexture(EntityPetSlow petSlow) {
        return skinuntame;
    }
}