import lombok.extern.java.Log;
import picocli.CommandLine;
import java.util.List;
import java.util.stream.Collectors;

@Log
@CommandLine.Command(name = "BundleCalculator",
        showAtFileInUsageHelp = true)
public class BundleCalculator implements Runnable {

    static class Bundles {
        @CommandLine.Parameters( index = "0", description = "The number of items")
        int bundlesNum;
        @CommandLine.Parameters( index = "1", description = "FormatCode: ${COMPLETION-CANDIDATES}")
        FormatCode formatCode;
    }

    @CommandLine.ArgGroup(exclusive = false, multiplicity = "1..*")
    List<Bundles> bundlesList;

    @Override
    public void run() {
        bundlesList.stream()
                   .map(e -> Calculator.input(e.formatCode, e.bundlesNum).calculate())
                   .collect(Collectors.toList())
                   .forEach(log::info);
    }

    public static void main(String[] args) {
        new CommandLine(new BundleCalculator()).execute(args);
    }
}
