package net.manmaed.petslow.tab;


import net.manmaed.petslow.PetSlow;
import net.manmaed.petslow.items.PSItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Arrays;
import java.util.List;

public class PSTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PetSlow.MOD_ID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> PETSLOW_TAB = CREATIVE_TABS.register(PetSlow.MOD_ID, () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(PSItems.SLOW_DOLL.get()))
            .title(Component.translatable("itemGroup." + PetSlow.MOD_ID ))
            .displayItems((parameters, output) -> {
                List<DeferredRegister<Item>> myItems = Arrays.asList(
                        PSItems.ITEMS
                );
                for (DeferredRegister<Item> register: myItems) {
                    register.getEntries().forEach(entry -> output.accept(entry.get()));
                }
            })
            .build());
}
