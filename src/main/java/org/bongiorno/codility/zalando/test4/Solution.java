package org.bongiorno.codility.zalando.test4;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;
import java.util.stream.Stream;


public class Solution {

    private static final Map<String, BiFunction<Stack<Integer>, String, Integer>> commands = new HashMap<>();
    private static int max = (int) (Math.pow(2, 20) - 1);

    static {
        commands.put("+", (s, a) -> s.push(s.pop() + s.pop()));
        commands.put("-", (s, a) -> s.size() < 2 ? -1 : Stream.of(s.pop(), s.pop()).reduce(Math::subtractExact).filter(i -> i > 0).map(s::push).orElse(-1));
        commands.put("DUP", (s, a) -> s.push(s.peek()));
        commands.put("POP", (s, a) -> s.pop());
        commands.put("+", (s, a) -> s.push(s.pop() + s.pop()));
        commands.put("NUMERIC", (s, a) -> {
            Integer value = Integer.parseInt(a);
            return value > max || value < 0 ? -1 : s.push(value);
        });
    }

    public int solution(String input) {
        Stack<Integer> stack = new Stack<>();
        for (String token : input.split(" ")) {
            BiFunction<Stack<Integer>, String, Integer> f = token.matches("[0-9]+") ? commands.get("NUMERIC") : commands.get(token);

            if (f == null)
                throw new IllegalArgumentException(token);

            Integer application = f.apply(stack, token);
            if (application == -1)
                return -1;

        }

        return stack.isEmpty() ? -1 : stack.peek();
    }

}
