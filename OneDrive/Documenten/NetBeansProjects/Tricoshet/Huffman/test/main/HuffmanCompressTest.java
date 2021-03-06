/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tree.Node;

/**
 *
 * @author cvdk9
 */
public class HuffmanCompressTest {
    
    @Test
    public void testCompress() throws IOException {
        File input = new File("C:\\Users\\cvdk9\\Desktop\\text1.txt");
        File output = new File("C:\\Users\\cvdk9\\Desktop\\bin.bin");
        File output2 = new File("C:\\Users\\cvdk9\\Desktop\\text2.txt");

        HuffmanCompress compressor = new HuffmanCompress();
        compressor.compress(input, output);

        HuffmanDecompress decompressor = new HuffmanDecompress();
        decompressor.decompress(output, output2);

        boolean isTwoEqual = FileUtils.contentEquals(input, output2);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(isTwoEqual, true);
    }   
    

    /**
     * Test of getFrequencyMap method, of class HuffmanCompress.
     */
    @Test
    public void testGetFrequencyMap() {
        HuffmanCompress instance = new HuffmanCompress();
        
        Map<Character, Integer> expResult = new HashMap<Character, Integer>();
        expResult.put('a', 3);
        expResult.put('b', 4);
        
        System.out.println(expResult);
        
        String str = "aaabbbb"; 
        final char[] charArray = str.toCharArray();
        Map<Character, Integer> result = instance.getFrequencyMap(charArray);
        assertEquals(expResult, result);
    }
}