package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Lady implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Lady() {
        doubles.add("CADDIE");
        doubles.add("ADEY");
        doubles.add("ADY");
        doubles.add("BADY");
        doubles.add("BRADY");
        doubles.add("CADY");
        doubles.add("CRADY");
        doubles.add("DADY");
        doubles.add("EYDIE");
        doubles.add("FRADY");
        doubles.add("GRADY");
        doubles.add("HAIDEE");
        doubles.add("KADY");
        doubles.add("MADEY");
        doubles.add("MADY");
        doubles.add("MAIDIE");
        doubles.add("RADY");
        doubles.add("SHADY");
        doubles.add("SPADY");
        doubles.add("ARKADY");
        doubles.add("GENADY");
        doubles.add("MCCRADY");
        doubles.add("MCGRADY");
        doubles.add("OGRADY");

        doubles.add("ACHY");
        doubles.add("AMY");
        doubles.add("BABIES");
        doubles.add("BABY");
        doubles.add("BAILEY");
        doubles.add("CRAZY");
        doubles.add("DAILY");
        doubles.add("DAISY");
        doubles.add("EIGHTIES");
        doubles.add("EIGHTY");
        doubles.add("FLAKY");
        doubles.add("GRAVY");
        doubles.add("HADES");
        doubles.add("HAITI");
        doubles.add("HALEY");
        doubles.add("HAZY");
        doubles.add("JAMIE");
        doubles.add("KATIE");
        doubles.add("KATY");
        doubles.add("LADIES");
        doubles.add("LATELY");
        doubles.add("LAZY");
        doubles.add("MATEY");
        doubles.add("MATIE");
        doubles.add("MAYBE");
        doubles.add("NAVY");
        doubles.add("PLATY");
        doubles.add("RABIES");
        doubles.add("RACY");
        doubles.add("RAINY");
        doubles.add("REIKI");
        doubles.add("SAFETY");
        doubles.add("SHAKY");
        doubles.add("SPACEY");
        doubles.add("TASTY");
        doubles.add("WAVEY");
        doubles.add("WAVY");
        doubles.add("WEIGHTY");
        
        triples.add("CRYBABY");
        triples.add("KUWAITI");
        triples.add("MERCEDES");
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
