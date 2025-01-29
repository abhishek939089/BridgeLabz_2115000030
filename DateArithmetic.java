import java.time.*;

public class DateArithmetic {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2024, 1, 29);
        LocalDate modifiedDate = date.plusDays(7).plusMonths(1).plusYears(2).minusWeeks(3);
        System.out.println("Final Date: " + modifiedDate);
    }
}
