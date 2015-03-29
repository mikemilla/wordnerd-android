package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Truck implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Truck() {
        singles.add("BRUCK");
        singles.add("BUCK");
        singles.add("CHUCK");
        singles.add("CLUCK");
        singles.add("DRUCK");
        singles.add("DUCK");
        singles.add("DUK");
        singles.add("FLUCK");
        singles.add("FUCK");
        singles.add("GLUCK");
        singles.add("GUCK");
        singles.add("HUCK");
        singles.add("HUCKE");
        singles.add("KLUCK");
        singles.add("KRUCK");
        singles.add("KRUK");
        singles.add("KUCK");
        singles.add("KUK");
        singles.add("LUCK");
        singles.add("LUK");
        singles.add("MRUK");
        singles.add("MUCK");
        singles.add("PLUCK");
        singles.add("PUCK");
        singles.add("RUCK");
        singles.add("SCHMUCK");
        singles.add("SCHUCH");
        singles.add("SCHUCK");
        singles.add("SHUCK");
        singles.add("SMUCK");
        singles.add("SNUCK");
        singles.add("STRUCK");
        singles.add("STUCK");
        singles.add("STUCKE");
        singles.add("SUC");
        singles.add("SUCK");
        singles.add("SUK");
        singles.add("TUCK");
        singles.add("WNUK");
        singles.add("WRUCK");
        singles.add("YUCK");
        singles.add("YUK");
        singles.add("ZUCK");
        singles.add("ZUK");
        
        doubles.add("AMOK");
        doubles.add("AMUCK");
        doubles.add("CANUCK");
        doubles.add("KACHUCK");
        doubles.add("UNSTUCK");
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
