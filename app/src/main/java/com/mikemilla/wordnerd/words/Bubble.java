package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Bubble implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Bubble() {
        doubles.add("DOUBLE");
        doubles.add("HUBBELL");
        doubles.add("HUBBLE");
        doubles.add("RUBBLE");
        doubles.add("STUBBLE");
        doubles.add("TROUBLE");
        doubles.add("NUBBLE");
        
        triples.add("REDOUBLE");
        
        doubles.add("BUBBA");
        doubles.add("BUBBLED");
        doubles.add("BUBBLES");
        doubles.add("BUCKLE");
        doubles.add("BUMBLE");
        doubles.add("BUNDLE");
        doubles.add("CHUCKLE");
        doubles.add("COUPLE");
        doubles.add("CRUMBLE");
        doubles.add("CUDDLE");
        doubles.add("DUFFLE");
        doubles.add("FUMBLE");
        doubles.add("FUNNEL");
        doubles.add("HUCKLE");
        doubles.add("HUDDLE");
        doubles.add("HUMBLE");
        doubles.add("HUSTLE");
        doubles.add("JUGGLE");
        doubles.add("KNUCKLE");
        doubles.add("MUCKLE");
        doubles.add("MUDDLE");
        doubles.add("MUMBLE");
        doubles.add("MUSCLE");
        doubles.add("MUZZLE");
        doubles.add("PUDDLE");
        doubles.add("PUZZLE");
        doubles.add("RUCKLE");
        doubles.add("RUDDLE");
        doubles.add("RUMBLE");
        doubles.add("SCUTTLE");
        doubles.add("SHOVEL");
        doubles.add("SHUFFLE");
        doubles.add("SHUTTLE");
        doubles.add("SMUGGLE");
        doubles.add("SNUGGLE");
        doubles.add("STRUGGLE");
        doubles.add("STUMBLE");
        doubles.add("SUBTLE");
        doubles.add("SUCKLE");
        doubles.add("SUPPLE");
        doubles.add("SUTTLE");
        doubles.add("TROUBLED");
        doubles.add("TROUBLES");
        doubles.add("TUMBLE");
        doubles.add("TUNNEL");
        
        triples.add("BEFUDDLE");
        triples.add("DECOUPLE");
        triples.add("QUINTUPLE");
        triples.add("REBUTTAL");
        triples.add("UNCOUPLE");
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
