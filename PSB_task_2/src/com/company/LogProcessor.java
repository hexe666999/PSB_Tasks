package com.company;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class LogProcessor {
    public static ArrayList<LogObject> processor(File file) {
        ArrayList<LogObject> logObjects = new ArrayList<>();

        try {
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String str = reader.readLine();
            while (str != null) {
                str = str.substring(1); // убираем "["
                String[] strings = str.split("]"); // разбиваем на 2 строки: дата и остальное
                String[] strings1 = strings[1].trim().split(" "); // разбиваем остальное по пробелу
                String[] ip = strings1[1].split("\\."); //чтобы отсеять ненужные хосты разбиваем хост
                // на 4 цифры и смотрим последнюю
                int host = Integer.parseInt(ip[3]);
                if (host >= 50 & host <= 100) {
                    str = reader.readLine();
                    continue; //  читаем следующую строку
                } else {
                    LogObject object1 = new LogObject();
                    object1.setDate(new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy", Locale.US).parse(strings[0]));
                    object1.setName(strings1[0]);
                    object1.setHost(strings1[1]);
                    object1.setApiFunction(strings1[2]);
                    try {
                        object1.setMessageByte(Integer.parseInt(strings1[3]));
                    }catch (NumberFormatException e){
                        object1.setMessageByte(0);
                    }
                    logObjects.add(object1);
                    str = reader.readLine();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return logObjects;
    }
}
