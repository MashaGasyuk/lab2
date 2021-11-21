package lab_1_test;

import lab_1.Station;
import lab_1.route.Route;
import lab_1.route.RouteBuilder;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class RouteTest {
    Station[] arr = new Station[]
            {new Station("a"),new Station("b"),new Station("c"),
                    new Station("d"),new Station("e"),new Station("i")};
     ArrayList<Station> stations = new ArrayList<>(Arrays.stream(arr).toList());

    @Test(expectedExceptions = AssertionError.class)
    public void CountOfStationsLess2(){
        new RouteBuilder().addStation(arr[0]).build();
    }
    @Test(expectedExceptions = AssertionError.class)
    public void CodeRouteUninit(){
        new RouteBuilder().addCode("").build();
    }
    @Test
    public void goodBuild(){
        new RouteBuilder().setStations(stations).addCode("someCode").build();
    }

    @Test
    public void NotChanged(ArrayList<Station> stations, String code){
        Route route = new RouteBuilder().setStations(stations).addCode(code).build();
        assertEquals(route.getCode(),code);
        assertEquals(route.getStationsR(),stations);
    }

    @DataProvider
    public Object[][] valuesNotChanged(){
        var st = new ArrayList<Station>();
        st.add(new Station("Kremka"));
        st.add(new Station("Kutka"));
        return new Object[][]{
                {stations,"someCodeRoute"},
                {st,"someCodeRoute"}
        };
    }

}