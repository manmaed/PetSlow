package net.manmaed.petslow.items;


import net.manmaed.petslow.PetSlow;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Created by manmaed on 24/02/2017.
 */
public class PSItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PetSlow.MOD_ID);

    public static final RegistryObject<Item> SLOW_DOLL = ITEMS.register("slow_doll", () -> new SlowDoll(new Item.Properties().tab(PetSlow.PETSLOW).stacksTo(1)));
    /*public static final RegistryObject<Item> MUG = ITEMS.register("mug", () -> new Mug(new Item.Properties().tab(PetSlow.PETSLOW)));
    public static final RegistryObject<Item> SLOW_BREW = ITEMS.register("slow_brew", () -> new SlowBrew(new Item.Properties().tab(PetSlow.PETSLOW).stacksTo(1)));
    public static final RegistryObject<Item> CLAY_BREW = ITEMS.register("clay_brew", () -> new ClayBrew(new Item.Properties().tab(PetSlow.PETSLOW).stacksTo(1)));
    public static final RegistryObject<Item> MUG_LAVA = ITEMS.register("mug", () -> new MugLava(new Item.Properties().tab(PetSlow.PETSLOW)));
    public static final RegistryObject<Item> MUG_WATER = ITEMS.register("mug", () -> new MugWater(new Item.Properties().tab(PetSlow.PETSLOW)));
    public static final RegistryObject<Item> MUG_MILK = ITEMS.register("mug", () -> new MugMilk(new Item.Properties().tab(PetSlow.PETSLOW)));*/
}
