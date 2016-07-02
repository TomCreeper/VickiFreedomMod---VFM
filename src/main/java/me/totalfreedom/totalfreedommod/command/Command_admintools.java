package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.command.CommandParameters;
import me.totalfreedom.totalfreedommod.command.CommandPermissions;
import me.totalfreedom.totalfreedommod.command.FreedomCommand;
import me.totalfreedom.totalfreedommod.command.SourceType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.PlayerInventory;
import me.totalfreedom.totalfreedommod.rank.Rank;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Get the neccesary tools for administrating", usage = "/<command>")
public class Command_admintools extends FreedomCommand
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        PlayerInventory inv = sender_p.getInventory();
        ItemStack logstick = new ItemStack(Material.STICK, 1);
        ItemStack block = new ItemStack(Material.EMERALD_BLOCK, 1);
        ItemStack wand = new ItemStack(Material.WOOD_AXE, 1);
        ItemStack compass = new ItemStack(Material.COMPASS, 1);
        for (Enchantment ench : Enchantment.values())
            {
                logstick.addUnsafeEnchantment(ench, 127);
            }
        for (Enchantment ench : Enchantment.values())
            {
                block.addUnsafeEnchantment(ench, 127);
            }
            for (Enchantment ench : Enchantment.values())
            {
                wand.addUnsafeEnchantment(ench, 127);
            }
            
            ItemMeta logstickmeta = logstick.getItemMeta();
        logstickmeta.setDisplayName(ChatColor.YELLOW + "Logstick");     
            
            ItemMeta blockmeta = block.getItemMeta();
            blockmeta.setDisplayName(ChatColor.DARK_RED + "Emerald" + ChatColor.RED + "Block");
            
            ItemMeta wandmeta = wand.getItemMeta();
            wandmeta.setDisplayName(ChatColor.GREEN + "World" + ChatColor.DARK_GREEN + "Edit" + ChatColor.RED + " Wand");
            
            ItemMeta compassmeta = compass.getItemMeta();
            compassmeta.setDisplayName(ChatColor.DARK_RED + "Compass");
            
            
                inv.addItem(logstick);
                inv.addItem(block);
                inv.addItem(wand);
                inv.addItem(compass);
              
             sender_p.sendMessage(ChatColor.RED + "Administrating tools has been placed into your inventory");
        return true;
            }
 }