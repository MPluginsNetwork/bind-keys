package net.mplugins.bindkeys.listeners;

import io.papermc.paper.event.player.PlayerPurchaseEvent;
import lombok.RequiredArgsConstructor;
import net.mplugins.bindkeys.keybinding.KeybindingHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

@RequiredArgsConstructor
public class KeybindingListener implements Listener {
    private final KeybindingHandler keybindingHandler;

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        final Player player = event.getPlayer();

        keybindingHandler.getKeybinding((player.isSneaking() ? "shift+" : "") + "q").ifPresent((keybinding) -> {
            event.setCancelled(keybinding.isCancelEvent());
            keybinding.executeCommands(player);
        });
    }

    @EventHandler
    public void onSwapHand(PlayerSwapHandItemsEvent event) {
        final Player player = event.getPlayer();

        keybindingHandler.getKeybinding((player.isSneaking() ? "shift+" : "") + "f").ifPresent((keybinding) -> {
            event.setCancelled(keybinding.isCancelEvent());
            keybinding.executeCommands(player);
        });
    }
}
