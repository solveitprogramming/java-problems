package com.solveitprogramming.problems;

import java.util.HashMap;
import java.util.Map;

public class Testing {


    public static void main(String[] args) {
        Map<String, Boolean> map = new HashMap<>();
        map.put("A", Boolean.TRUE);
        map.put("B", Boolean.TRUE);
        map.put("C", Boolean.TRUE);
        map.put("D", Boolean.TRUE);

        System.out.println(map.values().stream().reduce(false, (entry1, entry2) ->
            !entry1 || !entry2
        ));
    }
}
