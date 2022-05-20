package net.manmaed.petslow.commands;

import com.mojang.brigadier.builder.ArgumentBuilder;
import net.manmaed.petslow.hats.PSHats;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TextComponent;

/**
 * Created by manmaed on 29/11/2019.
 */
public class CommandSHChristmas {
    public static ArgumentBuilder<CommandSourceStack, ?> register() {
        return Commands.literal("christmas").requires(cs -> cs.hasPermission(0)).executes(ctx -> run(ctx.getSource()));
    }

    private static int run(CommandSourceStack source) {
        PSHats.setHat("christmas");
        source.sendSuccess(new TextComponent("petslow.mode.christmas"), true);
        return 0;
    }
}
