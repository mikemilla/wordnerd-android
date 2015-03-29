package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Goat implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Goat() {
        singles.add("BLOAT");
        singles.add("BOAT");
        singles.add("CHOAT");
        singles.add("CHOATE");
        singles.add("COAT");
        singles.add("COTE");
        singles.add("DOTE");
        singles.add("FLOAT");
        singles.add("GLOAT");
        singles.add("GROAT");
        singles.add("GROTE");
        singles.add("HAUTE");
        singles.add("HOTE");
        singles.add("KOTE");
        singles.add("MOAT");
        singles.add("MOTE");
        singles.add("NOTE");
        singles.add("OAT");
        singles.add("POTE");
        singles.add("QUOTE");
        singles.add("QUOTE");
        singles.add("ROAT");
        singles.add("ROTE");
        singles.add("SCHAUT");
        singles.add("SHOAT");
        singles.add("SLOAT");
        singles.add("SLOATE");
        singles.add("SMOTE");
        singles.add("SPROAT");
        singles.add("STOAT");
        singles.add("THROAT");
        singles.add("TOTE");
        singles.add("VOGT");
        singles.add("VOTE");
        singles.add("WROTE");

        doubles.add("AFLOAT");
        doubles.add("BACOTE");
        doubles.add("BANXQUOTE");
        doubles.add("CAPOTE");
        doubles.add("CHIPOTE");
        doubles.add("CONNOTE");
        doubles.add("DEMOTE");
        doubles.add("DENOTE");
        doubles.add("DEVOTE");
        doubles.add("DUCOTE");
        doubles.add("HINOTE");
        doubles.add("MISQUOTE");
        doubles.add("OUTVOTE");
        doubles.add("PROMOTE");
        doubles.add("REMOTE");
        doubles.add("REWROTE");
        doubles.add("UNCOAT");
        doubles.add("UNQUOTE");
        doubles.add("VANNOTE");
        
        triples.add("UNDERWROTE");
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
