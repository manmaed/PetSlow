package net.manmaed.petslow.entity;

import net.manmaed.petslow.PetSlow;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Created by manmaed on 12/10/2021.
 */
public class PSEntityTypes {

    //TODO: Add Main Part of the mod
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, PetSlow.MOD_ID);

   public static final DeferredHolder<EntityType<?>, EntityType<EntityPetSlow>> SLOWPOKE = ENTITY_TYPES.register("petslow", () -> EntityType.Builder.of(EntityPetSlow::new, MobCategory.MISC)
           .sized(0.5f, 1.0f)
           .nameTagOffset(2f)
           .build("petslow"));
}
