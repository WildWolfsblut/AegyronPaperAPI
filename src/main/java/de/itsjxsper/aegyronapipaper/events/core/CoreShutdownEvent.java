package de.itsjxsper.aegyronapipaper.events.core;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Called when Aegyron Core is shutting down.
 */
public class CoreShutdownEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();

    public CoreShutdownEvent() {
        super(true); // async
    }

    @Override
    public @NotNull HandlerList getHandlers() { return HANDLERS; }
    public static @NotNull HandlerList getHandlerList() { return HANDLERS; }
}
