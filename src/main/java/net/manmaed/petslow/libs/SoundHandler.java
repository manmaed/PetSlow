package net.manmaed.petslow.libs;

import net.manmaed.petslow.PetSlow;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Created by manmaed on 14/01/2019.
 */
public class SoundHandler {

    public static SoundEvent SLOWBOOP;
    public static SoundEvent SLOWDEATH;

    public static void registerSounds() {
        SLOWBOOP = registerSound("sounds.entity.minislow.boop");
        SLOWDEATH = registerSound("sounds.entity.minislow.death");
    }

    private static SoundEvent registerSound(String name) {
        ResourceLocation location = new ResourceLocation(PetSlow.MOD_ID, name);
        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(name);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;
    }
}
