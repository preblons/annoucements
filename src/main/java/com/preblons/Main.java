/*
Meu Primeiro Projeto em java :)
BY: PREBLONS
 */

package com.preblons;

import com.preblons.commands.BroadcastCommand;
import com.preblons.commands.ClearchatCommand;
import com.preblons.commands.ReloadCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.InputStreamReader;
import java.io.Reader;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Iniciando PreblonsAnnouncements...");

        this.saveDefaultConfig();

        try (Reader reader = new InputStreamReader(getResource("config.yml"), "UTF-8")) {
        } catch (Exception e) {
            getLogger().severe("Erro ao carregar o config.yml com UTF-8: " + e.getMessage());
        }

        if (getCommand("broadcast") != null) {
            getCommand("broadcast").setExecutor(new BroadcastCommand(this));
        } else {
            getLogger().severe("Comando 'broadcast' não encontrado no plugin.yml");
        }

        if (getCommand("clearchat") != null) {
            getCommand("clearchat").setExecutor(new ClearchatCommand(this));
        } else {
            getLogger().severe("Comando 'clearchat' não encontrado no plugin.yml");
        }
        if (getCommand("announcements-reload") != null) {
            getCommand("announcements-reload").setExecutor(new ReloadCommand(this));
        } else {
            getLogger().severe("Comando 'announcements-reload' não encontrado no plugin.yml");
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("Desligando PreblonsAnnouncements...");
    }
}
