package com.dev_1.CreateTextDocument.CommandHandler;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CommandHandler implements CommandExecutor {

    final String path = ""; // Insert the path you would like the text documents to go to.

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!(commandSender instanceof Player)) {
            return true;
        }

        Player p = (Player) commandSender;

        if (command.getName().equalsIgnoreCase("reloadplugin")) {
            Bukkit.reload();
            p.sendMessage(ChatColor.GREEN + "Plugin reloaded successfully.");
            return true;
        }

        if (command.getName().equalsIgnoreCase("createtxt")) {
            if (!(args.length >= 2)) {
                p.sendMessage(ChatColor.RED + "Invalid usage!");
                return true;
            }
            String file_name = args[0] + ".txt";
            StringBuilder data = new StringBuilder();
            data.append(p.getName()).append(":");
            for (int i = 1; i < args.length; i++) {
                data.append(" ").append(args[i]);
            }
            String message = data.toString().trim();

            try {
                PrintWriter writer = new PrintWriter(new FileWriter(new File(path, file_name)));
                writer.println(message);
                writer.close();
                p.sendMessage(ChatColor.GREEN + "Successfully made file " + ChatColor.YELLOW + file_name + ChatColor.GREEN + "!");
            } catch (IOException e) {
                e.printStackTrace();
                p.sendMessage(ChatColor.RED + "Failed to make file " + ChatColor.YELLOW + file_name + ChatColor.RED + "!");
            }
            return true;
        }
        return false;
    }
}
