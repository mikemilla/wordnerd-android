package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Down implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Down() {
        singles.add("BROWN");
        singles.add("CLOWN");
        singles.add("CROWN");
        singles.add("DOWNE");
        singles.add("DROWN");
        singles.add("FROWN");
        singles.add("GOWN");
        singles.add("LOWN");
        singles.add("NOUN");
        singles.add("SHOUN");
        singles.add("TOWN");

        doubles.add("AROUND");
        doubles.add("DOWNTOWN");
        doubles.add("FACEDOWN");
        doubles.add("MCCOUN");
        doubles.add("MCCOWN");
        doubles.add("MCGOWN");
        doubles.add("MCQUOWN");
        doubles.add("RENOWN");
        doubles.add("UPTOWN");
        doubles.add("PRONOUN");

        triples.add("ABBOTSTOWN");
        triples.add("ABBOTTSTOWN");

        singles.add("BOUND");
        singles.add("GROUND");
        singles.add("HOUND");
        singles.add("MOUND");
        singles.add("POUND");
        singles.add("ROUND");
        singles.add("SOUND");
        singles.add("WOUND");
        singles.add("FOUND");

        doubles.add("ABOUND");
        doubles.add("AGROUND");
        doubles.add("AROUND");
        doubles.add("ASTOUND");
        doubles.add("COMPOUND");
        doubles.add("CONFOUND");
        doubles.add("EXPOUND");
        doubles.add("IMPOUND");
        doubles.add("INBOUND");
        doubles.add("NEWFOUND");
        doubles.add("PROFOUND");
        doubles.add("PROPOUND");
        doubles.add("REBOUND");
        doubles.add("REDOUND");
        doubles.add("RENOWNED");
        doubles.add("RESOUND");
        doubles.add("SURROUND");
        doubles.add("UNBOUND");
        doubles.add("UNSOUND");
        doubles.add("UNWOUND");
        doubles.add("COMPOUND");
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
