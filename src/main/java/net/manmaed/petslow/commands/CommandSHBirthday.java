package net.manmaed.petslow.commands;

import com.mojang.brigadier.builder.ArgumentBuilder;
import net.manmaed.petslow.hats.PSHats;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

/**
 * Created by manmaed on 29/11/2019.
 */
public class CommandSHBirthday {
    public static ArgumentBuilder<CommandSourceStack, ?> register() {
        return Commands.literal("birthday").requires(cs ->cs.hasPermission(0)).executes(ctx -> run(ctx.getSource()));
    }

    private static int run(CommandSourceStack stack) {
        PSHats.setHat("birthday");
        stack.sendSuccess(Component.translatable("petslow.mode.birthday"), true);
        return 0;
    }
}