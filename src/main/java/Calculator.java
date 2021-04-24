import lombok.*;
import java.util.*;

@RequiredArgsConstructor(staticName = "input")
public class Calculator {

    @Getter
    private final TreeMap<Integer, Double> bundles;

    @Getter
    private final int orderNum;

    public Double calculate() {

        List<Integer> bundlesNum = new ArrayList<>(getBundles().navigableKeySet());
        List<Double> price = new ArrayList<>(getBundles().values());
        int n = bundlesNum.size();
        double[] dp = new double[orderNum + 1];

        for ( int i = 0 ; i < dp.length; i++) {
            dp[i] = Double.MAX_VALUE;
        }

        dp[0] = 0;
        for(int i = 0; i < n; i++) {
            for(int j = bundlesNum.get(i); j < dp.length; j++) {
                dp[j] = Math.min(dp[j], dp[(j - bundlesNum.get(i))] + price.get(i));
            }
        }
        double sum = dp[orderNum];
        return sum;
    }

}
