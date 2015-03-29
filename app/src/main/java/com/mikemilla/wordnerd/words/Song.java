package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Song implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Song() {
        singles.add("AUNG");
        singles.add("BONG");
        singles.add("CHONG");
        singles.add("CHUANG");
        singles.add("CONG");
        singles.add("CUONG");
        singles.add("DONG");
        singles.add("FONG");
        singles.add("GONG");
        singles.add("HMONG");
        singles.add("HONG");
        singles.add("HUANG");
        singles.add("HWANG");
        singles.add("JIANG");
        singles.add("JONG");
        singles.add("JUANG");
        singles.add("KAHNG");
        singles.add("KONG");
        singles.add("KWANG");
        singles.add("KWONG");
        singles.add("KYONG");
        singles.add("KYOUNG");
        singles.add("LONG");
        singles.add("MAUNG");
        singles.add("MONG");
        singles.add("ONG");
        singles.add("PONG");
        singles.add("PRONG");
        singles.add("QUANG");
        singles.add("RONG");
        singles.add("SPONG");
        singles.add("SPRONG");
        singles.add("STONG");
        singles.add("STRONG");
        singles.add("THONG");
        singles.add("THRONG");
        singles.add("TONG");
        singles.add("TRUONG");
        singles.add("TWANG");
        singles.add("VONG");
        singles.add("WONG");
        singles.add("WRONG");
        singles.add("XIONG");
        singles.add("YONG");
        singles.add("ZHANG");
        
        doubles.add("ALONG");
        doubles.add("BELONG");
        doubles.add("CHENGXIANG");
        doubles.add("CHENXIANG");
        doubles.add("DEJONG");
        doubles.add("DEJONGE");
        doubles.add("DEJONGH");
        doubles.add("DELONG");
        doubles.add("DREPUNG");
        doubles.add("GIANG");
        doubles.add("GUANGDONG");
        doubles.add("LIFELONG");
        doubles.add("LUONG");
        doubles.add("PHUONG");
        doubles.add("PROLONG");
        doubles.add("PUDONG");
        doubles.add("SARONG");
        doubles.add("SHOUGANG");
        doubles.add("VUONG");
        doubles.add("XUDONG");
        doubles.add("XUEDONG");
        doubles.add("YEARLONG");
        doubles.add("YUZONG");
        doubles.add("ZEDONG");
        doubles.add("ZHEJIANG");
        doubles.add("ZIYANG");
        
        triples.add("VIETCONG");
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
