import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@NoArgsConstructor(staticName = "getPriceTable")
public class PriceTable {

    private Map<FormatCode, TreeMap<Integer, Double>> priceTable;
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


    public TreeMap<Integer, Double> getBundles(FormatCode formatCode) {
        return priceTable.get(formatCode);
    }

    public void addBundlesNum(FormatCode formatCode, int num, double price) {
        priceTable.get(formatCode).put(num, price);
    }

    public void deleteBundlesNum(FormatCode formatCode, int num) {
        priceTable.get(formatCode).remove(num);
    }

    public void updateBundlesNum(FormatCode formatCode, int oldNum, int newNum) {
        double value = priceTable.get(formatCode).get(oldNum);
        deleteBundlesNum(formatCode, oldNum);
        addBundlesNum(formatCode, newNum, value);
    }

    public void updateBundlesPrice(FormatCode formatCode, int num, double newPrice) {
        priceTable.put(formatCode, new TreeMap<Integer, Double>() {{
            put(num ,newPrice);
        }});

    }
}
