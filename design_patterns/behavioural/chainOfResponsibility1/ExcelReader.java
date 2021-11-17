package design_patterns.behavioural.chainOfResponsibility1;

public class ExcelReader extends DataReader {
    @Override
    protected String getExtension() {
        return ".xls";
    }

    @Override
    protected void doRead(String fileName) {
        System.out.println("Reading data from an Excel spreadsheet.");
    }
}
