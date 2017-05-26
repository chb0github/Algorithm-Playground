package org.bongiorno;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.junit.Test;

import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collector;
import java.util.stream.Stream;

import static java.lang.System.out;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

public class GridDynamicsTest {

    @Test
    public void testCase() throws Exception {


    }

    private Integer highestN(int[] nums, int n) {
        return Arrays.stream(nums).boxed().map(i -> new OnlyNSet(i,n)).reduce(OnlyNSet::merge).map(l -> l.get(n)).orElse(null);
    }


    private static class OnlyNSet extends ArrayList<Integer> {

        private final int max;

        public OnlyNSet(Integer init, int max) {
            super(Collections.singleton(init));
            this.max = max;
        }

        @Override
        public boolean add(Integer integer) {
            boolean result = super.add(integer);
            if (this.size() > max)
                this.remove(this.get(0));
            Collections.sort(this);
            return result;
        }

        public OnlyNSet merge(Collection<Integer> other) {
            other.stream().forEach(this::add);
            return this;
        }
    }
    /*
    The goal of the task is to implement a solution which counts the number of people with given set of attributes and provides statistics on each of the given attributes.

Requirements:
- we have a group of people, each person has a unique ID (int or long) and a set of custom boolean attributes (we have a limit for the number of attributes per person which is let's say 500)

- we want to quickly filter our data set of people and count the number of people which have given attributes set. However, the result should not be a single number because we want to have the total number of people who satisfy the criteria but also results per age, as follows:
   - total 200
   - age_18-25 10
   - age_25_30 20
   - age_30_40 50
   - age_40+ 120

- should be implemented in Java
- run some performance benchmarks and explain them, explain how this solution can scale(vertically or horizontally - your preference), what  do we have to do to make it run 2x faster, is there any difference if we ask for 2 or 200 attributes?

Example query:
We want to calculate how many people are single males, how many people have a sports car, how many people live in a state of New York etc - that means that we have the following sample attributes:
- single,married, divorced
- male, female
- have_a_sports_car, have_a_compact_car, have_a_truck, have_a_pickup
- state_NY, state_WI,state_MI, etc
- age_18-25, age_25-30, age_30-40, age_40+
     */
}
