package json.mohammad.Reader;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import json.mohammad.Models.OperationInformation;
import json.mohammad.Models.Operations;

public class OperationReader {
    private Operations operations;

    public OperationReader() {
        operations = new Operations();
    }

    public List<OperationInformation> readOperation(String OperationResourcePath) throws IOException {
        // create object mapper
        ObjectMapper objectMapper = new ObjectMapper();

        InputStream inputStream = OperationReader.class.getResourceAsStream("/" + OperationResourcePath);

        // read JSON file and map to JsonNode object
        JsonNode rootNode = objectMapper.readTree(inputStream);

        // get entries array
        JsonNode operationsNode = rootNode.get("operations");

        // loop through each entry
        for (JsonNode operationNode : operationsNode) {
            // get values for name, population, and area
            String name = operationNode.get("name").asText();
            String function = operationNode.get("function").asText();
            String filter = operationNode.get("filter").asText();

            List<String> fields = new ArrayList<>();
            JsonNode fieldNode = operationNode.get("field");
            if (fieldNode != null && fieldNode.isArray()) {
                for (JsonNode field : fieldNode) {
                    fields.add(field.asText());
                }
            }

            OperationInformation operation = new OperationInformation(name, function, fields, filter);

            operations.addOperation(operation);
        }

        return operations.getOperations();
    }

}
