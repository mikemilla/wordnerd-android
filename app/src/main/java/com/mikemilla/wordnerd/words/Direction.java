package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Direction implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Direction() {
        doubles.add("FLEXION");
        doubles.add("SECTION");
        
        triples.add("ADVECTION");
        triples.add("AFFECTION");
        triples.add("COLLECTION");
        triples.add("COMPLEXION");
        triples.add("CONFECTION");
        triples.add("CONNECTION");
        triples.add("CONVECTION");
        triples.add("CORRECTION");
        triples.add("DEFECTION");
        triples.add("DETECTION");
        triples.add("DISSECTION");
        triples.add("EJECTION");
        triples.add("ELECTION");
        triples.add("ERECTION");
        triples.add("INFECTION");
        triples.add("INFLECTION");
        triples.add("INJECTION");
        triples.add("INSPECTION");
        triples.add("OBJECTION");
        triples.add("PERFECTION");
        triples.add("PROJECTION");
        triples.add("PROTECTION");
        triples.add("REFLECTION");
        triples.add("REJECTION");
        triples.add("SELECTION");
        
        quadruples.add("CIRCUMSPECTION");
        quadruples.add("DISAFFECTION");
        quadruples.add("DISCONNECTION");
        quadruples.add("DISINFECTION");
        quadruples.add("INSURRECTION");
        quadruples.add("INTERJECTION");
        quadruples.add("INTERSECTION");
        quadruples.add("INTROSPECTION");
        quadruples.add("PREDILECTION");
        quadruples.add("PREELECTION");
        quadruples.add("RECOLLECTION");
        quadruples.add("REDIRECTION");
        quadruples.add("REELECTION");
        quadruples.add("REINSPECTION");
        quadruples.add("RESURRECTION");
        
        doubles.add("LESSON");
        doubles.add("MENTION");
        doubles.add("PENSION");
        doubles.add("QUESTION");
        doubles.add("SECTIONED");
        doubles.add("SESSION");
        doubles.add("STEPSON");
        doubles.add("TENSION");
        doubles.add("TEXAN");
        doubles.add("THREADFIN");
        
        triples.add("AGGRESSION");
        triples.add("ASCENSION");
        triples.add("ATTENTION");
        triples.add("CONCEPTION");
        triples.add("CONFESSION");
        triples.add("CONNECTIONS");
        triples.add("DECEPTION");
        triples.add("DEPRESSION");
        triples.add("DETENTION");
        triples.add("DIMENSION");
        triples.add("DIRECTIONS");
        triples.add("DISCRETION");
        triples.add("EXCEPTION");
        triples.add("EXPRESSION");
        triples.add("IMPRESSION ");
        triples.add("INCEPTION");
        triples.add("INFECTIOUS");
        triples.add("INTENTION");
        triples.add("INVENTION");
        triples.add("OBSESSION");
        triples.add("PERCEPTION");
        triples.add("POSSESSION");
        triples.add("PROFESSION");
        triples.add("PROGRESSION");
        triples.add("RECEPTION");
        triples.add("RECESSION");
        triples.add("REPRESSION");
        triples.add("SUGGESTION");
        triples.add("SUPPRESSION");
        
        quadruples.add("CONTRACEPTION");
        quadruples.add("IMPERFECTION");
        quadruples.add("INTERCEPTION");
        quadruples.add("MISCONCEPTION");
        quadruples.add("PRECONCEPTION");
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
