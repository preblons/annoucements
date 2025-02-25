/*
Meu Primeiro Projeto em java :)
BY: PREBLONS
 */

package com.preblons.commands;

import com.preblons.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class ReloadCommand implements CommandExecutor {

    private final JavaPlugin plugin;

    public ReloadCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("preblons.reload")) {
            plugin.reloadConfig();
            sender.sendMessage("§aConfiguração recarregada com sucesso!");
            plugin.getLogger().info("Configuração recarregada com sucesso!");
        } else {
            sender.sendMessage("§cVocê não tem permissão para executar esse comando.");
        }
        return true;
    }
}
