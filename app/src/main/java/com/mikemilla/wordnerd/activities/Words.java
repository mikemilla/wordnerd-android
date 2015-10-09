package com.mikemilla.wordnerd.activities;

import java.util.List;

public class Words {
    private String word;
    private List<String> singles;
    private List<String> doubles;

    public Words(String word, List<String> singles, List<String> doubles) {
        this.word = word;
        this.singles = singles;
        this.doubles = doubles;
    }

    public String getWordObject() {
        return "Word: " + word + "\nSingles: " +  singles.toString() + "\nDoubles: " + doubles.toString();
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

}
