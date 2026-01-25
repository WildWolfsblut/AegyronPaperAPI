package de.itsjxsper.aegyronapipaper.group;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Represents a server group in the Aegyron network.
 *
 * @author ItsJxsper
 * @version 1.0.0
 */
public interface ServerGroup {

    /**
     * Gets the unique identifier of the group.
     *
     * @return the group UUID
     */
    @NotNull UUID getUUID();

    /**
     * Gets the name of the group.
     *
     * @return the group name
     */
    @NotNull String getName();

    /**
     * Gets all servers in this group.
     *
     * @return list of server names
     */
    @NotNull List<String> getServers();

    /**
     * Gets the number of servers in this group.
     *
     * @return the server count
     */
    int getServerCount();

    /**
     * Checks if a server is in this group.
     *
     * @param serverName the server name
     * @return true if server is in group
     */
    boolean hasServer(@NotNull String serverName);

    /**
     * Gets all enabled features for this group.
     *
     * @return map of feature names to enabled status
     */
    @NotNull Map<String, Boolean> getFeatures();

    /**
     * Checks if a feature is enabled for this group.
     *
     * @param feature the feature name
     * @return true if feature is enabled
     */
    boolean hasFeature(@NotNull String feature);

    /**
     * Gets the group's display name.
     *
     * @return the display name, or the name if not set
     */
    @NotNull String getDisplayName();

    /**
     * Gets the total number of online players in this group.
     *
     * @return the player count
     */
    int getOnlinePlayerCount();

    /**
     * Gets the maximum player capacity for this group.
     *
     * @return the max player capacity
     */
    int getMaxPlayerCapacity();

    /**
     * Gets custom properties for this group.
     *
     * @return map of custom properties
     */
    @NotNull Map<String, Object> getCustomProperties();

    /**
     * Gets a custom property by key.
     *
     * @param key the property key
     * @return the property value, or null if not found
     */
    Object getCustomProperty(@NotNull String key);
}