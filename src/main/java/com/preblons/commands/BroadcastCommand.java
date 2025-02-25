/*
Meu Primeiro Projeto em java :)
BY: PREBLONS
 */

package com.preblons.commands;

import com.preblons.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class BroadcastCommand implements CommandExecutor {

    private Main plugin;

    public BroadcastCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("preblons.bc")) {
            sender.sendMessage("§cVocê não tem permissão de executar esse comando.");
            return false;
        }

        if (args.length == 0) {
            sender.sendMessage("§cPor favor, forneça uma mensagem.");
            return false;
        }

        FileConfiguration config = plugin.getConfig();
        String prefix = config.getString("prefix");

        String message = String.join(" ", args);

        String formattedMessage = prefix.replace("{message}", message);

        formattedMessage = formattedMessage.replace("&", "§");

        Bukkit.broadcastMessage(formattedMessage);

        return true;
    }
}
