package json.mohammad.writer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutputWriter {

    public void SaveValues(Map<String, String> result, String outputResourcePath)
            throws JsonGenerationException, JsonMappingException, IOException {

        // create object mapper
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        // create list of objects
        List<ObjectNode> dataList = new ArrayList<>();

        ObjectNode root = objectMapper.createObjectNode();

        for (Map.Entry<String, String> res : result.entrySet()) {
            ObjectNode object = objectMapper.createObjectNode(); // create a new object for each entry
            object.put("name", res.getKey());
            object.put("roundedValue", res.getValue());
            dataList.add(object); // add the new object to the list
        }
        // create root object and add list of objects
        root.putPOJO("result", dataList);

        writeResultToJsonFile(outputResourcePath, objectMapper, root);
    }

    private void writeResultToJsonFile(String outputResourcePath, ObjectMapper objectMapper, ObjectNode root)
            throws JsonGenerationException, JsonMappingException, IOException {
        String projectRootDir = System.getProperty("user.dir"); // get the project's root directory

        String filePath = projectRootDir + "/src/main/resources/" + outputResourcePath;
        // the project's root
        File file = new File(filePath); // create a File object using the path

        if (!file.exists()) {
            file.createNewFile();
        }

        objectMapper.writeValue(file, root);
    }

}