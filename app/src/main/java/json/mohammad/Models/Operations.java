package json.mohammad.Models;

import java.util.ArrayList;
import java.util.List;

public class Operations {
    private List<OperationInformation> Operations;

    public Operations() {
        Operations = new ArrayList<>();
    }

    public List<OperationInformation> getOperations() {
        return Operations;
    }

    public void setOperations(List<OperationInformation> operations) {
        Operations = operations;
    }

    public void addOperation(OperationInformation operation) {
        Operations.add(operation);
    }

}
