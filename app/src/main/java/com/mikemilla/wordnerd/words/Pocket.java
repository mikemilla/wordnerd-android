package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Pocket implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Pocket() {
        doubles.add("DOCKET");
        doubles.add("HOCUTT");
        doubles.add("ROCKET");
        doubles.add("SOCKET");
        doubles.add("SPROCKET");
        doubles.add("ERAKAT");
        doubles.add("AWESOME");
        doubles.add("BONNET");
        doubles.add("BOXES");
        doubles.add("CHOCOLATE");
        doubles.add("CLOSET");
        doubles.add("COCKPIT");
        doubles.add("COMET");
        doubles.add("COSSET");
        doubles.add("CROCKETT");
        doubles.add("FAUCET");
        doubles.add("GODDESS");
        doubles.add("GOSSIP");
        doubles.add("HONEST");
        doubles.add("HOTTEST");
        doubles.add("LOCKET");
        doubles.add("LOCKETT");
        doubles.add("MODEST");
        doubles.add("OFFICE");
        doubles.add("OFTEN");
        doubles.add("POCKETS");
        doubles.add("PORKET");
        doubles.add("POSIT");
        doubles.add("PRODUCT");
        doubles.add("PROFIT");
        doubles.add("PROMISE");
        doubles.add("PROPHET");
        doubles.add("ROCKETS");
        doubles.add("ROCKETT");
        doubles.add("SOCKETS");
        doubles.add("SOLID");
        doubles.add("SONNET");
        doubles.add("TALKIN");
        doubles.add("VOMIT");
        doubles.add("WALLET");
        doubles.add("WALLETS");
        
        triples.add("COMPOSITE");
        triples.add("DEFOLLET");
        triples.add("DEPOSIT");
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
