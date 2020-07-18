package com.bhatmanr.invindex.comparisons.dictionaryimpl;

import java.util.HashMap;
import java.util.Map;

public class HashDictionaryIndex implements DictionaryIndexObserver {

    private static Map<String, String> hashTermIndex = new HashMap<String, String>();
    private Subject indexHandler;

    public HashDictionaryIndex(Subject indxHndlr) {
        this.indexHandler = indxHndlr;
        indexHandler.RegisterObserverIndex(this);
    }


    public void UpdateIndex(String term, String docId) {
        hashTermIndex.put(term,docId);
    }

    public void SearchIndex(String term) {

    }
}
