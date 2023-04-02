package spring.basics.homework.service;

import com.sun.net.httpserver.Authenticator;
import org.junit.Assert;
import org.junit.Test;
import spring.basics.homework.model.Distance;
import spring.basics.homework.model.Gender;
import spring.basics.homework.model.Person;
import spring.basics.homework.model.Result;

import java.time.Duration;

import static org.junit.Assert.*;

public class ResultParserTest {

    @Test
    public void parseResultTest() {
        var result= new ResultParser();
        var resultMen = result.parseResult("Ахмадеев Ринас,M,10 km,29:01");
        Result man1 = new Result(new Person("Ахмадеев Ринас", Gender.MALE), Distance.TEN_KM,
                parseTime("29:01"), "29:01");
        Assert.assertEquals(resultMen, man1);
    }

    private static Duration parseTime(String time) {
        var timeParts = time.split(":");

        // Минуты умножнаем на 60 и добавляем секунды
        var totalSecond = Integer.valueOf(timeParts[0]) * 60 + Integer.valueOf(timeParts[1]);
        return Duration.ofSeconds(totalSecond);
    }
}