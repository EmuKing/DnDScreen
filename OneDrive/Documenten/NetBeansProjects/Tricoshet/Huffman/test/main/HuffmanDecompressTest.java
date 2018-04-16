/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
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
public class HuffmanDecompressTest {
    
    /**
     * Test of decompress method, of class HuffmanDecompress.
     */
    @Test
    public void testDecompress() throws IOException {
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
    
}
