package de.itsjxsper.aegyronapipaper.events.group;

import de.itsjxsper.aegyronapipaper.group.ServerGroup;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a group's configuration is updated.
 */
public class GroupConfigUpdateEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();

    private final ServerGroup group;
    private final String reason;

    public GroupConfigUpdateEvent(@NotNull ServerGroup group, @NotNull String reason) {
        super(true); // async
        this.group = group;
        this.reason = reason;
    }

    public @NotNull ServerGroup getGroup() { return group; }
    public @NotNull String getReason() { return reason; }

    @Override
    public @NotNull HandlerList getHandlers() { return HANDLERS; }
    public static @NotNull HandlerList getHandlerList() { return HANDLERS; }
}

