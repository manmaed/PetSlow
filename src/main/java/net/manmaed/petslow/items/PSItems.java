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

    public static final DeferredItem<Item> SLOW_DOLL = ITEMS.register("slow_doll", () -> new SlowDoll(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> MUG = ITEMS.register("mug", () -> new Mug(new Item.Properties()));
    public static final DeferredItem<Item> SLOW_BREW = ITEMS.register("slow_brew", () -> new SlowBrew(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> CLAY_BREW = ITEMS.register("clay_brew", () -> new ClayBrew(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> MUG_LAVA = ITEMS.register("mug_lava", () -> new MugLava(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> MUG_WATER = ITEMS.register("mug_water", () -> new MugWater(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> MUG_MILK = ITEMS.register("mug_milk", () -> new MugMilk(new Item.Properties().stacksTo(1)));
}
