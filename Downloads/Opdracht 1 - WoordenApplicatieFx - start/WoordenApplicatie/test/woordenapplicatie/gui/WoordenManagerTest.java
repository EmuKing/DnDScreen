/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package woordenapplicatie.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cvdk9
 */
public class WoordenManagerTest {
    
    public WoordenManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of countWords method, of class WoordenManager.
     */
    @Test
    public void testCountWords() {
        System.out.println("countWords");
        String[] s = { "One", "Two", "Three" };
        WoordenManager instance = new WoordenManager();
        int expResult = 3;
        int result = instance.countWords(s);
        assertEquals(expResult, result);
    }

    /**
     * Test of countUniqueWords method, of class WoordenManager.
     */
    @Test
    public void testCountUniqueWords() {
        System.out.println("countUniqueWords");
        String[] s = { "One", "Two", "Three", "One" };
        WoordenManager instance = new WoordenManager();
        int expResult = 3;
        int result = instance.countUniqueWords(s);
        assertEquals(expResult, result);
    }

    /**
     * Test of sort method, of class WoordenManager.
     */
    @Test
    public void testSort() {
        System.out.println("sort");
        String[] s = {"e", "d", "z"};
        WoordenManager instance = new WoordenManager();
        Set<String> expResult = new HashSet<>(Arrays.asList("z", "e", "d"));
        Set<String> result = instance.sort(s);
        assertEquals(expResult, result);
    }

    /**
     * Test of wordCount method, of class WoordenManager.
     */
    @Test
    public void testWordCount() {
        System.out.println("wordCount");
        String[] strings = {"A", "B", "C", "C"};
        WoordenManager instance = new WoordenManager();
        HashMap<Integer, List<String>> expResult = new HashMap<Integer, List<String>>();
        expResult.put(1, Arrays.asList("A", "B"));
        expResult.put(2, Arrays.asList("C"));
        HashMap<Integer, List<String>> result = instance.wordCount(strings);
        assertEquals(expResult, result);
    }

    /**
     * Test of concord method, of class WoordenManager.
     */
    @Test
    public void testConcord() {
        System.out.println("concord");
        String text = "een, twee, drie, vier,\n" + "hoedje van, hoedje van,\n" + "een, twee, drie, vier,\n" + "hoedje van papier\n";;
        String[] s = {"een,", "twee,", "drie,", "vier,", "hoedje", "van,", "hoedje", "van,", "een,", "twee,", "drie,", "vier,", "hoedje", "van", "papier"};
        WoordenManager instance = new WoordenManager();
        String expResult = "{een,=[1, 3], hoedje=[2, 4], van=[2, 4], twee,=[1, 3], drie,=[1, 3], vier,=[1, 3], papier=[4], van,=[2]}";
        String result = instance.concord(text, s);
        assertEquals(expResult, result);
    }
    
}
