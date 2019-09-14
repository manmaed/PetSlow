package net.manmaed.petslow.item;

import net.manmaed.petslow.PetSlow;
import net.manmaed.petslow.entity.PSEntitys;
import net.manmaed.petslow.libs.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * Created by manmaed on 14/09/2019.
 */
public class PSItems {

     /* Example On Registering Items
    public static Item itemname;

    * in RegisterItems()
    itemname = new Item(new Item.Settings().group(PetRock.ITEM_GROUP));
    makeItems("nameofitem", itemname);
     */

     public static Item claybrew;
     public static Item mug;
     public static Item slowbrew;
     public static Item slowspawn;

     public static void RegisterItems() {
         mug = new Item(new Item.Settings().group(PetSlow.ITEM_GROUP));
         slowbrew = new Brew(new Item.Settings().group(PetSlow.ITEM_GROUP), "slowbrew");
         claybrew = new Brew(new Item.Settings().group(PetSlow.ITEM_GROUP), "claybrew");
         slowspawn = new SpawnEggItem(PSEntitys.petslow, 0, 0, new Item.Settings().group(PetSlow.ITEM_GROUP).maxCount(1));

         makeItems("mug", mug);
         makeItems("slowbrew", slowbrew);
         makeItems("claybrew", claybrew);
         makeItems("slowdoll", slowspawn);
     }

    public static void makeItems(String itemName, Item item){
        Registry.register(Registry.ITEM, new Identifier(Reference.MOD_ID, itemName), item);
    }
}
