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
public class LeafNode extends Node{
    private final Node node0;
    private final Node node1;
    
    @Override
    public int getFrequency(){
        return node0.getFrequency() + node1.getFrequency();
    }
    
    public LeafNode(Node node0, Node node1){
        this.node0 = node0;
        this.node1 = node1;
    }

    @Override
    void getMap(Map<Character, String> map, String code) {
        this.node0.getMap(map, code + "0");
        this.node1.getMap(map, code + "1");
    }
}
