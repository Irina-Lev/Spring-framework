package spring.basics.homework.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class GenderTest {

    @Test (expected = Exception.class)
    public void of() {
        Gender.of("123");
    }
} 