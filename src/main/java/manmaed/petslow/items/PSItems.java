package manmaed.petslow.items;

import manmaed.petslow.PetSlow;
import net.minecraft.item.Item;

/**
 * Created by manmaed on 24/02/2017.
 */
public class PSItems {

    //public static Item itemname;
    public static Item mug;
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
        /*spawnslow.setRegistryName("spawnslow");*/

    }
}
