package com.solveitprogramming.problems.graph;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RequiredArgsConstructor
public class Graph {

    private final Map<String, Set<String>> vertexMap = new HashMap<>();

    private final boolean uniDirectional;

    public void addVertex(String vertex) {
        vertexMap.putIfAbsent(vertex, new HashSet<>());
    }

    public void addEdge(String from, String to) {
        addVertex(from);
        addVertex(to);
        vertexMap.get(from).add(to);
        if (uniDirectional) {
            vertexMap.get(to).add(from);
        }
    }

    public void printGraph() {
        vertexMap.forEach((s, strings) -> {
            printVertex(s);
            printEdge(strings);
            System.out.println();
        });
    }

    public boolean existsVertex(String vertex) {
        return vertexMap.containsKey(vertex);
    }

    public Set<String> getEdges(String vertex) {
        return vertexMap.getOrDefault(vertex, new HashSet<>());
    }

    public int numberOfVertices() {
        return vertexMap.size();
    }

    private void printVertex(String vertex) {
        System.out.print("'" + vertex + "' -> ");
    }

    private void printEdge(Set<String> edges) {
        edges.forEach(e -> System.out.print("'" + e + "' "));
    }

}
