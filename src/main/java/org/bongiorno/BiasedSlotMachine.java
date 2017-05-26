package org.bongiorno;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;

public class BiasedSlotMachine {


    private static Random rng = new Random();


    private double skew;

    public BiasedSlotMachine(float skew) {
        this.skew = skew;
    }

    public Integer[] spin() {
        int item1 = 1 + rng.nextInt(15);

        double item2 = item1 + (rng.nextGaussian() * (skew / 32.5d));
        double item3 = item1 + (rng.nextGaussian() * (skew / 32.5d));
        return new Integer[] {item1,(int)Math.floor(item2),(int)Math.floor(item3)};
    }

    public static void main(String[] args) {

        BiasedSlotMachine slotMachine = new BiasedSlotMachine(.1f);
        // 3 -> 300
        // 2 -> 299
        // 1 -> 330
        long wins = Stream.generate(slotMachine::spin).limit(10000).filter(nums -> (nums[0] == nums[1]) && (nums[1] == nums[2])).count();
//        Map<Integer,Long> count = Stream.generate(slotMachine::spin).limit(10000).flatMap(Stream::of).collect(Collectors.groupingBy(Function.identity(), counting()));
        Stream.generate(slotMachine::spin).limit(10000).map(Arrays::toString).forEach(System.out::println);
        // 1.02, .98
//        return count.values().stream().map(Long::floatValue).anyMatch((l1,l2) -> Math.abs(1 - l1/l2) >= .1);
        System.out.println(wins);



    }

}