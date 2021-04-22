import lombok.*;
import java.util.*;

@RequiredArgsConstructor(staticName = "input")
public class Calculator {

    @Getter
    private Map<FormatCode,TreeMap<Integer, Double>> priceTable;
    {
       priceTable = new HashMap<>(){{
           put(FormatCode.IMG, new TreeMap<Integer, Double>() {{
               put(5, 450.00);
               put(10, 800.00);}});
           put(FormatCode.FLAC, new TreeMap<Integer, Double>() {{
               put(3, 427.50);
               put(6, 810.00);
               put(9, 1147.50);}});
           put(FormatCode.VID, new TreeMap<Integer, Double>() {{
               put(3, 570.00);
               put(5, 900.00);
               put(9, 1530.00);}});
       }};
    }


    @Getter
    private final FormatCode inputFormatCode;

    @Getter
    private final int inputBundleNum;

    public String calculate() {
        TreeMap<Integer, Double> map = priceTable.get(inputFormatCode);
        int n1 = inputBundleNum /  map.lastKey();
        int n2 = inputBundleNum %  map.lastKey() / map.lowerKey(map.lastKey());
        int n3 = inputBundleNum %  map.lastKey() % map.lowerKey(map.lastKey()) / map.firstKey() > 0
                ? inputBundleNum %  map.lastKey() % map.lowerKey(map.lastKey()) / map.firstKey() + 1
                : inputBundleNum %  map.lastKey() % map.lowerKey(map.lastKey()) / map.firstKey();

        double sum = n1 * priceTable.get(inputFormatCode).get(map.lastKey()) +
                     n2 * priceTable.get(inputFormatCode).get(map.lowerKey(map.lastKey())) +
                     n3 * priceTable.get(inputFormatCode).get(map.firstKey());

        return String.format("%d %s $%.2f \n", inputBundleNum, inputFormatCode, sum );
    }
}
