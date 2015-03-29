package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Poster implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Poster() {
        doubles.add("COASTER");
        doubles.add("HOSTER");
        doubles.add("MOSTER");
        doubles.add("ROASTER");
        doubles.add("TOASTER");
        doubles.add("TROESTER");
        doubles.add("BOATER");
        doubles.add("BOLSTER");
        doubles.add("CLOSER");
        doubles.add("CLOSURE");
        doubles.add("CLOVER");
        doubles.add("COASTERS");
        doubles.add("COLDER");
        doubles.add("COSTAR");
        doubles.add("DOSER");
        doubles.add("DOZER");
        doubles.add("FLOATER");
        doubles.add("FOLDER");
        doubles.add("GROCER");
        doubles.add("HOLDER");
        doubles.add("HOLSTER");
        doubles.add("JOKER");
        doubles.add("JOKESTER");
        doubles.add("KOSHER");
        doubles.add("LOAFER");
        doubles.add("LOWER");
        doubles.add("MOTOR");
        doubles.add("OLDER");
        doubles.add("OVER");
        doubles.add("OWNER");
        doubles.add("POKER");
        doubles.add("POLLSTER");
        doubles.add("POLSTER");
        doubles.add("POSER");
        doubles.add("POSTERS");
        doubles.add("ROADSTER");
        doubles.add("ROLLER");
        doubles.add("ROVER");
        doubles.add("SHOULDER");
        doubles.add("SMOKER");
        doubles.add("SOBER");
        doubles.add("SOLAR");
        doubles.add("POLAR");
        doubles.add("VOTER");
        doubles.add("BOASTER");
        
        triples.add("COMPOSER");
        triples.add("COMPOSURE");
        triples.add("UPHOLSTER");
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
