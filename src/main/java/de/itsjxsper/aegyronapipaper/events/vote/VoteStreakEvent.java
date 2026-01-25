package de.itsjxsper.aegyronapipaper.events.vote;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * Called when a player's vote streak changes.
 */
public class VoteStreakEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();

    private final UUID playerUUID;
    private final int currentStreak;
    private final int previousStreak;

    public VoteStreakEvent(@NotNull UUID playerUUID, int currentStreak, int previousStreak) {
        super(true); // async
        this.playerUUID = playerUUID;
        this.currentStreak = currentStreak;
        this.previousStreak = previousStreak;
    }

    public @NotNull UUID getPlayerUUID() { return playerUUID; }
    public int getCurrentStreak() { return currentStreak; }
    public int getPreviousStreak() { return previousStreak; }
    public boolean isStreakBroken() { return currentStreak < previousStreak; }

    @Override
    public @NotNull HandlerList getHandlers() { return HANDLERS; }
    public static @NotNull HandlerList getHandlerList() { return HANDLERS; }
}

