package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Scanner;

public class Task03 {
    public static void main (String[] args) throws ParseException, IOException {
//        CreateJsonFile();
//        AddToJsonFile();
        ParseJson();


    }

    public static void AddToJsonFile() {
        Scanner scan = new Scanner(System.in);
        JSONParser pars = new JSONParser();

        try {
            Object obj = pars.parse(new FileReader("bd.json"));
            JSONArray jsonArray = (JSONArray)obj;

            System.out.println(jsonArray);
            System.out.println("Введите фамилию ");
            String surname = scan.nextLine();
            System.out.println("Введите оценку ");
            String grade = scan.nextLine();
            System.out.println("Введите предмет ");
            String subject = scan.nextLine();

            JSONObject student = new JSONObject();
            student.put("Фамилия", surname);
            student.put("Оценка", grade);
            student.put("Предмет", subject);


            jsonArray.add(student);

            System.out.println(jsonArray);

            FileWriter file = new FileWriter("bd.json");
            file.write(jsonArray.toJSONString());
            file.flush();
            file.close();

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

    }

    public static void CreateJsonFile() {
        JSONArray list = new JSONArray();
        JSONObject student = new JSONObject();
        student.put("Фамилия", "Иванов");
        student.put("Оценка", "5");
        student.put("Предмет", "Математика");
        list.add(student);

        try (FileWriter file = new FileWriter("bd.json")){
            file.write(list.toJSONString());
            file.flush();
        } catch (IOException e){
            System.out.println();
        }
    }

    public static void ParseJson() throws ParseException {
        JSONParser parser = new JSONParser();
        StringBuilder build = new StringBuilder();
        HashMap <String, String> map = new HashMap<>();
        try (Reader reader = new FileReader("bd.json")) {
            Object obj = parser.parse(reader);
            JSONArray student = (JSONArray)obj;

            for (Object object : student) {
                JSONObject jsonObject = (JSONObject) parser.parse(object.toString());
                for (Object ob: jsonObject.keySet()){
                    map.put(ob.toString(), jsonObject.get(ob).toString());
                }
                build.append("Студент " + map.get("Фамилия") + " получил " + map.get("Оценка") +
                            " по предмету " + map.get("Предмет") + "\n");
            }

        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(build);

    }

}
