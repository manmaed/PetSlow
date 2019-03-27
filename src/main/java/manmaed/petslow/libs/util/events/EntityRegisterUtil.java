package manmaed.petslow.libs.util.events;

import manmaed.petslow.PetSlow;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

/**
 * Created by manmaed on 11/07/2017.
 */
public class EntityRegisterUtil {

    public static void registerEntity(ResourceLocation texture, Class<? extends Entity> entityClass, String entityName, int id, int eggPrimary, int eggSecondary) {
        EntityRegistry.registerModEntity(texture, entityClass, entityName, id, PetSlow.instance, 64, 3, true, eggPrimary, eggSecondary);
    }
}
