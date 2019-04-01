package manmaed.petslow.proxy;

import manmaed.petslow.client.render.entity.RenderSlowpoke;
import manmaed.petslow.client.render.layers.RenderChairLayer;
import manmaed.petslow.client.render.layers.RenderSignLayer;
import manmaed.petslow.entity.EntityMiniSlow;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraftforge.fml.client.registry.RenderingRegistry;


/**
 * Created by manmaed on 26/02/2017.
 */
public class ClientProxy extends CommonProxy {

    public void renderentitys() {
        RenderingRegistry.registerEntityRenderingHandler(EntityMiniSlow.class, RenderSlowpoke.FACTORY);
    }
    
    public void renderlayers() {
        Render render = Minecraft.getMinecraft().getRenderManager().getEntityClassRenderObject(EntityMiniSlow.class);
        if (render instanceof RenderSlowpoke) {
            RenderSlowpoke renderSlowpoke = (RenderSlowpoke) render;
            renderSlowpoke.addLayer(new RenderChairLayer(renderSlowpoke));
            renderSlowpoke.addLayer(new RenderSignLayer(renderSlowpoke));
        }
    }
}
