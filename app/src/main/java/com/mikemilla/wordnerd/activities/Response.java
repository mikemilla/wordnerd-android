package com.mikemilla.wordnerd.activities;

import java.util.List;

public class Response {

    private List<WordsEntity> words;

    public void setWords(List<WordsEntity> words) {
        this.words = words;
    }

    public List<WordsEntity> getWords() {
        return words;
    }

    public static class WordsEntity {

        private String word;
        private RhymesEntity rhymes;

        public void setWord(String word) {
            this.word = word;
        }

        public void setRhymes(RhymesEntity rhymes) {
            this.rhymes = rhymes;
        }

        public String getWord() {
            return word;
        }

        public RhymesEntity getRhymes() {
            return rhymes;
        }

        public static class RhymesEntity {

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

            public void setSingles(List<String> singles) {
                this.singles = singles;
            }

            public void setDoubles(List<String> doubles) {
                this.doubles = doubles;
            }

            public void setTriples(List<String> triples) {
                this.triples = triples;
            }

            public void setQuadruples(List<String> quadruples) {
                this.quadruples = quadruples;
            }

            public void setQuintuples(List<String> quintuples) {
                this.quintuples = quintuples;
            }

            public void setSextuples(List<String> sextuples) {
                this.sextuples = sextuples;
            }

            public void setSeptuples(List<String> septuples) {
                this.septuples = septuples;
            }

            public void setOctuples(List<String> octuples) {
                this.octuples = octuples;
            }

            public void setNonuples(List<String> nonuples) {
                this.nonuples = nonuples;
            }

            public void setDecuples(List<String> decuples) {
                this.decuples = decuples;
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
    }
}
