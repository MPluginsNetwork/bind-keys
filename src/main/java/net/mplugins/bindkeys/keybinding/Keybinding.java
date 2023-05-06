package net.mplugins.bindkeys.keybinding;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import java.util.List;

@RequiredArgsConstructor
@Data
@ToString
public class Keybinding {
    private final String key;
    private final String permission;
    private final boolean cancelEvent;
    private final List<String> commands;

    public void executeCommands(OfflinePlayer player) {
        for (String command : getCommands())
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("%player%", player.getName()));
    }
}
