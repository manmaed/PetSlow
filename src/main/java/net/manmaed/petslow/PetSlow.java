package net.manmaed.petslow;


import net.manmaed.petslow.blocks.PSBlocks;
import net.manmaed.petslow.entity.EntityPetSlow;
import net.manmaed.petslow.entity.PSEntityTypes;
import net.manmaed.petslow.items.PSItems;
import net.manmaed.petslow.sounds.PSSounds;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;
import java.util.List;

/**
 * Created by manmaed on 24/02/2017.
 */

@Mod(PetSlow.MOD_ID)
public class PetSlow {

    public static final String MOD_ID = "petslow";
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);
    public static final RegistryObject<CreativeModeTab> PETSLOW_TAB = CREATIVE_MODE_TABS.register(MOD_ID, () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(PSItems.SLOW_DOLL.get()))
            .title(Component.translatable("itemGroup." + MOD_ID ))
            .displayItems((parameters, output) -> {
                List<DeferredRegister<Item>> myItems = Arrays.asList(
                        PSItems.ITEMS
                );
                for (DeferredRegister<Item> register: myItems) {
                    register.getEntries().forEach(entry -> output.accept(entry.get()));
                }
            })
            .build());

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
        CREATIVE_MODE_TABS.register(event);
    }

    private void AttributeCreation(EntityAttributeCreationEvent event) {
        event.put(PSEntityTypes.SLOWPOKE.get(), EntityPetSlow.createAttributes().build());
    }

}