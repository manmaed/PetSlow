package net.manmaed.petslow;

import net.fabricmc.api.ClientModInitializer;
import net.manmaed.petslow.entity.PSEntityClient;

/**
 * Created by manmaed on 14/09/2019.
 */
public class PetSlowClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        PSEntityClient.loadRenders();
    }
}
