package net.manmaed.petslow.sounds;


import net.manmaed.petslow.PetSlow;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Created by manmaed on 12/10/2021.
 */
public class PSSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Registries.SOUND_EVENT, PetSlow.MOD_ID);
    /* Example Of Sound Reg
    public static final RegistryObject<SoundEvent> HELLO = SOUNDS.register(
            "sounds.entity.mineturtle.hello",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Reference.MOD_ID, "sounds.entity.mineturtle.hello")));
    */
    public static final DeferredHolder<SoundEvent, ?> SLOW_DEATH = SOUNDS.register("sounds.entity.petslow.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(PetSlow.MOD_ID, "sounds.entity.petslow.death")));
    public static final DeferredHolder<SoundEvent, ?> SLOW_TAME = SOUNDS.register("sounds.entity.petslow.tamed", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(PetSlow.MOD_ID, "sounds.entity.petslow.tamed")));
}
