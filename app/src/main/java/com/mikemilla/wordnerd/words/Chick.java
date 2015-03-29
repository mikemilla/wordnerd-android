package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Chick implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Chick() {
        singles.add("BIC");
        singles.add("BICK");
        singles.add("BLICK");
        singles.add("BRICK");
        singles.add("BRYK");
        singles.add("CLICK");
        singles.add("CRICK");
        singles.add("CWIK");
        singles.add("DICK");
        singles.add("DYK");
        singles.add("DZIK");
        singles.add("FICK");
        singles.add("FLICK");
        singles.add("FRICK");
        singles.add("GICK");
        singles.add("GLICK");
        singles.add("HICK");
        singles.add("KICK");
        singles.add("KLICK");
        singles.add("KNICK");
        singles.add("KRICK");
        singles.add("KWIK");
        singles.add("LICK");
        singles.add("MIC");
        singles.add("NICK");
        singles.add("NIK");
        singles.add("PICK");
        singles.add("PIK");
        singles.add("PRICK");
        singles.add("QUICK");
        singles.add("QUIK");
        singles.add("RICK");
        singles.add("SCHICK");
        singles.add("SCHLICK");
        singles.add("SCHMICK");
        singles.add("SCHNICK");
        singles.add("SCHRICK");
        singles.add("SCHTICK");
        singles.add("SHICK");
        singles.add("SHTICK");
        singles.add("SICK");
        singles.add("SLICK");
        singles.add("SMICK");
        singles.add("SNICK");
        singles.add("SPIC");
        singles.add("SPRICK");
        singles.add("STICK");
        singles.add("STRICK");
        singles.add("SWICK");
        singles.add("TICK");
        singles.add("TRICK");
        singles.add("VICK");
        singles.add("VIK");
        singles.add("WICK");
        singles.add("WIK");
        singles.add("WYK");
        singles.add("ZICK");
        singles.add("ZWICK");

        doubles.add("VANDYCK");
        doubles.add("VANWYCK");
        doubles.add("VANWYK");
        doubles.add("AFFLIK");

        triples.add("CONTRADICT");
        
        doubles.add("ADDICT");
        doubles.add("AFFLICT");
        doubles.add("CONFLICT");
        doubles.add("CONSTRICT");
        doubles.add("DEPICT");
        doubles.add("EVICT");
        doubles.add("HANDPICKED");
        doubles.add("INFLICT");
        doubles.add("PREDICT");
        doubles.add("RESTRICT");
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

    @Override
    public ArrayList<String> getSextupleSyllables() {
        return sextuples;
    }
}
