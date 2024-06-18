package net.manmaed.petslow.blocks;

import net.manmaed.petslow.PetSlow;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Created by manmaed on 24/02/2017.
 */
public class PSBlocks {
    //No Blocks To Add
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(PetSlow.MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PetSlow.MOD_ID);

    /*
     * Block:     public static final DeferredBlock<Block> MY_BLOCK = BLOCKS.register("my_block", MyBlock::new);
     * BlockItem: public static final DeferredItem<Item> MY_BLOCK_ITEM = ITEMS.register("my_block", () -> new BlockItem(MY_BLOCK.get()));
     */
}
