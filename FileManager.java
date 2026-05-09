package hospital_appointments_management_system;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

    private BufferedReader reader;
    private ArrayList<String> lines;
    private String filName;

    public FileManager(String filName) throws IOException {
        this.lines = new ArrayList<>();
        this.reader = new BufferedReader(new FileReader(filName));
        this.filName = filName;
    }

    public void fileWriter(String L) throws IOException {
        this.lines.add(L);
    }

    public void saveData() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.filName))) {
            for (int i = 0; i < this.lines.size(); i++) {
                String line = this.lines.get(i);
                writer.write(line);
                writer.newLine();
            }
        }
    }

    public static void saveData(String fileName, ArrayList<String> lines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Critical Error: Could not save data to " + fileName);
        }
    }

    public ArrayList<String> loadData() throws IOException {
        ArrayList<String> data = new ArrayList<>();
        String line;
        while ((line = this.reader.readLine()) != null) {
            if (!line.trim().isEmpty()) {
                data.add(line);
            }
        }
        return data;
    }
}
