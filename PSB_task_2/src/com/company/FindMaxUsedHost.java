package com.company;

import java.io.BufferedWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FindMaxUsedHost {
    public static String findMaxUsedHost(ArrayList<LogObject> objects) {
        Map<String, Integer> hosts = new HashMap<String, Integer>();
        for (int i = 0; i < objects.size(); i++) {
            hosts.put(objects.get(i).getHost(), 0);
        }
        for (Map.Entry<String, Integer> entry1 : hosts.entrySet()) {
            for (int j = 0; j < objects.size(); j++) {
                if (entry1.getKey().equals(objects.get(j).getHost())) {
                    entry1.setValue(entry1.getValue() + 1);
                }
            }
        }
        return Collections.max(hosts.entrySet()
                , Comparator.comparingInt(Map.Entry::getValue))
                .getKey();
    }

    public static void findFirstLastConnectionTime(ArrayList<LogObject> object, BufferedWriter bufferedWriter) throws IOException {
        ArrayList<Date> date = new ArrayList<>();
        String host = findMaxUsedHost(object);
        for (int i = 0; i < object.size(); i++) {
            if (object.get(i).getHost().equals(host)) {
                date.add(object.get(i).getDate());
            }
        }

        SimpleDateFormat dt = new SimpleDateFormat("dd.MM.yy HH:mm:ss");
        String minDate = dt.format(Collections.min(date));
        String maxDate = dt.format(Collections.max(date));
        bufferedWriter.write(host);
        bufferedWriter.write(System.lineSeparator());
        bufferedWriter.write("First connection time - [" + minDate + "]");
        bufferedWriter.write(System.lineSeparator());
        bufferedWriter.write("Last connection time - [" + maxDate + "]");
        bufferedWriter.write(System.lineSeparator());

    }
}
