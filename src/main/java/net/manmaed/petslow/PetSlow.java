package net.manmaed.petslow;


import net.manmaed.petslow.blocks.PSBlocks;
import net.manmaed.petslow.entity.EntityPetSlow;
import net.manmaed.petslow.entity.PSEntityTypes;
import net.manmaed.petslow.items.PSItems;
import net.manmaed.petslow.sounds.PSSounds;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * Created by manmaed on 24/02/2017.
 */

@Mod(PetSlow.MOD_ID)
public class PetSlow {

    public static final String MOD_ID = "petslow";
    public static final CreativeModeTab PETSLOW = new CreativeModeTab(PetSlow.MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(PSItems.SLOW_DOLL.get());
        }
    };

    public PetSlow() {
        IEventBus event = FMLJavaModLoadingContext.get().getModEventBus();
        PSItems.ITEMS.register(event);
        PSBlocks.BLOCKS.register(event);
        PSEntityTypes.ENTITY_TYPES.register(event);
        PSSounds.SOUNDS.register(event);
        event.addListener(this::AttributeCreation);
        event.addListener(PetSlowClient::doEntityRendering);
        event.addListener(PetSlowClient::registerLayerDefinitions);
        event.addListener(PetSlowClient::doClientStuff);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, PetSlowClient::registerClientCommands);
    }

    private void AttributeCreation(EntityAttributeCreationEvent event) {
        event.put(PSEntityTypes.SLOWPOKE.get(), EntityPetSlow.createAttributes().build());
    }

}