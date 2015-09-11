package jp.itohiro.kata;

import org.junit.Test;

import java.time.*;

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
    public void test1LocalDateTimeInstantiation() {
        LocalDate localDate20150812 = null; //todo: instantiate LocalDate for 2015-08-12 here
        assertNotNull("Hint: Create LocalDate instance for \"2015-08-12\" by using LocalDate.of() method",
                localDate20150812);
        assertThat(localDate20150812.toString(), is("2015-08-12"));

        LocalTime localTime07_56 = null; //todo: instantiate LocalTime for 07:56 here
        assertNotNull("Hint: Create LocalTime instance for \"07:56\" by using LocalTime.of() method",
                localTime07_56);
        assertThat(localTime07_56.toString(), is("07:56"));

        LocalDateTime localDateTime20150812_07_56 = null; //todo: instantiate LocalDateTime for 2015-08-12 here
        assertNotNull("Hint: Create LocalDateTime instance for \"2015-08-12T07:56\" by using LocalDateTime.of() method",
                localDateTime20150812_07_56);
        assertThat(localDateTime20150812_07_56.toString(), is("2015-08-12T07:56"));
    }

    /**
     *  Create a ZonedDateTime instance for "2015-08-12T07:56+09:00[Asia/Tokyo]".
     *  Create a ZonedDateTime instance for "2015-08-11T18:56-04:00[America/New_York]".
     *  Create a ZonedDateTime instance for "2015-08-12T07:56-04:00[America/New_York]".
     *  @see ZonedDateTime#of(LocalDate, LocalTime, ZoneId)
     *  @see ZonedDateTime#withZoneSameInstant(ZoneId)
     *  @see ZonedDateTime#withZoneSameLocal(ZoneId)
     */
    @Test
    public void test2ZonedDateTimeInstantiation() {
        //todo: create a ZonedDateTime for 2015-08-12T07:56[Asia/Tokyo]
        ZonedDateTime zonedDateTime20150812_07_56_Tokyo = null;

        assertNotNull("Hint: Create ZonedDateTime instance for \"2015-08-12T07:56\" in \"Asia/Tokyo\" by using ZonedDateTime.of() method",
                zonedDateTime20150812_07_56_Tokyo);
        assertThat(zonedDateTime20150812_07_56_Tokyo.toString(), is("2015-08-12T07:56+09:00[Asia/Tokyo]"));

        //todo: create a ZonedDateTime at the same instant as 2015-08-12T07:56[Asia/Tokyo] for zone "America/New_York"
        ZonedDateTime zonedDateTime20150811_18_56_NewYork = null;

        assertNotNull("Hint: Create ZonedDateTime instance for \"2015-08-11T18:56\" in \"America/New_York\" by using ZonedDateTime.withZoneSameInstant() method",
                zonedDateTime20150811_18_56_NewYork);
        assertThat(zonedDateTime20150811_18_56_NewYork.toString(), is("2015-08-11T18:56-04:00[America/New_York]"));

        //todo: create a ZonedDateTime with the same local time "2015-08-12T07:56" for zone "America/New_York"
        ZonedDateTime zonedDateTime20150812_07_56_NewYork = null;

        assertNotNull("Hint: Create ZonedDateTime instance for \"2015-08-12T07:56\" in \"America/New_York\" by using ZonedDateTime.withZoneSameLocal() method",
                zonedDateTime20150812_07_56_NewYork);
        assertThat(zonedDateTime20150812_07_56_NewYork.toString(), is("2015-08-12T07:56-04:00[America/New_York]"));
    }

    /**
     *  Create a ZonedDateTime instance at Asia/Tokyo for epoch milli second: 1441780196115 (2015-09-09T15:29:56.115+09:00[Asia/Tokyo]).
     *  Create a ZonedDateTime instance at Asia/Tokyo for epoch second: 1441780196 (2015-09-09T15:29:56+09:00[Asia/Tokyo]).
     *  @see Instant#ofEpochMilli(long)
     *  @see Instant#ofEpochSecond(long)
     *  @see Instant#atZone(ZoneId)
     */
    @Test
    public void test3Instant() {
        long epochMilliSecond = 1441780196115L;
        long epochSecond = 1441780196;

        //todo: create a ZonedDateTime at zone "America/New_York" for epoch milli second: 1441780196115
        ZonedDateTime zonedDateTime20150909_15_29_56_115 = null;

        assertNotNull("Hint: Create ZonedDateTime at zone \"America/New_York\" for epoch milli second: 1441780196115 by using Instance.ofEpochMilli() and Instance.atZone() methods",
                zonedDateTime20150909_15_29_56_115);
        assertThat(zonedDateTime20150909_15_29_56_115.toString(), is("2015-09-09T15:29:56.115+09:00[Asia/Tokyo]"));

        //todo: create a ZonedDateTime at zone "America/New_York" for epoch second: 1441780196
        ZonedDateTime zonedDateTime20150909_15_29_56 = null;

        assertNotNull("Hint: Create ZonedDateTime at zone \"America/New_York\" for epoch second: 1441780196 by using Instance.ofEpochSecond() and Instance.atZone() methods",
                zonedDateTime20150909_15_29_56);
        assertThat(zonedDateTime20150909_15_29_56.toString(), is("2015-09-09T15:29:56+09:00[Asia/Tokyo]"));
    }
}
