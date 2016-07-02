package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.TotalFreedomMod;
import me.totalfreedom.totalfreedommod.config.ConfigEntry;
import me.totalfreedom.totalfreedommod.config.MainConfig;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FLog;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.NON_OP, source = SourceType.BOTH)
@CommandParameters(description = "Shows information about TotalFreedomMod or reloads it", usage = "/<command> [reload]", aliases = "vfm")
public class Command_vickifreedommod extends FreedomCommand
{

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length == 1)
        {
            if (!args[0].equals("reload"))
            {
                return false;
            }

            if (!plugin.al.isAdmin(sender))
            {
                noPerms();
                return true;
            }

            plugin.config.load();
            plugin.services.stop();
            plugin.services.start();

            final String message = String.format("%s v%s reloaded.",
                    TotalFreedomMod.pluginName,
                    TotalFreedomMod.pluginVersion);

            msg(message);
            FLog.info(message);
            return true;
        }

        TotalFreedomMod.BuildProperties build = TotalFreedomMod.build;
        sender_sendMessage(ChatColor.RED + "Vicki" + ChatColor.GOLD + "Freedom" + ChatColor.AQUA + "Mod");
        msg("Running on " + ConfigEntry.SERVER_NAME.getString() + ".", ChatColor.GOLD);
        msg("Created by Madgeek1450 and Prozza.", ChatColor.GOLD);
        msg(ChatColor.GOLD + "Compiled and edited by" + ChatColor.DARK_PURPLE + "Loooll");
        msg(String.format("Version "
                + ChatColor.BLUE + "%s %s.%s " + ChatColor.GOLD + "("
                + ChatColor.BLUE + "%s" + ChatColor.GOLD + ")",
                build.codename,
                build.version,
                build.number,
                build.head), ChatColor.GOLD);
        msg(String.format("Compiled "
                + ChatColor.BLUE + "%s" + ChatColor.GOLD + " by "
                + ChatColor.BLUE + "%s",
                build.date,
                build.author), ChatColor.GOLD);
        return true;
    }

    private void sender_sendMessage(String string)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
