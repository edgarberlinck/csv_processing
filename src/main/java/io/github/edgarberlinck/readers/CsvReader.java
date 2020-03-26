package io.github.edgarberlinck.readers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import io.github.edgarberlinck.model.*;

public class CsvReader {
    public Map<String, Serializable> processCsvFile(File csv) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(csv));
            Map<String, Serializable> output = new HashMap<String, Serializable>();
            String line;
            String header = br.readLine();
        
            Boolean isFileOperaco = (header.split(";").length > 3); 

            while ((line = br.readLine()) != null) {
                String[] records = line.split(";");
                if (isFileOperaco) {
                    output.put(records[13], new Operacao(records[0], records[9], records[12]));
                } else {
                    output.put(records[0], new DadoMercado(records[2]));
                }
            }
            br.close();

            return output;
        } catch (IOException io) {
            System.out.println("Se lascou!");
            return null;
        }
    }
}