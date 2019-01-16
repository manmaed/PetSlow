package manmaed.petslow.items;

import manmaed.petslow.PetSlow;
import net.minecraft.item.Item;

/**
 * Created by manmaed on 24/02/2017.
 */
public class PSItems {

    //public static Item itemname;
    public static Item spawnslow;


    public static void load() {
        //Init'ing
		//itemname = new ItemClass();
        spawnslow = new SlowSpawn();

        //Registering
        //MainClass.getRegistryHelper().registerItem(itemname);
        PetSlow.getRegistryHelper().registerItem(spawnslow);

        //itemname.setRegistryName("itemname");
        spawnslow.setRegistryName("spawnslow");

    }

}
