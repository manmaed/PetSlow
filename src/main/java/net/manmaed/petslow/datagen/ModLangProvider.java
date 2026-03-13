package net.manmaed.petslow.datagen;


import net.manmaed.petslow.PetSlow;
import net.manmaed.petslow.datagen.lang.PSenus;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModLangProvider {
    public static void addTranslations(DataGenerator generator) {
        PackOutput output = generator.getPackOutput();
        generator.addProvider(true, new PSenus(output));
    }
}
