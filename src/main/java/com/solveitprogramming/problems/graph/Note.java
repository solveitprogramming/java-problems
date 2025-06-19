package com.solveitprogramming.problems.graph;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Note<T> {

    private T value;
    private Set<Note<T>> notes;

    public Note(T value, Note<T> note) {
        this.value = value;
        this.notes = new HashSet<>();
        this.notes.add(note);
    }

    public Note(T value) {
        this.value = value;
        this.notes = new HashSet<>();
    }

    public void addNote(Note<T> note) {
        if (!notes.contains(note)) {
            this.notes.add(note);
        }
    }

    public void addNote(T note) {
        addNote(new Note<>(note));
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Note<?> note)) {
            return false;
        }
        return value.equals(note.value);
    }
}
