package lab_2_test;

import lab_1.Station;
import lab_1.route.Route;
import lab_1.route.RouteBuilder;
import lab_2.FileSaveLoad;
import lab_2.desirialize.JSONDeserialize;
import lab_2.serialize.JSONSerialize;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

public class FileSaveLoadTest {

    @Test
    public void testSaveLoad() {
        Route route = new RouteBuilder()
                .addStation(new Station("a"))
                .addCode("b")
                .addStation(new Station("b"))
                .build();
        FileSaveLoad fileSaveLoad = new FileSaveLoad();
        String res=null;
        try {
            fileSaveLoad.saveFile("aa.txt",new JSONSerialize<Route>().fromObject(route));
            res = fileSaveLoad.loadFrom("aa.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            assertEquals(route,new JSONDeserialize<Route>(Route.class).toObject(res));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}