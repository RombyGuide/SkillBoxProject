package csvParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {

    //Основной метод приложения
    public static void main(String[] args) throws IOException {
        String filePath = "15_FilesAndNetwork/DataCollector/data/4/6/dates-1.csv";
        List<Stations> stations = ParseFileCsv(filePath);
        stations.forEach(System.out::println);

        //Тут вызов метода или прямая обработка полученных данных
    }

    //Парсинг CSV файла по указанному пути и получение данных из него
    private static List<Stations> ParseFileCsv(String filePath) throws IOException {
        //Загружаем строки из файла
        List<Stations> stations = new ArrayList<>();
        List<String> fileLines = Files.readAllLines(Paths.get(filePath));
//        System.out.println(fileLines);
        for (String fileLine : fileLines) {
            String[] splitedText = fileLine.split(",");
//            System.out.println(fileLine);
            ArrayList<String> columnList = new ArrayList<>();
            for (int i = 0; i < splitedText.length; i++) {
                //Если колонка начинается на кавычки или заканчивается на кавычки
                if (IsColumnPart(splitedText[i])) {
                    String lastText = columnList.get(columnList.size() - 1);
                    columnList.set(columnList.size() - 1, lastText + ","+ splitedText[i]);
                } else {
                    columnList.add(splitedText[i]);
                }
            }
            Stations stationDepth = new Stations();
            stationDepth.name = columnList.get(0);
            stationDepth.date = columnList.get(1);
            stations.add(stationDepth);
        }
        return stations;
    }

    //Проверка является ли колонка частью предыдущей колонки
    private static boolean IsColumnPart(String text) {
        String trimText = text.trim();
        //Если в тексте одна кавычка и текст на нее заканчивается значит это часть предыдущей колонки
        return trimText.indexOf("\"") == trimText.lastIndexOf("\"") && trimText.endsWith("\"");
    }
}