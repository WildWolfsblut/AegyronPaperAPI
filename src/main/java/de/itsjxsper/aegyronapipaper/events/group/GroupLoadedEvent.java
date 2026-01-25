package de.itsjxsper.aegyronapipaper.events.group;

import de.itsjxsper.aegyronapipaper.group.ServerGroup;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a group is loaded/initialized.
 */
public class GroupLoadedEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();

    private final ServerGroup group;

    public GroupLoadedEvent(@NotNull ServerGroup group) {
        super(true); // async
        this.group = group;
    }

    public @NotNull ServerGroup getGroup() { return group; }

    @Override
    public @NotNull HandlerList getHandlers() { return HANDLERS; }
    public static @NotNull HandlerList getHandlerList() { return HANDLERS; }
}
