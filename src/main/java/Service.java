import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.TreeMap;

@RequiredArgsConstructor(staticName = "input")
public class Service {

    @Getter
    private  final FormatCode orderItem;

    @Getter
    private final int orderNum;

    private double invokeCalculator() {
        TreeMap<Integer, Double> bundles = PriceTable.getPriceTable().getBundles(getOrderItem());
         return Calculator.input(bundles, getOrderNum()).calculate();
    }

    @Override
    public String toString() {
        double sum  = invokeCalculator();
        return String.format("%d %s $%.2f \n", orderNum, orderItem, sum );
    }
}
