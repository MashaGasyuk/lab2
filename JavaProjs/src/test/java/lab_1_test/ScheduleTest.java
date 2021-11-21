package lab_1_test;

import lab_1.Schedule;
import lab_1.Station;
import lab_1.route.Route;
import lab_1.route.RouteBuilder;
import lab_1.trip.Trip;
import lab_1.trip.TripBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import static org.testng.Assert.*;

public class ScheduleTest {
    Station[] arr = new Station[]
            {new Station("a"),new Station("b"),new Station("c"),
                    new Station("d"),new Station("e"),new Station("i")};
    ArrayList<Station> stations = new ArrayList<>(Arrays.stream(arr).toList());
    Route route = new RouteBuilder().setStations(stations).addCode("F").build();
    Trip[] tripsArr = new Trip[]{
            new TripBuilder().addRoute(route)
                    .addStartTime(new GregorianCalendar(2019,8,2,9,15))
                    .addEndTime(new GregorianCalendar(2019,8,2,10,45)).build(),
            new TripBuilder().addRoute(route)
                    .addStartTime(new GregorianCalendar(2019,8,3,10,15))
                    .addEndTime(new GregorianCalendar(2019,8,3,11,30)).build(),
            new TripBuilder().addRoute(route)
                    .addStartTime(new GregorianCalendar(2019,8,3,10,30))
                    .addEndTime(new GregorianCalendar(2019,8,3,11,0)).build(),
    };

    @Test(expectedExceptions = AssertionError.class)
    public void badValueInCreate(){
        new Schedule.Builder().build();
    }

    @Test
    public void GoodCreate(){
        new Schedule.Builder().setTrips(List.of(tripsArr)).build();
    }




}