package net.manmaed.petslow;


import net.manmaed.petslow.blocks.PSBlocks;
import net.manmaed.petslow.items.PSItems;
import net.manmaed.petslow.sounds.PSSounds;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
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

    /*
    TODO:
    Add Slowpoke
    Add Chair
    Add Slow spawn item

     */
    public PetSlow() {
        IEventBus event = FMLJavaModLoadingContext.get().getModEventBus();
        PSItems.ITEMS.register(event);
        PSBlocks.BLOCKS.register(event);
        PSSounds.SOUNDS.register(event);
    }
    /*
    TODO: Mod! 1.18.2
     */
    /*public static final ItemGroup PETSLOW = new ItemGroup(Reference.MOD_ID) {
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
    }*/
}