package net.manmaed.petslow.libs.util;

import net.manmaed.petslow.libs.Reference;
import net.minecraft.util.ResourceLocation;

/**
 * Created by manmaed on 05/08/2017.
 */
public class ResourceLocationHelper {

    public static ResourceLocation getResourceLocation(String modId, String path) {
        return new ResourceLocation(modId, path);
    }

    public static ResourceLocation getResourceLocation(String path) {
        return getResourceLocation(Reference.MOD_ID.toLowerCase(), path);
    }
}