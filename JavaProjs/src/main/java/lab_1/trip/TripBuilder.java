package lab_1.trip;

import lab_1.route.Route;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TripBuilder {
    private Trip trip;

    public TripBuilder() {
        trip = new Trip();
    }

    public TripBuilder addRoute(Route route){
        assert (route!=null);
        trip.setRoute(route);

        return this;
    }
    public TripBuilder addStartTime(Calendar start){
        assert (start!=null);
        trip.setStart(start);

        return this;
    }
    public TripBuilder addEndTime(Calendar end){
        assert (end!=null);
        trip.setEnd(end);

        return this;
    }
    public Trip build(){
        assert (trip.getRoute()!=null);
        assert (trip.getStartTime()!=null);
        assert (trip.getEndTime()!=null);
        assert (trip.getStartTime().before(trip.getEndTime()));

        return trip;
    }
}
