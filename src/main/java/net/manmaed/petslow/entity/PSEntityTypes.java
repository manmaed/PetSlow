package net.manmaed.petslow.entity;

import net.manmaed.petslow.libs.Reference;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Created by manmaed on 12/10/2021.
 */
public class PSEntityTypes {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Reference.MOD_ID);

    public static final RegistryObject<EntityType<EntityMiniSlow>> SLOWPOKE = ENTITY_TYPES.register("mini_slow", () -> EntityType.Builder.of(EntityMiniSlow::new, EntityClassification.MISC).sized(0.5f, 1.0f).build("mini_slow"));
}