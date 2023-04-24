package json.mohammad.Reader;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import json.mohammad.Models.Data;
import json.mohammad.Models.Entry;
import json.mohammad.Models.ExtendedStatistics;
import json.mohammad.almahamid.App;

import java.io.InputStream;
import java.util.List;
import java.io.IOException;

public class DataReader {

    private Data data;

    public DataReader() {
        this.data = new Data();
    }

    public List<Entry> readEntries(String dataResourcePath) throws IOException {
        // create object mapper
        ObjectMapper objectMapper = new ObjectMapper();

        InputStream inputStream = App.class.getResourceAsStream("/" + dataResourcePath);

        // read JSON file and map to JsonNode object
        JsonNode rootNode = objectMapper.readTree(inputStream);

        // get entries array
        JsonNode entriesNode = rootNode.get("entries");

        // loop through each entry
        for (JsonNode entryNode : entriesNode) {
            // get values for name, population, and area
            String name = entryNode.get("name").asText();
            int population = entryNode.get("population").asInt();
            double area = entryNode.get("extendedStatistics").get("area").asDouble();

            Entry entry = new Entry(name, population, new ExtendedStatistics(area));

            data.addEntry(entry);
        }

        return data.getEntries();
    }

}
