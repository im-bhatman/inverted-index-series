package com.bhatmanr.invindex.comparisons.dictionaryimpl;

public interface DictionaryIndexObserver {

    void UpdateIndex(String term, String doc_id);
    void SearchIndex(String term);
}
