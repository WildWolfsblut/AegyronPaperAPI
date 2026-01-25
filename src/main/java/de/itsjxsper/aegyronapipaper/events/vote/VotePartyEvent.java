package de.itsjxsper.aegyronapipaper.events.vote;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a vote party is triggered.
 */
public class VotePartyEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();

    private final int totalVotes;
    private final int requiredVotes;

    public VotePartyEvent(int totalVotes, int requiredVotes) {
        super(true); // async
        this.totalVotes = totalVotes;
        this.requiredVotes = requiredVotes;
    }

    public int getTotalVotes() { return totalVotes; }
    public int getRequiredVotes() { return requiredVotes; }

    @Override
    public @NotNull HandlerList getHandlers() { return HANDLERS; }
    public static @NotNull HandlerList getHandlerList() { return HANDLERS; }
}
