package ua.lv.pylypiuk.anton;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DateSorter {
    public List<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        List<LocalDate> rMonths = new ArrayList<>();
        List<LocalDate> nonRMonths = new ArrayList<>();

        for (LocalDate date : unsortedDates) {
            if (hasRInMonth(date.getMonth())) {
                rMonths.add(date);
            } else {
                nonRMonths.add(date);
            }
        }
        
        Comparator<LocalDate> ascendingComparator = Comparator.comparing(LocalDate::toString);

        Comparator<LocalDate> descendingComparator = Comparator.comparing(LocalDate::toString).reversed();

        rMonths.sort(ascendingComparator);
        nonRMonths.sort(descendingComparator);

        List<LocalDate> sortedDates = new ArrayList<>(rMonths);
        sortedDates.addAll(nonRMonths);

        return sortedDates;
    }

    private boolean hasRInMonth(Month month) {
        String monthName = month.toString().toLowerCase();
        return monthName.contains("r");
    }

    public static void main(String[] args) {
        List<LocalDate> unsortedDates = new ArrayList<>();
        unsortedDates.add(LocalDate.of(2004, 7, 1));
        unsortedDates.add(LocalDate.of(2005, 1, 2));
        unsortedDates.add(LocalDate.of(2007, 1, 1));
        unsortedDates.add(LocalDate.of(2032, 5, 3));

        DateSorter dateSorter = new DateSorter();

        List<LocalDate> sortedDates = dateSorter.sortDates(unsortedDates);

        System.out.println("Sorted dates:");
        for (LocalDate date : sortedDates) {
            System.out.println(date);
        }
    }
}
