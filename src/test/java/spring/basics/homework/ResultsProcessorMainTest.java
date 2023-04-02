package spring.basics.homework;

import org.junit.Assert;
import org.junit.Test;
import spring.basics.homework.model.Distance;
import spring.basics.homework.model.Gender;
import spring.basics.homework.model.Person;
import spring.basics.homework.model.Result;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ResultsProcessorMainTest {

    @Test
    public void getFastestWimen() throws IOException {
        Result wimen1 = new Result(new Person("Коробкина Елена", Gender.FEMALE), Distance.TEN_KM,
                parseTime("31:49"), "31:49");
        Result wimen2 = new Result(new Person("Александрова Анастасия", Gender.FEMALE), Distance.TEN_KM,
                parseTime("32:39"), "32:39");

        List<Result> fastestWimenTest = new ArrayList<>();
        fastestWimenTest.add(wimen1);
        fastestWimenTest.add(wimen2);
        List<Result> fastestWimen = ResultsProcessorMain.getFastestMen(Gender.FEMALE, Distance.TEN_KM, 2);

        Assert.assertEquals(fastestWimen, fastestWimenTest);
    }

    @Test
    public void getFastestMen() throws IOException {
        Result man1 = new Result(new Person("Никитин Владимир", Gender.MALE), Distance.TEN_KM,
                parseTime("28:22"), "28:22");
        Result man2 = new Result(new Person("Ахмадеев Ринас", Gender.MALE), Distance.TEN_KM,
                parseTime("29:01"), "29:01");

        List<Result> fastestMenTest = new ArrayList<>();
        fastestMenTest.add(man1);
        fastestMenTest.add(man2);
        List<Result> fastestMen = ResultsProcessorMain.getFastestMen(Gender.MALE, Distance.TEN_KM, 2
        );

        Assert.assertEquals(fastestMen, fastestMenTest);

    }

    private Duration parseTime(String time) {
        var timeParts = time.split(":");

        // Минуты умножнаем на 60 и добавляем секунды
        var totalSecond = Integer.valueOf(timeParts[0]) * 60 + Integer.valueOf(timeParts[1]);
        return Duration.ofSeconds(totalSecond);
    }

}