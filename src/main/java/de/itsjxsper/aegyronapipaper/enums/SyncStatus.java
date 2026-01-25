package de.itsjxsper.aegyronapipaper.enums;

/**
 * Represents the synchronization status of player data.
 */
public enum SyncStatus {
    /** Data is fully synchronized */
    SYNCED,
    /** Data is currently being synchronized */
    SYNCING,
    /** Data sync is pending */
    PENDING,
    /** Data sync failed */
    FAILED,
    /** Data sync is disabled */
    DISABLED
}
