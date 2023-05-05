package net.mplugins.bindkeys.keybinding;

import java.util.*;

public class KeybindingHandler {
    private final Map<String, Keybinding> keybindingMap = new HashMap<>();

    public KeybindingHandler(List<Keybinding> keybindings) {
        for (Keybinding keybinding : keybindings)
            keybindingMap.put(keybinding.getKey().toLowerCase(Locale.ROOT), keybinding);
    }

    public Optional<Keybinding> getKeybinding(String key) {
        if (!keybindingMap.containsKey(key.toLowerCase()))
            return Optional.empty();

        return Optional.of(keybindingMap.get(key.toLowerCase()));
    }

    public Collection<Keybinding> getKeybindings() {
        return keybindingMap.values();
    }
}
