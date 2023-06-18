package pt.ipp.isep.dei.esoft.project.domain.shared;

import java.io.Serializable;

public enum AnnouncementStatus implements Serializable {
    REQUESTED,
    PUBLISHED,
    REJECTED,
    SOLD,
    RENTED,
    PENDENT
}
