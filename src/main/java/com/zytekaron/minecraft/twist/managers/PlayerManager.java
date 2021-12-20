package com.zytekaron.minecraft.twist.managers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlayerManager {
    private final Map<Player, PlayerType> players;
    
    public PlayerManager() {
        this.players = new HashMap<>();
    }

    public void setType(Player player, PlayerType type) {
        this.players.put(player, type);
    }

    public void removeType(Player player) {
        this.players.remove(player);
    }

    public void clear() {
        this.players.clear();
    }
    
    public PlayerType getType(Player player) {
        return this.players.getOrDefault(player, PlayerType.SPECTATOR);
    }
    
    public boolean isHunter(Player player) {
        return this.getType(player) == PlayerType.HUNTER;
    }
    
    public boolean isRunner(Player player) {
        return this.getType(player) == PlayerType.RUNNER;
    }
    
    public boolean isNone(Player player) {
        return this.getType(player) == PlayerType.SPECTATOR;
    }
    
    public List<Player> getHunters() {
        return this.getPlayersWithType(PlayerType.HUNTER);
    }
    
    public List<Player> getRunners() {
        return this.getPlayersWithType(PlayerType.RUNNER);
    }
    
    public List<Player> getSpectators() {
        return this.getPlayersWithType(PlayerType.SPECTATOR);
    }
    
    public List<Player> getPlayersWithType(PlayerType type) {
        return Bukkit.getOnlinePlayers().stream()
                .filter(player -> getType(player) == type)
                .collect(Collectors.toList());
    }
}
