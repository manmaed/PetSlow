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

    public static final RegistryObject<Item> SLOW_DOLL = ITEMS.register("slow_doll", () -> new SlowDoll(new Item.Properties().tab(PetSlow.PETSLOW).stacksTo(1)));
    public static final RegistryObject<Item> MUG = ITEMS.register("mug", () -> new Mug(new Item.Properties().tab(PetSlow.PETSLOW)));
    public static final RegistryObject<Item> SLOW_BREW = ITEMS.register("slow_brew", () -> new SlowBrew(new Item.Properties().tab(PetSlow.PETSLOW).stacksTo(1)));
    public static final RegistryObject<Item> CLAY_BREW = ITEMS.register("clay_brew", () -> new ClayBrew(new Item.Properties().tab(PetSlow.PETSLOW).stacksTo(1)));

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
