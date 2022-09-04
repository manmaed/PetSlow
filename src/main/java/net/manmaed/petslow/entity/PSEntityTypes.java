package net.manmaed.petslow.entity;

import net.manmaed.petslow.PetSlow;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Created by manmaed on 12/10/2021.
 */
public class PSEntityTypes {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, PetSlow.MOD_ID);

    public static final RegistryObject<EntityType<EntityPetSlow>> SLOWPOKE = ENTITY_TYPES.register("petslow", () -> EntityType.Builder.of(EntityPetSlow::new, MobCategory.MISC).sized(0.5f, 1.0f).build("petslow"));
}
