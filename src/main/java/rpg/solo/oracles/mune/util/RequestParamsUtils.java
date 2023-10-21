package rpg.solo.oracles.mune.util;

import java.util.List;
import java.util.Map;

public class RequestParamsUtils {
    public static String getSpuriousParamsStr(Map<String,String> params, List<String> expectedParams) {
        StringBuilder strBuilder = new StringBuilder();

        for (String expectedParam : expectedParams) {
            params.remove(expectedParam);
        }

        if (!params.isEmpty()) {
            params.keySet().forEach(s -> {
                if (!strBuilder.isEmpty()) {
                    strBuilder.append(", ");
                }
                strBuilder.append(s);
            });
        }

        return strBuilder.toString();
    }
}
