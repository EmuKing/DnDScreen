/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import java.util.Map;

/**
 *
 * @author cvdk9
 */
public class CharacterNode extends Node {
    private int frequency;
    private Character character;
    
    @Override
    public int getFrequency(){
        return frequency;
    }
    
    public Character getCharacter(){
        return character;
    }
    
    public CharacterNode(int frequency, Character character){
        this.frequency = frequency;
        this.character = character;
    }
    
    @Override
    protected void getMap(final Map<Character, String> map, final String code) {
        map.put(this.character, code);
    }
}
