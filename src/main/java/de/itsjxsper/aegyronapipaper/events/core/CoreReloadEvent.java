package de.itsjxsper.aegyronapipaper.events.core;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Called when Aegyron Core is reloaded.
 */
public class CoreReloadEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();

    private final String reason;

    public CoreReloadEvent(@NotNull String reason) {
        super(true); // async
        this.reason = reason;
    }

    public @NotNull String getReason() { return reason; }

    @Override
    public @NotNull HandlerList getHandlers() { return HANDLERS; }
    public static @NotNull HandlerList getHandlerList() { return HANDLERS; }
}
