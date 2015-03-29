package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Party implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Party() {
        doubles.add("AARTI");
        doubles.add("ARTIE");
        doubles.add("ARTY");
        doubles.add("BARTEE");
        doubles.add("CARTY");
        doubles.add("DARTY");
        doubles.add("HARTY");
        doubles.add("HEARTY");
        doubles.add("MARTI");
        doubles.add("MARTIE");
        doubles.add("MARTY");
        doubles.add("PARTI");
        doubles.add("SARTI");
        doubles.add("SMARTY");

        triples.add("MCCARTY");
        triples.add("MCCLARTY");
        triples.add("MCLARTY");
        triples.add("UGARTE");
        triples.add("MORIARTY");
        triples.add("URIARTE");
        
        doubles.add("ARBY");
        doubles.add("ARI");
        doubles.add("ARMY");
        doubles.add("BARBIE");
        doubles.add("BARLEY");
        doubles.add("BARNEY");
        doubles.add("BIRDIE");
        doubles.add("BURGEE");
        doubles.add("CARDI");
        doubles.add("CARDY");
        doubles.add("CARLY");
        doubles.add("CHARLIE");
        doubles.add("CHIRPY");
        doubles.add("CORBY");
        doubles.add("CORGI");
        doubles.add("CORKY");
        doubles.add("DARBY");
        doubles.add("DARKIE");
        doubles.add("DERBY");
        doubles.add("DIRTY");
        doubles.add("FORTY");
        doubles.add("GNARLY");
        doubles.add("GORKI");
        doubles.add("GORKY");
        doubles.add("HARDLY");
        doubles.add("HARDY");
        doubles.add("HARLEY");
        doubles.add("HARVEY");
        doubles.add("HEARTBEAT");
        doubles.add("HOTTIE");
        doubles.add("JERKY");
        doubles.add("LARDY");
        doubles.add("MARDI");
        doubles.add("MARLEY");
        doubles.add("MARLY");
        doubles.add("MURKY");
        doubles.add("NARLY");
        doubles.add("PARDY");
        doubles.add("PARLAY");
        doubles.add("PARLEY");
        doubles.add("PARY");
        doubles.add("PERKY");
        doubles.add("PORGY");
        doubles.add("PORKY");
        doubles.add("QUIRKY");
        doubles.add("SHARPIE");
        doubles.add("SHARPY");
        doubles.add("SHORTY");
        doubles.add("SMARTLY");
        doubles.add("SORRY");
        doubles.add("SORTIE");
        doubles.add("SPARKY");
        doubles.add("SPORTY");
        doubles.add("STARRY");
        doubles.add("STURDY");
        doubles.add("TARDY");
        doubles.add("THIRTY");
        doubles.add("TURKEY");
        doubles.add("VERDE");
        doubles.add("VERDI");
        doubles.add("WORDY");
        doubles.add("YARDIE");
        
        triples.add("ATARI");
        triples.add("BACARDI");
        triples.add("FERRARI");
        triples.add("MALARKEY");
        triples.add("SAFARI");
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
