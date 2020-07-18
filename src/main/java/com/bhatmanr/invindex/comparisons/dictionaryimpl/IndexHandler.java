package com.bhatmanr.invindex.comparisons.dictionaryimpl;

import java.util.ArrayList;

public class IndexHandler implements Subject {

    private ArrayList<DictionaryIndexObserver> indexObservers;
    private IncrementCounter indexTermCount = new IncrementCounter();

    public IndexHandler() {
        indexObservers = new ArrayList<DictionaryIndexObserver>();
        indexTermCount.incrementCounterValue();
    }


    public void RegisterObserverIndex(DictionaryIndexObserver indexObj) {
        indexObservers.add(indexObj);
    }

    public void RemoveObserverIndex(DictionaryIndexObserver indexObj) {
        int i = indexObservers.indexOf(indexObj);
        if (i >=0) {
            indexObservers.remove(i);
        }
    }

    public void UpdateObserverIndex(String term, String docId) {
        for (DictionaryIndexObserver observer: indexObservers) {
            observer.UpdateIndex(term, docId);
        }
    }

}
