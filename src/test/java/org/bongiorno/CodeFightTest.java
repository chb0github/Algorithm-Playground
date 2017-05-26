package org.bongiorno;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Stream.*;
import static org.junit.Assert.*;

/**
 * Created by cbongiorno on 4/3/17.
 */
public class CodeFightTest {

    @Test
    public void testCenturyFromYear() throws Exception {
        assertEquals(20, new CodeFight().centuryFromYear(1905));
    }

    @Test
    public void testPalindrome() throws Exception {
        assertTrue(CodeFight.checkPalindrome("aabaa"));
        assertFalse(CodeFight.checkPalindrome("abac"));
        assertTrue(CodeFight.checkPalindrome("a"));
    }

    @Test
    public void testThing() throws Exception {
        int[] inputArray = {3, 6, -2, -5, 7, 3};
        assertEquals(21, CodeFight.adjacentElementsProduct(inputArray));
    }


    @Test
    public void thing() throws Exception {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(5);
        queue.add(3);
        queue.add(7);

        queue.forEach(System.out::println);
        queue.forEach(System.out::println);
    }


    @Test
    public void name() throws Exception {
        Map<String, List<SomeThing>> collect = generate(SomeThing::new).limit(100).collect(Collectors.groupingBy(SomeThing::getId));
        System.out.println(collect);

    }

    private Map<String,SomeThing> index(Iterable<SomeThing> input) {
        Map<String,SomeThing> result = new HashMap<>();

        for (SomeThing someThing : input) {
            result.put(someThing.getId(),someThing);
        }

        return result;
    }

private static final String[] names = {"Christian","Ty Satrang","Joe"};
    private static Random rng = new Random();

    private static class SomeThing {

        private String id = names[rng.nextInt(names.length)];

        public String getId() {
            return id;
        }
    }

}
