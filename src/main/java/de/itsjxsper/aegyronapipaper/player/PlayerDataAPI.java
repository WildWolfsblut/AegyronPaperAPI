package de.itsjxsper.aegyronapipaper.player;

import de.itsjxsper.aegyronapipaper.enums.SyncStatus;
import de.itsjxsper.aegyronapipaper.utils.DataSerializer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * API for player data management and synchronization.
 *
 * <p>Usage examples:
 * <pre>{@code
 * // Get player data
 * AegyronPlayer aPlayer = api.playerData().getPlayer(player).orElse(null);
 *
 * // Check if player is online
 * boolean online = api.playerData().isOnline(uuid);
 *
 * // Force data sync
 * api.playerData().savePlayerData(player);
 * }</pre>
 *
 * @author ItsJxsper
 * @version 1.0.0
 */
public interface PlayerDataAPI {

    // ============================================================
    // PLAYER DATA ACCESS
    // ============================================================

    /**
     * Gets Aegyron player data for a Bukkit player.
     *
     * @param player the Bukkit player
     * @return optional containing the Aegyron player
     */
    @NotNull Optional<AegyronPlayer> getPlayer(@NotNull Player player);

    /**
     * Gets Aegyron player data by UUID.
     *
     * @param uuid the player UUID
     * @return future containing optional with the player
     */
    @NotNull CompletableFuture<Optional<AegyronPlayer>> getPlayer(@NotNull UUID uuid);

    /**
     * Gets Aegyron player data by username.
     *
     * @param username the player username
     * @return future containing optional with the player
     */
    @NotNull CompletableFuture<Optional<AegyronPlayer>> getPlayer(@NotNull String username);

    /**
     * Checks if a player is online on any server.
     *
     * @param uuid the player UUID
     * @return future containing true if player is online
     */
    @NotNull CompletableFuture<Boolean> isOnline(@NotNull UUID uuid);

    /**
     * Gets the server name where a player is currently playing.
     *
     * @param uuid the player UUID
     * @return future containing optional with server name
     */
    @NotNull CompletableFuture<Optional<String>> getPlayerServer(@NotNull UUID uuid);

    // ============================================================
    // DATA SYNCHRONIZATION
    // ============================================================

    /**
     * Saves player data to the backend.
     * This method is async and returns immediately.
     *
     * @param player the player
     * @return future that completes when save is done
     */
    @NotNull CompletableFuture<Void> savePlayerData(@NotNull Player player);

    /**
     * Saves player data by UUID.
     *
     * @param uuid the player UUID
     * @return future that completes when save is done
     */
    @NotNull CompletableFuture<Void> savePlayerData(@NotNull UUID uuid);

    /**
     * Loads player data from the backend.
     * This will overwrite any local data!
     *
     * @param player the player
     * @return future that completes when load is done
     */
    @NotNull CompletableFuture<Void> loadPlayerData(@NotNull Player player);

    /**
     * Loads player data by UUID.
     *
     * @param uuid the player UUID
     * @return future that completes when load is done
     */
    @NotNull CompletableFuture<Void> loadPlayerData(@NotNull UUID uuid);

    /**
     * Forces a complete data synchronization for a player.
     * This will sync all enabled data types.
     *
     * @param player the player
     * @return future that completes when sync is done
     */
    @NotNull CompletableFuture<Void> syncPlayerData(@NotNull Player player);

    /**
     * Checks if data sync is enabled for the current group.
     *
     * @return true if sync is enabled
     */
    boolean isSyncEnabled();

    /**
     * Checks if data sync is enabled for a specific group.
     *
     * @param groupName the group name
     * @return future containing true if sync is enabled
     */
    @NotNull CompletableFuture<Boolean> isSyncEnabled(@NotNull String groupName);

    // ============================================================
    // STATISTICS
    // ============================================================

    /**
     * Gets player statistics.
     *
     * @param uuid the player UUID
     * @return future containing optional with player stats
     */
    @NotNull CompletableFuture<Optional<PlayerStats>> getStats(@NotNull UUID uuid);

    /**
     * Gets total playtime for a player across all servers.
     *
     * @param uuid the player UUID
     * @return future containing playtime in seconds
     */
    @NotNull CompletableFuture<Long> getPlaytime(@NotNull UUID uuid);

    /**
     * Gets the last time a player was seen online.
     *
     * @param uuid the player UUID
     * @return future containing last seen timestamp in millis
     */
    @NotNull CompletableFuture<Long> getLastSeen(@NotNull UUID uuid);

    /**
     * Gets the total number of times a player has joined.
     *
     * @param uuid the player UUID
     * @return future containing join count
     */
    @NotNull CompletableFuture<Integer> getJoinCount(@NotNull UUID uuid);

    // ============================================================
    // UTILITY
    // ============================================================

    /**
     * Gets the sync status for a player.
     *
     * @param player the player
     * @return the sync status
     */
    @NotNull SyncStatus getSyncStatus(@NotNull Player player);

    /**
     * Registers a custom data type for synchronization.
     * This allows plugins to sync their own data.
     *
     * @param dataType the data type identifier
     * @param serializer the serializer for this data type
     */
    void registerDataType(@NotNull String dataType, @NotNull DataSerializer<?> serializer);
}