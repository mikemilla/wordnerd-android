package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Sofa implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Sofa() {
        doubles.add("BOPHA");
        doubles.add("BOA");
        doubles.add("BOCA");
        doubles.add("COBRA");
        doubles.add("COCA");
        doubles.add("CODA");
        doubles.add("COLA");
        doubles.add("COMA");
        doubles.add("COPA");
        doubles.add("COSA");
        doubles.add("LOCA");
        doubles.add("LOLA");
        doubles.add("MOCA");
        doubles.add("MOCHA");
        doubles.add("NOVA");
        doubles.add("OPRAH");
        doubles.add("OSHA");
        doubles.add("OVA");
        doubles.add("QUOTA");
        doubles.add("ROSA");
        doubles.add("ROTA");
        doubles.add("SCOTIA");
        doubles.add("SHOFAR");
        doubles.add("SODA");
        doubles.add("SOFAS");
        doubles.add("SOFER");
        doubles.add("SOMA");
        doubles.add("SOSA");
        doubles.add("SOVA");
        doubles.add("TOGA");
        doubles.add("XHOSA");
        doubles.add("YOGA");
        
        triples.add("AMBROSIA");
        triples.add("AROMA");
        triples.add("CORDOVA");
        triples.add("CORONA");
        triples.add("DAKOTA");
        triples.add("EUROPA");
        triples.add("FORMOSA");
        triples.add("JEHOVAH");
        triples.add("MIMOSA");
        triples.add("MOLDOVA");
        triples.add("MUCOSA");
        triples.add("TOYOTA");
        triples.add("CASANOVA");
        triples.add("MARIPOSA");
        triples.add("MINNESOTA");
        triples.add("PONDEROSA");
        triples.add("SUPERNOVA");
        triples.add("ZARAGOZA");
        
        doubles.add("YODA");
        
        triples.add("DAKOTA");
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
