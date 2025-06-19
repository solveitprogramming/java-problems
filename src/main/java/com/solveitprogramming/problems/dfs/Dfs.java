package com.solveitprogramming.problems.dfs;

import com.solveitprogramming.problems.graph.GraphWithNote;
import com.solveitprogramming.problems.graph.Note;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Dfs {

    public static void main(String[] args) {
        GraphWithNote<Integer> graphWithNote = createGraph();
        graphWithNote.printGraph();
        graphWithNote.showGraph();
        dfs(graphWithNote);
        System.out.println();
        graphWithNote.changeRoot(7);
        graphWithNote.showGraph();
        dfs(graphWithNote);
    }

    private static GraphWithNote<Integer> createGraph() {
        GraphWithNote<Integer> graphWithNote = new GraphWithNote<>(0, true);
        graphWithNote.addNote(0, 1);
        graphWithNote.addNote(0, 2);
        graphWithNote.addNote(0, 4);
        graphWithNote.addNote(1, 3);
        graphWithNote.addNote(1, 5);
        graphWithNote.addNote(1, 6);
        graphWithNote.addNote(2, 4);
        graphWithNote.addNote(2, 6);
        graphWithNote.addNote(4, 6);
        graphWithNote.addNote(5, 6);
        graphWithNote.addNote(5, 7);
        return graphWithNote;
    }

    private static void dfs(GraphWithNote<Integer> graphWithNote) {
        Set<Integer> visited = new HashSet<>();
        Stack<Note<Integer>> stack = new Stack<>();
        Note<Integer> root = graphWithNote.getRoot();
        System.out.print(root.getValue() + ", ");
        stack.push(root);
        visited.add(root.getValue());
        while (!stack.isEmpty()) {
            Note<Integer> note = stack.peek();
            Set<Note<Integer>> notes = note.getNotes();
            boolean pushValue = false;
            for (Note<Integer> n : notes) {
                if (!visited.contains(n.getValue())) {
                    stack.push(n);
                    visited.add(n.getValue());
                    System.out.print(n.getValue() + ", ");
                    pushValue = true;
                    break;
                }
            }
            if (!pushValue) {
                stack.pop();
            }
        }
    }

}
