/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import tree.Node;
import tree.Comperator;
import tree.CharacterNode;
import tree.LeafNode;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author cvdk9
 */
public class HuffmanCompress {

    public static final Logger LOGGER = Logger.getLogger(HuffmanCompress.class.getName());
    
    public void compress(final File _inputFile, final File _outputFile) {
        final char[] characters = this.handleInput(_inputFile);
        final Map<Character, Integer> frequencyMap = this.getFrequencyMap(characters);
        final PriorityQueue<Node> nodes = this.getSortedPriorityQueue(frequencyMap);
        final Node rootNode = this.getHuffmanTreeRootNode(nodes);
        final Map<Character, String> dictionaryMap = rootNode.getDictionaryMap();
        final byte[] bytes = this.compressCharArray(characters, dictionaryMap);

        this.handleOutput(_outputFile, dictionaryMap, bytes);
    }

    
    private char[] handleInput(final File _file) {
        try {
            final String string = FileUtils.readFileToString(_file, Charset.defaultCharset());

            return string.toCharArray();
        }
        catch (final IOException _exception) {
            LOGGER.log(Level.SEVERE, _exception.toString(), _exception);
        }

        return new char[] {};
    }
    
    public Map<Character, Integer> getFrequencyMap(final char[] _characters) {
        final Map<Character, Integer> frequencyMap = new HashMap<>();

        for (final Character character : _characters) {
            frequencyMap.merge(character, 1, (oldValue, newValue) -> oldValue + 1);
        }
        return frequencyMap;
    }
    
    private PriorityQueue<Node> getSortedPriorityQueue(final Map<Character, Integer> _frequencyMap) {
        final PriorityQueue<Node> nodePriorityQueue = new PriorityQueue<>(_frequencyMap.size(), new Comperator());

        for (final Map.Entry entry : _frequencyMap.entrySet()) {
            nodePriorityQueue.add(new CharacterNode((int) entry.getValue(), (char) entry.getKey()));
        }

        return nodePriorityQueue;
    }
    
    private Node getHuffmanTreeRootNode(final PriorityQueue<Node> _nodePriorityQueue) {
        while (true) {
            if (_nodePriorityQueue.size() > 1) {
                final Node node1 = _nodePriorityQueue.remove();
                final Node node2 = _nodePriorityQueue.remove();
                final LeafNode leafNode = new LeafNode(node1, node2);
                _nodePriorityQueue.add(leafNode);
            }
            else {
                return _nodePriorityQueue.peek();
            }
        }
    }
    
    private byte[] compressCharArray(final char[] _characters, final Map<Character, String> _dictionaryMap) {
        final StringBuilder code = this.charArrayToCode(_characters, _dictionaryMap);
        final int amountPadded = this.paddCodeWithZeros(code);

        return this.paddedCodeToByteArray(code, amountPadded);
    }
    
    private StringBuilder charArrayToCode(final char[] _characters, final Map<Character, String> _dictionaryMap) {
        final StringBuilder stringBuilder = new StringBuilder();

        for (final Character character : _characters) {
            stringBuilder.append(_dictionaryMap.get(character));
        }

        return stringBuilder;
    }
    
    private int paddCodeWithZeros(final StringBuilder _code) {
        final StringBuilder paddingZeros = new StringBuilder();
        final int amountPadded = 8 - (_code.length() % 8);

        for (int i = 0; i < amountPadded; i++) {
            paddingZeros.append("0");
        }

        _code.insert(0, paddingZeros);

        return amountPadded;
    }
    
    private byte intToByte(final int _value) {
        return (byte) _value;
    }
    
    private byte stringToByte(final String _value) {
        int value = Integer.parseInt(_value, 2);
        return this.intToByte(value);
    }
    
    private byte[] paddedCodeToByteArray(final StringBuilder _paddedCode, final int _amountPadded) {
        final byte[] bytes = new byte[_paddedCode.length() / 8 + 1];

        bytes[0] = this.intToByte(_amountPadded);

        for (int i = 0; i < _paddedCode.length(); i+= 8) {
            final String byteAsString = _paddedCode.substring(i, i + 8);
            bytes[i / 8 + 1] = this.stringToByte(byteAsString);
        }

        return bytes;
    }
    
    private void handleOutput(final File _outputFile, final Map<Character, String> _dictionaryMap, final byte[] _data) {
        try (final FileOutputStream fileOutputStream = new FileOutputStream(_outputFile)) {
            final ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(_dictionaryMap);
            fileOutputStream.write(_data);
        }
        catch (final IOException _exception) {
            LOGGER.log(Level.SEVERE, _exception.toString(), _exception);
        }
    }
}