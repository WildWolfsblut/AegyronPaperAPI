package de.itsjxsper.aegyronapipaper.events.group;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a player changes server groups.
 */
public class GroupChangeEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();

    private final Player player;
    private final String fromGroup;
    private final String toGroup;

    public GroupChangeEvent(@NotNull Player player, @NotNull String fromGroup, @NotNull String toGroup) {
        this.player = player;
        this.fromGroup = fromGroup;
        this.toGroup = toGroup;
    }

    public @NotNull Player getPlayer() { return player; }
    public @NotNull String getFromGroup() { return fromGroup; }
    public @NotNull String getToGroup() { return toGroup; }

    @Override
    public @NotNull HandlerList getHandlers() { return HANDLERS; }
    public static @NotNull HandlerList getHandlerList() { return HANDLERS; }
}
