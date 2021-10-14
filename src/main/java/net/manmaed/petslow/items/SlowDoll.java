package net.manmaed.petslow.items;

import net.manmaed.petslow.entity.EntityMiniSlow;
import net.manmaed.petslow.entity.PSEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.MobSpawnerTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.spawner.AbstractSpawner;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * Created by manmaed on 24/02/2017.
 */
public class SlowDoll extends Item {

    Random rand = new Random();

    public SlowDoll(Properties properties) {
        super(properties);
    }

    /*@Override
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
    }*/

    /*@Override
    public ActionResult<ItemStack> useOn(World world, PlayerEntity player, Hand hand) {
        if (!world.isClientSide) {
            ItemStack itemStack = player.getItemInHand(hand);
            itemStack.shrink(1);
            //TODO: Spawn Slow
     EntityMiniSlow miniSlow = new EntityMiniSlow(PSEntityTypes.SLOWPOKE.get(), world);
            miniSlow.setLocationFromBoundingbox(player.xRot, player.yRot, player.xRot);
            worldIn.spawnEntity(miniSlow);
        }
        return super.use(world, player, hand);
    }*/
    /**
     * Called when this item is used when targetting a Block
     */
    @Override
    public ActionResultType useOn(ItemUseContext context) {
        World world = context.getLevel();
        EntityType<?> entityType = PSEntityTypes.SLOWPOKE.get();
        if (world.isClientSide()) {
            return ActionResultType.SUCCESS;
        } else {
            ItemStack itemstack = context.getItemInHand();
            BlockPos blockpos = context.getClickedPos();
            Direction direction = context.getClickedFace();
            BlockState blockstate = world.getBlockState(blockpos);
            Block block = blockstate.getBlock();
            if (block == Blocks.SPAWNER) {
                TileEntity tileentity = world.getBlockEntity(blockpos);
                if (tileentity instanceof MobSpawnerTileEntity) {
                    AbstractSpawner abstractspawner = ((MobSpawnerTileEntity)tileentity).getSpawner();
                    abstractspawner.setEntityId(entityType);
                    tileentity.setChanged();
                    world.sendBlockUpdated(blockpos, blockstate, blockstate, 3);
                    itemstack.shrink(1);
                    return ActionResultType.SUCCESS;
                }
            }

            BlockPos blockpos1;
            if (blockstate.getCollisionShape(world, blockpos).isEmpty()) {
                blockpos1 = blockpos;
            } else {
                blockpos1 = blockpos.relative(direction);
            }

            if (entityType.spawn((ServerWorld)world, itemstack, context.getPlayer(), blockpos1, SpawnReason.SPAWN_EGG, true, !Objects.equals(blockpos, blockpos1) && direction == Direction.UP) != null) {
                itemstack.shrink(1);
            }

            return ActionResultType.SUCCESS;
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("item.petslow.slow_doll.tooltip"));
    }
}
