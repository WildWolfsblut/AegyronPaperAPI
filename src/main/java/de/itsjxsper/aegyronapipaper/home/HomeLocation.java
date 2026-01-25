package de.itsjxsper.aegyronapipaper.home;

import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a serializable home location.
 */
public interface HomeLocation {

    /**
     * Gets the world name.
     *
     * @return the world name
     */
    @NotNull String getWorld();

    /**
     * Gets the X coordinate.
     *
     * @return the X coordinate
     */
    double getX();

    /**
     * Gets the Y coordinate.
     *
     * @return the Y coordinate
     */
    double getY();

    /**
     * Gets the Z coordinate.
     *
     * @return the Z coordinate
     */
    double getZ();

    /**
     * Gets the yaw.
     *
     * @return the yaw
     */
    float getYaw();

    /**
     * Gets the pitch.
     *
     * @return the pitch
     */
    float getPitch();

    /**
     * Converts to a Bukkit location if the world is loaded.
     *
     * @return the Bukkit location, or null if world not loaded
     */
    @Nullable Location toBukkitLocation();

    /**
     * Creates a HomeLocation from a Bukkit location.
     *
     * @param location the Bukkit location
     * @return the home location
     */
    static @NotNull HomeLocation fromBukkitLocation(@NotNull Location location) {
        return new HomeLocationImpl(
                location.getWorld().getName(),
                location.getX(),
                location.getY(),
                location.getZ(),
                location.getYaw(),
                location.getPitch()
        );
    }
}
