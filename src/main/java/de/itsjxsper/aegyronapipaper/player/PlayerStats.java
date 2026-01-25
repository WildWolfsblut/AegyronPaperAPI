package de.itsjxsper.aegyronapipaper.player;

import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.UUID;

/**
 * Represents player statistics across the network.
 *
 * @author ItsJxsper
 * @version 1.0.0
 */
public interface PlayerStats {

    /**
     * Gets the player's UUID.
     *
     * @return the UUID
     */
    @NotNull UUID getPlayerUUID();

    /**
     * Gets total playtime in seconds.
     *
     * @return playtime in seconds
     */
    long getTotalPlaytime();

    /**
     * Gets playtime for a specific server.
     *
     * @param serverName the server name
     * @return playtime in seconds, or 0 if never played
     */
    long getPlaytimeOnServer(@NotNull String serverName);

    /**
     * Gets playtime for a specific group.
     *
     * @param groupName the group name
     * @return playtime in seconds, or 0 if never played
     */
    long getPlaytimeInGroup(@NotNull String groupName);

    /**
     * Gets the total number of joins across all servers.
     *
     * @return total join count
     */
    int getTotalJoinCount();

    /**
     * Gets the number of joins for a specific server.
     *
     * @param serverName the server name
     * @return join count for this server
     */
    int getJoinCountForServer(@NotNull String serverName);

    /**
     * Gets the timestamp of the first join.
     *
     * @return timestamp in milliseconds
     */
    long getFirstJoin();

    /**
     * Gets the timestamp of the last join.
     *
     * @return timestamp in milliseconds
     */
    long getLastJoin();

    /**
     * Gets the timestamp of the last seen time.
     *
     * @return timestamp in milliseconds
     */
    long getLastSeen();

    /**
     * Gets all playtime statistics per server.
     *
     * @return map of server name to playtime in seconds
     */
    @NotNull Map<String, Long> getPlaytimePerServer();

    /**
     * Gets all join count statistics per server.
     *
     * @return map of server name to join count
     */
    @NotNull Map<String, Integer> getJoinCountPerServer();

    /**
     * Gets custom statistics.
     *
     * @param key the stat key
     * @return the stat value, or null if not found
     */
    Object getCustomStat(@NotNull String key);

    /**
     * Gets all custom statistics.
     *
     * @return map of custom stats
     */
    @NotNull Map<String, Object> getAllCustomStats();
}
