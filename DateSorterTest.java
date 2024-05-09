package sample;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DateSorterTest {
    private final DateSorter dateSorter = new DateSorter();
    private final List<LocalDate> unsortedDates = Arrays.asList(
            LocalDate.of(2004, 7, 1),
            LocalDate.of(2005, 1, 2),
            LocalDate.of(2007, 1, 1),
            LocalDate.of(2032, 5, 3));

    private final List<LocalDate> EXPECTED_LIST = List.of(
            LocalDate.of(2005, 1, 2),
            LocalDate.of(2007, 1, 1),
            LocalDate.of(2032, 5, 3),
            LocalDate.of(2004, 7, 1));

    @Test
    void sortDatesSuccess() {

        Collection<LocalDate> sortedDates = dateSorter.sortDates(unsortedDates);
        Assertions.assertEquals(EXPECTED_LIST, sortedDates);
    }

    @Test
    void sortDatesSuccessWithNull() {
        List<LocalDate> arrayList = new ArrayList<>(unsortedDates);
        arrayList.add(null);
        Collection<LocalDate> sortedDates = dateSorter.sortDates(arrayList);
        Assertions.assertEquals(EXPECTED_LIST, sortedDates);
    }

    @Test
    void shouldTrowExceptionNull() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                dateSorter.sortDates(null));

        String message = exception.getMessage();

        assertEquals("Input list of dates is null or empty.", message);
    }

    @Test
    void shouldTrowExceptionEmpty() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                dateSorter.sortDates(List.of()));

        String message = exception.getMessage();

        assertEquals("Input list of dates is null or empty.", message);
    }
}