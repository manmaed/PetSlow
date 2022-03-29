package net.manmaed.petslow.commands;


import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.manmaed.petslow.hats.PSHats;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TextComponent;

/**
 * Created by manmaed on 29/11/2019.
 */
public class CommandSHHallowen {
    public static ArgumentBuilder<CommandSourceStack, ?> register() {
        return Commands.literal("halloween").requires(cs -> cs.hasPermission(0)).executes(ctx -> run(ctx.getSource()));
    }

    private static int run(CommandSourceStack source) throws CommandSyntaxException {
        PSHats.setHat("halloween");
        source.getEntity().sendMessage(new TextComponent("Happy Halloween!"), source.getPlayerOrException().getUUID());
        return 0;
    }
}
