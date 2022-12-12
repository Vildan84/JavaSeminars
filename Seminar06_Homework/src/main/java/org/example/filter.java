package org.example;

import java.util.Comparator;
import java.util.HashSet;
import java.util.stream.Stream;

public class filter {

    public static void filterByRam(HashSet<NoteBook> note, int ram) {
        Stream<NoteBook> str = note.stream();
        str.filter(n->n.getRam()>=ram).sorted(Comparator.comparingInt(NoteBook::getRam)).forEach(NoteBook::info);
    }

    public static void filterByRom(HashSet<NoteBook> note, int rom) {
        Stream<NoteBook> str = note.stream();
        str.filter(n->n.getRom()>=rom).sorted(Comparator.comparingInt(NoteBook::getRom)).forEach(NoteBook::info);
    }

    public static void filterByOS(HashSet<NoteBook> note, String os) {
        Stream<NoteBook> str = note.stream();
        str.filter(n->n.getOS().equals(os)).forEach(NoteBook::info);
    }

    public static void filterByBrand(HashSet<NoteBook> note, String br) {
        Stream<NoteBook> str = note.stream();
        str.filter(n->n.getBrand().equals(br)).forEach(NoteBook::info);
    }

}
