package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Ring implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Ring() {
        singles.add("BING");
        singles.add("BLING");
        singles.add("BRING");
        singles.add("CHING");
        singles.add("CLING");
        singles.add("DING");
        singles.add("DRING");
        singles.add("FLING");
        singles.add("GING");
        singles.add("GRING");
        singles.add("HING");
        singles.add("JING");
        singles.add("KING");
        singles.add("KLING");
        singles.add("KRING");
        singles.add("LING");
        singles.add("LYNG");
        singles.add("MING");
        singles.add("NING");
        singles.add("PING");
        singles.add("PRING");
        singles.add("QING");
        singles.add("RINGE");
        singles.add("SCHWING");
        singles.add("SHING");
        singles.add("SING");
        singles.add("SINGH");
        singles.add("SLING");
        singles.add("SPRING");
        singles.add("STING");
        singles.add("STRING");
        singles.add("SWING");
        singles.add("THING");
        singles.add("THWING");
        singles.add("TING");
        singles.add("WING");
        singles.add("WRING");
        singles.add("XING");
        singles.add("YING");
        singles.add("ZING");
        
        doubles.add("BEIJING");
        doubles.add("CHONGQING");
        doubles.add("PEKING");
        doubles.add("QINGMING");
        doubles.add("UNRING");
        doubles.add("UPSWING");
        doubles.add("XIAOPING");
        doubles.add("YENCHING");
        
        triples.add("ADMIRING");
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
