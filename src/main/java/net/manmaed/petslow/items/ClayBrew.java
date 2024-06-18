package net.manmaed.petslow.items;


import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Created by manmaed on 09/04/2019.
 */
public class ClayBrew extends Item {


    public ClayBrew(Properties properties) {
        super(properties);
    }

    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        if (!level.isClientSide)
            livingEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 60)); // FORGE - move up so stack.shrink does not turn stack into air
        if (livingEntity instanceof ServerPlayer) {
            ServerPlayer serverplayer = (ServerPlayer) livingEntity;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, itemStack);
            serverplayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (livingEntity instanceof Player && !((Player) livingEntity).getAbilities().instabuild) {
            itemStack.shrink(1);
        }

        return itemStack.isEmpty() ? new ItemStack(PSItems.MUG.get()) : itemStack;
    }

    public int getUseDuration(ItemStack p_42933_) {
        return 32;
    }

    public UseAnim getUseAnimation(ItemStack p_42931_) {
        return UseAnim.DRINK;
    }

    public InteractionResultHolder<ItemStack> use(Level p_42927_, Player p_42928_, InteractionHand p_42929_) {
        return ItemUtils.startUsingInstantly(p_42927_, p_42928_, p_42929_);
    }


    @Override
    public void appendHoverText(ItemStack stack, TooltipContext tooltipContext, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(Component.translatable("item.petslow.clay_brew.tooltip").setStyle(Style.EMPTY.withColor(ChatFormatting.YELLOW)));
        tooltip.add(Component.translatable("item.petslow.clay_brew.nfhc").setStyle(Style.EMPTY.withBold(true)));
    }
}
