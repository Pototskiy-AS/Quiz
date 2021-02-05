package test.quiz;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Settings {
    private String name = "Name";
    private int total_questions = 5;
    private int seconds = 10;
    private String fileQuestion = "D:\\JAVA\\JAVA\\src\\test\\quiz\\questions.json";
    private static final File fileSettings = new File("D:\\JAVA\\JAVA\\src\\test\\quiz\\settings.json");
    private static final File fileScores = new File("D:\\JAVA\\JAVA\\src\\test\\quiz\\score.json");

    public Settings(String name, int total_questions) {
        this.name = name;
        this.total_questions = total_questions;
    }

    public Settings() {
    }

    // запись заработанных очков
    public static void scoresWriter(Scores score) {
        List<Scores> scores = scoresReader();
        scores.add(score);
        scores = scores.stream()
                .sorted((o1, o2) -> o2.getScore()-o1.getScore())
                .limit(5)
                .collect(Collectors.toCollection(LinkedList::new));
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        try {
            objectMapper.writeValue(fileScores, scores);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // чтение заработанных очков
    public static List<Scores> scoresReader() {
        byte[] jsonData = new byte[0];
        try {
            jsonData = Files.readAllBytes(Paths.get(fileScores.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return Arrays.stream(objectMapper.readValue(jsonData, Scores[].class))
                    .limit(5)
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //чтение вопросов из файла в массив
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

    //чтение настроек из файла
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
