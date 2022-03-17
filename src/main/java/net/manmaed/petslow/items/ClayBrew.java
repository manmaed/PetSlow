package net.manmaed.petslow.items;


import net.minecraft.world.item.Item;

/**
 * Created by manmaed on 09/04/2019.
 */
public class ClayBrew extends Item {


    public ClayBrew(Properties properties) {
        super(properties);
    }

    /*@Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("item.petslow.clay_brew.tooltip"));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        super.finishUsingItem(stack, worldIn, entityLiving);
        if (entityLiving instanceof ServerPlayerEntity) {
            ServerPlayerEntity player = (ServerPlayerEntity) entityLiving;
            CriteriaTriggers.CONSUME_ITEM.trigger(player, stack);
            player.awardStat(Stats.ITEM_USED.get(this));
        }
        if (!worldIn.isClientSide) {
            //TODO: Change?
            entityLiving.curePotionEffects(stack);
        }
        if (stack.isEmpty()) {
            return new ItemStack(PSItems.MUG.get());
        } else {
            if (entityLiving instanceof PlayerEntity && !((PlayerEntity) entityLiving).abilities.instabuild) {
                ItemStack itemStack = new ItemStack(PSItems.MUG.get());
                PlayerEntity player = (PlayerEntity) entityLiving;
                if (!player.inventory.add(itemStack)) {
                    player.drop(itemStack, false);
                }
            }
            return stack;
        }
    }

    *//**
     * How long it takes to use or consume an item
     *//*
    public int getUseDuration(ItemStack stack) {
        return 32;
    }

    public UseAction getUseAnimation(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public SoundEvent getDrinkingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        return DrinkHelper.useDrink(world, player, hand);
    }*/
}
