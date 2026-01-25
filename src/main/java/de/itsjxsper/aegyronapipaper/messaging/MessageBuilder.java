package de.itsjxsper.aegyronapipaper.messaging;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * Builder for creating complex interactive messages.
 *
 * <p>Usage example:
 * <pre>{@code
 * api.messaging().builder()
 *     .text("<gold>Click here ")
 *     .clickCommand("/spawn")
 *     .hoverText("Teleport to spawn")
 *     .then("<gray>or ")
 *     .then("<red>here")
 *     .clickUrl("https://example.com")
 *     .hoverText("Visit website")
 *     .send(player);
 * }</pre>
 *
 * @author ItsJxsper
 * @version 1.0.0
 */
public interface MessageBuilder {

    // ============================================================
    // TEXT CONTENT
    // ============================================================

    /**
     * Adds text to the message (supports MiniMessage format).
     *
     * @param text the text to add
     * @return this builder
     */
    @NotNull MessageBuilder text(@NotNull String text);

    /**
     * Adds a component to the message.
     *
     * @param component the component to add
     * @return this builder
     */
    @NotNull MessageBuilder component(@NotNull Component component);

    /**
     * Adds a new line to the message.
     *
     * @return this builder
     */
    @NotNull MessageBuilder newline();

    /**
     * Starts a new component (like calling text() but semantically clearer).
     *
     * @param text the text for the new component
     * @return this builder
     */
    @NotNull MessageBuilder then(@NotNull String text);

    // ============================================================
    // CLICK EVENTS
    // ============================================================

    /**
     * Makes the last added component execute a command when clicked.
     *
     * @param command the command to execute (without /)
     * @return this builder
     */
    @NotNull MessageBuilder clickCommand(@NotNull String command);

    /**
     * Makes the last added component suggest a command when clicked.
     *
     * @param command the command to suggest
     * @return this builder
     */
    @NotNull MessageBuilder clickSuggest(@NotNull String command);

    /**
     * Makes the last added component open a URL when clicked.
     *
     * @param url the URL to open
     * @return this builder
     */
    @NotNull MessageBuilder clickUrl(@NotNull String url);

    /**
     * Makes the last added component copy text to clipboard when clicked.
     *
     * @param text the text to copy
     * @return this builder
     */
    @NotNull MessageBuilder clickCopy(@NotNull String text);

    /**
     * Adds a custom click event to the last added component.
     *
     * @param clickEvent the click event
     * @return this builder
     */
    @NotNull MessageBuilder click(@NotNull ClickEvent clickEvent);

    // ============================================================
    // HOVER EVENTS
    // ============================================================

    /**
     * Shows text when hovering over the last added component.
     *
     * @param text the hover text (supports MiniMessage)
     * @return this builder
     */
    @NotNull MessageBuilder hoverText(@NotNull String text);

    /**
     * Shows a component when hovering over the last added component.
     *
     * @param component the hover component
     * @return this builder
     */
    @NotNull MessageBuilder hoverComponent(@NotNull Component component);

    /**
     * Adds a custom hover event to the last added component.
     *
     * @param hoverEvent the hover event
     * @return this builder
     */
    @NotNull MessageBuilder hover(@NotNull HoverEvent<?> hoverEvent);

    // ============================================================
    // BUILDING & SENDING
    // ============================================================

    /**
     * Builds the final component.
     *
     * @return the built component
     */
    @NotNull Component build();

    /**
     * Builds and sends the message to a player.
     *
     * @param player the player to send to
     */
    void send(@NotNull Player player);

    /**
     * Builds and sends the message to multiple players.
     *
     * @param players the players to send to
     */
    void send(@NotNull Collection<Player> players);

    /**
     * Builds and sends the message as an action bar to a player.
     *
     * @param player the player
     */
    void sendActionBar(@NotNull Player player);

    /**
     * Resets the builder to start fresh.
     *
     * @return this builder
     */
    @NotNull MessageBuilder reset();
}