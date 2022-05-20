package net.manmaed.petslow.commands;


import com.mojang.brigadier.builder.ArgumentBuilder;
import net.manmaed.petslow.hats.PSHats;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TranslatableComponent;

/**
 * Created by manmaed on 29/11/2019.
 */
public class CommandSHHallowen {
    public static ArgumentBuilder<CommandSourceStack, ?> register() {
        return Commands.literal("halloween").requires(cs -> cs.hasPermission(0)).executes(ctx -> run(ctx.getSource()));
    }

    private static int run(CommandSourceStack source) {
        PSHats.setHat("halloween");
        source.sendSuccess(new TranslatableComponent("petslow.mode.halloween"), true);
        return 0;
    }
}
