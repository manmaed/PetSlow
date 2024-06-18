package net.manmaed.petslow.datagen;


import net.manmaed.petslow.PetSlow;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModLangProvider extends LanguageProvider {
    public ModLangProvider(PackOutput packOutput) {
        super(packOutput, PetSlow.MOD_ID, "en_us");
    }


    @Override
    protected void addTranslations() {

        boolean addedTop = false;
        if (!addedTop) {
            add("a.lang.file.name", "English US");
            add("a.lang.author.name", "manmaed");
            add("itemGroup." + PetSlow.MOD_ID, "PetSlow");
            addedTop = true;
            add("item.petslow.mug", "Mug");
            add("item.petslow.mug_water", "Mug of Water");
            add("item.petslow.mug_lava", "Mug of Lava");
            add("item.petslow.mug_milk", "Mug of Milk");
            add("item.petslow.clay_brew", "Clay Brew");
            add("item.petslow.slow_brew", "Slow Brew");
            add("item.petslow.mug.tooltip", "It's a Mug used to drink from");
            add("item.petslow.mug_water.tooltip", "Just a Glass of Water");
            add("item.petslow.mug_lava.tooltip", "Hot Stuff");
            add("item.petslow.mug_milk.tooltip", "Fresh Milk");
            add("item.petslow.clay_brew.tooltip", "Used to heal a tamed Mini Slowpoke");
            add("item.petslow.clay_brew.nfhc", "Not For Human Consumption");
            add("item.petslow.slow_brew.tooltip", "Used to tame a Mini Slowpoke");
            add("item.petslow.slow_doll", "Slowpoke Doll");
            add("item.petslow.slow_doll.tooltip.one", "Mini Slowpoke instructions,");
            add("item.petslow.slow_doll.tooltip.two", "* To tame it give it a Slow brew");
            add("item.petslow.slow_doll.tooltip.three", "* To heal it give it a Clay brew");
            add("entity.petslow.petslow", "Pet Slow");
            add("entity.petslow.death", "Pet Slow death");
            add("entity.petslow.tamed", "Pet Slow tamed");
            add("petslow.mode.christmas", "Happy Christmas!");
            add("petslow.mode.birthday", "Birthday mode enabled!");
            add("petslow.mode.halloween", "Happy Halloween!");
            add("petslow.mode.none", "Hats cleared!");
            add("petslow.command.reload", "Hats Reloaded!");
        }

    }
}
