package de.itsjxsper.aegyronapipaper.events.player;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * Called when player data is synchronized.
 */
public class PlayerDataSyncEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();

    private final UUID playerUUID;
    private final String syncType;
    private final boolean success;

    public PlayerDataSyncEvent(@NotNull UUID playerUUID, @NotNull String syncType, boolean success) {
        super(true); // async
        this.playerUUID = playerUUID;
        this.syncType = syncType;
        this.success = success;
    }

    public @NotNull UUID getPlayerUUID() { return playerUUID; }
    public @NotNull String getSyncType() { return syncType; }
    public boolean isSuccess() { return success; }

    @Override
    public @NotNull HandlerList getHandlers() { return HANDLERS; }
    public static @NotNull HandlerList getHandlerList() { return HANDLERS; }
}
