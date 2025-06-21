package com.solveitprogramming.problems.dfs;

import com.solveitprogramming.problems.graph.Graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DfsGraph {

    public static void main(String[] args) {
        Graph graph = new Graph(true);

        graph.addEdge("1", "2");
        graph.addEdge("1", "3");
        graph.addEdge("1", "5");

        graph.addEdge("2", "6");

        graph.addEdge("3", "8");
        graph.addEdge("3", "9");


        graph.addEdge("4", "6");

        graph.addEdge("5", "7");

        graph.addEdge("6", "7");

        graph.addEdge("7", "9");

        graph.printGraph();
        printDfs(graph, "1");

    }

    public static void printDfs(Graph graph, String startingVertex) {

        Stack<String> stack = new Stack<>();
        Set<String> visited = new HashSet<>();
        stack.push(startingVertex);
        visited.add(startingVertex);
        System.out.print(startingVertex + " ");

        while (!stack.isEmpty()) {
            String currentVertex = stack.peek();
            Set<String> edges = graph.getEdges(currentVertex);
            for (String edge : edges) {
                if (!visited.contains(edge)) {
                    stack.push(edge);
                    visited.add(edge);
                    System.out.print(edge + " ");
                    break;
                }
            }

            if (visited.size() == graph.numberOfVertices()) {
                break;
            }
            if (stack.peek().equals(currentVertex)) {
                stack.pop();
            }
        }

    }
}
