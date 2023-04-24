package json.mohammad.Models;

import java.util.ArrayList;
import java.util.List;

public class Data {
  private List<Entry> entries;

  public Data() {
    entries = new ArrayList<>();
  }

  public List<Entry> getEntries() {
    return entries;
  }

  public void setEntries(List<Entry> entries) {
    this.entries = entries;
  }

  public void addEntry(Entry entry) {
    entries.add(entry);
  }

}
