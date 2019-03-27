package manmaed.petslow.libs;

import net.minecraft.util.ResourceLocation;

/**
 * Created by manmaed on 13/01/2019.
 */
public class SoundFiles {

    public static final String SOUNDFILES = "textures/entity/";
    public static final ResourceLocation SLOWPOKE = ResourceLocationHelper.getResourceLocation(SOUNDFILES + "slowpoke64.ogg");

    private static class ResourceLocationHelper {
        public static ResourceLocation getResourceLocation(String modId, String path) {
            return new ResourceLocation(modId, path);
        }

        public static ResourceLocation getResourceLocation(String path) {
            return getResourceLocation(Reference.MOD_ID.toLowerCase(), path);
        }
    }
}
