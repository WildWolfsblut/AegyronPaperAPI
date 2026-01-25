package de.itsjxsper.aegyronapipaper.events.home;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a home is created.
 */
public class HomeCreateEvent extends Event implements Cancellable {
    private static final HandlerList HANDLERS = new HandlerList();

    private final Player player;
    private final String homeName;
    private boolean cancelled = false;

    public HomeCreateEvent(@NotNull Player player, @NotNull String homeName) {
        this.player = player;
        this.homeName = homeName;
    }

    public @NotNull Player getPlayer() { return player; }
    public @NotNull String getHomeName() { return homeName; }

    @Override
    public boolean isCancelled() { return cancelled; }
    @Override
    public void setCancelled(boolean cancel) { this.cancelled = cancel; }

    @Override
    public @NotNull HandlerList getHandlers() { return HANDLERS; }
    public static @NotNull HandlerList getHandlerList() { return HANDLERS; }
}
