package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.util.FUtil;
import me.totalfreedom.totalfreedommod.rank.Rank;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.ChatColor;


@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.BOTH)
@CommandParameters(description = "Shortcut to enable/disable WorldEdit.", usage = "/<command>")
public class Command_wetoggle extends FreedomCommand
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        Plugin targetPlugin = server.getPluginManager().getPlugin("WorldEdit");
        if (targetPlugin != null)
        {
            PluginManager pluginManager = plugin.getServer().getPluginManager();

            boolean enabled = targetPlugin.isEnabled();
            if (enabled)
            {
                pluginManager.disablePlugin(targetPlugin);
            }
            else
            {
                pluginManager.enablePlugin(targetPlugin);
            }

            FUtil.adminAction(sender.getName(), (!enabled ? "Enabled " : "Disabled ") + "WorldEdit.", true);
        }
        else
        {
            sender.sendMessage(targetPlugin + " is not installed on this server.");
        }

        return true;
    }
}