package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Flask implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Flask() {
        singles.add("BASK");
        singles.add("BASQUE");
        singles.add("CASK");
        singles.add("ASK");
        singles.add("LASK");
        singles.add("MASK");
        singles.add("MASQUE");
        singles.add("PASCH");
        singles.add("PASK");
        singles.add("PASQUE");
        singles.add("RASK");
        singles.add("TASK");
        singles.add("TRASK");

        doubles.add("UNMASK");

        singles.add("ACTS");
        singles.add("AX");
        singles.add("AXE");
        singles.add("BACKES");
        singles.add("BACKS");
        singles.add("BAX");
        singles.add("BLACKS");
        singles.add("CRACKS");
        singles.add("DACS");
        singles.add("DAX");
        singles.add("DAX'");
        singles.add("FAX");
        singles.add("FLAX");
        singles.add("HACKS");
        singles.add("JACKS");
        singles.add("JAQUES");
        singles.add("KNACKS");
        singles.add("LACKS");
        singles.add("LAX");
        singles.add("MACKS");
        singles.add("MACS");
        singles.add("MAX");
        singles.add("PACKS");
        singles.add("PACS");
        singles.add("PAX");
        singles.add("PLAQUES");
        singles.add("PLAX");
        singles.add("QUACKS");
        singles.add("RACKS");
        singles.add("RAX");
        singles.add("SACHS");
        singles.add("SACKS");
        singles.add("SACS");
        singles.add("SAKS");
        singles.add("SAX");
        singles.add("SHACKS");
        singles.add("SLACKS");
        singles.add("SMACKS");
        singles.add("SNACKS");
        singles.add("STACKS");
        singles.add("TACKS");
        singles.add("TAX");
        singles.add("TRACKS");
        singles.add("TRACTS");
        singles.add("TRAX");
        singles.add("VAX");
        singles.add("WACKS");
        singles.add("WAX");
        singles.add("WHACKS");
        singles.add("YAX");
        singles.add("ZACKS");

        doubles.add("ATTACKS");
        doubles.add("ATTRACTS");
        doubles.add("COMPACTS");
        doubles.add("CONTRACTS");
        doubles.add("DETRACTS");
        doubles.add("DISTRACTS");
        doubles.add("ENACTS");
        doubles.add("EXACTS");
        doubles.add("EXTRACTS");
        doubles.add("IMPACTS");
        doubles.add("PRETAX");
        doubles.add("REACTS");
        doubles.add("REDACTES");
        doubles.add("RELAX");
        doubles.add("RETRACTS");
        doubles.add("ANTITAX");
        doubles.add("NEOAX");
        doubles.add("REENACTS");

        singles.add("APPS");
        singles.add("AX");
        singles.add("AXE");
        singles.add("BACKS");
        singles.add("BAX");
        singles.add("BLACKS");
        singles.add("CADS");
        singles.add("CAPS");
        singles.add("CHAPS");
        singles.add("CLAPS");
        singles.add("CRACKS");
        singles.add("CRAPS");
        singles.add("DAX");
        singles.add("FAX");
        singles.add("FLAPS");
        singles.add("FLAX");
        singles.add("GAPS");
        singles.add("JACKS");
        singles.add("LAPS");
        singles.add("LAPSE");
        singles.add("LAX");
        singles.add("MACS");
        singles.add("MAPS");
        singles.add("MAX");
        singles.add("NAPS");
        singles.add("PACKS");
        singles.add("PAX");
        singles.add("QUACKS");
        singles.add("RAPS");
        singles.add("SACKS");
        singles.add("SACS");
        singles.add("SAPS");
        singles.add("SAX");
        singles.add("SAXE");
        singles.add("SCHNAPPS");
        singles.add("SCRAPS");
        singles.add("SLACKS");
        singles.add("SNAPS");
        singles.add("STACKS");
        singles.add("TACKS");
        singles.add("TAPS");
        singles.add("TAX");
        singles.add("TRACKS");
        singles.add("TRAPS");
        singles.add("WAX");
        singles.add("WRAPS");

        doubles.add("COLLAPSE");
        doubles.add("CONTRACTS");
        doubles.add("DEATH TAX");
        doubles.add("ELAPSE");
        doubles.add("PERHAPS");
        doubles.add("PRETAX");
        doubles.add("RELAPSE");
        doubles.add("RELAX");

        triples.add("CATARACTS");
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
