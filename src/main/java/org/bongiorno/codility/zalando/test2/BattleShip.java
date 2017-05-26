package org.bongiorno.codility.zalando.test2;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

/**
 * Created by cbongiorno on 1/29/17.
 */
public class BattleShip {

    public String solution(int mapSize, String tlBr, String hits) {
        List<Boat> boats = stream(tlBr.split(",")).map(s -> s.split(" ")).map(pos -> new Boat(pos[0], pos[1])).collect(toList());

        stream(hits.split(" ")).forEach(p -> boats.stream().forEach(b -> b.incoming(p)));
        Set<Boat> wereHit = boats.stream().filter(Boat::wasHit).collect(toSet());
        Set<Boat> wereSunk = boats.stream().filter(Boat::sunk).collect(toSet());
        wereHit.removeAll(wereSunk);

        return String.format("%d,%d", wereSunk.size(), wereHit.size());

    }

    private static class Boat {

        private static Random idGen = new Random();
        private final int id;

        private Map<String, Boolean> positions = new HashMap<>();

        private static final Pattern p = Pattern.compile(("([1-9]+)([A-Z])"));


        public Boat(String tl, String br) {
            this.id = idGen.nextInt(Integer.MAX_VALUE);
            Matcher tlMatcher = p.matcher(tl);
            Matcher brMatcher = p.matcher(br);

            if (!tlMatcher.matches() || !brMatcher.matches())
                throw new IllegalArgumentException("Bad positional pattern");

            int tlRow = Integer.parseInt(tlMatcher.group(1));
            int tlColumn = tlMatcher.group(2).charAt(0);

            int brRow = Integer.parseInt(brMatcher.group(1));
            int brColumn = brMatcher.group(2).charAt(0);

            int columnRange = brColumn - tlColumn;
            int rowRange = brRow - tlRow;

            StickyId<Integer> rowSupplier = new StickyId<>(0,rowRange,(i -> i+ 1));
            StickyId<Integer> columnSuplier = new StickyId<>(0,columnRange, c -> c + 1);


            this.positions = IntStream.rangeClosed(0, Math.max(rowRange, columnRange)).mapToObj(i -> String.format("%d%d", rowSupplier.get(), columnSuplier.get())).collect(toMap(Function.identity(), k -> Boolean.FALSE));

            System.out.println();
        }

        public Set<String> getPositions() {
            return positions.keySet();
        }

        public boolean incoming(String position) {
            return positions.containsKey(position) && positions.put(position, Boolean.TRUE) != null;
        }

        public boolean sunk() {
            return positions.values().stream().reduce(Boolean::logicalAnd).orElse(Boolean.FALSE);
        }

        public boolean wasHit() {
            return positions.values().stream().reduce(Boolean::logicalOr).orElse(Boolean.FALSE);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Boat boat = (Boat) o;

            return id == boat.id;

        }

        @Override
        public int hashCode() {
            return id;
        }
    }

    private static class StickyId<T extends Comparable<T>> implements Supplier<T> {
        private T start;
        private T current;
        private T max;
        private UnaryOperator<T> next;

        public StickyId(T start, T max, UnaryOperator<T> next) {
            this.max = max;
            this.next = next;
            this.start  = start;
            T potential = next.apply(start);
            if(potential.compareTo(max) <= 0)
                current = potential;
        }

        @Override
        public T get() {
            T potential = this.next.apply(current);
            return potential.compareTo(current) <= 0 ? potential : current;
        }
    }
}
