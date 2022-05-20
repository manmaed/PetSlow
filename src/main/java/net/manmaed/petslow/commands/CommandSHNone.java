package net.manmaed.petslow.commands;


import com.mojang.brigadier.builder.ArgumentBuilder;
import net.manmaed.petslow.hats.PSHats;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TranslatableComponent;

/**
 * Created by manmaed on 29/11/2019.
 */
public class CommandSHNone {
    public static ArgumentBuilder<CommandSourceStack, ?> register() {
        return Commands.literal("none").requires(cs -> cs.hasPermission(0)).executes(ctx -> run(ctx.getSource()));
    }

    private static int run(CommandSourceStack source) {
        PSHats.setHat("none");
        source.sendSuccess(new TranslatableComponent("petslow.mode.none"), true);
        return 0;
    }
}