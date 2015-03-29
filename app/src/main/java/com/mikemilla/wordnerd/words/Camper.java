package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Camper implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Camper() {
        doubles.add("BAMBER");
        doubles.add("CAMBER");
        doubles.add("CAMBRE");
        doubles.add("CLAMBER");
        doubles.add("GAMBER");
        doubles.add("KAMBER");
        doubles.add("SCHAMBER");
        doubles.add("AMBERS");
        doubles.add("AMBLER");
        doubles.add("AMOR");
        doubles.add("ANCHOR");
        doubles.add("ANDER");
        doubles.add("ANGER");
        doubles.add("ANKER");
        doubles.add("ANSWER");
        doubles.add("AZURE");
        doubles.add("BAMBI");
        doubles.add("BANGOR");
        doubles.add("BANKER");
        doubles.add("BANTER");
        doubles.add("BRANDER");
        doubles.add("AMBER");
        doubles.add("HAMSTER");
        doubles.add("CANCER");
        doubles.add("CANDOR");
        doubles.add("CANKER");
        doubles.add("CANTER");
        doubles.add("CANTOR");
        doubles.add("CLAMMER");
        doubles.add("CLAMOR");
        doubles.add("DAMPER");
        doubles.add("DANCER");
        doubles.add("GAMBLER");
        doubles.add("GANDER");
        doubles.add("GLAMOR");
        doubles.add("GLAMOUR");
        doubles.add("GRAMMAR");
        doubles.add("GRAMMER");
        doubles.add("GRANTOR");
        doubles.add("HAMMER");
        doubles.add("HAMPER");
        doubles.add("HAMSTER");
        doubles.add("HANDER");
        doubles.add("HANKER");
        doubles.add("LAMBER");
        doubles.add("LANDER");
        doubles.add("MANNER");
        doubles.add("PAMPER");
        doubles.add("PANDER");
        doubles.add("PLANNER");
        doubles.add("PLANTER");
        doubles.add("RAMBLER");
        doubles.add("RANCOR");
        doubles.add("RANKER");
        doubles.add("SANDER");
        doubles.add("SCAMMER");
        doubles.add("SCAMPER");
        doubles.add("SLAMMER");
        doubles.add("SLANDER");
        doubles.add("STABBER");
        doubles.add("STAMMER");
        doubles.add("STAMPER");
        doubles.add("STANDER");
        doubles.add("TAMPER");
        doubles.add("TANKER");
        doubles.add("TANNER");
        doubles.add("VAMPIRE");
        doubles.add("ZANDER");

        triples.add("COMMANDER");
        triples.add("ENCHANTER");
        triples.add("LEANDER");
        triples.add("LYSANDER");
        triples.add("MEANDER");
        triples.add("ALEXANDER");
        triples.add("CORIANDER");

        quadruples.add("SALAMANDER");
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
