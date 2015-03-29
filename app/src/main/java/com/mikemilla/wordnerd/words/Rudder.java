package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Rudder implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Rudder() {
        doubles.add("MUDDER");
        doubles.add("SCUDDER");
        doubles.add("SHUDDER");
        doubles.add("STOUDER");
        doubles.add("BLUBBER");
        doubles.add("BUTLER");
        doubles.add("BROTHER");
        doubles.add("BUFFER");
        doubles.add("BUGGER");
        doubles.add("BUTTER");
        doubles.add("CLUTTER");
        doubles.add("COLOR");
        doubles.add("COLOUR");
        doubles.add("COVER");
        doubles.add("CUTTER");
        doubles.add("DUCKER");
        doubles.add("FLUTTER");
        doubles.add("FUCKER");
        doubles.add("GUNNER");
        doubles.add("GUTTER");
        doubles.add("HUGGER");
        doubles.add("LOVER");
        doubles.add("LUBBER");
        doubles.add("MOTHER");
        doubles.add("MUGGER");
        doubles.add("MUTTER");
        doubles.add("NUTTER");
        doubles.add("OTHER");
        doubles.add("PLUCKER");
        doubles.add("PUCKER");
        doubles.add("PUTTER");
        doubles.add("ROUGHER");
        doubles.add("RUBBER");
        doubles.add("RUNNER");
        doubles.add("RUTTER");
        doubles.add("SCRUBBER");
        doubles.add("SCUPPER");
        doubles.add("SHUTTER");
        doubles.add("SLUGGER");
        doubles.add("SMOTHER");
        doubles.add("SPUTTER");
        doubles.add("STUTTER");
        doubles.add("SUCCOR");
        doubles.add("SUCKER");
        doubles.add("SUFFER");
        doubles.add("SUMMER");
        doubles.add("SUPPER");
        doubles.add("SUTTER");
        doubles.add("THUNDER");
        doubles.add("TRUCKER");
        doubles.add("TUCKER");
        doubles.add("TUGGER");
        doubles.add("UDDER");
        doubles.add("UNDER");
        doubles.add("UPPER");
        doubles.add("UTTER");
        doubles.add("WONDER");
        
        triples.add("AFLUTTER");
        triples.add("ANOTHER");
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
