package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class It implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public It() {
        singles.add("BIT");
        singles.add("BRIT");
        singles.add("CHIT");
        singles.add("FIT");
        singles.add("FLIT");
        singles.add("GRIT");
        singles.add("GIT");
        singles.add("HIT");
        singles.add("KIT");
        singles.add("KNIT");
        singles.add("LIT");
        singles.add("MITT");
        singles.add("NIT");
        singles.add("PIT");
        singles.add("PITT");
        singles.add("PLITT");
        singles.add("PRITT");
        singles.add("QUIT");
        singles.add("RITT");
        singles.add("SCHLITT");
        singles.add("SCHMIDT");
        singles.add("SCHMIT");
        singles.add("SHIT");
        singles.add("SIT");
        singles.add("SKIT");
        singles.add("SLIT");
        singles.add("SMIT");
        singles.add("SPIT");
        singles.add("SPLIT");
        singles.add("SPRIT");
        singles.add("STITT");
        singles.add("TIT");
        singles.add("TRITT");
        singles.add("VITT");
        singles.add("WHIT");
        singles.add("WIT");
        singles.add("WRIT");

        doubles.add("ACQUIT");
        doubles.add("ADMIT");
        doubles.add("BARRITT");
        doubles.add("BEFIT");
        doubles.add("BOBLITT");
        doubles.add("BURDITT");
        doubles.add("CLAMPITT");
        doubles.add("COMMIT");
        doubles.add("DAVITT");
        doubles.add("DEVITT");
        doubles.add("DEWITT");
        doubles.add("EMIT");
        doubles.add("GILLETT");
        doubles.add("LAFITTE");
        doubles.add("LEGIT");
        doubles.add("MCNITT");
        doubles.add("OMIT");
        doubles.add("PERMIT");
        doubles.add("POLITTE");
        doubles.add("PRESPLIT");
        doubles.add("RESPLIT");
        doubles.add("REFIT");
        doubles.add("REMIT");
        doubles.add("SAVITT");
        doubles.add("SUBMIT");
        doubles.add("TRANSMIT");
        doubles.add("UNFIT");
        doubles.add("LEGIT");

        triples.add("READMIT");
        triples.add("RECOMMIT");
        triples.add("RESUBMIT");
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
