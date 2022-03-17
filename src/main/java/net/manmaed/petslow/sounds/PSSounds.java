package net.manmaed.petslow.sounds;

import net.manmaed.petslow.libs.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Created by manmaed on 12/10/2021.
 */
public class PSSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Reference.MOD_ID);
    /* Example Of Sound Reg
    public static final RegistryObject<SoundEvent> HELLO = SOUNDS.register(
            "sounds.entity.mineturtle.hello",
            () -> new SoundEvent(new ResourceLocation(Reference.MOD_ID, "sounds.entity.mineturtle.hello")));
    */
    public static final RegistryObject<SoundEvent> SLOW_DEATH = SOUNDS.register("sounds.entity.mini_slow.death", () -> new SoundEvent(new ResourceLocation(Reference.MOD_ID, "sounds.entity.mini_slow.death")));

}
