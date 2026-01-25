package de.itsjxsper.aegyronapipaper.events.player;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * Called when player data is loaded from the backend.
 */
public class PlayerDataLoadEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();

    private final UUID playerUUID;
    private final boolean success;

    public PlayerDataLoadEvent(@NotNull UUID playerUUID, boolean success) {
        super(true); // async
        this.playerUUID = playerUUID;
        this.success = success;
    }

    public @NotNull UUID getPlayerUUID() { return playerUUID; }
    public boolean isSuccess() { return success; }

    @Override
    public @NotNull HandlerList getHandlers() { return HANDLERS; }
    public static @NotNull HandlerList getHandlerList() { return HANDLERS; }
}
