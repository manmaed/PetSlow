package net.manmaed.petslow.commands;


import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.manmaed.petslow.hats.PSHats;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

/**
 * Created by manmaed on 29/11/2019.
 */
public class CommandSHBirthday {
    public static ArgumentBuilder<CommandSourceStack, ?> register() {
        return Commands.literal("birthday").requires(cs -> cs.hasPermission(0)).executes(ctx -> run(ctx.getSource()));
    }

    private static int run(CommandSourceStack source) throws CommandSyntaxException {
        PSHats.setHat("birthday");
        return 0;
    }
}