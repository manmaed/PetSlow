package net.manmaed.petslow.items;


import net.minecraft.world.item.Item;

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
    /*@Override
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
    }*/
}
