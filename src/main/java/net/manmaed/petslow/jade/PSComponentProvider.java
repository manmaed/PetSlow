package net.manmaed.petslow.jade;

import net.manmaed.petslow.entity.EntityPetSlow;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.EntityAccessor;
import snownee.jade.api.IEntityComponentProvider;
import snownee.jade.api.IServerDataProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;

/**
 * Made by manmaed on 13/03/2026
 */

public enum PSComponentProvider implements IEntityComponentProvider, IServerDataProvider<EntityAccessor> {
    INSTANCE;

    @Override
    public void appendTooltip(ITooltip tooltip, EntityAccessor entityAccessor, IPluginConfig iPluginConfig) {
        if (entityAccessor.getServerData().contains("AFK")) {
            tooltip.add(Component.translatable("petslow.entity.petslow.afk", entityAccessor.getServerData().getBoolean("AFK")));
        }
        if (entityAccessor.getServerData().contains("TorchCount")) {
            if (entityAccessor.getServerData().getInt("TorchCount") == 0) {
                tooltip.add(Component.translatable("petslow.entity.petslow.torchcount.none"));
            } else {
                tooltip.add(Component.translatable("petslow.entity.petslow.torchcount.some", entityAccessor.getServerData().getInt("TorchCount")));
            }
        }
    }

    @Override
    public void appendServerData(CompoundTag compoundTag, EntityAccessor entityAccessor) {
        EntityPetSlow petSlow = (EntityPetSlow) entityAccessor.getEntity();
        compoundTag.putBoolean("AFK", petSlow.isAway());
        compoundTag.putInt("TorchCount", petSlow.getTorchCount());
    }

    @Override
    public ResourceLocation getUid() {
        return PSJadeIds.PETSLOW_STATS;
    }
}
