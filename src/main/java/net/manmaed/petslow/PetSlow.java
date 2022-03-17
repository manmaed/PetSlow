package net.manmaed.petslow;


import net.manmaed.petslow.blocks.PSBlocks;
import net.manmaed.petslow.client.render.entity.RenderSlowpoke;
import net.manmaed.petslow.entity.EntityMiniSlow;
import net.manmaed.petslow.entity.PSEntityTypes;
import net.manmaed.petslow.items.PSItems;
import net.manmaed.petslow.libs.Reference;
import net.manmaed.petslow.sounds.PSSounds;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * Created by manmaed on 24/02/2017.
 */

@Mod(Reference.MOD_ID)
public class PetSlow {

    /*
    TODO: Entity Work!
     */
    public static final ItemGroup PETSLOW = new ItemGroup(Reference.MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(PSItems.SLOW_DOLL.get());
        }
    };

    public PetSlow() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        PSItems.ITEMS.register(eventBus);
        PSBlocks.BLOCKS.register(eventBus);
        PSEntityTypes.ENTITY_TYPES.register(eventBus);
        PSSounds.SOUNDS.register(eventBus);

        eventBus.addListener(PetSlowClient::doClientStuff);
        eventBus.addListener(PetSlow::entityAttribute);
    }
    public static void init(final FMLCommonSetupEvent event) {
        DeferredWorkQueue.runLater(PetSlow::initEntitys);
    }

    public static void entityAttribute(final EntityAttributeCreationEvent event) {
        event.put(PSEntityTypes.SLOWPOKE.get(), EntityMiniSlow.setCustomAttributes().build());
    }
    public static void initEntitys() {
        GlobalEntityTypeAttributes.put(PSEntityTypes.SLOWPOKE.get(), EntityMiniSlow.setCustomAttributes().build());
    }
}