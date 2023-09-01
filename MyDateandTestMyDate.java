import java.util.*;

class MyDate {
    private int year;
    private int month;
    private int day;

    // No-arg constructor for current date
    public MyDate() {
        this(System.currentTimeMillis());
    }

    // Constructor with elapsed time
    public MyDate(long elapsedTime) {
        setDate(elapsedTime);
    }

    // Constructor with specified year, month, and day
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // Getter methods
    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    // Method to set a new date using elapsed time
    public void setDate(long elapsedTime) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(elapsedTime);

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
    }
}



public class TestMyDate {
    public static void main(String[] args) {
        MyDate date1 = new MyDate();
        MyDate date2 = new MyDate(34355555133101L);

        System.out.println("Date 1: " + date1.getYear() + "-" + date1.getMonth() + "-" + date1.getDay());
        System.out.println("Date 2: " + date2.getYear() + "-" + date2.getMonth() + "-" + date2.getDay());
    }
}



UML:
-------------------------------------
|             MyDate                |
-------------------------------------
| - year: int                        |
| - month: int                       |
| - day: int                         |
-------------------------------------
| + MyDate()                         |
| + MyDate(elapsedTime: long)        |
| + MyDate(year: int, month: int,    |
|         day: int)                  |
| + getYear(): int                   |
| + getMonth(): int                  |
| + getDay(): int                    |
| + setDate(elapsedTime: long): void |
-------------------------------------
