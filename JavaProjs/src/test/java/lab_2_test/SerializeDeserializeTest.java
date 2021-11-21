package lab_2_test;

import lab_1.Station;
import lab_1.route.Route;
import lab_1.route.RouteBuilder;
import lab_2.desirialize.JSONDeserialize;
import lab_2.desirialize.TXTDeserialize;
import lab_2.desirialize.XMLDeserialize;
import lab_2.serialize.JSONSerialize;
import lab_2.serialize.TXTSerialize;
import lab_2.serialize.XMLSerialize;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

public class SerializeDeserializeTest {
    @Test
    public void toShow(){
        Route route = new RouteBuilder().addCode("AA").addStation(new Station("bb")).addStation(new Station("cc")).build();
        TXTSerialize<Route> txtSerialize = new TXTSerialize<>();
        TXTDeserialize<Route> txtDeserialize = new TXTDeserialize<>(Route.class);
        try {
            String res = txtSerialize.fromObject(route);
            System.out.println(res);
            Route newR = txtDeserialize.toObject(res);
            System.out.println(newR.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ObjectsToSerFromSer(){
        Route route = new RouteBuilder().addCode("AA").addStation(new Station("bb")).addStation(new Station("cc")).build();

        String json = "";
        String xml = "";
        String txt = "";

        try {
            json = new JSONSerialize<>().fromObject(route);
            xml = new XMLSerialize<>().fromObject(route);
            txt = new TXTSerialize<>().fromObject(route);



            assertEquals(route,new JSONDeserialize<>(Route.class).toObject(json));
            assertEquals(route,new XMLDeserialize<Route>(Route.class).toObject(xml));
            assertEquals(route,new TXTDeserialize<Route>(Route.class).toObject(txt));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}