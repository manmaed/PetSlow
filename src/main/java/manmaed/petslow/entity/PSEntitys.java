package manmaed.petslow.entity;

import manmaed.petslow.libs.util.ResourceLocationHelper;
import manmaed.petslow.libs.util.events.EntityRegisterUtil;

/**
 * Created by manmaed on 26/02/2017.
 */
public class PSEntitys {

    public static void load()
    {
        /**
         * Register the mod entity type with FML
         * This will also register a spawn egg.

         * @param texture Main Texture?
         * @param entityClass The entity class
         * @param entityName A unique name for the entity
         * @param id A mod specific ID for the entity
         * @param eggPrimary Primary egg color BackGround
         * @param eggSecondary Secondary egg color Dots
         */

        int id = 1;


        EntityRegisterUtil.registerEntity(ResourceLocationHelper.getResourceLocation("minime"), EntityMiniSlow .class, "MiniSlow", id++ , 0xdcd5d5, 0x686565);
    }

}
