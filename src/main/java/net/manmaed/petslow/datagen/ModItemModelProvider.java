package net.manmaed.petslow.datagen;

import net.manmaed.petslow.PetSlow;
import net.manmaed.petslow.items.PSItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.Objects;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, PetSlow.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        handheldItem(PSItems.SLOW_DOLL.get());
        handheldItem(PSItems.MUG.get());
        handheldItem(PSItems.SLOW_BREW.get());
        handheldItem(PSItems.CLAY_BREW.get());
        handheldItem(PSItems.MUG_LAVA.get());
        handheldItem(PSItems.MUG_WATER.get());
        handheldItem(PSItems.MUG_MILK.get());
        handheldItem(PSItems.ULTIMATE_SLOW_BREW.get());
    }

    public ItemModelBuilder handheldItem(Item item) {
        return handheldItem(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item)));
    }

    public ItemModelBuilder handheldItem(ResourceLocation item) {
        return getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + item.getPath()));
    }
}
