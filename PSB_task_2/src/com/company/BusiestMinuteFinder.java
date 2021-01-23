package com.company;

import java.io.BufferedWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BusiestMinuteFinder {

    public static void findBusiestMinute (ArrayList<LogObject> objects, BufferedWriter bufferedWriter) throws IOException {
        Map<String, Map<String, Integer>> countMinutes = new HashMap<>(); // мапа мап (имя (апи, количество запросов)
        SimpleDateFormat dt = new SimpleDateFormat("dd.MM.yy HH:mm");

        for (int i = 0; i < objects.size(); i++) {
            countMinutes.put(dt.format(objects.get(i).getDate()), new HashMap<String, Integer>());
        } // кладем в мапу  минуты, апи и кол-во запросов пока пустые
        for (Map.Entry<String, Map<String, Integer>> entry1 : countMinutes.entrySet()) {

            entry1.getValue().put("/sendData", 0);
            entry1.getValue().put("/receiveData", 0);

        }// кладем в мапу апи
        for (Map.Entry<String, Map<String, Integer>> entry1 : countMinutes.entrySet()) {
            for (int j = 0; j < objects.size(); j++) {
                if (entry1.getKey().equals(dt.format(objects.get(j).getDate()))) {
                    for (Map.Entry<String, Integer> entry2 : entry1.getValue().entrySet()) {
                        if (entry2.getKey().equals(objects.get(j).getApiFunction())) {
                            entry2.setValue(entry2.getValue() + objects.get(j).getMessageByte());
                        }
                    }
                }
            }
        } // считаем байты
        Map<String, Integer> minuteTotalByte = new HashMap<String, Integer>();

        for (Map.Entry<String, Map<String, Integer>> entry : countMinutes.entrySet()) {
            int bytes = 0;
            for (Map.Entry<String, Integer> entry2 : entry.getValue().entrySet()) {
                bytes += entry2.getValue();
            }
            minuteTotalByte.put(entry.getKey(), bytes);
        }  // считаем общее кол-во байт

        String min = Collections.max(minuteTotalByte.entrySet()
                , Comparator.comparingInt(Map.Entry::getValue))
                .getKey(); // находим минуту с макс байтами


        int byteSent = 0;
        int byteReceived = 0;

        for (Map.Entry<String, Map<String, Integer>> entry1 : countMinutes.entrySet()) {
            if (entry1.getKey().equals(min)) {
                for (Map.Entry<String, Integer> entry2 : entry1.getValue().entrySet()) {
                    if (entry2.getKey().equals("/sendData")) {
                        byteSent = entry2.getValue();
                    }
                    if (entry2.getKey().equals("/receiveData")) {
                        byteReceived = entry2.getValue();
                    }
                }
            }
        } //  записываем в переменные полученные и отправленные байты для найденной минуты


        bufferedWriter.write("[" + min + "]");
        bufferedWriter.write(System.lineSeparator());
        bufferedWriter.write("byte sent - " + byteSent);
        bufferedWriter.write(System.lineSeparator());
        bufferedWriter.write("byte received - " + byteReceived);
        bufferedWriter.write(System.lineSeparator());
    }
}
