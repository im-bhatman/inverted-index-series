package com.bhatmanr.invindex.comparisons.dictionaryimpl;

public interface Subject {
    void RegisterObserverIndex(DictionaryIndexObserver dobj);
    void RemoveObserverIndex(DictionaryIndexObserver dobj);
    void UpdateObserverIndex(String term, String doc_id);
}
