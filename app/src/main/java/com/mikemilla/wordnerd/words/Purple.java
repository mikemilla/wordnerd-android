package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Purple implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Purple() {
        doubles.add("BURBLE");
        doubles.add("CARPAL");
        doubles.add("CHORTLE");
        doubles.add("CIRCLE");
        doubles.add("CIRCLES");
        doubles.add("CIRCUS");
        doubles.add("COLONEL");
        doubles.add("CORBEL");
        doubles.add("CURDLE");
        doubles.add("CURTAIN");
        doubles.add("FERTILE");
        doubles.add("FERTLE");
        doubles.add("GARBLE");
        doubles.add("GIRDLE");
        doubles.add("GURGLE");
        doubles.add("HERBAL");
        doubles.add("HURDLE");
        doubles.add("HURTFUL");
        doubles.add("HURTLE");
        doubles.add("JOURNAL");
        doubles.add("KERNEL");
        doubles.add("MARBLE");
        doubles.add("MERTLE");
        doubles.add("MORTAL");
        doubles.add("MYRTLE");
        doubles.add("PERSON");
        doubles.add("PIRKLE");
        doubles.add("PORTAL");
        doubles.add("PURPA");
        doubles.add("PURPLED");
        doubles.add("PURPLES");
        doubles.add("PURPOSE");
        doubles.add("SNORKEL");
        doubles.add("SPARKLE");
        doubles.add("SQUIRREL");
        doubles.add("STARTLE");
        doubles.add("SURFACE");
        doubles.add("SYRUP");
        doubles.add("THERMAL");
        doubles.add("TURTLE");
        doubles.add("URKEL");
        doubles.add("VERBAL");
        doubles.add("WARBLE");
        
        triples.add("COMMERCIAL");
        triples.add("ENCIRCLE");
        triples.add("ETERNAL");
        triples.add("IMMORTAL");
        triples.add("INFERTILE");
        triples.add("INTERNAL");
        triples.add("NOCTURNAL");
        triples.add("NONVERBAL");
        triples.add("PURPLER");
        triples.add("REHEARSAL");
        triples.add("REVERSAL");
        
        quadruples.add("MATRIARCHAL");
        quadruples.add("METACARPAL");
        quadruples.add("PATRIARCHAL");
        quadruples.add("UNIVERSAL");
    }

    public ArrayList<String> getSingleSyllables() {
        return singles;
    }

    public ArrayList<String> getDoubleSyllables() {
        return doubles;
    }

    public ArrayList<String> getTripleSyllables() {
        return triples;
    }

    public ArrayList<String> getQuadrupleSyllables() {
        return quadruples;
    }

    public ArrayList<String> getQuintupleSyllables() {
        return quintuples;
    }

    public ArrayList<String> getSextupleSyllables() {
        return sextuples;
    }
}
