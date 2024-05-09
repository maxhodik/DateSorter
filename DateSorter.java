package sample;

import java.time.LocalDate;
import java.util.*;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 * <p>
 * <p>
 * package sample;
 * <p>
 * import java.time.LocalDate;
 * import java.util.Collection;
 * import java.util.List;
 * <p>
 * /**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 * <p>
 * Implement in single class. Don't chane constructor and signature method.
 */
public class DateSorter {

    private static final String R_CHAR_IN_MONTH = "r";

    /**
     * The implementation of this method should sort dates.
     * The output should be in the following order:
     * Dates with an 'r' in the month,
     * sorted ascending (first to last),
     * then dates without an 'r' in the month,
     * sorted descending (last to first).
     * For example, October dates would come before May dates,
     * because October has an 'r' in it.
     * thus: (2004-07-01, 2005-01-02, 2007-01-01, 2032-05-03)
     * would sort to
     * (2005-01-02, 2007-01-01, 2032-05-03, 2004-07-01)
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the collection of dates now sorted as per the spec
     */
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {

        if (unsortedDates == null || unsortedDates.isEmpty()) {
            throw new IllegalArgumentException("Input list of dates is null or empty.");
        }
        List<LocalDate> datesWithR = getSortedDateWithR(unsortedDates);
        List<LocalDate> datesWithoutR = getSortedDatesWithoutR(unsortedDates);
        List<LocalDate> result = new ArrayList<>(datesWithR);
        result.addAll(datesWithoutR);
        return result;
    }

    private List<LocalDate> getSortedDatesWithoutR(List<LocalDate> unsortedDates) {
        return unsortedDates.stream()
                .filter(Objects::nonNull)
                .filter(x -> !isDateMonthContainsR(x))
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    private List<LocalDate> getSortedDateWithR(List<LocalDate> unsortedDates) {
        return unsortedDates.stream()
                .filter(Objects::nonNull)
                .filter(this::isDateMonthContainsR)
                .sorted()
                .toList();
    }

    private boolean isDateMonthContainsR(LocalDate x) {
        return x.getMonth().toString().toLowerCase().contains(R_CHAR_IN_MONTH);
    }
}