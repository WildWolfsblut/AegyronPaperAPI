package de.itsjxsper.aegyronapipaper.home;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * API for cross-server home management.
 *
 * <p>Usage examples:
 * <pre>{@code
 * // Get player's homes
 * List<Home> homes = api.home().getHomes(player).join();
 *
 * // Create a home
 * api.home().createHome(player, "base", player.getLocation());
 *
 * // Teleport to home
 * api.home().teleportToHome(player, "base");
 *
 * // Check home limit
 * int limit = api.home().getHomeLimit(player);
 * }</pre>
 *
 * @author ItsJxsper
 * @version 1.0.0
 */
public interface HomeAPI {

    // ============================================================
    // HOME MANAGEMENT
    // ============================================================

    /**
     * Gets all homes for a player.
     *
     * @param player the player
     * @return future containing list of homes
     */
    @NotNull CompletableFuture<List<Home>> getHomes(@NotNull Player player);

    /**
     * Gets all homes for a player by UUID.
     *
     * @param uuid the player UUID
     * @return future containing list of homes
     */
    @NotNull CompletableFuture<List<Home>> getHomes(@NotNull UUID uuid);

    /**
     * Gets a specific home by name.
     *
     * @param player the player
     * @param homeName the home name
     * @return future containing optional with the home
     */
    @NotNull CompletableFuture<Optional<Home>> getHome(@NotNull Player player, @NotNull String homeName);

    /**
     * Gets a specific home by name and UUID.
     *
     * @param uuid the player UUID
     * @param homeName the home name
     * @return future containing optional with the home
     */
    @NotNull CompletableFuture<Optional<Home>> getHome(@NotNull UUID uuid, @NotNull String homeName);

    /**
     * Creates a new home for a player.
     *
     * @param player the player
     * @param homeName the home name
     * @param location the home location
     * @return future containing the created home
     * @throws IllegalArgumentException if name is invalid or limit exceeded
     */
    @NotNull CompletableFuture<Home> createHome(
            @NotNull Player player,
            @NotNull String homeName,
            @NotNull Location location
    );

    /**
     * Deletes a home.
     *
     * @param player the player
     * @param homeName the home name
     * @return future containing true if home was deleted
     */
    @NotNull CompletableFuture<Boolean> deleteHome(@NotNull Player player, @NotNull String homeName);

    /**
     * Deletes a home by UUID.
     *
     * @param uuid the player UUID
     * @param homeName the home name
     * @return future containing true if home was deleted
     */
    @NotNull CompletableFuture<Boolean> deleteHome(@NotNull UUID uuid, @NotNull String homeName);

    /**
     * Renames a home.
     *
     * @param player the player
     * @param oldName the current name
     * @param newName the new name
     * @return future containing true if home was renamed
     * @throws IllegalArgumentException if new name is invalid
     */
    @NotNull CompletableFuture<Boolean> renameHome(
            @NotNull Player player,
            @NotNull String oldName,
            @NotNull String newName
    );

    /**
     * Updates a home's location.
     *
     * @param player the player
     * @param homeName the home name
     * @param newLocation the new location
     * @return future containing true if location was updated
     */
    @NotNull CompletableFuture<Boolean> updateHomeLocation(
            @NotNull Player player,
            @NotNull String homeName,
            @NotNull Location newLocation
    );

    // ============================================================
    // TELEPORTATION
    // ============================================================

    /**
     * Teleports a player to their home.
     * This respects warmup and cooldown settings.
     *
     * @param player the player to teleport
     * @param homeName the home name
     * @return future containing true if teleport was initiated
     */
    @NotNull CompletableFuture<Boolean> teleportToHome(@NotNull Player player, @NotNull String homeName);

    /**
     * Teleports a player to their home immediately without warmup.
     *
     * @param player the player to teleport
     * @param homeName the home name
     * @return future containing true if teleport succeeded
     */
    @NotNull CompletableFuture<Boolean> teleportToHomeInstantly(@NotNull Player player, @NotNull String homeName);

    /**
     * Checks if a player can teleport to a home right now.
     * This checks cooldowns and other restrictions.
     *
     * @param player the player
     * @return true if player can teleport
     */
    boolean canTeleport(@NotNull Player player);

    /**
     * Gets the remaining cooldown time for home teleportation.
     *
     * @param player the player
     * @return remaining cooldown in seconds, or 0 if no cooldown
     */
    long getRemainingCooldown(@NotNull Player player);

    /**
     * Gets the warmup time for home teleportation.
     *
     * @return warmup time in seconds
     */
    int getWarmupTime();

    /**
     * Gets the cooldown time for home teleportation.
     *
     * @return cooldown time in seconds
     */
    int getCooldownTime();

    // ============================================================
    // LIMITS & VALIDATION
    // ============================================================

    /**
     * Gets the maximum number of homes a player can have.
     * This respects permissions (e.g., aegyron.homes.limit.10).
     *
     * @param player the player
     * @return the home limit
     */
    int getHomeLimit(@NotNull Player player);

    /**
     * Gets the number of homes a player currently has.
     *
     * @param player the player
     * @return future containing the home count
     */
    @NotNull CompletableFuture<Integer> getHomeCount(@NotNull Player player);

    /**
     * Gets the number of remaining homes a player can create.
     *
     * @param player the player
     * @return future containing the remaining homes
     */
    @NotNull CompletableFuture<Integer> getRemainingHomes(@NotNull Player player);

    /**
     * Checks if a player can create another home.
     *
     * @param player the player
     * @return future containing true if player can create a home
     */
    @NotNull CompletableFuture<Boolean> canCreateHome(@NotNull Player player);

    /**
     * Validates a home name.
     *
     * @param homeName the home name to validate
     * @return true if name is valid
     */
    boolean isValidHomeName(@NotNull String homeName);

    /**
     * Checks if a home name is already used by a player.
     *
     * @param player the player
     * @param homeName the home name
     * @return future containing true if name exists
     */
    @NotNull CompletableFuture<Boolean> homeExists(@NotNull Player player, @NotNull String homeName);

    // ============================================================
    // STATISTICS
    // ============================================================

    /**
     * Gets the most recently used home for a player.
     *
     * @param player the player
     * @return future containing optional with the home
     */
    @NotNull CompletableFuture<Optional<Home>> getMostRecentHome(@NotNull Player player);

    /**
     * Gets the last time a home was used.
     *
     * @param player the player
     * @param homeName the home name
     * @return future containing timestamp in millis, or 0 if never used
     */
    @NotNull CompletableFuture<Long> getLastUsedTime(@NotNull Player player, @NotNull String homeName);

    /**
     * Gets the number of times a home has been used.
     *
     * @param player the player
     * @param homeName the home name
     * @return future containing usage count
     */
    @NotNull CompletableFuture<Integer> getHomeUsageCount(@NotNull Player player, @NotNull String homeName);
}