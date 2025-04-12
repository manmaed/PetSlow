package net.manmaed.petslow.items;


import net.manmaed.petslow.PetSlow;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Created by manmaed on 24/02/2017.
 */
public class PSItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PetSlow.MOD_ID);

    public static final DeferredItem<Item> SLOW_DOLL = ITEMS.register("slow_doll", SlowDoll::new);
    public static final DeferredItem<Item> MUG = ITEMS.register("mug", Mug::new);
    public static final DeferredItem<Item> SLOW_BREW = ITEMS.register("slow_brew", SlowBrew::new);
    public static final DeferredItem<Item> CLAY_BREW = ITEMS.register("clay_brew", ClayBrew::new);
    public static final DeferredItem<Item> MUG_LAVA = ITEMS.register("mug_lava", MugLava::new);
    public static final DeferredItem<Item> MUG_WATER = ITEMS.register("mug_water", MugWater::new);
    public static final DeferredItem<Item> MUG_MILK = ITEMS.register("mug_milk", MugMilk::new);
    public static final DeferredItem<Item> ULTIMATE_SLOW_BREW = ITEMS.register("ultimate_slow_brew", UltimateSlowBrew::new);
}
