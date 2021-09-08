package me.RafaelAulerDeMeloAraujo.ScoreboardManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class TablistPrefix {

    private final Scoreboard scoreboard;

    public TablistPrefix(Scoreboard scoreboard){
        this.scoreboard = scoreboard;
        registerPrefix("aDono", "§4[Dono] ");
        registerPrefix("bDiretor", "§3[Diretor] ");
        registerPrefix("cAdmin", "§b[Admin] ");
        registerPrefix("dGerente", "§9[Gerente] ");
        registerPrefix("eCoordenador", "§5[Coordenador] ");
        registerPrefix("fModerador", "§2[Moderador] ");
        registerPrefix("gAjudante", "§e[Ajudante] ");
        registerPrefix("hYoutuber", "§b[Youtuber] ");
        registerPrefix("iMiniYT", "§c[MiniYT] ");
        registerPrefix("jRuby", "§c[Ruby] ");
        registerPrefix("kChampion", "§d[Champion] ");
        registerPrefix("lVip", "§a[Vip] ");
        registerPrefix("mMembro", "§7");
    }

    private Team getTeamPlayer(Player player){
    	if(player.hasPermission("*")){
            return scoreboard.getTeam("aDono");
        }
        if(player.hasPermission("tag.diretor")){
            return scoreboard.getTeam("bDiretor");
        }
        if(player.hasPermission("tag.admin")){
            return scoreboard.getTeam("cAdmin");
        }
        if(player.hasPermission("tag.gerente")){
            return scoreboard.getTeam("dGerente");
        }
        if(player.hasPermission("tag.coordenador")){
            return scoreboard.getTeam("eCoordenador");
        }
        if(player.hasPermission("tag.moderador")){
            return scoreboard.getTeam("fModerador");
        }
        if(player.hasPermission("tag.ajudante")){
            return scoreboard.getTeam("gAjudante");
        }
        if(player.hasPermission("tag.youtuber")){
            return scoreboard.getTeam("hYoutuber");
        }
        if(player.hasPermission("tag.miniyt")){
            return scoreboard.getTeam("iMiniYT");
        }
        if(player.hasPermission("tag.ruby")){
            return scoreboard.getTeam("jRuby");
        }
        if(player.hasPermission("tag.champion")){
            return scoreboard.getTeam("kChampion");
        }
        if(player.hasPermission("tag.vip")){
            return scoreboard.getTeam("lVip");
        }
        return scoreboard.getTeam("mMembro");
    }


    private void registerPrefix(String group, String prefix){
        Team team = scoreboard.getTeam(group)==null?scoreboard.registerNewTeam(group):scoreboard.getTeam(group);
        team.setPrefix(prefix);
    }

    public void applyPlayer(){
        for(Player all: Bukkit.getOnlinePlayers()){
            Team team = getTeamPlayer(all);
            if(!team.hasEntry(all.getName())){
                team.addEntry(all.getName());
            }
        }
    }
}
