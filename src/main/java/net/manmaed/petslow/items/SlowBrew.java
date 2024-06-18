package net.manmaed.petslow.items;


import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.List;

/**
 * Created by manmaed on 09/04/2019.
 */
public class SlowBrew extends Item {

    public SlowBrew(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        if (livingEntity instanceof ServerPlayer serverPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, itemStack);
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
        }
        if (!level.isClientSide) {
           // livingEntity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 60)); // FORGE - move up so stack.shrink does not turn stack into air
        }
        if (livingEntity instanceof Player player) {
            return ItemUtils.createFilledResult(itemStack, player, new ItemStack(PSItems.MUG.get()), false);
        } else {
            itemStack.consume(1, livingEntity);
            return itemStack;
        }
    }

    @Override
    public int getUseDuration(ItemStack itemStack, LivingEntity livingEntity) {
        return 32;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack p_41452_) {
        return UseAnim.DRINK;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        return ItemUtils.startUsingInstantly(level, player,  hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext tooltipContext, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(Component.translatable("item.petslow.slow_brew.tooltip").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
    }
}
