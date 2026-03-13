package net.manmaed.petslow.jade;

import net.manmaed.petslow.PetSlow;
import net.minecraft.resources.ResourceLocation;

/**
 * Made by manmaed on 13/03/2026
 */

public interface PSJadeIds {
    ResourceLocation PETSLOW_STATS = PS("petslow_stats");

    static ResourceLocation PS(String path) {
        return ResourceLocation.fromNamespaceAndPath(PetSlow.MOD_ID, path);
    }
}
