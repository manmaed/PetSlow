package net.manmaed.petslow.commands;


import com.mojang.brigadier.CommandDispatcher;
import net.manmaed.petslow.PetSlow;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

/**
 * Created by manmaed on 29/11/2019.
 */
public class PSCommands {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {

        dispatcher.register(Commands.literal(PetSlow.MOD_ID).then(CommandSetHat.register()));
    }
}
