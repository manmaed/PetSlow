package manmaed.petslow.libs;

import net.minecraft.util.ResourceLocation;

/**
 * Created by manmaed on 26/02/2017.
 */
public class Textures {

    public static final String MODEL_SHEET_LOCATION = "textures/entity/";
    public static final ResourceLocation SLOWPOKE = ResourceLocationHelper.getResourceLocation(MODEL_SHEET_LOCATION + "slowpoke.png");
    public static final ResourceLocation CHAIR = ResourceLocationHelper.getResourceLocation(MODEL_SHEET_LOCATION + "chair.png");
    public static final ResourceLocation SIGN = ResourceLocationHelper.getResourceLocation(MODEL_SHEET_LOCATION + "sign.png");


    private static class ResourceLocationHelper {
        public static ResourceLocation getResourceLocation(String modId, String path) {
            return new ResourceLocation(modId, path);
        }

        public static ResourceLocation getResourceLocation(String path) {
            return getResourceLocation(Reference.MOD_ID.toLowerCase(), path);
        }
    }
}
