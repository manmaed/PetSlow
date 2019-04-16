package manmaed.petslow.client.render.entity;

import manmaed.petslow.client.render.model.ModelSlowpokeOnly;
import manmaed.petslow.entity.EntityBigSlow;
import manmaed.petslow.libs.Textures;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

/**
 * Created by manmaed on 26/02/2017.
 */
public class RenderSlowpokeBoss extends RenderLiving<EntityBigSlow> {

    public static final Factory FACTORY = new Factory();

    public RenderSlowpokeBoss(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelSlowpokeOnly(), 2.4F);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(EntityBigSlow entity) {
        return Textures.SLOWPOKE;
    }

    public static class Factory implements IRenderFactory<EntityBigSlow> {
        @Override
        public Render<? super EntityBigSlow> createRenderFor(RenderManager manager) {
            return new RenderSlowpokeBoss(manager);
        }
    }
}
