package edu.rafael.exceptions;

import javax.swing.*;
import java.io.*;

public class CustomException_1 {
    public static void main(String[] args) {
        String fileName = JOptionPane.showInputDialog(null, "File name to be printed: ");

        printArchiveInConsole(fileName);
        System.out.println("Perhaps the exception or not, the program still running...");

    }

    public static void printArchiveInConsole(String fileName) {

        try {
            BufferedReader br = readFile(fileName);
            String line = br.readLine();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            do {
                bw.write(line);
                bw.newLine();
                line = br.readLine();
            } while (line != null);
            bw.flush();
            br.close();

        } catch (ImpossibleOpenFileException e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage());
            e.printStackTrace();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                    "An unexpected error occurred. Please, contact support.\n" + ex.getMessage());
            ex.getStackTrace();
        }

    }

    public static BufferedReader readFile(String fileName) throws ImpossibleOpenFileException {
        File file = new File(fileName);
        try {
            return new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            throw new ImpossibleOpenFileException(file.getName(), file.getPath());
        }
    }
}

class ImpossibleOpenFileException extends Exception {
    private String fileName;
    private String directory;

    public ImpossibleOpenFileException(String fileName, String directory) {
        super("File " + fileName + " was not found in directory " + directory);
        this.fileName = fileName;
        this.directory = directory;
    }

    @Override
    public String toString() {
        return "ImpossibleOpenFileException{" +
                "fileName='" + fileName + '\'' +
                ", directory='" + directory + '\'' +
                '}';
    }
}