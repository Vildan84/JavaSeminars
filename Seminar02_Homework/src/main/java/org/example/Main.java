package org.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import java.util.logging.*;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        CreateJsonFile();
        ParseJson();
        Integer[] arr = new Integer[]{4, 5, 2, 1, 0, 8, 7, -3, 17};
        BubbleSort(arr);

    }

    public static void CreateJsonFile() {
        JSONObject obj = new JSONObject();
        obj.put("name", "Ivanov");
        obj.put("country", "Russia");
        obj.put("city", "Moscow");
        obj.put("age", "null");

        try (FileWriter file = new FileWriter("base.json")){
            file.write(obj.toJSONString());
            file.flush();
        } catch (IOException e){
            System.out.println();
        }
    }

    public static void ParseJson() throws ParseException {
        JSONParser parser = new JSONParser();
        StringBuilder build = new StringBuilder("select * from students where ");
        try (Reader reader = new FileReader("base.json")) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            for (Object s: jsonObject.keySet()){
                if (!Objects.equals(jsonObject.get(s), "null")){
                    build.append(s.toString()).append("=").append(jsonObject.get(s));
                    build.append(" ");
                    build.append("AND");
                    build.append(" ");
                }
            }
            System.out.println(build.subSequence(0, build.length()-5));

            } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void BubbleSort(Integer[] arr) throws IOException {
        Logger logger = Logger.getLogger(Calculator.class.getName());
        FileHandler fh = new FileHandler("logSort.txt");
        logger.addHandler(fh);
        SimpleFormatter SFormat = new SimpleFormatter();
        fh.setFormatter(SFormat);
        for (int i = 0; i < arr.length - 1; i++){
            logger.log(Level.INFO,"Array " + Arrays.toString(arr));
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[i]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}