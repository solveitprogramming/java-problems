package com.solveitprogramming.problems.graph;

import lombok.Getter;

import java.util.*;

public class GraphWithNote<T> {

    @Getter
    private Note<T> root;
    private boolean uniDirectional = true;
    private boolean notConnectedGraph = true;

    private Map<T, Note<T>> map = new HashMap<>();

    public GraphWithNote(T root, boolean uniDirectional) {
        this.root = new Note<T>(root);
        this.uniDirectional = uniDirectional;
        map.put(root, this.root);
    }

    public void addNote(T toValue, T newValue) {
        if (notConnectedGraph && !map.containsKey(toValue)) {
            map.put(toValue, new Note<>(newValue));
        }
        if (map.containsKey(toValue)) {
            if (!map.containsKey(newValue)) {
                Note<T> note = new Note<>(newValue);
                map.put(newValue, note);
            }
            Note<T> newNote = map.get(newValue);
            Note<T> toNote = map.get(toValue);
            if (uniDirectional) {
                newNote.addNote(toNote);
            }
            map.get(toValue).addNote(newNote);
        }
    }

    public void changeRoot(T newRoot) {
        if (map.containsKey(newRoot)) {
            root = map.get(newRoot);
        }
    }

    public void printGraph() {
        map.forEach((t, tNote) -> {
            System.out.print("'" + t + "' -> ");
            tNote.getNotes().forEach(v -> System.out.print("'" + v.getValue() + "' "));
            System.out.println();
        });
    }

    public void showGraph() {
        List<StringBuilder> stringBuilders = new ArrayList<>();
        drawFromNode(root, new HashSet<>(), "", false, stringBuilders);
        stringBuilders.forEach(stringBuilder -> {
            stringBuilder.delete(0, 3);
            System.out.println(stringBuilder);
        });
    }

    private void drawFromNode(Note<T> node, Set<T> visited, String prefix, boolean isLast, List<StringBuilder> stringBuilders) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(prefix);
        stringBuilder.append(isLast ? "└── " : "├── ");
        stringBuilder.append(node.getValue());
        stringBuilders.add(stringBuilder);
        visited.add(node.getValue());

        // Filter out visited neighbors to avoid cycles
        List<Note<T>> unvisited = new ArrayList<>();
        for (Note<T> neighbor : node.getNotes()) {
            if (!visited.contains(neighbor.getValue())) {
                unvisited.add(neighbor);
            }
        }

        // Recurse into unvisited neighbors
        for (int i = 0; i < unvisited.size(); i++) {
            boolean last = (i == unvisited.size() - 1);
            drawFromNode(unvisited.get(i), visited, prefix + (isLast ? "    " : "│   "), last, stringBuilders);
        }
    }



}
