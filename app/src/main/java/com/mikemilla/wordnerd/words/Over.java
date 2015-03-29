package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Over implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Over() {
        doubles.add("CLOVER");
        doubles.add("DOVER");
        doubles.add("DROVER");
        doubles.add("GROVER");
        doubles.add("KOVAR");
        doubles.add("KOVER");
        doubles.add("ROVER");
        doubles.add("SLOVER");
        doubles.add("SNOVER");
        doubles.add("STOVER");
        
        triples.add("LANDROVER");
        triples.add("MOREOVER");
        
        doubles.add("BLOWER");
        doubles.add("BOLDER");
        doubles.add("BOULDER");
        doubles.add("BOWSER");
        doubles.add("CHAUFFEUR");
        doubles.add("CLOSER");
        doubles.add("CLOSURE");
        doubles.add("COASTER");
        doubles.add("COLDER");
        doubles.add("CROZIER");
        doubles.add("DOZER");
        doubles.add("FOLDER");
        doubles.add("GOPHER");
        doubles.add("GROCER");
        doubles.add("GROSSER");
        doubles.add("HOLDER");
        doubles.add("HOMER");
        doubles.add("JOKER");
        doubles.add("KOSHER");
        doubles.add("LOADER");
        doubles.add("LOAFER");
        doubles.add("LONER");
        doubles.add("LOWER");
        doubles.add("MOTOR");
        doubles.add("MOWER");
        doubles.add("NOVA");
        doubles.add("OBER");
        doubles.add("ODER");
        doubles.add("ODOR");
        doubles.add("OGRE");
        doubles.add("OLDER");
        doubles.add("OWNER");
        doubles.add("POKER");
        doubles.add("POSER");
        doubles.add("POSTER");
        doubles.add("ROLLER");
        doubles.add("SHOULDER");
        doubles.add("SLOWER");
        doubles.add("SOBER");
        doubles.add("STONER");
        doubles.add("TOASTER");
        
        triples.add("COMPOSER");
        triples.add("COMPOSURE");
        triples.add("DISCLOSURE");
        triples.add("DISPOSER");
        triples.add("ENCLOSURE");
        triples.add("EXPOSURE");
        triples.add("FORECLOSURE");
        triples.add("INCLOSURE");
        triples.add("OCTOBER");
        
        quintuples.add("OVEREXPOSURE");
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
