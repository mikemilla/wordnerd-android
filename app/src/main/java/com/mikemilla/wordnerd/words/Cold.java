package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Cold implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Cold() {
        singles.add("BOLD");
        singles.add("BOWLED");
        singles.add("DOLD");
        singles.add("DOLED");
        singles.add("FOLD");
        singles.add("GOLD");
        singles.add("HOLD");
        singles.add("HOLED");
        singles.add("MOLD");
        singles.add("MOULD");
        singles.add("NOLD");
        singles.add("OLD");;
        singles.add("POLLED");
        singles.add("ROALD");
        singles.add("ROLLED");
        singles.add("SCOLD");
        singles.add("SOLD");
        singles.add("SOLED");
        singles.add("STROLLED");
        singles.add("TOLD");
        singles.add("TOLLED");
        singles.add("VOLD");
        singles.add("WOLD");
        
        doubles.add("AHOLD");
        doubles.add("BEHOLD");
        doubles.add("CAJOLED");
        doubles.add("CONSOLED");
        doubles.add("CONTROLLED");
        doubles.add("ENFOLD");
        doubles.add("ENROLLED");
        doubles.add("EXTOLLED");
        doubles.add("FORETOLD");
        doubles.add("FOURFOLD");
        doubles.add("MACHOLD");
        doubles.add("OUTSOLD");
        doubles.add("PAROLED");
        doubles.add("PATROLLED");
        doubles.add("REMOLD");
        doubles.add("RESOLD");
        doubles.add("TWOFOLD");
        doubles.add("UNFOLD");
        doubles.add("UNSOLD");
        doubles.add("UNTOLD");
        doubles.add("UPHOLD");
        doubles.add("WITHHOLD");
        
        triples.add("DECONTROLLED");
        triples.add("OVERSOLD");
        triples.add("UNCONTROLLED");
        triples.add("UNDERSOLD");
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
