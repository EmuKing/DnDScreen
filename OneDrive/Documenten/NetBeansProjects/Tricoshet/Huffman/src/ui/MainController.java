package ui;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import main.HuffmanCompress;
import main.HuffmanDecompress;

public class MainController {

    @FXML private Button button_inputFileCompress;
    @FXML private TextField textField_inputFileCompress;
    @FXML private Button button_outputFileCompress;
    @FXML private TextField textField_outputFileCompress;
    @FXML private Button button_compress;

    private final FileChooser inputTextFileChooserCompress;
    private File inputTextFileCompress;
    private final FileChooser outputBinaryFileChooserCompress;
    private File outputBinaryFileCompress;

    @FXML private Button button_inputFileDecompress;
    @FXML private TextField textField_inputFileDecompress;
    @FXML private Button button_outputFileDecompress;
    @FXML private TextField textField_outputFileDecompress;
    @FXML private Button button_decompress;

    private final FileChooser inputBinaryFileChooserDecompress;
    private File inputBinaryFileDecompress;
    private final FileChooser outputTextFileChooserDecompress;
    private File outputTextFileDecompress;

    public MainController() {
        this.inputTextFileChooserCompress = new FileChooser();
        this.outputBinaryFileChooserCompress = new FileChooser();

        this.inputBinaryFileChooserDecompress = new FileChooser();
        this.outputTextFileChooserDecompress = new FileChooser();
    }

    /**
     * Setup the file choosers, extension filters and button click events
     */
    @FXML
    protected void initialize() {
        FileChooser.ExtensionFilter textFilter = new FileChooser.ExtensionFilter("TXT Files (*.txt)", "*.txt");
        FileChooser.ExtensionFilter binaryFilter = new FileChooser.ExtensionFilter("BIN Files (*.bin)", "*.bin");

        this.inputTextFileChooserCompress.getExtensionFilters().add(textFilter);
        this.inputTextFileChooserCompress.setTitle("Select Input File For Compression");
        this.outputBinaryFileChooserCompress.getExtensionFilters().add(binaryFilter);
        this.outputBinaryFileChooserCompress.setTitle("Select Output File For Compression");

        this.button_inputFileCompress.setOnMouseClicked(event -> this.selectInputFileCompress());
        this.button_outputFileCompress.setOnMouseClicked(event -> this.selectOutputFileCompress());
        this.button_compress.setOnMouseClicked(event -> this.compress());

        this.inputBinaryFileChooserDecompress.getExtensionFilters().add(binaryFilter);
        this.inputBinaryFileChooserDecompress.setTitle("Select Input File For Decompression");
        this.outputTextFileChooserDecompress.getExtensionFilters().add(textFilter);
        this.outputTextFileChooserDecompress.setTitle("Select Output File For Decompression");

        this.button_inputFileDecompress.setOnMouseClicked(event -> this.selectInputFileDecompress());
        this.button_outputFileDecompress.setOnMouseClicked(event -> this.selectOutputFileDecompress());
        this.button_decompress.setOnMouseClicked(event -> this.decompress());
    }

    /**
     * Opens a dialog, asking for the file to compress, so the input file.
     * If a file is chosen, it updates the selected file, and shows a file is selected
     * using the textField_inputFileCompress
     */
    private void selectInputFileCompress() {
        if (this.inputTextFileCompress != null) {
            this.inputTextFileChooserCompress.setInitialDirectory(this.inputTextFileCompress.getParentFile());
        }

        final File selectedInputFile = this.inputTextFileChooserCompress.showOpenDialog(this.getStage());

        if (selectedInputFile != null) {
            this.inputTextFileCompress = selectedInputFile;
            this.textField_inputFileCompress.setText(this.inputTextFileCompress.getAbsolutePath());
        }
    }

    /**
     * Opens a dialog, asking for the file to write the compressed data to, so the output file.
     * If a file is chosen, it updates the selected file, and shows a file is selected using
     * the textField_outputFileCompress
     */
    private void selectOutputFileCompress() {
        if (this.outputBinaryFileCompress != null) {
            this.outputBinaryFileChooserCompress.setInitialDirectory(this.outputBinaryFileCompress.getParentFile());
        }

        final File selectedOutputFile = this.outputBinaryFileChooserCompress.showOpenDialog(this.getStage());

        if (selectedOutputFile != null) {
            this.outputBinaryFileCompress = selectedOutputFile;
            this.textField_outputFileCompress.setText(this.outputBinaryFileCompress.getAbsolutePath());
        }
    }

    /**
     * If both an input and output file are selected, it calls the huffmanAlgorithm to
     * compress the input file, and write the compressed data to the output file.
     */
    private void compress() {
        if (this.inputTextFileCompress == null || this.outputBinaryFileCompress == null) {
            return;
        }
        
        final HuffmanCompress compress = new HuffmanCompress();

        compress.compress(this.inputTextFileCompress, this.outputBinaryFileCompress);

        System.out.println("Finished compressing.");
    }

    /**
     * Opens a dialog, asking for the file to decompress, so the input file.
     * If a file is chosen, it updates the selected file, and shows a file is selected
     * using the textField_inputFileDecompress
     */
    private void selectInputFileDecompress() {
        if (this.inputBinaryFileDecompress != null) {
            this.inputBinaryFileChooserDecompress.setInitialDirectory(this.inputBinaryFileDecompress.getParentFile());
        }

        final File selectedInputFile = this.inputBinaryFileChooserDecompress.showOpenDialog(this.getStage());

        if (selectedInputFile != null) {
            this.inputBinaryFileDecompress = selectedInputFile;
            this.textField_inputFileDecompress.setText(this.inputBinaryFileDecompress.getAbsolutePath());
        }
    }

    /**
     * Opens a dialog, asking for the file to write the decompressed data to, so the output file.
     * If a file is chosen, it updates the selected file, and shows a file is selected using
     * the textField_outputFileDecompress
     */
    private void selectOutputFileDecompress() {
        if (this.outputTextFileDecompress != null) {
            this.outputTextFileChooserDecompress.setInitialDirectory(this.outputTextFileDecompress.getParentFile());
        }

        final File selectedOutputFile = this.outputTextFileChooserDecompress.showOpenDialog(this.getStage());

        if (selectedOutputFile != null) {
            this.outputTextFileDecompress = selectedOutputFile;
            this.textField_outputFileDecompress.setText(this.outputTextFileDecompress.getAbsolutePath());
        }
    }

    /**
     * If both an input and output file are selected, it calls the huffmanAlgorithm to
     * decompress the input file, and write the decompressed data to the output file.
     */
    private void decompress() {
        final HuffmanDecompress decompress = new HuffmanDecompress();

        decompress.decompress(this.inputBinaryFileDecompress, this.outputTextFileDecompress);

        System.out.println("Finished decompressing.");
    }

    /**
     * @return Returns the stage of the main window.
     */
    private Stage getStage() {
        return (Stage) this.button_compress.getScene().getWindow();
    }
}