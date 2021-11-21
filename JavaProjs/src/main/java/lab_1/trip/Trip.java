package lab_1.trip;

import lab_1.route.Route;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Trip implements Serializable {
    private Route route;
    private Calendar start;
    private Calendar end;

    public Trip()  {
        //route = new Route();
        start = new GregorianCalendar();
        end = new GregorianCalendar();
    }

    public Route getRoute() {
        return route;
    }

    protected void setRoute(Route route) {
        this.route = route;
    }

    public Calendar getStartTime() {
        return start;
    }

    protected void setStart(Calendar start) {
        this.start = start;
    }

    public Calendar getEndTime() {
        return end;
    }

    protected void setEnd(Calendar end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return Objects.equals(route, trip.route) && Objects.equals(start, trip.start) && Objects.equals(end, trip.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(route, start, end);
    }

    @Override
    public String toString() {
        return "Trip{" +
                "route=" + route +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
