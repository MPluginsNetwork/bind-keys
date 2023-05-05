package net.mplugins.bindkeys;

import net.mplugins.bindkeys.keybinding.Keybinding;
import net.mplugins.bindkeys.keybinding.KeybindingHandler;
import net.mplugins.bindkeys.listeners.KeybindingListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class BindKeysPlugin extends JavaPlugin {
    private static BindKeysPlugin plugin;
    private KeybindingHandler keybindingHandler;

    @Override
    public void onLoad() {
        plugin = this;

        saveDefaultConfig();

        final List<Keybinding> keybindings = new ArrayList<>();

        for (Map.Entry<String, Object> entry : getConfig().getConfigurationSection("keybindings").getValues(false).entrySet()) {
            final String path = "keybindings." + entry.getKey();
            final String key = entry.getKey();
            final String permission = getConfig().getString(path + ".permission");
            final List<String> commands = getConfig().getStringList(path + ".commands");
            final Keybinding keybinding = new Keybinding(key, permission, commands);

            keybindings.add(keybinding);

            System.out.println("Loaded keybinding: " + keybinding);
        }

        keybindingHandler = new KeybindingHandler(keybindings);
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new KeybindingListener(keybindingHandler), this);
    }

    public KeybindingHandler getKeybindingHandler() {
        return keybindingHandler;
    }

    public static BindKeysPlugin getInstance() {
        return plugin;
    }
}
