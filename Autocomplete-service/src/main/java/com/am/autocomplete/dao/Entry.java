package com.am.autocomplete.dao;

public class Entry implements Comparable<Entry> {
    private String word;
    private Long frequency;

    public Entry(String word, long frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public long getFrequency() {
        return frequency;
    }

    public void setFrequency(long frequency) {
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Entry other) {
        return this.frequency.compareTo(other.frequency);
    }
}