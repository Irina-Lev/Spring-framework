package spring.basics.homework;

import java.io.IOException;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import spring.basics.homework.config.ResultsProcessorConfig;
import spring.basics.homework.model.Distance;
import spring.basics.homework.model.Gender;
import spring.basics.homework.model.Result;
import spring.basics.homework.service.ResultsProcessor;
import spring.basics.homework.service.ResultsReader;

public class ResultsProcessorMain {

    public static void main(String[] args) throws IOException {

        List<Result> fastestMen = getFastestMen(Gender.FEMALE, Distance.TEN_KM, 3);
        System.out.println(fastestMen);
    }

    public  static List <Result> getFastestMen (Gender gender, Distance distance, int line) throws IOException {
        var applicationContext = new AnnotationConfigApplicationContext(ResultsProcessorConfig.class);

        var resultsReader = applicationContext.getBean(ResultsReader.class);
        var filePath = new ClassPathResource("results.csv").getFile().toPath();
        var results = resultsReader.readFromFile(filePath);

        var resultsProcessor = new ResultsProcessor(results);
        return  resultsProcessor.getFastest(gender, distance, line);
    }
}

