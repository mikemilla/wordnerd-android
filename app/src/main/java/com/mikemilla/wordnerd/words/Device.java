package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Device implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Device() {
        singles.add("BICE");
        singles.add("BRICE");
        singles.add("BRYCE");
        singles.add("BUYSSE");
        singles.add("DEISS");
        singles.add("DICE");
        singles.add("DISE");
        singles.add("DYCE");
        singles.add("FEIS");
        singles.add("FLEISS");
        singles.add("GEISE");
        singles.add("GEISS");
        singles.add("GNEISS");
        singles.add("GRICE");
        singles.add("GUICE");
        singles.add("HEISE");
        singles.add("HEISS");
        singles.add("HICE");
        singles.add("ICE");
        singles.add("KIES");
        singles.add("KLEISS");
        singles.add("KREISS");
        singles.add("LEISS");
        singles.add("LICE");
        singles.add("MEISS");
        singles.add("MICE");
        singles.add("NICE");
        singles.add("NYCE");
        singles.add("PREISS");
        singles.add("PRICE");
        singles.add("PRYCE");
        singles.add("REISS");
        singles.add("RICE");
        singles.add("SCHWEISS");
        singles.add("SLICE");
        singles.add("SPICE");
        singles.add("SPLICE");
        singles.add("STICE");
        singles.add("THEISS");
        singles.add("THRICE");
        singles.add("TICE");
        singles.add("TRICE");
        singles.add("TWICE");
        singles.add("TYCE");
        singles.add("VICE");
        singles.add("VISE");
        singles.add("WEIS");
        singles.add("WEISS");
        singles.add("WICE");
        singles.add("WRICE");
        singles.add("ZEISS");
        
        doubles.add("ADVICE");
        doubles.add("BERNEICE");
        doubles.add("CONCISE");
        doubles.add("DEVISE");
        doubles.add("DEWEISS");
        doubles.add("ENTICE");
        doubles.add("EXCISE");
        doubles.add("MATTEIS");
        doubles.add("MISPRICE");
        doubles.add("PRECISE");
        doubles.add("REPRICE");
        doubles.add("SUFFICE");
        
        triples.add("OVERPRICE");
        
        singles.add("BITES");
        singles.add("CITES");
        singles.add("HEIGHTS");
        singles.add("KNIGHTS");
        singles.add("LIGHTS");
        singles.add("MITES");
        singles.add("NIGHTS");
        singles.add("RIGHTS");
        singles.add("SIGHTS");
        singles.add("SITES");
        singles.add("TIGHTS");
        singles.add("WHITES");
        
        doubles.add("ADVISE");
        doubles.add("CRISIS");
        doubles.add("CYPHER");
        doubles.add("DECIDE");
        doubles.add("DELIGHT");
        doubles.add("DEMISE");
        doubles.add("DESIGN");
        doubles.add("DEVISE");
        doubles.add("DISGUISE");
        doubles.add("DIVIDE");
        doubles.add("DIVINE");
        doubles.add("ITEM");
        doubles.add("NICEST");
        doubles.add("PRESCRIBED");
        doubles.add("SURPRISE");
        doubles.add("SURVIVE");
        doubles.add("TONIGHT");
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
