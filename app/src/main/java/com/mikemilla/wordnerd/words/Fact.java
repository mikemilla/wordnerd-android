package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Fact implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Fact() {
        singles.add("ACT");
        singles.add("BACKED");
        singles.add("BLACKED");
        singles.add("BRACHT");
        singles.add("BRACT");
        singles.add("CRACKED");
        singles.add("HACKED");
        singles.add("JACKED");
        singles.add("KRACHT");
        singles.add("LACKED");
        singles.add("PACKED");
        singles.add("PACT");
        singles.add("PRACHT");
        singles.add("RACKED");
        singles.add("SACKED");
        singles.add("SCHACHT");
        singles.add("SLACKED");
        singles.add("SMACKED");
        singles.add("SNACKED");
        singles.add("STACKED");
        singles.add("STACTE");
        singles.add("TACKED");
        singles.add("TACT");
        singles.add("TRACHT");
        singles.add("TRACKED");
        singles.add("TRACT");
        singles.add("WHACKED");
        singles.add("WRACKED");
        
        doubles.add("ABSTRACT");
        doubles.add("ATTACKED");
        doubles.add("ATTRACT");
        doubles.add("COMPACT");
        doubles.add("CONTRACT");
        doubles.add("DETRACT");
        doubles.add("DIFFRACT");
        doubles.add("DISTRACT");
        doubles.add("ENACT");
        doubles.add("EXACT");
        doubles.add("EXTRACT");
        doubles.add("IMPACT");
        doubles.add("INTACT");
        doubles.add("MEDFACT");
        doubles.add("PROTRACT");
        doubles.add("REACT");
        doubles.add("REDACT");
        doubles.add("REPACKED");
        doubles.add("RETRACT");
        doubles.add("SUBTRACT");
        doubles.add("TRANSACT");
        doubles.add("UNPACKED");
        
        triples.add("INEXACT");
        triples.add("INTERACT");
        triples.add("REENACT");
        
        quadruples.add("COUNTERATTACKED");
        quadruples.add("OVERREACT");
        
        singles.add("ABT");
        singles.add("APT");
        singles.add("CAPPED");
        singles.add("CLAPPED");
        singles.add("FLAPPED");
        singles.add("LAPPED");
        singles.add("MAPPED");
        singles.add("NAPPED");
        singles.add("RAPPED");
        singles.add("RAPT");
        singles.add("SAPPED");
        singles.add("SLAPPED");
        singles.add("SNAPPED");
        singles.add("STRAPPED");
        singles.add("TAPPED");
        singles.add("TRAPPED");
        singles.add("WRAPPED");
        
        doubles.add("ADAPT");
        doubles.add("COMPACT");
        doubles.add("CONTRACT");
        doubles.add("EXTRACT");
        doubles.add("UNTAPPED");
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
