package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Pink implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Pink() {
        singles.add("BINK");
        singles.add("BLINK");
        singles.add("BRINK");
        singles.add("CHINK");
        singles.add("CINQ");
        singles.add("CINQUE");
        singles.add("CLINK");
        singles.add("DINK");
        singles.add("DRINK");
        singles.add("FINCK");
        singles.add("FINK");
        singles.add("FLINK");
        singles.add("FRINK");
        singles.add("HINCK");
        singles.add("HINK");
        singles.add("INK");
        singles.add("KLINCK");
        singles.add("KLINK");
        singles.add("KLINKE");
        singles.add("KRINKE");
        singles.add("LINC");
        singles.add("LINK");
        singles.add("LYNK");
        singles.add("MINC");
        singles.add("MINK");
        singles.add("PLINK");
        singles.add("PRINK");
        singles.add("RINCK");
        singles.add("RINK");
        singles.add("SCHINKE");
        singles.add("SCHLINK");
        singles.add("SHRINK");
        singles.add("SINK");
        singles.add("SKINK");
        singles.add("SLINK");
        singles.add("SMINK");
        singles.add("SPINK");
        singles.add("STINK");
        singles.add("SWINK");
        singles.add("SYNC");
        singles.add("THINK");
        singles.add("VINK");
        singles.add("WINK");
        singles.add("ZINC");
        singles.add("ZINK");
        
        doubles.add("RETHINK");
        doubles.add("RELINK");

        triples.add("OVERTHINK");
        triples.add("INTERLINK");
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
