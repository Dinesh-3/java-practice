package design_patterns.behavioural.chainOfResponsibility1;

public class NumbersReader extends DataReader {
    @Override
    protected String getExtension() {
        return ".numbers";
    }

    @Override
    protected void doRead(String fileName) {
        System.out.println("Reading data from a Numbers spreadsheet: ");
    }
}
