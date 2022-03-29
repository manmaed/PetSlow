package net.manmaed.petslow.commands;

import com.mojang.brigadier.builder.ArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

/**
 * Created by manmaed on 29/11/2019.
 */
public class CommandSetHat {
    public static ArgumentBuilder<CommandSourceStack, ?> register() {
        return Commands.literal("sethat").requires(cs -> cs.hasPermission(0)).then(CommandSHBirthday.register()).then(CommandSHChristmas.register()).then(CommandSHHallowen.register()).then(CommandSHNone.register());
    }
}
