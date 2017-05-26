
package org.bongiorno.codility.zalando.test1;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toCollection;

/**
 * Created by cbongiorno on 1/29/17.
 */
public class Zalando1 {

    public int solution(int[] peopleWeights, int[] peopleFloors, int maxFloors, int maxCapacity, int maxWeight) {
        if(peopleFloors.length != peopleWeights.length)
            throw new IllegalArgumentException("invalid input");

        Elevator elevator = new Elevator(maxFloors,maxWeight,maxCapacity);

        Queue<Person> people = IntStream.range(0,peopleFloors.length).mapToObj(i -> new Person(peopleWeights[i],peopleFloors[i])).collect(toCollection(LinkedList::new));

//        int foo = generate(people::remove).limit(people.size()).filter(elevator::add).map(b -> elevator.run()).reduce(Integer::sum).orElse(0);

        int count = 0;
        for(Person p = people.peek(); p != null; p = people.peek()) {
            if(!elevator.add(p)) {
                count += elevator.run();
            }
            else {
                people.remove(); // he got on the elevator and out of the queue
            }
        }

        // write your code in Java SE 8
        return count + elevator.run();
    }

    private static class Person{
        int weight;
        int floor;

        public Person(int weight, int floor) {
            this.weight = weight;
            this.floor = floor;
        }
    }

    private static class Elevator {
        private int maxFloors;
        private int maxWeight;
        private int currentWeight = 0;
        private int maxCapacity;
        private int currentCapacity = 0;
        private Map<Integer,Collection<Person>> people = new TreeMap<>();

        public Elevator(int maxFloors, int maxWeight, int maxCapacity) {
            if(maxCapacity <= 0 || maxFloors <= 0 || maxWeight <= 0)
                throw new IllegalArgumentException("Elevator is out of service");

            this.maxFloors = maxFloors;
            this.maxWeight = maxWeight;
            this.maxCapacity = maxCapacity;

        }

        public boolean add(Person person) {
            if(person.floor > maxFloors)
                throw new IllegalArgumentException("You're in the wrong building, pal!");

            if((currentWeight + person.weight) <= maxWeight && (currentCapacity + 1) <= maxCapacity) {
                people.computeIfAbsent(person.floor,k -> new LinkedList<>()).add(person);
                currentWeight += person.weight;
                currentCapacity++;
                return true;
            }
            return false;
        }

        public int run() {
            int result = people.size() > 0 ? people.size() + 1 : 0;
            currentCapacity = 0;
            currentWeight = 0;
            people.clear();
            return result;
        }
    }
}
