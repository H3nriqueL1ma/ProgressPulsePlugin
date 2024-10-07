package com.github.h3nriquel1ma.progressPulsePluginCore.Interfaces.Rewards;

import java.util.Map;

public interface AddEntriesManager<K, V> {
    void addEntries(Map<K, V> listOne, Map<K, V> listTwo, Map<K, V> listThree, Map<K, V> listFour, Map<K, V> listFive);
}
