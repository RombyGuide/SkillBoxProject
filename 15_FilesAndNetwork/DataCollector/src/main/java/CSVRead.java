import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVRead {
    private static String COMMA_DELIMITER;

    public static void main(String[] args) throws IOException {
        readAllDataAtOnce("FilesAndNetwork/DataCollector/data/7/1/depths-2.csv");
    }

    public static void readAllDataAtOnce(String file)
    {
        try {
            // Create an object of file reader
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader(file);
            // create csvReader object and skip first Line
            com.opencsv.CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines( 1 )
                    .build();
            List<String[]> allData = csvReader.readAll();
            // print Data
            for (String[] row : allData) {
                for (String cell : row) {
                    System.out.print(cell + " " );
                }
                System.out.println();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
