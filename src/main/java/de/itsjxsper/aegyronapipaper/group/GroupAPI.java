package de.itsjxsper.aegyronapipaper.group;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * API for server group management and queries.
 *
 * <p>Usage examples:
 * <pre>{@code
 * // Get current server's group
 * Optional<ServerGroup> group = api.group().getCurrentGroup();
 *
 * // Check if server is in a group
 * if (api.group().isInGroup("survival")) {
 *     // Do something
 * }
 *
 * // Get all servers in a group
 * List<String> servers = api.group().getServersInGroup("lobby");
 * }</pre>
 *
 * @author ItsJxsper
 * @version 1.0.0
 */
public interface GroupAPI {

    // ============================================================
    // CURRENT SERVER
    // ============================================================

    /**
     * Gets the group of the current server.
     *
     * @return optional containing the group, or empty if not in a group
     */
    @NotNull Optional<ServerGroup> getCurrentGroup();

    /**
     * Gets the group UUID of the current server.
     *
     * @return optional containing the group UUID
     */
    @NotNull Optional<UUID> getCurrentGroupUUID();

    /**
     * Gets the group name of the current server.
     *
     * @return optional containing the group name
     */
    @NotNull Optional<String> getCurrentGroupName();

    /**
     * Checks if the current server is in a specific group.
     *
     * @param groupName the group name to check
     * @return true if the server is in the group
     */
    boolean isInGroup(@NotNull String groupName);

    /**
     * Checks if the current server is in a specific group.
     *
     * @param groupUUID the group UUID to check
     * @return true if the server is in the group
     */
    boolean isInGroup(@NotNull UUID groupUUID);

    // ============================================================
    // GROUP QUERIES
    // ============================================================

    /**
     * Gets a server group by name.
     *
     * @param groupName the group name
     * @return future containing optional with the group
     */
    @NotNull CompletableFuture<Optional<ServerGroup>> getGroup(@NotNull String groupName);

    /**
     * Gets a server group by UUID.
     *
     * @param groupUUID the group UUID
     * @return future containing optional with the group
     */
    @NotNull CompletableFuture<Optional<ServerGroup>> getGroup(@NotNull UUID groupUUID);

    /**
     * Gets all available server groups.
     *
     * @return future containing list of all groups
     */
    @NotNull CompletableFuture<List<ServerGroup>> getAllGroups();

    /**
     * Checks if a group exists.
     *
     * @param groupName the group name
     * @return future containing true if the group exists
     */
    @NotNull CompletableFuture<Boolean> groupExists(@NotNull String groupName);

    // ============================================================
    // SERVER QUERIES
    // ============================================================

    /**
     * Gets all servers in a specific group.
     *
     * @param groupName the group name
     * @return future containing list of server names
     */
    @NotNull CompletableFuture<List<String>> getServersInGroup(@NotNull String groupName);

    /**
     * Gets all servers in a specific group.
     *
     * @param groupUUID the group UUID
     * @return future containing list of server names
     */
    @NotNull CompletableFuture<List<String>> getServersInGroup(@NotNull UUID groupUUID);

    /**
     * Checks if a server is in a specific group.
     *
     * @param serverName the server name
     * @param groupName the group name
     * @return future containing true if server is in group
     */
    @NotNull CompletableFuture<Boolean> isServerInGroup(@NotNull String serverName, @NotNull String groupName);

    /**
     * Gets the total number of servers in a group.
     *
     * @param groupName the group name
     * @return future containing the server count
     */
    @NotNull CompletableFuture<Integer> getServerCount(@NotNull String groupName);

    /**
     * Gets the total number of online players in a group.
     *
     * @param groupName the group name
     * @return future containing the player count
     */
    @NotNull CompletableFuture<Integer> getPlayerCount(@NotNull String groupName);

    // ============================================================
    // FEATURES
    // ============================================================

    /**
     * Checks if a feature is enabled for a group.
     *
     * @param groupName the group name
     * @param feature the feature name
     * @return future containing true if feature is enabled
     */
    @NotNull CompletableFuture<Boolean> hasFeature(@NotNull String groupName, @NotNull String feature);

    /**
     * Checks if a feature is enabled for the current group.
     *
     * @param feature the feature name
     * @return true if feature is enabled, false otherwise
     */
    boolean hasFeature(@NotNull String feature);

    // ============================================================
    // CONFIGURATION
    // ============================================================

    /**
     * Reloads the group configuration from the backend.
     *
     * @return future that completes when reload is done
     */
    @NotNull CompletableFuture<Void> reloadGroupConfig();

    /**
     * Reloads a specific group's configuration.
     *
     * @param groupName the group name
     * @return future that completes when reload is done
     */
    @NotNull CompletableFuture<Void> reloadGroupConfig(@NotNull String groupName);
}