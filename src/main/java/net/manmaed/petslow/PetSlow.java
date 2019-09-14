package net.manmaed.petslow;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.manmaed.petslow.entity.PSEntitys;
import net.manmaed.petslow.item.PSItems;
import net.manmaed.petslow.libs.Reference;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * Created by manmaed on 14/09/2019.
 */
public class PetSlow implements ModInitializer {

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier(Reference.MOD_ID, "itemgroup")).icon(() -> new ItemStack(PSItems.slowspawn)).build();
    public static final Identifier SLOW_DEATH_ID = new Identifier(Reference.MOD_ID, "petslow_death");
    public static SoundEvent SLOW_DEATH = new SoundEvent(SLOW_DEATH_ID);

    @Override
    public void onInitialize() {
        PSItems.RegisterItems();
        PSEntitys.RegisterEntitys();
        Registry.register(Registry.SOUND_EVENT, PetSlow.SLOW_DEATH_ID, SLOW_DEATH);
    }
}
