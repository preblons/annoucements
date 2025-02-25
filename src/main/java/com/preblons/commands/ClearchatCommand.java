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

public class ClearchatCommand implements CommandExecutor {

    private Main plugin;

    public ClearchatCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("limpar.chat")) {
            sender.sendMessage("§cVocê não tem permissão para executar esse comando.");
            return false;
        }

        for (int i = 0; i < 1000; i++) {
            Bukkit.broadcastMessage(" ");
        }

        sender.sendMessage("§aChat limpo com sucesso!");

        return true;
    }
}
