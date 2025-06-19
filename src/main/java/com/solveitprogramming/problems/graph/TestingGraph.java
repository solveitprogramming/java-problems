package com.solveitprogramming.problems.graph;

public class TestingGraph {

    public static void main(String[] args) {
        Graph graph = new Graph(true);

        graph.addEdge("1", "2");
        graph.addEdge("1", "3");
        graph.addEdge("1", "4");
        graph.addEdge("2", "3");
        graph.addEdge("2", "5");
        graph.addEdge("4", "6");
        graph.addEdge("5", "6");

        graph.printGraph();

    }

}
