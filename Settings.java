package test.quiz;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Settings {
    private String name = "Name";
    private int total_questions = 5;
    private int seconds = 10;
    private String fileQuestion = "D:\\JAVA\\JAVA\\src\\test\\quiz\\questions.json";
    private static final File fileSettings = new File("D:\\JAVA\\JAVA\\src\\test\\quiz\\settings.json");

    public Settings(String name, int total_questions) {
        this.name = name;
        this.total_questions = total_questions;
    }

    public Settings() {
    }

    //запись из массива в файл( Будет использоваться для записи очков )
    public static void jsonWriter(List<Object> questions, File file) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        try {
            objectMapper.writeValue(file, questions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //чтение из файла в массив
    public List<Question> questionReader() {
        byte[] jsonData = new byte[0];
        try {
            jsonData = Files.readAllBytes(Paths.get(fileQuestion));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return Arrays.asList(objectMapper.readValue(jsonData, Question[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //сохранение настроек
    public static void settingsWriter(Settings setting) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        try {
            objectMapper.writeValue(fileSettings, setting);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //чтение из файла в массив
    public static Settings settingsReader() {
        byte[] jsonData = new byte[0];
        try {
            jsonData = Files.readAllBytes(Paths.get(fileSettings.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(jsonData, Settings.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Settings readSettings() {
        return Settings.settingsReader();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal_questions() {
        return total_questions;
    }

    public void setTotal_questions(int total_questions) {
        this.total_questions = total_questions;
    }

    public int getSeconds() {
        return seconds;
    }

    public String getFileQuestion() {
        return fileQuestion;
    }

    public void setFileQuestion(String fileQuestion) {
        this.fileQuestion = fileQuestion;
    }

    public static File getFileSettings() {
        return fileSettings;
    }


}
