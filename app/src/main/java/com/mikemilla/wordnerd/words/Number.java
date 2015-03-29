package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Number implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Number() {
        triples.add("CUCUMBER");
        
        doubles.add("UMBER");
        doubles.add("CUMBER");
        doubles.add("HUMBER");
        doubles.add("LUMBER");
        doubles.add("SLUMBER");
        doubles.add("ENCUMBER");
        doubles.add("MACUMBER");
        doubles.add("MCCUMBER");
        doubles.add("OUTNUMBER");
        doubles.add("UNENCUMBER");
        doubles.add("BLUNDER");
        doubles.add("BROTHER");
        doubles.add("BUMMER");
        doubles.add("BUMPER");
        doubles.add("BUNKER");
        doubles.add("BUTTER");
        doubles.add("COLOR");
        doubles.add("COMER");
        doubles.add("COMFORT");
        doubles.add("COVER");
        doubles.add("DRUMMER");
        doubles.add("DUMBER");
        doubles.add("DUMMER");
        doubles.add("DUMPER");
        doubles.add("DUNBAR");
        doubles.add("DUNKER");
        doubles.add("GUNNER");
        doubles.add("HUMMER");
        doubles.add("HUNGER");
        doubles.add("HUNKER");
        doubles.add("HUNTER");
        doubles.add("JUMPER");
        doubles.add("JUNKER");
        doubles.add("LOVER");
        doubles.add("LUMBAR");
        doubles.add("LUMPER");
        doubles.add("MONGER");
        doubles.add("MOTHER");
        doubles.add("OTHER");
        doubles.add("PLUMBER");
        doubles.add("PLUMMER");
        doubles.add("PLUNDER");
        doubles.add("PUMPER");
        doubles.add("PUNTER");
        doubles.add("RHUMBA");
        doubles.add("RUBBER");
        doubles.add("RUMBA");
        doubles.add("RUNNER");
        doubles.add("STUMPER");
        doubles.add("STUNNER");
        doubles.add("SUMMER");
        doubles.add("SUNDER");
        doubles.add("THUMPER");
        doubles.add("THUNDER");
        doubles.add("TUMBLER");
        doubles.add("UNDER");
        doubles.add("WONDER");
        doubles.add("YOUNGER");
        doubles.add("YOUNKER");
        
        triples.add("ANOTHER");
        triples.add("ASUNDER");
        triples.add("SPELUNKER");
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
