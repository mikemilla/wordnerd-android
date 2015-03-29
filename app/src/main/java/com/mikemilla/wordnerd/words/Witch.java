package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Witch implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Witch() {
        singles.add("BITCH");
        singles.add("BLITCH");
        singles.add("BRITSCH");
        singles.add("DITCH");
        singles.add("FICHE");
        singles.add("FITCH");
        singles.add("FLITCH");
        singles.add("FRITCH");
        singles.add("FRITSCH");
        singles.add("FRITSCHE");
        singles.add("FRITZSCHE");
        singles.add("GLITCH");
        singles.add("HITCH");
        singles.add("ICH");
        singles.add("ITCH");
        singles.add("KITCH");
        singles.add("KITSCH");
        singles.add("KLICH");
        singles.add("KRYCH");
        singles.add("LICH");
        singles.add("MICH");
        singles.add("MITCH");
        singles.add("MITSCH");
        singles.add("NICHE");
        singles.add("NITSCH");
        singles.add("NITSCHE");
        singles.add("NYCZ");
        singles.add("PICHE");
        singles.add("PITCH");
        singles.add("PITSCH");
        singles.add("RICH");
        singles.add("RITCH");
        singles.add("SNITCH");
        singles.add("STICH");
        singles.add("STITCH");
        singles.add("SWITCH");
        singles.add("TRICHE");
        singles.add("TRITCH");
        singles.add("TRITSCH");
        singles.add("TWITCH");
        singles.add("WHICH");
        singles.add("WICH");
        singles.add("ZICH");
        
        doubles.add("UNHITCH");
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
