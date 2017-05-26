package org.bongiorno;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.out;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;


public class GridDynamics {

    private final Map<String, Long> report;

    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter pr = new PrintWriter(new BufferedOutputStream(new FileOutputStream("stats.csv", true)));

        out.format("Looking for %s%n", args[0]);

        int peopleCount = parseInt(args[1]);

        long iterations = parseLong(args[2]);
        System.out.format("Results for %d runs with %d people in the corpus ",iterations,peopleCount);

        long now = System.currentTimeMillis();
        long[] timings = LongStream.generate(() -> timing(args[0], peopleCount)).limit(iterations).toArray();
        long done = System.currentTimeMillis();

        System.out.println("Completed in: " + Duration.of(done -now, ChronoUnit.MILLIS));
        LongSummaryStatistics stats = LongStream.of(timings).summaryStatistics();
        System.out.println(stats);

        LongStream.of(timings).forEach(timing -> pr.format("%d,%n",timing));
        pr.flush();
        pr.close();


    }

    private static Long timing(String attribute, Integer peopleCount) {
        long now = System.currentTimeMillis();
        new GridDynamics(peopleCount).getResults(attribute);
        return System.currentTimeMillis() - now;
    }

    public GridDynamics(int peopleCount) {
        report = Stream.generate(Person::new).limit(peopleCount).map(Person::getProperties).map(Map::entrySet)
                .flatMap(Collection::stream).filter(Map.Entry::getValue).collect(groupingBy(Map.Entry::getKey, counting()));
    }

    public Long getResults(String attribute) {
        return report.getOrDefault(attribute,0L);
    }


    @AllArgsConstructor
    @Getter
    @EqualsAndHashCode
    @ToString
    private static class Person {

        private static final Random r = new Random(1);

        private Map<String,Boolean> properties;
        private Long id = Math.abs(r.nextLong());

        public Person() {

            this.properties = Stream.of("single","married", "divorced",
                    "male", "female",
                    "have_a_sports_car", "have_a_compact_car", "have_a_truck", "have_a_pickup",
                    "state_NY", "state_WI","state_MI", "etc",
                    "age_18-25", "age_25-30", "age_30-40", "age_40+").collect(toMap(identity(), v -> r.nextBoolean()));
        }
    }

}
