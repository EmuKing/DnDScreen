/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import org.apache.commons.io.FileUtils;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cvdk9
 */
public class HuffmanDecompress {
    
    private static final Logger LOGGER = Logger.getLogger(HuffmanDecompress.class.getName());
    
    public void decompress(final File _inputFile, final File _outputFile) {
        try (final FileInputStream fileInputStream = new FileInputStream(_inputFile)) {
            final Map<String, Character> dictionaryMap = this.getDictionaryMap(fileInputStream);
            final String compressedData = this.getCompressedData(fileInputStream);
            final String decompressedData = this.decompressData(compressedData, dictionaryMap);

            this.handleOutput(decompressedData, _outputFile);
        }
        catch (final IOException | ClassNotFoundException _exception) {
            LOGGER.log(Level.SEVERE, _exception.toString(), _exception);
        }
    }
    
    private String decompressData(final String _compressedData, final Map<String, Character> _dictionaryMap) {
        final StringBuilder compressedCharacterBuilder = new StringBuilder();
        final StringBuilder decompressedData = new StringBuilder();

        for (int i = 0; i < _compressedData.length(); i++) {
            this.handleBit(decompressedData, i, compressedCharacterBuilder, _compressedData, _dictionaryMap);
        }

        return decompressedData.toString();
    }
    
    private void handleBit(final StringBuilder _decompressedData, final int _index, final StringBuilder _compressedCharacterBuilder, final String _compressedData, final Map<String, Character> _dictionaryMap) {
        _compressedCharacterBuilder.append(_compressedData.substring(_index, _index + 1));

        final String compressedCharacter = _compressedCharacterBuilder.toString();

        if (_dictionaryMap.containsKey(compressedCharacter)) {
            _compressedCharacterBuilder.setLength(0);
            _decompressedData.append(_dictionaryMap.get(compressedCharacter));
        }
    }
    
    private String getCompressedData(final FileInputStream _fileInputStream) throws IOException {
        final int paddedZeros = _fileInputStream.read();
        final StringBuilder stringBuilder = new StringBuilder();

        while (_fileInputStream.available() > 0) {
            stringBuilder.append(String.format("%8s", Integer.toBinaryString(_fileInputStream.read())));
        }

        return stringBuilder.toString().replace(' ', '0').substring(paddedZeros);
    }
    
    private Map<String, Character> getDictionaryMap(final FileInputStream _fileInputStream) throws IOException, ClassNotFoundException {
        final ObjectInputStream objectInputStream = new ObjectInputStream(_fileInputStream);
        final Object object = objectInputStream.readObject();

        if (object instanceof Map) {
            return this.revertDictionaryMap((Map<Character, String>) object);
        }

        return null;
    }
    
    private Map<String, Character> revertDictionaryMap(final Map<Character, String> _revertedDictionaryMap) {
        final Map<String, Character> dictionaryMap = new HashMap<>();

        _revertedDictionaryMap.forEach((_character, _code) -> dictionaryMap.put(_code, _character));

        return dictionaryMap;
    }
    
    private void handleOutput(final String _decompressedData, final File _outputFile) throws IOException {
        FileUtils.writeStringToFile(_outputFile, _decompressedData, Charset.defaultCharset());
    }
}
