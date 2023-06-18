package pt.ipp.isep.dei.esoft.project.domain.shared;

import java.io.Serializable;

/**
 * The enum Announcement status.
 */
public enum AnnouncementStatus implements Serializable {
    /**
     * Requested announcement status.
     */
    REQUESTED,
    /**
     * Published announcement status.
     */
    PUBLISHED,
    /**
     * Rejected announcement status.
     */
    REJECTED,
    /**
     * Sold announcement status.
     */
    SOLD,
    /**
     * Rented announcement status.
     */
    RENTED,
    /**
     * Pendent announcement status.
     */
    PENDENT
}
