package com.mikemilla.wordnerd.data;

import java.util.List;

public class Words {
    private String word;
    private List<String> singles;
    private List<String> doubles;
    private List<String> triples;
    private List<String> quadruples;
    private List<String> quintuples;
    private List<String> sextuples;
    private List<String> septuples;
    private List<String> octuples;
    private List<String> nonuples;
    private List<String> decuples;

    public Words(String word, List<String> singles, List<String> doubles,
                 List<String> triples, List<String> quadruples, List<String> quintuples,
                 List<String> sextuples, List<String> septuples, List<String> octuples,
                 List<String> nonuples, List<String> decuples) {
        this.word = word;
        this.singles = singles;
        this.doubles = doubles;
        this.triples = triples;
        this.quadruples = quadruples;
        this.quintuples = quintuples;
        this.sextuples = sextuples;
        this.septuples = septuples;
        this.octuples = octuples;
        this.nonuples = nonuples;
        this.decuples = decuples;
    }

    public String getWordObject() {
        return "Word: " + word +
                "\nSingles: " + singles.toString() +
                "\nDoubles: " + doubles.toString() +
                "\nTriples: " + triples.toString() +
                "\nQuadruples: " + quadruples.toString() +
                "\nQuintuples: " + quintuples.toString() +
                "\nSextuples: " + sextuples.toString() +
                "\nSeptuples: " + septuples.toString() +
                "\nOctuples: " + octuples.toString() +
                "\nNonuples: " + nonuples.toString() +
                "\nDecuples: " + decuples.toString();
    }

    public String getWord() {
        return word;
    }

    public List<String> getSingles() {
        return singles;
    }

    public List<String> getDoubles() {
        return doubles;
    }

    public List<String> getTriples() {
        return triples;
    }

    public List<String> getQuadruples() {
        return quadruples;
    }

    public List<String> getQuintuples() {
        return quintuples;
    }

    public List<String> getSextuples() {
        return sextuples;
    }

    public List<String> getSeptuples() {
        return septuples;
    }

    public List<String> getOctuples() {
        return octuples;
    }

    public List<String> getNonuples() {
        return nonuples;
    }

    public List<String> getDecuples() {
        return decuples;
    }

}
