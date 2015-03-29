package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Grand implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Grand() {
        singles.add("BAND");
        singles.add("BANNED");
        singles.add("BLAND");
        singles.add("BRAND");
        singles.add("CANNED");
        singles.add("CHAND");
        singles.add("FANNED");
        singles.add("GLAND");
        singles.add("HAND");
        singles.add("LAND");
        singles.add("MANDE");
        singles.add("MANNED");
        singles.add("PANNED");
        singles.add("PLANNED");
        singles.add("RAND");
        singles.add("SAND");
        singles.add("SANDE");
        singles.add("SCANNED");
        singles.add("SHAND");
        singles.add("SPANNED");
        singles.add("STAND");
        singles.add("STRAND");
        singles.add("STRANDE");
        singles.add("TANNED");
        singles.add("VANDE");
        singles.add("ZAND");
        
        doubles.add("BOURLAND");
        doubles.add("COMMAND");
        doubles.add("DELAND");
        doubles.add("DEMAND");
        doubles.add("DISBAND");
        doubles.add("EXPAND");
        doubles.add("FERNAND");
        doubles.add("FIRSTHAND");
        doubles.add("HOILAND");
        doubles.add("LABAND");
        doubles.add("LEFTHAND");
        doubles.add("MARCHAND");
        doubles.add("OFFHAND");
        doubles.add("OUTMANNED");
        doubles.add("REMAND");
        doubles.add("RIGHTHAND");
        doubles.add("UNMANNED");
        doubles.add("UNPLANNED");
        doubles.add("WITHSTAND");

        triples.add("VALLEGRANDE");
        triples.add("RUBBERBAND");
        triples.add("CONTRABAND");
        triples.add("UNDERSTAND");
        triples.add("UNDERHAND");
        triples.add("OVERHAND");
        triples.add("SECONDHAND");

        quadruples.add("MISUNDERSTAND");

        singles.add("CLAMMED");
        singles.add("CRAMMED");
        singles.add("DAMMED");
        singles.add("DAMNED");
        singles.add("HANGED");
        singles.add("JAMMED");
        singles.add("RAMMED");
        singles.add("SLAMMED");
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
