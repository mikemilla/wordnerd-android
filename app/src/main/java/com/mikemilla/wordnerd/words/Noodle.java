package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Noodle implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Noodle() {
        doubles.add("STRUDEL");
        doubles.add("BOODLE");
        doubles.add("CRUDELE");
        doubles.add("DOODLE");
        doubles.add("FEUDAL");
        doubles.add("OODLE");
        doubles.add("POODLE");
        doubles.add("RUDEL");
        doubles.add("SUDOL");
        doubles.add("TRUDEL");
        doubles.add("UDALL");
        
        triples.add("CABOODLE");
        triples.add("APPROVAL");
        triples.add("QUADRUPLE");
        triples.add("REFUSAL");
        triples.add("REMOVAL");
        
        doubles.add("BOOTLE");
        doubles.add("BRUTAL");
        doubles.add("BUCCAL");
        doubles.add("BUGLE");
        doubles.add("BUTYL");
        doubles.add("CRUCIAL");
        doubles.add("CRUEL");
        doubles.add("DUCAL");
        doubles.add("DUPLE");
        doubles.add("FOOZLE");
        doubles.add("FRUGAL");
        doubles.add("FUTILE");
        doubles.add("GOOGLE");
        doubles.add("GOOGOL");
        doubles.add("GRUESOME");
        doubles.add("JEWEL");
        doubles.add("JUDO");
        doubles.add("KUGEL");
        doubles.add("NEUTRAL");
        doubles.add("POODLES");
        doubles.add("POOTLE");
        doubles.add("PUPIL");
        doubles.add("ROUBLE");
        doubles.add("RUBLE");
        doubles.add("RUEFUL");
        doubles.add("RUMEN");
        doubles.add("SCRUPLE");
        doubles.add("STUDENT");
        doubles.add("STUPID");
        doubles.add("TOOTLE");
        doubles.add("TUBAL");
        doubles.add("TUNA");
        doubles.add("UNIT");
        doubles.add("USEFUL");
        doubles.add("VOODOO");
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
