package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Level implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Level() {
        doubles.add("BEVEL");
        doubles.add("BEVLE");
        doubles.add("BEZEL");
        doubles.add("BEZLE");
        doubles.add("BEVIL");
        doubles.add("DEVIL");
        doubles.add("DEVOLL");
        doubles.add("EVEL");
        doubles.add("REVEL");
        
        triples.add("BEDEVIL");
        triples.add("DISHEVEL");
        
        quadruples.add("MULTILEVEL");
        
        doubles.add("BETHEL");
        doubles.add("CAREFUL");
        doubles.add("ETHEL");
        doubles.add("ETHYL");
        doubles.add("GENTLE");
        doubles.add("HEAVEN");
        doubles.add("HECKLE");
        doubles.add("KENNEL");
        doubles.add("KETTLE");
        doubles.add("LEBEL");
        doubles.add("MEDAL");
        doubles.add("MEDDLE");
        doubles.add("MENTAL");
        doubles.add("METAL");
        doubles.add("METHYL");
        doubles.add("METTLE");
        doubles.add("NESTLE");
        doubles.add("NEVILLE");
        doubles.add("PEBBLE");
        doubles.add("PEDAL");
        doubles.add("PEDDLE");
        doubles.add("PENCIL");
        doubles.add("PERIL");
        doubles.add("PETAL");
        doubles.add("PRETZEL");
        doubles.add("REBEL");
        doubles.add("SETTLE");
        doubles.add("SEVEN");
        doubles.add("SEVERAL");
        doubles.add("SPECIAL");
        doubles.add("TEMPLE");
        doubles.add("TREBLE");
        doubles.add("TREMBLE");
        doubles.add("TRESTLE");
        doubles.add("VESSEL");
        doubles.add("WRESTLE");
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
