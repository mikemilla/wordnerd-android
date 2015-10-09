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

        private String id;
        private String word;
        private RhymesEntity rhymes;

        public void setId(String id) {
            this.id = id;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public void setRhymes(RhymesEntity rhymes) {
            this.rhymes = rhymes;
        }

        public String getId() {
            return id;
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

            public void setSingles(List<String> singles) {
                this.singles = singles;
            }

            public void setDoubles(List<String> doubles) {
                this.doubles = doubles;
            }

            public List<String> getSingles() {
                return singles;
            }

            public List<String> getDoubles() {
                return doubles;
            }
        }
    }
}
