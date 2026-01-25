package de.itsjxsper.aegyronapipaper.utils;

import org.jetbrains.annotations.NotNull;

/**
 * Interface for custom data serializers.
 *
 * @param <T> the data type
 */
public interface DataSerializer<T> {
    /**
     * Serializes data to a string.
     *
     * @param data the data to serialize
     * @return the serialized string
     */
    @NotNull String serialize(@NotNull T data);

    /**
     * Deserializes data from a string.
     *
     * @param serialized the serialized string
     * @return the deserialized data
     */
    @NotNull T deserialize(@NotNull String serialized);
}
