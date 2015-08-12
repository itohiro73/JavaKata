package jp.itohiro.kata;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class Ex2DateTimeKata {

    /**
     *  Create a LocalDate instance for "2015-08-12".
     *  Create a LocalTime instance for "07:56".
     *  Create a LocalDateTime instance for "2015-08-12T07:56".
     *  @see LocalDate#of(int year, int month, int dayOfMonth)
     *  @see LocalTime#of(int hour, int minute, int second)
     *  @see LocalDateTime#of(int year, int month, int dayOfMonth, int hour, int minute)
     */
    @Test
    public void test1Instantiation() {
        LocalDate localDate20150812 = null; //todo: instantiate LocalDate for 2015-08-12 here
        assertNotNull("Hint: Create LocalDate instance for \"2015-08-12\" by using LocalDate.of() method",
                localDate20150812);
        assertThat(localDate20150812.toString(), is("2015-08-12"));

        LocalTime localTime07_56 = null; //todo: instantiate LocalTime for 07:56 here
        assertNotNull("Hint: Create LocalTime instance for \"07:56\" by using LocalTime.of() method",
                localTime07_56);
        assertThat(localTime07_56.toString(), is("07:56"));

        LocalDateTime localDateTime20150812_07_56 = null; //todo: instantiate LocalDateTime for 2015-08-12 here
        assertNotNull("Hint: Create LocalDateTime instance for \"07:56\" by using LocalTime.of() method",
                localDateTime20150812_07_56);
        assertThat(localDateTime20150812_07_56.toString(), is("2015-08-12T07:56"));
    }
}
