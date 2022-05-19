package Task3;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class task3 {
    public static void main(String[] args) throws ParseException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] delim = (reader.readLine()).split(" ");
        reader.close();

        String tests = delim[0];
        String values = delim[1];

        StringBuilder stringBuilderValues = new StringBuilder();
        StringBuilder stringBuilderTests = new StringBuilder();

        try (BufferedReader in = new BufferedReader(new FileReader(values))) {
            String inputValues;
            while ((inputValues = in.readLine()) != null) {
                stringBuilderValues.append(inputValues);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader in = new BufferedReader(new FileReader(tests))) {
            String inputTests;
            while ((inputTests = in.readLine()) != null) {
                stringBuilderTests.append(inputTests);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject jsonObjectValues = (JSONObject) JSONValue.parseWithException(stringBuilderValues.toString());
        JSONArray jsonValues = (JSONArray) jsonObjectValues.get("values");
        JSONObject valuesData;
        Map<Object, Object> map = new HashMap<>();
        List<String> value = new ArrayList<>();
        for (int i = 0;i<jsonValues.size();i++){
            valuesData = (JSONObject) jsonValues.get(i);
            map.put(valuesData.get("id"), valuesData.get("value"));
            value.add((String) valuesData.get("value"));
        }


        String result = String.valueOf(stringBuilderTests).replaceAll("\\s","");

        Matcher pattern = Pattern.compile("value\":").matcher(result);

        List<Integer> position = new ArrayList<>();
        while (pattern.find()){
            position.add(pattern.start());
        }

        StringBuilder stringBuilder = new StringBuilder(result);

        for (int i = position.size()-1; i>=0;i--){
            stringBuilder.insert(position.get(i)+8,value.get(i));
        }

        JSONObject jsonObject = (JSONObject) JSONValue.parseWithException(stringBuilder.toString());

        Files.write(Paths.get("report.json"), jsonObject.toJSONString().getBytes());
    }
}
