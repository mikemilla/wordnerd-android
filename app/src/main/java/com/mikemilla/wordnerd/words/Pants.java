package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Pants implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Pants() {
        singles.add("ANTS");
        singles.add("AUNTS");
        singles.add("BANTZ");
        singles.add("CHANTS");
        singles.add("FRANTZ");
        singles.add("GANTZ");
        singles.add("GLANTZ");
        singles.add("GRANTS");
        singles.add("GRANTZ");
        singles.add("GRANZ");
        singles.add("HANTZ");
        singles.add("JANTZ");
        singles.add("KANTZ");
        singles.add("KRANTZ");
        singles.add("LANTZ");
        singles.add("MANTZ");
        singles.add("NANTES");
        singles.add("NANTZ");
        singles.add("PLANTS");
        singles.add("PLANTZ");
        singles.add("RANTZ");
        singles.add("SCHANTZ");
        singles.add("SCHRANTZ");
        singles.add("SHANTZ");
        singles.add("SLANTS");
        singles.add("TSCHANTZ");
        singles.add("YANTZ");
        
        doubles.add("IMPLANTS");
        doubles.add("SUPPLANTS");
        doubles.add("TRANSPLANTS");
        
        singles.add("RANTS");
        singles.add("CHANCE");
        singles.add("DANCE");
        singles.add("FRANCE");
        singles.add("GLANCE");
        singles.add("LANCE");
        singles.add("NANCE");
        singles.add("PRANCE");
        singles.add("STANCE");
        singles.add("TRANCE");
        
        doubles.add("ADVANCE");
        doubles.add("ASKANCE");
        doubles.add("ENHANCE");
        doubles.add("EXPANSE");
        doubles.add("FINANCE");
        doubles.add("PERCHANCE");
        doubles.add("ROMANCE");
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
