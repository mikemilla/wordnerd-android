package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Crib implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Crib() {
        singles.add("BIB");
        singles.add("DIBB");
        singles.add("GIB");
        singles.add("GLIB");
        singles.add("IB");
        singles.add("JIB");
        singles.add("FIB");
        singles.add("KIBBE");
        singles.add("LIB");
        singles.add("MIB");
        singles.add("NIB");
        singles.add("RIB");
        singles.add("SIB");
        singles.add("SKIBBE");
        singles.add("SQUIB");
        singles.add("TRIB");
        singles.add("BIP");
        singles.add("BLIP");
        singles.add("CHIP");
        singles.add("CLIP");
        singles.add("DIP");
        singles.add("DRIP");
        singles.add("FLIP");
        singles.add("GRIP");
        singles.add("GYP");
        singles.add("HIP");
        singles.add("IP");
        singles.add("KIP");
        singles.add("LIP");
        singles.add("NIP");
        singles.add("PIP");
        singles.add("QUIP");
        singles.add("RIP");
        singles.add("SCRIP");
        singles.add("SHIP");
        singles.add("SIP");
        singles.add("SIPP");
        singles.add("SKIP");
        singles.add("SLIP");
        singles.add("SNIP");
        singles.add("STRIP");
        singles.add("TIP");
        singles.add("TRIP");
        singles.add("WHIP");
        singles.add("YIP");
        singles.add("ZIP");
        singles.add("EQUIP");
        
        doubles.add("OUTSTRIP");
        doubles.add("UNZIP");

        triples.add("MICROCHIP");
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
