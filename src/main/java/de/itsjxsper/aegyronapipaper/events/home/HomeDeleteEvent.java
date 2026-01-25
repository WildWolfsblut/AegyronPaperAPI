package de.itsjxsper.aegyronapipaper.events.home;

import de.itsjxsper.aegyronapipaper.home.Home;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a home is deleted.
 */
public class HomeDeleteEvent extends Event implements Cancellable {
    private static final HandlerList HANDLERS = new HandlerList();

    private final Player player;
    private final Home home;
    private boolean cancelled = false;

    public HomeDeleteEvent(@NotNull Player player, @NotNull Home home) {
        this.player = player;
        this.home = home;
    }

    public @NotNull Player getPlayer() { return player; }
    public @NotNull Home getHome() { return home; }

    @Override
    public boolean isCancelled() { return cancelled; }
    @Override
    public void setCancelled(boolean cancel) { this.cancelled = cancel; }

    @Override
    public @NotNull HandlerList getHandlers() { return HANDLERS; }
    public static @NotNull HandlerList getHandlerList() { return HANDLERS; }
}
