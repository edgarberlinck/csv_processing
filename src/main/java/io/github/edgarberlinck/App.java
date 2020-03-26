package io.github.edgarberlinck;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public File readResource(String fileName) {
        try {
            return getClass().getClassLoader().getResource(fileName).getFile();
        } catch (IOException io) {
            System.out.println("Deu uma cagada de IO. Se fudeu!");
        } catch (FileNotFoundException fn) {
            System.out.println("O arquivo não existe, seu trouxa!");
        }
    }

    public void printFileContents (File file) {
        FileReader reader = new FileReader(file);
        BufferedReader br = new BufferedReader(reader);

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
 
    public static void main( String[] args ) {
        App app = new App();
        app.printFileContents(app.readResource("Operacoes.csv"));
    }
}
