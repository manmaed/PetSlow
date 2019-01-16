package manmaed.petslow.client.render.entity;

import manmaed.petslow.client.render.model.ModelSlowpoke;
import manmaed.petslow.entity.EntityMiniSlow;
import manmaed.petslow.libs.Textures;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

/**
 * Created by manmaed on 26/02/2017.
 */
public class RenderSlowpoke extends RenderLiving<EntityMiniSlow>
{

    public static final Factory FACTORY = new Factory();


    public RenderSlowpoke(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelSlowpoke(), 0.4F);
    }
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(EntityMiniSlow entity) {
        return Textures.SLOWPOKE;
    }

    public static class Factory implements IRenderFactory<EntityMiniSlow>
    {
        @Override
        public Render<? super EntityMiniSlow> createRenderFor(RenderManager manager)
        {
            return new RenderSlowpoke(manager);
        }
    }

}
