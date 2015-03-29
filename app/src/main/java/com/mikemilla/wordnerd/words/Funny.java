package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Funny implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Funny() {
        doubles.add("DUNNY");
        doubles.add("DUMMY");
        doubles.add("BUNNEY");
        doubles.add("BUNNIE");
        doubles.add("BUNNY");
        doubles.add("GUNNY");
        doubles.add("HONEY");
        doubles.add("LUNNEY");
        doubles.add("LUNNY");
        doubles.add("MONEY");
        doubles.add("MUNNI");
        doubles.add("RUNNY");
        doubles.add("SONNY");
        doubles.add("SUNNY");
        doubles.add("TUNNEY");
        doubles.add("TUNNY");
        doubles.add("BLOODY");
        doubles.add("BUBBLY");
        doubles.add("BUDDY");
        doubles.add("BUGGY");
        doubles.add("BUMPY");
        doubles.add("BUNDY");
        doubles.add("BUNNIES");
        doubles.add("CHUBBY");
        doubles.add("CHUMMY");
        doubles.add("CLUMSY");
        doubles.add("COUNTRY");
        doubles.add("CRUMMY");
        doubles.add("CUDDLY");
        doubles.add("DUMMIES");
        doubles.add("DUMMY");
        doubles.add("FLUFFY");
        doubles.add("FUBBY");
        doubles.add("FUNKY");
        doubles.add("FUNNIES");
        doubles.add("FUSSY");
        doubles.add("FUZZY");
        doubles.add("GRUMPY");
        doubles.add("GULLY");
        doubles.add("GUMMY");
        doubles.add("HUBBY");
        doubles.add("LOVELY");
        doubles.add("LUCKY");
        doubles.add("MONDAY");
        doubles.add("MONKEY");
        doubles.add("MUDDY");
        doubles.add("MUMMY");
        doubles.add("NUTTY");
        doubles.add("PUPPY");
        doubles.add("RUMMY");
        doubles.add("SCUMMY");
        doubles.add("STUDY");
        doubles.add("TUMMY");
        doubles.add("UGLY");
        doubles.add("YUMMY");
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
