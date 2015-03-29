package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Embark implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Embark() {
        singles.add("ARC");
        singles.add("ARK");
        singles.add("BARCH");
        singles.add("BARKE");
        singles.add("BARQUE");
        singles.add("CLARK");
        singles.add("DARK");
        singles.add("HARC");
        singles.add("HARK");
        singles.add("KARCH");
        singles.add("LARK");
        singles.add("MARC");
        singles.add("MARK");
        singles.add("MARQUE");
        singles.add("NARC");
        singles.add("PARC");
        singles.add("PARK");
        singles.add("QUARK");
        singles.add("SARK");
        singles.add("SHARK");
        singles.add("SPARC");
        singles.add("SPARK");
        singles.add("STARK");
        singles.add("BARK");

        doubles.add("DEMARK");
        doubles.add("PREMARK");
        doubles.add("REMARK");
        doubles.add("TRANSPARK");
        doubles.add("DISEMBARK");
        doubles.add("INTERMARK");
        doubles.add("TRADEMARK");

        singles.add("BERK");
        singles.add("BIRK");
        singles.add("BURK");
        singles.add("BURKE");
        singles.add("CIRQUE");
        singles.add("CLERK");
        singles.add("CORK");
        singles.add("DIRK");
        singles.add("ERK");
        singles.add("FORK");
        singles.add("IRK");
        singles.add("JERK");
        singles.add("KIRK");
        singles.add("LURK");
        singles.add("MERC");
        singles.add("MERK");
        singles.add("MURK");
        singles.add("PERK");
        singles.add("PORK");
        singles.add("QUIRK");
        singles.add("SHIRK");
        singles.add("SMIRK");
        singles.add("STORK");
        singles.add("TORQUE");
        singles.add("TURK");
        singles.add("WORK");
        singles.add("YORK");
        
        doubles.add("BERSERK");
        doubles.add("REWORK");
        doubles.add("UNCORK");
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

    @Override
    public ArrayList<String> getSextupleSyllables() {
        return sextuples;
    }

}
