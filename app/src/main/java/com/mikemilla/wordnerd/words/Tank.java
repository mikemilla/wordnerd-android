package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Tank implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Tank() {
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
        
        doubles.add("ALBANK");
        doubles.add("DEBLANC");
        doubles.add("LEBLANC");
        doubles.add("MONTBLANC");
        doubles.add("NONBANK");
        
        triples.add("ANTITANK");
        triples.add("KREDIETBANK");
        triples.add("QUARTEURLANC");
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
