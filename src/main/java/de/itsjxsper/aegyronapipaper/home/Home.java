package de.itsjxsper.aegyronapipaper.home;

import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

/**
 * Represents a player's home location.
 *
 * @author ItsJxsper
 * @version 1.0.0
 */
public interface Home {

    /**
     * Gets the unique identifier of this home.
     *
     * @return the home UUID
     */
    @NotNull UUID getUUID();

    /**
     * Gets the UUID of the player who owns this home.
     *
     * @return the player UUID
     */
    @NotNull UUID getPlayerUUID();

    /**
     * Gets the name of the home.
     *
     * @return the home name
     */
    @NotNull String getName();

    /**
     * Gets the location of the home.
     *
     * @return the location
     */
    @NotNull HomeLocation getLocation();

    /**
     * Gets the Bukkit location if the world is loaded.
     *
     * @return the Bukkit location, or null if world not loaded
     */
    @Nullable
    Location getBukkitLocation();

    /**
     * Gets the groups this home is restricted to.
     * Empty list means no restrictions.
     *
     * @return list of group uuids
     */
    @NotNull List<UUID> getGroupRestrictions();

    /**
     * Checks if this home can be used in a specific group.
     *
     * @param groupUUID the group uuid
     * @return true if home can be used in this group
     */
    boolean canUseInGroup(@NotNull UUID groupUUID);

    /**
     * Gets the timestamp when this home was created.
     *
     * @return timestamp in milliseconds
     */
    long getCreatedAt();

    /**
     * Gets the timestamp when this home was last used.
     *
     * @return timestamp in milliseconds, or 0 if never used
     */
    long getLastUsed();

    /**
     * Gets the number of times this home has been used.
     *
     * @return usage count
     */
    int getUsageCount();

    /**
     * Checks if the home's world is currently loaded.
     *
     * @return true if world is loaded
     */
    boolean isWorldLoaded();

    /**
     * Gets the name of the world where this home is located.
     *
     * @return the world name
     */
    @NotNull String getWorldName();
}
