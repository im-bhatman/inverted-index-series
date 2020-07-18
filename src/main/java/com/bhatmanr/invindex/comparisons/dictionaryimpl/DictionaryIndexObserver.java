package com.bhatmanr.invindex.comparisons.dictionaryimpl;

public interface DictionaryIndexObserver {

    void UpdateIndex(String term, String docId);
    void SearchIndex(String term);
}
