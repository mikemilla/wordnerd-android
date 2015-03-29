package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Cake implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Cake() {
        singles.add("ACHE");
        singles.add("AKE");
        singles.add("BAKE");
        singles.add("BLAKE");
        singles.add("BRAKE");
        singles.add("BREAK");
        singles.add("CRAKE");
        singles.add("DAKE");
        singles.add("DRAKE");
        singles.add("FAKE");
        singles.add("HAIK");
        singles.add("HAKE");
        singles.add("JACQUE");
        singles.add("JAKE");
        singles.add("LAKE");
        singles.add("MAKE");
        singles.add("NAIK");
        singles.add("PAIK");
        singles.add("PAKE");
        singles.add("PLAKE");
        singles.add("QUAKE");
        singles.add("RAKE");
        singles.add("SAKE");
        singles.add("SCHAKE");
        singles.add("SCHLAKE");
        singles.add("SCHNAKE");
        singles.add("SCHWAKE");
        singles.add("SHAIK");
        singles.add("SHAIKH");
        singles.add("SHAKE");
        singles.add("SHRAKE");
        singles.add("SLAKE");
        singles.add("SNAKE");
        singles.add("SPAKE");
        singles.add("STAKE");
        singles.add("STEAK");
        singles.add("STRAKE");
        singles.add("TAKE");
        singles.add("WAKE");
        singles.add("YAKE");
        
        doubles.add("AWAKE");
        doubles.add("BETAKE");
        doubles.add("FORSAKE");
        doubles.add("MISTAKE");
        doubles.add("OPAQUE");
        doubles.add("PARTAKE");
        doubles.add("REMAKE");
        doubles.add("RETAKE");
        doubles.add("HANDSHAKE");

        singles.add("DERANK");
        singles.add("BANC");
        singles.add("BANK");
        singles.add("BANQUE");
        singles.add("BLANC");
        singles.add("BLANCK");
        singles.add("BLANK");
        singles.add("BRANK");
        singles.add("CLANK");
        singles.add("CRANK");
        singles.add("DAHNKE");
        singles.add("DANK");
        singles.add("DRANK");
        singles.add("FLANK");
        singles.add("FRANC");
        singles.add("FRANCK");
        singles.add("FRANK");
        singles.add("HANK");
        singles.add("JAHNKE");
        singles.add("JANK");
        singles.add("LANK");
        singles.add("MAHNKE");
        singles.add("MANK");
        singles.add("PLANK");
        singles.add("PRANK");
        singles.add("RANCK");
        singles.add("RANK");
        singles.add("SANK");
        singles.add("SCHANCK");
        singles.add("SCHANK");
        singles.add("SCHRANK");
        singles.add("SHANK");
        singles.add("SHRANK");
        singles.add("SKANK");
        singles.add("SPANK");
        singles.add("STAHNKE");
        singles.add("STANKS");
        singles.add("SWANK");
        singles.add("TANKE");
        singles.add("THANK");
        singles.add("YAHNKE");
        singles.add("YANK");
        singles.add("ZANK");
        singles.add("FLAKE");

        doubles.add("ALBANK");
        doubles.add("DEBLANC");
        doubles.add("LEBLANC");
        doubles.add("MONTBLANC");
        doubles.add("NONBANK");
        
        triples.add("ANTITANK");
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
