package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Game implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Game() {
        singles.add("AIM");
        singles.add("AME");
        singles.add("BAIM");
        singles.add("BAME");
        singles.add("BLAME");
        singles.add("BOEHM");
        singles.add("BRAME");
        singles.add("CAME");
        singles.add("CLAIM");
        singles.add("DAME");
        singles.add("FAME");
        singles.add("FAYME");
        singles.add("FLAIM");
        singles.add("FLAME");
        singles.add("FRAIM");
        singles.add("FRAME");
        singles.add("GRAEME");
        singles.add("KAIM");
        singles.add("LAME");
        singles.add("MAIM");
        singles.add("MAME");
        singles.add("MAYME");
        singles.add("NAME");
        singles.add("RHAME");
        singles.add("SAME");
        singles.add("SEJM");
        singles.add("SHAME");
        singles.add("SWAIM");
        singles.add("TAME");
        
        doubles.add("ACCLAIM"); 
        doubles.add("AFLAME");
        doubles.add("ASHAME");
        doubles.add("BALLGAME");
        doubles.add("BECAME");
        doubles.add("DECLAIM");
        doubles.add("DEFAME");
        doubles.add("DISCLAIM");
        doubles.add("EXCLAIM");
        doubles.add("INFLAME");
        doubles.add("POSTGAME");
        doubles.add("PROCLAIM");
        doubles.add("RECLAIM");
        doubles.add("RENAME");
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
