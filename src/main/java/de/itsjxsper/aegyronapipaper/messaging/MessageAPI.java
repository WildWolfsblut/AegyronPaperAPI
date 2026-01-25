package de.itsjxsper.aegyronapipaper.messaging;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * API for sending messages, broadcasts, and other player communications.
 * Supports MiniMessage format and Adventure components.
 *
 * <p>Usage examples:
 * <pre>{@code
 * // Send message to player
 * api.messaging().sendMessage(player, "<green>Hello!");
 *
 * // Broadcast to all players
 * api.messaging().broadcast("<red>Server restart in 5 minutes!");
 *
 * // Send to specific group
 * api.messaging().broadcastToGroup("survival", "Event started!");
 *
 * // Use message builder
 * api.messaging().builder()
 *     .text("<gold>Click here")
 *     .clickCommand("/spawn")
 *     .hoverText("Teleport to spawn")
 *     .send(player);
 * }</pre>
 *
 * @author ItsJxsper
 * @version 1.0.0
 */
public interface MessageAPI {

    // ============================================================
    // SINGLE MESSAGES
    // ============================================================

    /**
     * Sends a message to a player.
     *
     * @param player the player to send to
     * @param message the message (supports MiniMessage format)
     */
    void sendMessage(@NotNull Player player, @NotNull String message);

    /**
     * Sends a message to a player by UUID.
     *
     * @param uuid the player UUID
     * @param message the message
     * @return future that completes when message is sent
     */
    @NotNull CompletableFuture<Void> sendMessage(@NotNull UUID uuid, @NotNull String message);

    /**
     * Sends a component to a player.
     *
     * @param player the player
     * @param component the component
     */
    void sendMessage(@NotNull Player player, @NotNull Component component);

    /**
     * Sends an action bar message to a player.
     *
     * @param player the player
     * @param message the message
     */
    void sendActionBar(@NotNull Player player, @NotNull String message);

    /**
     * Sends an action bar component to a player.
     *
     * @param player the player
     * @param component the component
     */
    void sendActionBar(@NotNull Player player, @NotNull Component component);

    // ============================================================
    // BROADCASTS
    // ============================================================

    /**
     * Broadcasts a message to all players on all servers.
     *
     * @param message the message to broadcast
     * @return future that completes when broadcast is sent
     */
    @NotNull CompletableFuture<Void> broadcast(@NotNull String message);

    /**
     * Broadcasts a component to all players on all servers.
     *
     * @param component the component to broadcast
     * @return future that completes when broadcast is sent
     */
    @NotNull CompletableFuture<Void> broadcast(@NotNull Component component);

    /**
     * Broadcasts a message to all players in a specific server group.
     *
     * @param groupName the group name
     * @param message the message
     * @return future that completes when broadcast is sent
     */
    @NotNull CompletableFuture<Void> broadcastToGroup(@NotNull String groupName, @NotNull String message);

    /**
     * Broadcasts a message to all players on a specific server.
     *
     * @param serverName the server name
     * @param message the message
     * @return future that completes when broadcast is sent
     */
    @NotNull CompletableFuture<Void> broadcastToServer(@NotNull String serverName, @NotNull String message);

    /**
     * Broadcasts a message to players with a specific permission.
     *
     * @param permission the permission node
     * @param message the message
     * @return future that completes when broadcast is sent
     */
    @NotNull CompletableFuture<Void> broadcastWithPermission(@NotNull String permission, @NotNull String message);

    // ============================================================
    // TITLES & EFFECTS
    // ============================================================

    /**
     * Sends a title to a player.
     *
     * @param player the player
     * @param title the title text
     * @param subtitle the subtitle text
     */
    void sendTitle(@NotNull Player player, @NotNull String title, @NotNull String subtitle);

    /**
     * Sends a title with custom timings.
     *
     * @param player the player
     * @param title the title text
     * @param subtitle the subtitle text
     * @param fadeIn fade in time in ticks
     * @param stay stay time in ticks
     * @param fadeOut fade out time in ticks
     */
    void sendTitle(
            @NotNull Player player,
            @NotNull String title,
            @NotNull String subtitle,
            int fadeIn,
            int stay,
            int fadeOut
    );

    /**
     * Sends an Adventure title to a player.
     *
     * @param player the player
     * @param title the title
     */
    void sendTitle(@NotNull Player player, @NotNull Title title);

    /**
     * Plays a sound to a player.
     *
     * @param player the player
     * @param sound the sound to play
     */
    void playSound(@NotNull Player player, @NotNull Sound sound);

    /**
     * Plays a sound to a player with custom volume and pitch.
     *
     * @param player the player
     * @param sound the sound
     * @param volume the volume (0.0 to 1.0)
     * @param pitch the pitch (0.5 to 2.0)
     */
    void playSound(@NotNull Player player, @NotNull Sound sound, float volume, float pitch);

    // ============================================================
    // MESSAGE BUILDER
    // ============================================================

    /**
     * Creates a new message builder for complex messages.
     *
     * @return a new message builder
     */
    @NotNull MessageBuilder builder();

    // ============================================================
    // UTILITY
    // ============================================================

    /**
     * Parses a MiniMessage string to a Component.
     *
     * @param message the message string
     * @return the parsed component
     */
    @NotNull Component parse(@NotNull String message);

    /**
     * Strips all formatting from a message.
     *
     * @param message the message
     * @return the plain text
     */
    @NotNull String stripFormatting(@NotNull String message);
}