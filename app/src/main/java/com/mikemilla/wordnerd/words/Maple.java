package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Maple implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Maple() {
        doubles.add("ABEL");
        doubles.add("ABLE");
        doubles.add("CHAEBOL");
        doubles.add("CRABLE");
        doubles.add("FABLE");
        doubles.add("GABLE");
        doubles.add("GRABLE");
        doubles.add("GRAYBEAL");
        doubles.add("HABLE");
        doubles.add("KABLE");
        doubles.add("KNABLE");
        doubles.add("LABEL");
        doubles.add("LAIBLE");
        doubles.add("MABEL");
        doubles.add("MABLE");
        doubles.add("RAIBLE");
        doubles.add("SABLE");
        doubles.add("SCHAIBLE");
        doubles.add("STABLE");
        doubles.add("TABLE");
        doubles.add("WAIBEL");
        doubles.add("ZABEL");
        doubles.add("TANGLE");
        doubles.add("CABLE");

        doubles.add("DISABLE");
        doubles.add("ENABLE");
        doubles.add("MISLABEL");
        doubles.add("RELABEL");
        doubles.add("UNABLE");
        doubles.add("UNSTABLE");
        doubles.add("ABLED");
        doubles.add("ANGEL");
        doubles.add("APRIL");
        doubles.add("BAGEL");
        doubles.add("BASIC");
        doubles.add("CAGLE");
        doubles.add("CALEB");
        doubles.add("CAPLE");
        doubles.add("CRADLE");
        doubles.add("FAITHFUL");
        doubles.add("FATAL");
        doubles.add("GRACEFUL");
        doubles.add("GRATEFUL");
        doubles.add("HASTEN");
        doubles.add("HATEFUL");
        doubles.add("HAZEL");
        doubles.add("LABELS");
        doubles.add("LABOR");
        doubles.add("LADLE");
        doubles.add("MAPLE");
        doubles.add("NAPLES");
        doubles.add("NASAL");
        doubles.add("NATAL");
        doubles.add("NAVAL");
        doubles.add("NAVEL");
        doubles.add("PAINFUL");
        doubles.add("PAPAL");
        doubles.add("PLAYFUL");
        doubles.add("RACHEL");
        doubles.add("STAPLE");
        doubles.add("STATED");
        doubles.add("TABLES");
        doubles.add("TAKEN");
        
        triples.add("BETRAYAL");
        triples.add("CAPABLE");
        triples.add("DISABLED");
        triples.add("FINAGLE");
        triples.add("POSTNATAL");
        triples.add("PRENATAL");
        
        quadruples.add("AVAILABLE");
        quadruples.add("NEONATAL");
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
