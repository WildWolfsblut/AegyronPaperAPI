package de.itsjxsper.aegyronapipaper.events.vote;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * Called when a player votes for the server.
 */
public class VoteReceivedEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();

    private final UUID playerUUID;
    private final String serviceName;
    private final long timestamp;

    public VoteReceivedEvent(@NotNull UUID playerUUID, @NotNull String serviceName, long timestamp) {
        super(true); // async
        this.playerUUID = playerUUID;
        this.serviceName = serviceName;
        this.timestamp = timestamp;
    }

    public @NotNull UUID getPlayerUUID() { return playerUUID; }
    public @NotNull String getServiceName() { return serviceName; }
    public long getTimestamp() { return timestamp; }

    @Override
    public @NotNull HandlerList getHandlers() { return HANDLERS; }
    public static @NotNull HandlerList getHandlerList() { return HANDLERS; }
}
