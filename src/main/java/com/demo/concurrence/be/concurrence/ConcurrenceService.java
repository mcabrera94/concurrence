package com.demo.concurrence.be.concurrence;

import com.demo.concurrence.be.constans.CommonConstans;
import com.demo.concurrence.be.utils.Task;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class ConcurrenceService implements CommonConstans {

    public int[] getNumbers(String listNumbers) {
        Map < String, Object > mapResult = new HashMap< String, Object >();
        int[] numbersArray = new int[0];
        try {
            String cleanNumbers = listNumbers.replace(OPEN_BRACKET, EMPTY).replace(CLOSED_BRACKET, EMPTY);
            numbersArray = Arrays.stream(cleanNumbers.split(COMMA)).mapToInt(Integer::parseInt).toArray();
        } catch (Exception e ) {
            mapResult.put(TYPE, MESSAGE_TYPE_ERROR);
            mapResult.put(MESSAGE, MESSAGE_ERROR);
        }
        return numbersArray;
    }

    public String getOperator(String operator) {
        Map < String, Object > mapResult = new HashMap< String, Object >();
        String symbol = EMPTY;
        try {
            symbol = operator;
        } catch (Exception e) {
            mapResult.put(TYPE, MESSAGE_TYPE_ERROR);
            mapResult.put(MESSAGE, MESSAGE_ERROR);
        }
        return symbol;
    }

    public Map<String, Object> executeThread(int id, int[] numbers, String symbol) {
        Map < String, Object > mapResult = new HashMap< String, Object >();
        try {
            double value = 0;
            Task task = new Task(ONE, numbers, symbol);
            task.start();
            Thread.sleep(1000);
            value = task.getValue();

            mapResult.put(TYPE, MESSAGE_TYPE_SUCCESS);
            mapResult.put(MESSAGE, MESSAGE_TYPE_SUCCESS);
            mapResult.put(RESULT, value);
        } catch (Exception e) {
            mapResult.put(TYPE, MESSAGE_TYPE_ERROR);
            mapResult.put(MESSAGE, MESSAGE_ERROR);
        }
        return mapResult;
    }
}
