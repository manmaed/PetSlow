package net.manmaed.petslow;


import net.manmaed.petslow.blocks.PSBlocks;
import net.manmaed.petslow.client.resourcepack.EmbeddedPackSource;
import net.manmaed.petslow.entity.EntityPetSlow;
import net.manmaed.petslow.entity.PSEntityTypes;
import net.manmaed.petslow.items.PSItems;
import net.manmaed.petslow.sounds.PSSounds;
import net.manmaed.petslow.tab.PSTab;
import net.minecraft.server.packs.PackType;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforgespi.locating.IModFile;

/**
 * Created by manmaed on 24/02/2017.
 */

@Mod(PetSlow.MOD_ID)
public class PetSlow {

    public static final String MOD_ID = "petslow";
    public PetSlow(IEventBus event, ModContainer container) {
        PSItems.ITEMS.register(event);
        PSBlocks.BLOCKS.register(event);
        PSEntityTypes.ENTITY_TYPES.register(event);
        PSSounds.SOUNDS.register(event);
        PSTab.CREATIVE_TABS.register(event);
        event.addListener(this::AttributeCreation);
        event.addListener(PetSlowClient::doEntityRendering);
        event.addListener(PetSlowClient::registerLayerDefinitions);
        event.addListener(PetSlowClient::doClientStuff);
        NeoForge.EVENT_BUS.addListener(EventPriority.HIGH, PetSlowClient::registerClientCommands);

        IModFile modFile = container.getModInfo().getOwningFile().getFile();
        event.addListener((AddPackFindersEvent packFinderEvent) -> {
            if (packFinderEvent.getPackType() == PackType.CLIENT_RESOURCES) {
                packFinderEvent.addRepositorySource(new EmbeddedPackSource(modFile, "petslow_programmer_art", "resourcePack.petslow.programmer_art.name"));
            }
        });
    }

    private void AttributeCreation(EntityAttributeCreationEvent event) {
        event.put(PSEntityTypes.SLOWPOKE.get(), EntityPetSlow.createAttributes().build());
    }



}