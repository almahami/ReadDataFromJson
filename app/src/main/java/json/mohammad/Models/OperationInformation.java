package json.mohammad.Models;

import java.util.List;

public class OperationInformation {
    private String name;
    private String function;
    private List<String> field;

    private String filter;

    public OperationInformation(String name, String function, List<String> field, String filter) {
        this.name = name;
        this.function = function;
        this.field = field;
        this.filter = filter;
    }

    public String getName() {
        return name;
    }

    public String getFunction() {
        return function;
    }

    public List<String> getField() {
        return field;
    }

    public String getFilter() {
        return filter;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void setField(List<String> field) {
        this.field = field;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    @Override
    public String toString() {
        return "Operation [name=" + name + ", function=" + function + ", field=" + field + ", filter=" + filter + "]";
    }

}
