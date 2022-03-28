package net.manmaed.petslow.client.model;

import net.manmaed.petslow.PetSlow;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

/**
 * Created by manmaed on 18/03/2022.
 */
public class PSModels {

    public static final ModelLayerLocation PETSLOW = makeModelLayerLocation("petslow");
    public static final ModelLayerLocation HAT = makeModelLayerLocation("hat");
    public static final ModelLayerLocation CHAIR = makeModelLayerLocation("chair");
    public static final ModelLayerLocation SIGN = makeModelLayerLocation("sign");

    public static ModelLayerLocation makeModelLayerLocation(String name) {
        return new ModelLayerLocation(new ResourceLocation(PetSlow.MOD_ID, name), name);
    }

}