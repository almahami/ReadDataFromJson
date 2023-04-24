package json.mohammad.almahamid;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import json.mohammad.Models.Entry;
import json.mohammad.Models.OperationInformation;
import json.mohammad.Reader.DataReader;
import json.mohammad.Reader.OperationReader;
import json.mohammad.writer.OutputWriter;

public class JsonCalculator {
  private OutputWriter outputWriter;

  public JsonCalculator() {
    outputWriter = new OutputWriter();
  }

  public void Calculator(String dataResourcePath, String operationResourcePath, String outputResourcePath)
      throws IOException {

    DataReader dataReader = new DataReader();
    List<Entry> entries = dataReader.readEntries(dataResourcePath);

    OperationReader operationReader = new OperationReader();
    List<OperationInformation> operations = operationReader.readOperation(operationResourcePath);
    Map<String, String> result = new HashMap<>();
    DecimalFormat df = new DecimalFormat("0.00");

    for (OperationInformation operation : operations) {
      if (operation.getFunction().equals("average")) {
        double average = 0.0;
        int sum = 0;
        for (Entry entry : entries) {
          if (entry.getName().matches("M.*"))
            sum += entry.getPopulation();
        }
        average = sum / (entries.size() - 1);
        result.put(operation.getName(), df.format(average));
      }

      if (operation.getFunction().equals("sum")) {
        int sum = 0;
        for (Entry entry : entries) {
          if (entry.getName().matches(".*burg")) {
            sum += entry.getExtendedStatistics().getArea();
          }
        }
        result.put(operation.getName(), df.format(sum));
      }

      if (operation.getFunction().equals("min")) {
        List<Double> areas = new LinkedList<>();
        for (Entry entry : entries) {
          if (entry.getName().matches(".*n.+")) {
            areas.add(entry.getExtendedStatistics().getArea());
          }
        }

        areas.sort((o1, o2) -> o1.compareTo(o2));
        result.put(operation.getName(), df.format(areas.get(0)));
      }

      if (operation.getFunction().equals("max")) {
        List<Integer> population = new LinkedList<>();
        for (Entry entry : entries) {
          if (entry.getName().matches(".*e.*n.*")) {
            System.out.println(entry.getName() + " " + entry.getPopulation());
            population.add(entry.getPopulation());
          }
        }

        population.sort((o1, o2) -> o1.compareTo(o2));

        result.put(operation.getName(), df.format(population.get(population.size() - 1)));
      }

    }
    outputWriter.SaveValues(result, outputResourcePath);
  }

}
