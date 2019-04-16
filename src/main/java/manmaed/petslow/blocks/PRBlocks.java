package manmaed.petslow.blocks;


import manmaed.petslow.PetSlow;
import net.minecraft.block.Block;

/**
 * Created by manmaed on 24/02/2017.
 */
public class PRBlocks {
    //public static Block myblockname;
    public static Block claybrewkeg;


    public static void load() {
        //Init'ing
        //myblockname = new MyBlocksclass();
        claybrewkeg = new ClawBrewKeg("claybrewkeg");
        PetSlow.getRegistryHelper().registerBlock(claybrewkeg);
        // /Reg
        //PetSlow.getRegistryHelper().registerBlock(myblockname);
        //myblockname.setRegistryName("myblockname");
    }
}
