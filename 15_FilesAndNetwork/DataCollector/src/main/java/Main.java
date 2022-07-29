import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import core.Line;
import core.ParserMsk;
import core.Station;
import core.StationIndex;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    private final static String jsonFile = "FilesAndNetwork/DataCollector/data/msk.json";
    private static List<Line> allLines;    // все наши линии
    private static Map<String, Station> allStations = new TreeMap<>();  // все наши станции
    private static List<TreeSet<Station>> allConnections = new ArrayList<>(); //все наши переходы(узлы)
    private static StationIndex mapMsk = new StationIndex();  //итоговая карта метро

    public static void main(String[] args) throws IOException {

        ParserMsk metroParser = new ParserMsk();

        allLines = metroParser.parseLines();//добавляем линии в список
        allLines.forEach((line) -> {
            mapMsk.addLine(line);// сразу добавляем линию на карту
            List<Station> stationsOfLine = metroParser.parseStations(line);
//            System.out.println(stationsOfLine);//получаем список станций для каждой линии
            mapMsk.addAllLineStations(line, stationsOfLine);// добавляем на карту станции к каждой линии
            stationsOfLine.forEach(el -> allStations.put(el.getName(), el));// формируем также общий список станций
        });

        allConnections = metroParser.parseConnections(allLines, allStations);// добавляем переходы в список
        allConnections.forEach(x -> mapMsk.addConnection(x));// добавляем переходы на карту

        mapToFile(mapMsk, jsonFile);// записываем полученный объект в json-файл;
    }

    private static void mapToFile(StationIndex index, String file) throws IOException {
        String fileName = file.substring(file.lastIndexOf("/") + 1);  //это имя копируемого файла
        String filePath = file.substring(0, file.lastIndexOf("/") + 1);
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        FileWriter toJson = new FileWriter(filePath + fileName);
        gson.toJson(index, toJson);
        toJson.flush();
        toJson.close();
    }
}

