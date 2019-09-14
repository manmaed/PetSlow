package net.manmaed.petslow.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.render.EntityRendererRegistry;
import net.manmaed.petslow.client.render.entity.EntityRendererPetSlow;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.entity.Entity;

/**
 * Created by manmaed on 14/09/2019.
 */
public class PSEntityClient {

    @Environment(EnvType.CLIENT)
    public static void loadRenders() {
        EntityRendererRegistry.INSTANCE.register(EntityPetSlow.class, new EntityRendererRegistry.Factory() {
            @Environment(EnvType.CLIENT)
            @Override
            public EntityRenderer<? extends Entity> create(EntityRenderDispatcher r, EntityRendererRegistry.Context it) {
                return new EntityRendererPetSlow(r);
            }
        });
    }
}
