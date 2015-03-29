package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Kitten implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Kitten() {
        doubles.add("CHITIN");
        doubles.add("CHITON");
        doubles.add("BITTEN");
        doubles.add("BITTON");
        doubles.add("BRITAIN");
        doubles.add("BRITON");
        doubles.add("BRITTAIN");
        doubles.add("BRITTAN");
        doubles.add("BRITTEN");
        doubles.add("BRITTON");
        doubles.add("DITTON");
        doubles.add("FITTON");
        doubles.add("GETTIN");
        doubles.add("GRITTON");
        doubles.add("LITTEN");
        doubles.add("LITTON");
        doubles.add("LYTTON");
        doubles.add("MITTAN");
        doubles.add("MITTEN");
        doubles.add("MITTON");
        doubles.add("RYTON");
        doubles.add("SITTIN");
        doubles.add("SITTON");
        doubles.add("SMITTEN");
        doubles.add("TITONE");
        doubles.add("WHITON");
        doubles.add("WHITTEN");
        doubles.add("WHITTON");
        doubles.add("WITTEN");
        doubles.add("WITTON");
        doubles.add("WRITTEN");
        
        triples.add("LEVITON");
        triples.add("REWRITTEN");
        triples.add("UNWRITTEN");
        
        quadruples.add("OVERWRITTEN");
        
        doubles.add("BLITZEN");
        doubles.add("CHICKEN");
        doubles.add("CLINTON");
        doubles.add("DRIVEN");
        doubles.add("DYLAN");
        doubles.add("FITTED");
        doubles.add("GIBBON");
        doubles.add("GIVEN");
        doubles.add("GLISTEN");
        doubles.add("GRIFFEN");
        doubles.add("HIDDEN");
        doubles.add("HITTING");
        doubles.add("KITCHEN");
        doubles.add("KITTEL");
        doubles.add("KITTENS");
        doubles.add("KRISTEN");
        doubles.add("LINEN");
        doubles.add("LINTON");
        doubles.add("LISTEN");
        doubles.add("LITTLE");
        doubles.add("MIDDEN");
        doubles.add("MISSION");
        doubles.add("MITTENS");
        doubles.add("PISTON");
        doubles.add("PITON");
        doubles.add("PRISON");
        doubles.add("QUICKEN");
        doubles.add("RIBBON");
        doubles.add("RIDDEN");
        doubles.add("RISEN");
        doubles.add("SICKEN");
        doubles.add("SITTING");
        doubles.add("SPITTIN");
        doubles.add("SHITTIN");
        doubles.add("STIFFEN");
        doubles.add("STRICKEN");
        doubles.add("THICKEN");
        doubles.add("TIGON");
        doubles.add("WHITMAN");
        doubles.add("WICCAN");
        doubles.add("WOMEN");
        
        triples.add("ADMITTED");
        triples.add("FORBIDDEN");
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
