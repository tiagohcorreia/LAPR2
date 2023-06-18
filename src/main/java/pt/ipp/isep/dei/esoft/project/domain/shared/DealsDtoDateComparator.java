package pt.ipp.isep.dei.esoft.project.domain.shared;

import pt.ipp.isep.dei.esoft.project.domain.dto.DealsDto;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Locale;

public class DealsDtoDateComparator implements Comparator<DealsDto> {
    @Override
    public int compare(DealsDto o1, DealsDto o2) {
        return o1.getDate().compareTo(o2.getDate());
    }
}
