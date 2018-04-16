/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author cvdk9
 */
public abstract class Node {
    
    abstract int getFrequency();
    abstract void getMap(final Map<Character, String> map, final String code);
    
    public Map<Character, String> getDictionaryMap() {
        final Map<Character, String> dictionaryMap = new HashMap<>();

        this.getMap(dictionaryMap, "");

        return dictionaryMap;
    }
}
