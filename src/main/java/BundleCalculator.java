import lombok.extern.java.Log;
import picocli.CommandLine;
import java.util.List;
import java.util.stream.Collectors;

@Log
@CommandLine.Command(name = "BundleCalculator",
        showAtFileInUsageHelp = true)
public class BundleCalculator implements Runnable {

    static class Order {
        @CommandLine.Parameters( index = "0", description = "The number of items")
        int orderNum;
        @CommandLine.Parameters( index = "1", description = "FormatCode: ${COMPLETION-CANDIDATES}")
        FormatCode orderItem;
    }

    @CommandLine.ArgGroup(exclusive = false, multiplicity = "1..*")
    List<Order> orderList;

    @Override
    public void run() {
        orderList.stream()
                   .map(e -> Service.input(e.orderItem, e.orderNum).toString())
                   .collect(Collectors.toList())
                   .forEach(log::info);
    }

    public static void main(String[] args) {
        new CommandLine(new BundleCalculator()).execute(args);
    }
}
