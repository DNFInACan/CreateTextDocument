package com.dev_1.CreateTextDocument;

import com.dev_1.CreateTextDocument.CommandHandler.CommandHandler;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class CreateTextDocument extends JavaPlugin {

    @Override
    public void onEnable() {
        String[] commands = new String[] {
                "createtxt",
                "reloadplugin"
        };
        for (String s : Arrays.asList(commands)) {
            getCommand(s).setExecutor(new CommandHandler());
        }
    }

    @Override
    public void onDisable() {
    }
}
