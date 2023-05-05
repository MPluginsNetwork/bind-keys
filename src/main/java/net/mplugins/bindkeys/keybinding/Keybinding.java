package net.mplugins.bindkeys.keybinding;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@RequiredArgsConstructor
@Data
@ToString
public class Keybinding {
    private final String key;
    private boolean cancelEvent;
    private final String permission;
    private final List<String> commands;
}
