package edu.rafael.exceptions;

import javax.swing.*;
import java.io.*;

/*
 * Print an archive in console 
 */
public class CheckedException {
    public static void main(String[] args) {

        // String archiveName = "example.txt"; //this should work, as the archive exists
        String archiveName = "exampe.txt"; // Exception: it doesn't exist (file name misspelled).
        boolean loopingControl = true;

        try {
            printArchiveInConsole(archiveName);
            loopingControl = false;
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File doesn't exist! \nCheck if the file name is correct.");
        } catch (IOException e) { // IOException comes last beacuse it has a higher hierarchy.
            // If you place it first, its subclasses (e.g. FileNotFound) will not be catched
            JOptionPane.showMessageDialog(null, "An unexpected error occurred! Contact support: ");
            e.getStackTrace();
        } finally {
            System.out.println("The program is over!");
        }

        System.out.println("Perhaps the exception or not, the program still running...");
    }

    public static void printArchiveInConsole(String archiveName) throws IOException {
        File file = new File(archiveName);

        BufferedReader br = new BufferedReader(new FileReader(file.getName()));
        String line = br.readLine();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        do {
            bw.write(line);
            bw.newLine();
            line = br.readLine();
        } while (line != null);
        bw.flush();
        br.close();

    }
}
