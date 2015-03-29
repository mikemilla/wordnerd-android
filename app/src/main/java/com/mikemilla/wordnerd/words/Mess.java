package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Mess implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Mess() {
        singles.add("BESS");
        singles.add("BLESS");
        singles.add("BRESS");
        singles.add("CHES");
        singles.add("CHESS");
        singles.add("CRESS");
        singles.add("DRESS");
        singles.add("FESS");
        singles.add("GESS");
        singles.add("GLESS");
        singles.add("GRESS");
        singles.add("GUESS");
        singles.add("HESS");
        singles.add("HESSE");
        singles.add("JESS");
        singles.add("KESS");
        singles.add("KLESS");
        singles.add("KNESS");
        singles.add("KRESS");
        singles.add("LES");
        singles.add("LESS");
        singles.add("NES");
        singles.add("NESS");
        singles.add("PESCE");
        singles.add("PLESS");
        singles.add("PRESS");
        singles.add("RESS");
        singles.add("STRESS");
        singles.add("TESS");
        singles.add("TRESS");
        singles.add("VESS");
        singles.add("WES");
        singles.add("WESS");
        singles.add("YES");
        
        doubles.add("ADDRESS");
        doubles.add("AGGRESS");
        doubles.add("ASSESS");
        doubles.add("ATTESTS");
        doubles.add("CARESS");
        doubles.add("COMPRESS");
        doubles.add("CONFESS");
        doubles.add("CONTESTS");
        doubles.add("DEPRESS");
        doubles.add("DIGESTS");
        doubles.add("DIGRESS");
        doubles.add("DETEST");
        doubles.add("DISTRESS");
        doubles.add("EGRESS");
        doubles.add("ELLESSE");
        doubles.add("ETESS");
        doubles.add("EXCESS");
        doubles.add("EXPRESS");
        doubles.add("FINESSE");
        doubles.add("FLUORESCE");
        doubles.add("FORBESS");
        doubles.add("IMPRESS");
        doubles.add("LARGESSE");
        doubles.add("LUTECE");
        doubles.add("LYNESS");
        doubles.add("NOBLESSE");
        doubles.add("OBSESS");
        doubles.add("OPPRESS");
        doubles.add("POSSESS");
        doubles.add("PROFESS");
        doubles.add("PROGRESS");
        doubles.add("PROTESTS");
        doubles.add("RECESS");
        doubles.add("REDRESS");
        doubles.add("REGRESS");
        doubles.add("REPRESS");
        doubles.add("REQUESTS");
        doubles.add("SIESE");
        doubles.add("SIMPLESSE");
        doubles.add("SUCCESS");
        doubles.add("SUPPRESS");
        doubles.add("TRANSGRESS");
        doubles.add("UNDRESS");
        doubles.add("UNLESS");
        
        triples.add("ACQUIESCE");
        triples.add("COALESCE");
        triples.add("CONVALESCE");
        triples.add("DISPOSSESS");
        triples.add("NONETHELESS");
        triples.add("REASSESS");
        triples.add("REINVESTS");
        triples.add("REPOSSESS");
        
        singles.add("BETS");
        singles.add("GETS");
        singles.add("JETS");
        singles.add("LETS");
        singles.add("METZ");
        singles.add("NETS");
        singles.add("SETS");
        singles.add("SWEATS");
        
        doubles.add("ADDRESS");
        doubles.add("COMPRESS");
        doubles.add("EXCESS");
        doubles.add("PROGRESS");
        doubles.add("REGRESS");
        doubles.add("REGRETS");
        
        singles.add("TEST");
        
        quadruples.add("NEVERTHELESS");
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
