package com.company.PSB_task_3;


import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;

public class RequestProcessor {

    public static String responseBuilder (String request) throws IOException {
        StringReader reader = new StringReader(request);
        ObjectMapper mapper = new ObjectMapper();
        RequestBody requestBody = mapper.readValue(reader, RequestBody.class);

        String op = requestBody.getOperation();

        int[] num = requestBody.getNumbers();
        int result = 0;

        if (op.equals("min")) {
            result = MathFunctions.findMin(num);
        } else if (op.equals("max")) {
            result = MathFunctions.findMax(num);
        } else if (op.equals("average")) {
            result = MathFunctions.findAvg(num);
        } else if (op.equals("median")) {
            result = MathFunctions.findMedian(num);
        } else
            num = MathFunctions.findPrime(num);

        if (!op.equals("prime")){
            num = new int[]{result};
        }

        return "{\n\"result\": " + Arrays.toString(num) + "\n}";
    }
}
