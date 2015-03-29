package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Tattle implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Tattle() {
        doubles.add("ADDLE");
        doubles.add("APPEL");
        doubles.add("APPLE");
        doubles.add("BABBLE");
        doubles.add("BABEL");
        doubles.add("BAFFLE");
        doubles.add("BARREL");
        doubles.add("BATTLED");
        doubles.add("BATTLES");
        doubles.add("CACKLE");
        doubles.add("CAMEL");
        doubles.add("CANDLE");
        doubles.add("CASTLE");
        doubles.add("CATTLE");
        doubles.add("CHANNEL");
        doubles.add("CHAPEL");
        doubles.add("CRACKLE");
        doubles.add("DABBLE");
        doubles.add("DRABBLE");
        doubles.add("FRAGILE");
        doubles.add("GAGGLE");
        doubles.add("GAVEL");
        doubles.add("GRACKLE");
        doubles.add("GRAPPLE");
        doubles.add("GRAVEL");
        doubles.add("HACKLE");
        doubles.add("HAGGLE");
        doubles.add("HANDLE");
        doubles.add("HASSLE");
        doubles.add("JACKAL");
        doubles.add("MANTEL");
        doubles.add("PADDLE");
        doubles.add("RABBLE");
        doubles.add("RADDLE");
        doubles.add("RAFFLE");
        doubles.add("RATTLE");
        doubles.add("RATTLED");
        doubles.add("RAVEL");
        doubles.add("SADDLE");
        doubles.add("SAMPLE");
        doubles.add("SCHNABEL");
        doubles.add("SCRABBLE");
        doubles.add("SHACKLE");
        doubles.add("SPACKLE");
        doubles.add("STRADDLE");
        doubles.add("TACKLE");
        doubles.add("TRAVEL");
        doubles.add("BATTLE");
        doubles.add("TADDLE");

        triples.add("ASTRADDLE");
        triples.add("BEDRAGGLE");
        triples.add("UNRAVEL");
        triples.add("UNSHACKLE");
        triples.add("UNSHACKLED");
        
        quadruples.add("PSYCHOBABBLE");
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
