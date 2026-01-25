package de.itsjxsper.aegyronapipaper;

import org.jetbrains.annotations.NotNull;

/**
 * Internal provider for the API instance.
 * This class is used by the implementation to set the instance.
 */
public final class AegyronPaperAPIProvider {
    static AegyronPaperAPI instance;

    private AegyronPaperAPIProvider() {
        throw new UnsupportedOperationException("This is a utility class");
    }

    /**
     * Sets the API instance. This method should only be called by the implementation.
     *
     * @param api the API instance
     */
    public static void setInstance(@NotNull AegyronPaperAPI api) {
        if (instance != null) {
            throw new IllegalStateException("AegyronPaperAPI instance is already set");
        }
        instance = api;
    }

    /**
     * Unsets the API instance. This method should only be called on plugin shutdown.
     */
    public static void unsetInstance() {
        instance = null;
    }
}
