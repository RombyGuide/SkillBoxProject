package core;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ParserMsk {
    private final static String mapUrl = "https://skillbox-java.github.io/";
    Document document;
    Elements elements;

    public ParserMsk() throws IOException {
        this.document = Jsoup.connect(mapUrl).get();
        this.elements = document.select("div#metrodata");
    }

    public List<Line> parseLines() {
        Elements lines = elements.select("span.js-metro-line.t-metrostation-list-header.t-icon-metroln");
        List<Line> listOfLines = new ArrayList<>();
        Map<String, String> namesOfLines = lines.stream()
                .collect(Collectors.toMap((k) -> k.attr("data-line"), Element::text));
        namesOfLines.forEach((k, v) -> listOfLines.add(new Line(k, v)));
        return listOfLines;
    }

    public List<Station> parseStations(Line line) {
        Elements stations = elements.select("div.js-metro-stations.t-metrostation-list-table[data-line = " + line.getID() + "]").select("span.name");
        List<String> namesOfStations = stations.stream().map(Element::text).collect(Collectors.toList());
        return namesOfStations.stream().map(x -> new Station(x, line)).collect(Collectors.toList());
    }

    public List<TreeSet<Station>> parseConnections(List<Line> lineList, Map<String, Station> stationList) {
        List<TreeSet<Station>> result = new ArrayList<>();
        lineList.forEach(line -> {
            Elements connections = elements.select("div.js-metro-stations.t-metrostation-list-table[data-line = " + line.getID() + "]").select("p");
            List<TreeSet<Station>> connectionsOfLine = connections.stream().map(stations -> {
                TreeSet<Station> stationSet = new TreeSet<>();
                stationSet.add(stationList.get(stations.select("span.name").text()));
                for (Line innerLine : lineList) {
                    if (extractStationName(stations, innerLine) != null) {
                        stationSet.add(stationList.get(extractStationName(stations, innerLine)));
                    }
                }
                return stationSet;
            }).filter(s -> s.size() > 1).collect(Collectors.toList());
            result.addAll(connectionsOfLine);
        });
        return result;
    }

    public static String extractStationName(Element element, Line line) {
        String title = element.select("span.ln-" + line.getID()).attr("title");
        if (!title.isBlank() && !title.isEmpty()) {
            int begin = title.indexOf("«") + 1;
            int end = title.lastIndexOf("»");
            return title.substring(begin, end);
        } else return null;
    }
}
