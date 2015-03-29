package com.mikemilla.wordnerd.words;

import com.mikemilla.wordnerd.Syllables;

import java.util.ArrayList;

public class Ham implements Syllables {

    public static ArrayList<String> singles = new ArrayList<String>();
    public static ArrayList<String> doubles = new ArrayList<String>();
    public static ArrayList<String> triples = new ArrayList<String>();
    public static ArrayList<String> quadruples = new ArrayList<String>();
    public static ArrayList<String> quintuples = new ArrayList<String>();
    public static ArrayList<String> sextuples = new ArrayList<String>();

    public Ham() {
        singles.add("AM");
        singles.add("BAHM");
        singles.add("BAM");
        singles.add("BRAM");
        singles.add("CAM");
        singles.add("CHAM");
        singles.add("CLAM");
        singles.add("CRAM");
        singles.add("DAHM");
        singles.add("DAM");
        singles.add("DRAM");
        singles.add("FLAM");
        singles.add("FRAHM");
        singles.add("FRAM");
        singles.add("GAHM");
        singles.add("GAMM");
        singles.add("GRAEME");
        singles.add("HAHM");
        singles.add("GRAM");
        singles.add("JAM");
        singles.add("KAM");
        singles.add("FAM");
        singles.add("KLAMM");
        singles.add("KRAM");
        singles.add("KVAM");
        singles.add("LAHM");
        singles.add("LAM");
        singles.add("LAMB");
        singles.add("NAHM");
        singles.add("NAM");
        singles.add("PAM");
        singles.add("PHAM");
        singles.add("PLAM");
        singles.add("QUAMME");
        singles.add("RAHM");
        singles.add("RAM");
        singles.add("RAMM");
        singles.add("SAHM");
        singles.add("SAM");
        singles.add("SCAM");
        singles.add("SCHRAM");
        singles.add("SCRAM");
        singles.add("SHAM");
        singles.add("SLAM");
        singles.add("SPAM");
        singles.add("SRAM");
        singles.add("STAM");
        singles.add("STRAM");
        singles.add("SWAM");
        singles.add("TAM");
        singles.add("TAMM");
        singles.add("THAM");
        singles.add("TRAM");
        singles.add("WHAM");
        singles.add("YAM");
        singles.add("ZAHM");
        singles.add("GRAHAM");

        doubles.add("ABRAM");
        doubles.add("ALAM");
        doubles.add("BEACHAM");
        doubles.add("BURCHAM");
        doubles.add("DIRLAM");
        doubles.add("DURHAM");
        doubles.add("DUCHAM");
        doubles.add("EXAM");
        doubles.add("GRAHAM");
        doubles.add("INGHRAM");
        doubles.add("KVAMME");
        doubles.add("LAFLAM");
        doubles.add("MADAME");
        doubles.add("MCCLAM");
        doubles.add("MCHAM");
        doubles.add("MCLAMB");
        doubles.add("PANAM");
        doubles.add("SIAM");
        doubles.add("VANDAM");
        doubles.add("DURHAM");
        doubles.add("MADAME");
        doubles.add("SHAZAM");
        doubles.add("GODDAMN");

        triples.add("INSTAGRAM");
        triples.add("AMSTERDAM");
        triples.add("MAMMOGRAM");
        triples.add("KILOGRAM");
        triples.add("MILLIGRAM");
        triples.add("TELEGRAM");
        triples.add("CENTIGRAM");
        triples.add("HOLOGRAM");
        triples.add("HEXAGRAM");
        triples.add("HECTOGRAM");
        triples.add("NANOGRAM");

        quintuples.add("PARALLELOGRAM");
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
