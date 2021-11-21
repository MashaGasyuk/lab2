package lab_1;

import lab_1.trip.Trip;

import java.io.Serializable;
import java.util.*;

/**
 * Клас маршрутів руху. Клас зберігає в собі маршрути. Видає інформацію про них
 */
public class Schedule implements Serializable {
    private List<Trip> trips;

    protected Schedule() {
        trips = new ArrayList<>();
    }

    public static class Builder{
        private Schedule schedule;

        public Builder() {
            schedule = new Schedule();
        }
        public Builder addTrip(Trip trip){
            assert (trip!=null);
            schedule.trips.add(trip);
            return this;
        }
        public Builder setTrips(List<Trip> trips){
            assert (trips!=null);
            schedule.trips = trips;
            return this;
        }
        public Schedule build(){
            assert (schedule.trips != null);
            assert (schedule.trips.size()!=0);
            return schedule;
        }
    }

    /**
     * Повертає всі маршрути, які будуть в цей день
     * @param day
     * @return
     */
    public ArrayList<Trip> getTripsAtDay(Calendar day) {
        assert (day!=null);
        ArrayList<Trip> tripsAtDay= new ArrayList<>();
        for (var trip: trips) {
            if(trip.getStartTime().before(day) && trip.getEndTime().after(day)){
                tripsAtDay.add(trip);
            }
        }
        return tripsAtDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(trips, schedule.trips);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trips);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "trips=" + trips +
                '}';
    }
}
