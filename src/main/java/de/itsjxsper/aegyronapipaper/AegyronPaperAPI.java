package de.itsjxsper.aegyronapipaper;

import de.itsjxsper.aegyronapipaper.group.GroupAPI;
import de.itsjxsper.aegyronapipaper.home.HomeAPI;
import de.itsjxsper.aegyronapipaper.messaging.MessageAPI;
import de.itsjxsper.aegyronapipaper.player.PlayerDataAPI;
import org.jetbrains.annotations.NotNull;

/**
 * Main entry point for the Aegyron Paper API.
 * This API provides access to all Aegyron Core features for Paper plugin developers.
 *
 * <p>Usage example:
 * <pre>{@code
 * AegyronPaperAPI api = AegyronPaperAPI.getInstance();
 * api.messaging().broadcast("Hello World!");
 * }</pre>
 *
 * @author ItsJxsper
 * @version 1.0.0
 * @since 1.0.0
 */
public interface AegyronPaperAPI {

    /**
     * Gets the singleton instance of the Aegyron Paper API.
     *
     * @return the API instance
     * @throws IllegalStateException if the API is not initialized
     */
    static @NotNull AegyronPaperAPI getInstance() {
        if (AegyronPaperAPIProvider.instance == null) {
            throw new IllegalStateException(
                    "AegyronPaperAPI is not initialized. Make sure Aegyron-Paper plugin is loaded."
            );
        }
        return AegyronPaperAPIProvider.instance;
    }

    /**
     * Gets the messaging API for sending messages and broadcasts.
     *
     * @return the messaging API
     */
    @NotNull MessageAPI messaging();

    /**
     * Gets the group API for server group management.
     *
     * @return the group API
     */
    @NotNull GroupAPI group();

    /**
     * Gets the player data API for player data management.
     *
     * @return the player data API
     */
    @NotNull PlayerDataAPI playerData();

    /**
     * Gets the home API for home management.
     *
     * @return the home API
     */
    @NotNull HomeAPI home();

    /**
     * Gets the API version.
     *
     * @return the version string
     */
    @NotNull String getVersion();

    /**
     * Checks if the API is fully initialized and ready to use.
     *
     * @return true if the API is ready
     */
    boolean isReady();
}
