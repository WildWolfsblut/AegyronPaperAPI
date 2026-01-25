package de.itsjxsper.aegyronapipaper.home;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Default implementation of HomeLocation.
 */
record HomeLocationImpl(
        String world,
        double x,
        double y,
        double z,
        float yaw,
        float pitch
) implements HomeLocation {

    @Override
    public @NotNull String getWorld() { return world; }
    @Override
    public double getX() { return x; }
    @Override
    public double getY() { return y; }
    @Override
    public double getZ() { return z; }
    @Override
    public float getYaw() { return yaw; }
    @Override
    public float getPitch() { return pitch; }

    @Override
    public @Nullable Location toBukkitLocation() {
        var world = Bukkit.getWorld(this.world);
        if (world == null) return null;
        return new Location(world, x, y, z, yaw, pitch);
    }
}
