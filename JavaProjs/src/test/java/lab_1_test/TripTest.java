package lab_1_test;

import lab_1.Station;
import lab_1.route.Route;
import lab_1.route.RouteBuilder;
import lab_1.trip.TripBuilder;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.testng.Assert.*;

public class TripTest {
    Station[] arr = new Station[]
            {new Station("a"),new Station("b"),new Station("c"),
                    new Station("d"),new Station("e"),new Station("i")};
    ArrayList<Station> stations = new ArrayList<>(Arrays.stream(arr).toList());
    Route route = new RouteBuilder().setStations(stations).addCode("F").build();


    @Test(expectedExceptions = AssertionError.class)
    public void badValue(){
        new TripBuilder().build();
    }
    @Test(expectedExceptions = AssertionError.class)
    public void badTime(){
        new TripBuilder()
                .addRoute(route)
                .addStartTime(new GregorianCalendar(2017,23,2,12,0,0))
                .addEndTime(new GregorianCalendar(2017,23,2,11,0,0))
                .build();
    }
    @Test(dataProvider = "valuesToGoodTrip")
    public void goodTrip(Route route, GregorianCalendar start, GregorianCalendar end){
       var trip =  new TripBuilder()
               .addRoute(route)
               .addStartTime(start)
               .addEndTime(end)
               .build();
        assertEquals(trip.getRoute(),route);
        assertEquals(trip.getStartTime(),start);
        assertEquals(trip.getEndTime(),end);
    }

    @DataProvider
    public Object[][] valuesToGoodTrip(){

        return new Object[][]{
                {route,new GregorianCalendar(2019,10,10,9,0),new GregorianCalendar(2019,10,10,10,0)},
                {route,new GregorianCalendar(2019,10,10,9,0),new GregorianCalendar(2019,10,10,11,0)}
        };
    }
}