/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
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
public class HuffmanCompressTest {
    
    public HuffmanCompressTest() {
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
     * Test of compress method, of class HuffmanCompress.
     */
    @Test
    public void testCompress() {
        System.out.println("compress");
        File _inputFile = null;
        File _outputFile = null;
        HuffmanCompress instance = new HuffmanCompress();
        instance.compress(_inputFile, _outputFile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
