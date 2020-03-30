package io.github.edgarberlinck.readers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

import io.github.edgarberlinck.model.*;

public class CsvReader {
    public Map<String, ArrayList<Serializable>> processCsvFile(File csv) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(csv));
            Map<String, ArrayList<Serializable>> output = new HashMap<String, ArrayList<Serializable>>();
            String line;
            String header = br.readLine();
        
            Boolean isFileOperaco = (header.split(";").length > 3); 

            ArrayList<Serializable> data;
            String[] records;
            
            // @TODO: Refactor me, for the love of GOD!!!!
            while ((line = br.readLine()) != null) {
                records = line.split(";");
                if (isFileOperaco) {
                    data = output.get(records[13]);
                    if (data == null) {
                        data = new ArrayList<Serializable>();
                    }
                    data.add(new Operacao(records[0], records[9], records[12]));

                    output.put(records[13], data);
                } else {
                    data = output.get(records[0]);
                    if (data == null) {
                        data = new ArrayList<Serializable>();
                    }
                    data.add(new DadoMercado(records[2]));

                    output.put(records[0], data);
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