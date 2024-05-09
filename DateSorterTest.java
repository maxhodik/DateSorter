package sample;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

class DateSorterTest {
    List<LocalDate> unsortedDates = List.of(
            LocalDate.of(2004, 7, 1),
            LocalDate.of(2005, 1, 2),
            LocalDate.of(2007, 1, 1),
            LocalDate.of(2032, 5, 3));

    List<LocalDate> expectedList = List.of(
            LocalDate.of(2005, 1, 2),
            LocalDate.of(2007, 1, 1),
            LocalDate.of(2032, 5, 3),
            LocalDate.of(2004, 7, 1));

    @Test
    void sortDates() {
        DateSorter dateSorter = new DateSorter();
        Collection<LocalDate> sortedDates = dateSorter.sortDates(unsortedDates);
        Assertions.assertEquals(sortedDates, expectedList);
    }
}