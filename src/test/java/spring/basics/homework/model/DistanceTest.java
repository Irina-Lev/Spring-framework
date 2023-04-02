package spring.basics.homework.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class DistanceTest {

    @Test (expected = Exception.class)
    public void of() {
         Distance.of("123");
    }
}