package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Vase implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Vase() {
        singles.add("ACE");
        singles.add("BASE");
        singles.add("BRACE");
        singles.add("CAISSE");
        singles.add("CASE");
        singles.add("CAYCE");
        singles.add("CHACE");
        singles.add("CHASE");
        singles.add("CRACE");
        singles.add("DACE");
        
        triples.add("DATABASE");
        
        singles.add("DRACE");
        singles.add("FACE");
        singles.add("FRACE");
        singles.add("GLACE");
        singles.add("GRACE");
        singles.add("HEYSE");
        singles.add("LACE");
        singles.add("MACE");
        singles.add("MAIS");
        singles.add("NACE");
        singles.add("PACE");
        singles.add("PLACE");
        singles.add("RACE");
        singles.add("RAIS");
        singles.add("SPACE");
        singles.add("THRACE");
        singles.add("TRACE");
        singles.add("WACE");
        
        doubles.add("DISGRACE");
        doubles.add("DISPLACE");
        doubles.add("EFFACE");
        doubles.add("EMBRACE");
        doubles.add("ENCASE");
        doubles.add("ERASE");
        doubles.add("INCASE");
        doubles.add("LAMBASTES");
        doubles.add("MISPLACE");
        doubles.add("REPLACE");
        doubles.add("RETRACE");
        
        triples.add("INTERLACE");
        triples.add("ARIANESPACE");
        triples.add("AEROSPACE");
        
        singles.add("GLAZE");
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
