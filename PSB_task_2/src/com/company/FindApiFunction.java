package com.company;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

public class FindApiFunction {
    public static Map<String, String> findMostUsedApiFunctions(ArrayList<LogObject> logObjects) {
        Map<String, String> nameApiFunction = new HashMap<>(); //  мапа для возврата методом
        Map<String, Map<String, Integer>> countApiFunctions = new HashMap<>(); // мапа мап (имя (апи, количество запросов)

        for (int i = 0; i < logObjects.size(); i++) {
            countApiFunctions.put(logObjects.get(i).getName(), new HashMap<String, Integer>());
        } // кладем в мапу имена, апи и кол-во запросов пока пустые

        for (Map.Entry<String, Map<String, Integer>> entry1 : countApiFunctions.entrySet()) {
            for (int j = 0; j < logObjects.size(); j++) {
                if (entry1.getKey().equals(logObjects.get(j).getName())) {
                    entry1.getValue().put(logObjects.get(j).getApiFunction(), 0);
                }
            }
        }// кладем в мапу апи

        for (Map.Entry<String, Map<String, Integer>> entry1 : countApiFunctions.entrySet()) {
            for (int j = 0; j < logObjects.size(); j++) {
                if (entry1.getKey().equals(logObjects.get(j).getName())) {
                    for (Map.Entry<String, Integer> entry2 : entry1.getValue().entrySet()) {
                        if (entry2.getKey().equals(logObjects.get(j).getApiFunction())) {
                            entry2.setValue(entry2.getValue() + 1);
                        }
                    }
                }
            }
        } // считаем кол-во запросов каждого апи

        for (Map.Entry<String, Map<String, Integer>> entry : countApiFunctions.entrySet()) {
            nameApiFunction.put(entry.getKey(), Collections.max(entry.getValue().entrySet()
                    , Comparator.comparingInt(Map.Entry::getValue))
                    .getKey());
        } // находим апи с макс кол-вом запросов и кладем в финальную мапу

        return nameApiFunction;
    }

    public static void printMap(Map<String, String> map, BufferedWriter bufferedWriter) throws IOException { // выводим результат

        for (Map.Entry<String, String> entry : map.entrySet()) {
            bufferedWriter.write(entry.getKey() + " - " + entry.getValue());
            bufferedWriter.write(System.lineSeparator());
        }
    }
}

