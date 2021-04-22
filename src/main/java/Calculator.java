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

    public TreeMap<Integer, Double> getBundles(FormatCode formatCode) {
        return priceTable.get(formatCode);
    }

    public void addBundlesNum(FormatCode formatCode, int bundlesNum, double price) {
        priceTable.get(formatCode).put(bundlesNum, price);
    }

    public void deleteBundlesNum(FormatCode formatCode, int bundlesNum) {
        priceTable.get(formatCode).remove(bundlesNum);
    }

    public void updateBundlesNum(FormatCode formatCode, int oldBundlesNum, int newBundlesNum) {
        double value = priceTable.get(formatCode).get(oldBundlesNum);
        deleteBundlesNum(formatCode, oldBundlesNum);
        addBundlesNum(formatCode, newBundlesNum, value);
    }

    public void updateBundlesPrice(FormatCode formatCode, int bundlesNum, double price) {
        priceTable.put(formatCode, new TreeMap<Integer, Double>() {{
            put(bundlesNum ,price);
        }});

    }


    public String calculate() {
        TreeMap<Integer, Double> map = getBundles(inputFormatCode);
        int n1 = inputBundleNum /  map.lastKey();
        int n2 = inputBundleNum %  map.lastKey() / map.lowerKey(map.lastKey());
        int n3 = inputBundleNum %  map.lastKey() % map.lowerKey(map.lastKey()) / map.firstKey() > 0
                ? inputBundleNum %  map.lastKey() % map.lowerKey(map.lastKey()) / map.firstKey() + 1
                : inputBundleNum %  map.lastKey() % map.lowerKey(map.lastKey()) / map.firstKey();

        double sum = n1 * getBundles(inputFormatCode).get(map.lastKey()) +
                     n2 * getBundles(inputFormatCode).get(map.lowerKey(map.lastKey())) +
                     n3 * getBundles(inputFormatCode).get(map.firstKey());

        return String.format("%d %s $%.2f \n", inputBundleNum, inputFormatCode, sum );
    }
}
