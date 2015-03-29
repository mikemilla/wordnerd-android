package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Hanger implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Hanger() {
        doubles.add("CLANGER");
        doubles.add("CLANGOR");
        doubles.add("BANGER");
        doubles.add("FANGER");
        doubles.add("GANGER");
        doubles.add("DANGER");
        doubles.add("HANGAR");
        doubles.add("LANGER");
        doubles.add("SANGER");
        doubles.add("SCHLANGER");
        doubles.add("SPRANGER");
        doubles.add("STANGER");
        doubles.add("TANGER");
        doubles.add("WANGER");
        doubles.add("ZANGER");
        doubles.add("ANCHOR");
        doubles.add("AMOR");
        doubles.add("ANCHOR");
        doubles.add("ANGER");
        doubles.add("ANGLER");
        doubles.add("ANSWER");
        doubles.add("BADDER");
        doubles.add("BAGGER");
        doubles.add("BANGERS");
        doubles.add("BANGOR");
        doubles.add("BANKER");
        doubles.add("BANNER");
        doubles.add("BANTER");
        doubles.add("CANKER");
        doubles.add("CLAMOR");
        doubles.add("CRAMMER");
        doubles.add("DAGGER");
        doubles.add("DANCER");
        doubles.add("GANGSTER");
        doubles.add("GLAMOR");
        doubles.add("GLAMOUR");
        doubles.add("GRAMMAR");
        doubles.add("HAGNER");
        doubles.add("HAMMER");
        doubles.add("HAMPER");
        doubles.add("HANDER");
        doubles.add("HANKER");
        doubles.add("JAMMER");
        doubles.add("LADDER");
        doubles.add("MADDER");
        doubles.add("MANNER");
        doubles.add("MANOR");
        doubles.add("PLANNER");
        doubles.add("RAMMER");
        doubles.add("SCANNER");
        doubles.add("SLAMMER");
        doubles.add("SLANDER");
        doubles.add("SPANNER");
        doubles.add("STAGGER");
        doubles.add("STAMMER");
        doubles.add("STRANGLER");
        doubles.add("STRANGER");
        doubles.add("SWAGGER");
        doubles.add("TANKER");
        doubles.add("TANNER");

        triples.add("DISCLAIMER");
        triples.add("RECLAIMER");
        triples.add("CLIFFHANGER");
        triples.add("HEADBANGER");

        quadruples.add("DOPPELGANGER");
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
