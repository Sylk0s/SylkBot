package SylkBot;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import java.io.*;

public class SylkConfigs {

    private static final String path = "sylkConfigs.json";

    @Expose public String token;
    @Expose public String prefix;

    public static SylkConfigs setup() {
        try {
            File newConfigsFile = new File(path);
            if (newConfigsFile.createNewFile()) {
                SylkConfigs newConfigs = new SylkConfigs();
                newConfigs.token = "token";
                newConfigs.prefix = ".";
                newConfigs.saveObject();
                return newConfigs;
            } else {
                System.out.println("Found existing sylkConfigs.json");
                return setupObject();
            }
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }

    private static SylkConfigs setupObject() {
        try {
            Gson gson = new Gson();
            return gson.fromJson(new FileReader(path), SylkConfigs.class);
        } catch (FileNotFoundException e) {
            System.out.println("Somehow didnt fine the file???");
            return null;
        }
    }

    private void saveObject() {
        try {
            FileWriter writer = new FileWriter(path);
            new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create().toJson(this, writer);
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
