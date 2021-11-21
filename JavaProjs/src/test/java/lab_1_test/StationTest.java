package lab_1_test;

import lab_1.Station;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StationTest {
    @Test(expectedExceptions = AssertionError.class)
    public void badName(){
        new Station("");
    }

    @Test
    public void goodCreate(){
        new Station("4esovtsi");
    }

    @Test(dataProvider = "readNames")
    public void NotChangeReadNames(String name, String res){
        Station station = new Station(name);
        assertEquals(station.getName(),res);
    }


    @DataProvider
    public Object[][] readNames(){
        return new Object[][]{
                {"Gribovka","Gribovka"},
                {"Bactshi","Bactshi"}
        };
    }

}