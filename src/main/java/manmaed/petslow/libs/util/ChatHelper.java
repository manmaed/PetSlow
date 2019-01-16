package manmaed.petslow.libs.util;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.FMLCommonHandler;

/**
 * Created by manmaed on 03/03/2017.
 */
public class ChatHelper {

    public static void sendChatMessageToPlayer(TextComponentString message, EntityPlayer player)
    {
        player.sendMessage(message);
    }
    public static void sendChatMessageToSender(TextComponentString message, ICommandSender sender)
    {
        sender.sendMessage(message);
    }

    public static void sendChatMessageServerWide(TextComponentString message) {
        for (EntityPlayer player : getServer().getPlayerList().getPlayers()) {
            player.sendMessage(message);

        }
    }
    public static MinecraftServer getServer() {

        return FMLCommonHandler.instance().getMinecraftServerInstance();
    }

}
