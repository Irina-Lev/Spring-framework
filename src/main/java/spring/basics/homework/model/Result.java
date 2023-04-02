package spring.basics.homework.model;

import java.time.Duration;

public record Result(Person person, Distance distance, Duration time, String timeString) {


    @Override
    public String toString() {
        return "Result{" +
                "person=" + person +
                ", distance=" + distance +
                ", time='" + timeString + '\'' +
                '}';
    }

    public boolean hasGender(Gender gender) {
        return person.gender() == gender;
    }

    public boolean hasDistance(Distance distance) {
        return this.distance == distance;
    }
}

