package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Mars implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Mars() {
        singles.add("ARES");
        singles.add("BAARS");
        singles.add("BARS");
        singles.add("BARZ");
        singles.add("CARS");
        singles.add("CZARS");
        singles.add("GARS");
        singles.add("JARS");
        singles.add("KAHRS");
        singles.add("LARS");
        singles.add("MARZ");
        singles.add("NARS");
        singles.add("PARS");
        singles.add("SARS");
        singles.add("SCARS");
        singles.add("STARS");
        singles.add("VARS");
        
        doubles.add("BAZAARS");
        doubles.add("CIGARS");
        doubles.add("DINARS");
        doubles.add("GUITARS");
        doubles.add("RENOIRS");
        doubles.add("SITARS");
        doubles.add("TOKARS");
        
        singles.add("AIRS");
        singles.add("BEARS");
        singles.add("BEERS");
        singles.add("BORES");
        singles.add("CARES");
        singles.add("CHAIRS");
        singles.add("CHEERS");
        singles.add("CLEARS");
        singles.add("CORES");
        singles.add("CORPS");
        singles.add("CURES");
        singles.add("DOORS");
        singles.add("DRAWERS");
        singles.add("EARS");
        singles.add("ERS");
        singles.add("FEARS");
        singles.add("GEARS");
        singles.add("HAIRS");
        singles.add("HEIRS");
        singles.add("MARES");
        singles.add("MOORS");
        singles.add("NARES");
        singles.add("OARS");
        singles.add("PAIRS");
        singles.add("PARES");
        singles.add("PEARS");
        singles.add("PEERS");
        singles.add("PIERS");
        singles.add("PORES");
        singles.add("SCORES");
        singles.add("SHARES");
        singles.add("SHEARS");
        singles.add("SHIRES");
        singles.add("SIRES");
        singles.add("SORES");
        singles.add("SPEARS");
        singles.add("SPHERES");
        singles.add("SPIRES");
        singles.add("SPORES");
        singles.add("SPURS");
        singles.add("SQUARES");
        singles.add("STAIRS");
        singles.add("STEERS");
        singles.add("STORES");
        singles.add("TEARS");
        singles.add("THEIRS");
        singles.add("TOURS");
        singles.add("WARES");
        singles.add("WARS");
        singles.add("YEARS");
        singles.add("YOURS");
        
        doubles.add("AFFAIRS");
        doubles.add("ALGIERS");
        doubles.add("ARREARS");
        doubles.add("AZORES");
        doubles.add("DOWNSTAIRS");
        doubles.add("FIRES");
        doubles.add("HIRES");
        doubles.add("HOURS");
        doubles.add("MESSIEURS");
        doubles.add("OUTDOORS");
        doubles.add("REPAIRS");
        doubles.add("SOURS");
        doubles.add("UPSTAIRS");
        doubles.add("WIRES");
        
        triples.add("UNAWARES");
        triples.add("VOLUNTEERS");
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
