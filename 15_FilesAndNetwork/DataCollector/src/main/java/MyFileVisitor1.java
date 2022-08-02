import com.opencsv.CSVReaderBuilder;

import java.io.File;
import java.io.FileReader;
import java.util.List;

public class MyFileVisitor1 {
    public static void main(String[] args) throws Exception {
        traverse("15_FilesAndNetwork/DataCollector/data");
    }

    private static void traverse(String dir){
        File file = new File(dir);
        if (file.isDirectory()) {
            String[] children = file.list();
            for (int i = 0; children != null && i < children.length; i++) {
                traverse(String.valueOf(new File(file, children[i])));
            }
        }
        if (file.isFile()) {
            if (file.getName().endsWith(".json")) {
//                System.out.println(dir.getAbsolutePath());//change it if needed
//                readAllDataAtOnce(file);
            }
        }
    }

    public static void readAllDataAtOnce(File file)
    {
        try {
            // Create an object of file reader
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader(file);
            // create csvReader object and skip first Line
            com.opencsv.CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines( 0 )
                    .build();
            List<String[]> allData = csvReader.readAll();
            // print Data
            for (String[] row : allData) {
                for (String cell : row) {
                    System.out.print(cell + " ");
                }
//                System.out.println();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}