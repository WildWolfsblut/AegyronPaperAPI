package de.itsjxsper.aegyronapipaper.player;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Represents a player in the Aegyron network with synchronized data.
 *
 * @author ItsJxsper
 * @version 1.0.0
 */
public interface AegyronPlayer {

    /**
     * Gets the player's UUID.
     *
     * @return the UUID
     */
    @NotNull UUID getUUID();

    /**
     * Gets the player's username.
     *
     * @return the username
     */
    @NotNull String getUsername();

    /**
     * Gets the Bukkit player if online on this server.
     *
     * @return optional containing the Bukkit player
     */
    @NotNull Optional<Player> getBukkitPlayer();

    /**
     * Checks if the player is online on any server.
     *
     * @return true if player is online
     */
    boolean isOnline();

    /**
     * Gets the server the player is currently on.
     *
     * @return the server name, or null if offline
     */
    @Nullable String getCurrentServer();

    /**
     * Gets the player's current location if on this server.
     *
     * @return optional containing the location
     */
    @NotNull Optional<Location> getLocation();

    /**
     * Gets total playtime across all servers.
     *
     * @return playtime in seconds
     */
    long getPlaytime();

    /**
     * Gets the last time the player was seen online.
     *
     * @return timestamp in milliseconds
     */
    long getLastSeen();

    /**
     * Gets the total number of times the player has joined.
     *
     * @return join count
     */
    int getJoinCount();

    /**
     * Gets the player's first join timestamp.
     *
     * @return timestamp in milliseconds
     */
    long getFirstJoin();


    /**
     * Gets custom data stored for this player.
     *
     * @param key the data key
     * @return the data value, or null if not found
     */
    @Nullable Object getCustomData(@NotNull String key);

    /**
     * Sets custom data for this player.
     *
     * @param key the data key
     * @param value the data value
     */
    void setCustomData(@NotNull String key, @Nullable Object value);

    /**
     * Gets all custom data for this player.
     *
     * @return map of custom data
     */
    @NotNull Map<String, Object> getAllCustomData();

    /**
     * Checks if the player has a specific permission.
     * Only works if player is online on this server.
     *
     * @param permission the permission node
     * @return true if player has permission
     */
    boolean hasPermission(@NotNull String permission);

    /**
     * Gets the player's primary group (from LuckPerms).
     *
     * @return the primary group name
     */
    @NotNull String getPrimaryGroup();

    /**
     * Checks if custom data exists for a key.
     *
     * @param key the data key
     * @return true if data exists
     */
    boolean hasCustomData(@NotNull String key);

    /**
     * Removes custom data for a key.
     *
     * @param key the data key
     */
    void removeCustomData(@NotNull String key);
}