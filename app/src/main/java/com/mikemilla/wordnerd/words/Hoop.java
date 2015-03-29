package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Hoop implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Hoop() {
        singles.add("BOOP");
        singles.add("COOP");
        singles.add("COUPE");
        singles.add("CROUP");
        singles.add("DOUPE");
        singles.add("DROOP");
        singles.add("DRUPE");
        singles.add("DUPE");
        singles.add("GOOP");
        singles.add("GROUP");
        singles.add("GRUPE");
        singles.add("HOUP");
        singles.add("HUPE");
        singles.add("KNOOP");
        singles.add("KOOP");
        singles.add("LOOP");
        singles.add("LOUP");
        singles.add("LUPE");
        singles.add("POOP");
        singles.add("ROOP");
        singles.add("ROUPE");
        singles.add("RUPE");
        singles.add("SCOOP");
        singles.add("SHOOP");
        singles.add("SHOUP");
        singles.add("SHUPE");
        singles.add("SLOOP");
        singles.add("SNOOP");
        singles.add("SOUP");
        singles.add("STOOP");
        singles.add("STOUP");
        singles.add("STROOP");
        singles.add("STROUP");
        singles.add("STUPE");
        singles.add("SWOOP");
        singles.add("THROOP");
        singles.add("TROOP");
        singles.add("TROUP");
        singles.add("WHOOP");
        
        doubles.add("RESCOOP");
        
        triples.add("ALLEYOOP");
        triples.add("GUADALUPE");
        triples.add("INTERGROUP");
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
