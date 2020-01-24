package com.example.tulips.sample;

import android.content.Context;
import android.util.Log;

import com.example.tulips.R;
import com.example.tulips.model.Character;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JSONData {
    public static List<Character> characterList;

    static {
        characterList = new ArrayList<>();
    }

    public static List<Character> getJSON(Context context){
        String json = null;
        json = loadJSONFromRes(context); //load JSON from resource
        characterList = parseJSON(json); //parse JSON
        return characterList;
    }

    private static String loadJSONFromRes(Context context) {
        //opens the raw JSON file and assigns it to an InputStream instance
        InputStream inputStream = context.getResources().openRawResource(R.raw.harrypotter);

        //stores the JSON as a String
        String jsonString = new Scanner(inputStream).useDelimiter("\\A").next();

        // https://stackoverflow.com/questions/6349759/using-json-file-in-android-app-resources
        // This uses the Java class Scanner, leading to less lines of code than some other methods of reading a simple text / json file. The delimiter pattern \A means 'the beginning of the input'. .next() reads the next token, which is the whole file in this case.

//        InputStream inputStream = null;
//        String jsonString = null;
//        try {
//            inputStream = context.getResources().openRawResource(R.raw.harrypotter);
//
//            int size = inputStream.available();
//            byte[] buffer = new byte[size];
//            inputStream.read(buffer);
//            jsonString = new String(buffer, "UTF-8");
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//            return null;
//        } finally {
//            try {
//                inputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        return jsonString;
    }

    private static List<Character> parseJSON(String jsonString){
        if (jsonString != null) {
            try {
                //create JSONObject
                JSONObject jsonObject = new JSONObject(jsonString);

                //create JSONArray with the value from the characters key
                JSONArray characterArray = jsonObject.getJSONArray("characters");

                //loop through each object in the array
                for (int i =0; i < characterArray.length(); i++) {
                    JSONObject charObject = characterArray.getJSONObject(i);

                    //get values for name and info keys
                    String name = charObject.getString("name");
                    String info = charObject.getString("info");

                    //create new Character object
                    Character character = new Character(name, info);

                    //add character object to our ArrayList
                    characterList.add(character);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return characterList;
    }
}
