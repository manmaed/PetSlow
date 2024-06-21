package net.manmaed.petslow.datagen;

import net.manmaed.petslow.PetSlow;
import net.manmaed.petslow.items.PSItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {

    public static RecipeCategory category = RecipeCategory.BUILDING_BLOCKS;
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup) {
        super(output, lookup);
    }

    public static ResourceLocation getSave(String string) {
        return ResourceLocation.fromNamespaceAndPath(PetSlow.MOD_ID, string);
    }

    @Override
    protected void buildRecipes(RecipeOutput consumer) {
        makeMugs(consumer);
        makeSlowDoll(consumer);
    }

    protected static void makeMugs(RecipeOutput consumer) {
        //Mug
        ShapedRecipeBuilder.shaped(category, PSItems.MUG, 1)
                .define('s', Ingredient.of(Blocks.STONE))
                .define('b', Ingredient.of(Items.STONE_BUTTON))
                .pattern("sb")
                .unlockedBy("has_stone", has(Blocks.STONE))
                .save(consumer);

        //Mug Milk
        ShapelessRecipeBuilder.shapeless(category, PSItems.MUG_MILK, 1)
                .requires(Ingredient.of(Items.MILK_BUCKET))
                .requires(PSItems.MUG)
                .unlockedBy("has_mug", has(PSItems.MUG))
                .save(consumer);

        //Mug Lava
        ShapelessRecipeBuilder.shapeless(category, PSItems.MUG_LAVA, 1)
                .requires(Ingredient.of(Items.LAVA_BUCKET))
                .requires(PSItems.MUG)
                .unlockedBy("has_mug", has(PSItems.MUG))
                .save(consumer);

        //Mug Water
        ShapelessRecipeBuilder.shapeless(category, PSItems.MUG_WATER, 1)
                .requires(Ingredient.of(Items.WATER_BUCKET))
                .requires(PSItems.MUG)
                .unlockedBy("has_mug", has(PSItems.MUG))
                .save(consumer);

        //Mug Clay
        ShapedRecipeBuilder.shaped(category, PSItems.CLAY_BREW, 1)
                .define('c', Ingredient.of(Items.CLAY_BALL))
                .define('w', Ingredient.of(PSItems.MUG_WATER))
                .pattern("ccc")
                .pattern("cwc")
                .unlockedBy("has_mug", has(PSItems.MUG))
                .save(consumer);

        //Mug Slow
        ShapelessRecipeBuilder.shapeless(category, PSItems.SLOW_BREW, 1)
                .requires(Ingredient.of(Items.WHEAT))
                .requires(Ingredient.of(Items.APPLE))
                .requires(PSItems.MUG)
                .unlockedBy("has_mug", has(PSItems.MUG))
                .save(consumer);
    }

    protected static void makeSlowDoll(RecipeOutput consumer) {
        ShapedRecipeBuilder.shaped(category, PSItems.SLOW_DOLL, 1)
                .define('c', Ingredient.of(Items.CLAY_BALL))
                .define('f', Ingredient.of(Items.ROTTEN_FLESH))
                .define('s', Ingredient.of(Items.SUGAR))
                .define('t', Ingredient.of(Items.TORCH))
                .pattern("cfc")
                .pattern("scs")
                .pattern("ctc")
                .unlockedBy("has_mug", has(PSItems.MUG))
                .save(consumer);
    }
}
