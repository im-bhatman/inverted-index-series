package com.bhatmanr.invindex.comparisons.dictionaryimpl;

public interface DictionaryIndex {

    void AddToIndex(String term, String document);

    void SearchTerm(String term);
}
