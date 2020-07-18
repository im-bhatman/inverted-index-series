package com.bhatmanr.invindex.comparisons.dictionaryimpl;

import java.util.SortedMap;
import java.util.TreeMap;

public class TreeDictionaryIndex implements DictionaryIndexObserver {

    private static SortedMap<String,String> index = new TreeMap<String,String>();
    private Subject indexHandler;

    public TreeDictionaryIndex(Subject indxHndlr) {
        this.indexHandler = indxHndlr;
    }

    public void UpdateIndex(String term, String docId) {
        index.put(term, docId);
    }

    public void SearchIndex(String term) {

    }
}
