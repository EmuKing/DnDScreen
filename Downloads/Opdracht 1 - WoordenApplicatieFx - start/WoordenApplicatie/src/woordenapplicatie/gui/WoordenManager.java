/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package woordenapplicatie.gui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author cvdk9
 */
public class WoordenManager {
    public int countWords(String[] s){
        return s.length;
    }
    
    public int countUniqueWords(String[] s){
        Set<String> notAList = new HashSet();
        Collections.addAll(notAList, s);
        return notAList.size();
    }
    
    public Set<String> sort(String[] s){
        Set<String> notAList = new HashSet();
        Collections.addAll(notAList, s);
        
        Set<String> myTreeSet = new TreeSet(Collections.reverseOrder());
        myTreeSet.addAll(notAList);
        
        return myTreeSet;
    }
    
    public HashMap<Integer, List<String>> wordCount(String[] strings) {
    HashMap<String, Integer> map = new HashMap<String, Integer> ();
    for (String s:strings) {
        if (!map.containsKey(s)) {
            map.put(s, 1);
        }
        else {
            int count = map.get(s);
            map.put(s, count + 1);
        }
    }
    
    HashMap<Integer, List<String>> reverseMap = new HashMap<Integer, List<String>>();
    
    for(Map.Entry<String, Integer> entry : map.entrySet()){
        if (!reverseMap.containsKey(entry.getValue())) {
            List<String> stringList = new ArrayList<String>();
            stringList.add(entry.getKey());
            reverseMap.put(entry.getValue(), stringList);
        }
        else {
            int count = entry.getValue();
            reverseMap.get(count).add(entry.getKey());
        }
    }

        
    return reverseMap;
    }
    
    public String concord(String text, String[] s){
        String[] lines = text.split("\\n");

        Map<String, List<Integer>> map = new HashMap<>();
        for(String w : s){
            map.put(w, new ArrayList<>());
        }

        for (String key : map.keySet())
        {
            List<Integer> list = new ArrayList<>();
            int linenumber = 1;
            for (String line : lines) {
                if(line.indexOf(key) != -1)
                    list.add(linenumber);

                linenumber++;
            }
            map.put(key, list);
        }
        System.out.println(map);
        return map.toString();
    }
        
}
