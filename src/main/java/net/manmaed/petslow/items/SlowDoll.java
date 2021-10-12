package net.manmaed.petslow.items;

import net.manmaed.petslow.entity.PSEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

/**
 * Created by manmaed on 24/02/2017.
 */
public class SlowDoll extends Item {

    Random rand = new Random();

    public SlowDoll(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        World world = context.getLevel();
        if (world.isClientSide) {
            return ActionResultType.PASS;
        } else {
            ItemStack itemStack = context.getItemInHand();
            BlockPos blockPos = context.getClickedPos();
            Direction direction = context.getClickedFace();
            BlockState blockState = world.getBlockState(blockPos);
            Block block = blockState.getBlock();
            BlockPos blockpos1;
            if (blockState.getCollisionShape(world, blockPos).isEmpty()) {
                blockpos1 = blockPos;
            } else {
                blockpos1 = blockPos.relative(direction);
            }
            if (PSEntityTypes.SLOWPOKE.isPresent()) {
                itemStack.shrink(1);
            }
            return ActionResultType.PASS;
        }
    }

    /*@Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClientSide) {
            ItemStack itemStack = player.getItemInHand(hand);
            itemStack.shrink(1);
            //TODO: Spawn Slow
            *//*
     * @see net.minecraft.world.item.Items
     *//*
     *//*EntityMiniSlow miniSlow = new EntityMiniSlow(worldIn);
            miniSlow.setLocationAndAngles(playerIn.posX, playerIn.posY, playerIn.posZ, 10, 10);
            worldIn.spawnEntity(miniSlow);*//*
        }
        return super.use(world, player, hand);
    }*/

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("item.petslow.slow_doll.tooltip"));
        //tooltip.add("To tame a Mini Slowpoke give it a Slow brew, to heal it give it a Clay brew");
    }
}
