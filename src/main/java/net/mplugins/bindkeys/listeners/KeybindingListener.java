package net.mplugins.bindkeys.listeners;

import lombok.RequiredArgsConstructor;
import net.mplugins.bindkeys.keybinding.KeybindingHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

@RequiredArgsConstructor
public class KeybindingListener implements Listener {
    private final KeybindingHandler keybindingHandler;

    @EventHandler
    public void onSwapHand(PlayerSwapHandItemsEvent event) {
        final Player player = event.getPlayer();

        keybindingHandler.getKeybinding("f").ifPresent((keybinding) -> {
            event.setCancelled(keybinding.isCancelEvent());

            for (String command : keybinding.getCommands())
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("%player%", player.getName()));
        });
    }
}
