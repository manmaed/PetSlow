package net.manmaed.petslow.items;

import net.manmaed.petslow.PetSlow;
import net.manmaed.petslow.libs.Reference;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Created by manmaed on 24/02/2017.
 */
public class PSItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MOD_ID);

    public static final RegistryObject<Item> spawn_Slow = ITEMS.register("spawn_slow", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> mug = ITEMS.register("mug", () -> new Mug(new Item.Properties()));
    public static final RegistryObject<Item> slow_Brew = ITEMS.register("slow_brew", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> clay_Brew = ITEMS.register("claybrew", () -> new Item(new Item.Properties()));

}

//public static Item itemname;
    /*public static Item mug;
    public static Item spawnslow;
    public static Item slowbrew;
    public static Item claybrew;

    public static void load() {
        //Init'ing
        //itemname = new ItemClass();
        spawnslow = new SlowSpawn("spawnslow");
        mug = new Mug("mug");
        slowbrew = new SlowBrew("slowbrew");
        claybrew = new ClayBrew("claybrew");
        //beer = new SlowDrinkItemBase("beer");


        //Registering
        //MainClass.getRegistryHelper().registerItem(itemname);
        PetSlow.getRegistryHelper().registerItem(spawnslow);
        PetSlow.getRegistryHelper().registerItem(mug);
        PetSlow.getRegistryHelper().registerItem(slowbrew);
        PetSlow.getRegistryHelper().registerItem(claybrew);

        //itemname.setRegistryName("itemname");
        *//*spawnslow.setRegistryName("spawnslow");
    }*/
