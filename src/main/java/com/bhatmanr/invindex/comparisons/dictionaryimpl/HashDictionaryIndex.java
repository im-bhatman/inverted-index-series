package com.bhatmanr.invindex.comparisons.dictionaryimpl;

import java.util.HashMap;
import java.util.Map;

public class HashDictionaryIndex implements DictionaryIndexObserver {

    private static Map<String, String> hashTermIndex = new HashMap<String, String>();
    private Subject indexHandler; // Do we really need this here ?

    public HashDictionaryIndex(Subject indxHndlr) {
        this.indexHandler = indxHndlr;
        this.indexHandler.RegisterObserverIndex(this);
    }


    public void UpdateIndex(String term, String docId) {
        hashTermIndex.put(term,docId);
    }

    public void SearchIndex(String term) {

    }
}
