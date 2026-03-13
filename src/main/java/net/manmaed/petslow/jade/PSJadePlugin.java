package net.manmaed.petslow.jade;

import net.manmaed.petslow.entity.EntityPetSlow;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

/**
 * Made by manmaed on 13/03/2026
 */

@WailaPlugin
public class PSJadePlugin implements IWailaPlugin {

    @Override
    public void register(IWailaCommonRegistration registration) {
        registration.registerEntityDataProvider(PSComponentProvider.INSTANCE, EntityPetSlow.class);
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerEntityComponent(PSComponentProvider.INSTANCE, EntityPetSlow.class);

    }
}
