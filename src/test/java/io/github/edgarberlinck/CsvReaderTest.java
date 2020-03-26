package io.github.edgarberlinck;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.Serializable;
import java.util.Map;

import org.junit.Test;

import io.github.edgarberlinck.handlers.*;
import io.github.edgarberlinck.readers.*;

public class CsvReaderTest {
    private ResourceHandler resourceHandler = new ResourceHandler();
    private CsvReader csvReader = new CsvReader();
    private final String OPERATION_RESOURCE_NAME = "Operacoes.csv";
    private final String MARKET_DATA_RESOURCE_NAME = "DadosMercado.csv";

    @Test
    public void shouldReturnAnExistingKeyForOperationFileTest () {
        File resource = resourceHandler.readResource(OPERATION_RESOURCE_NAME);
        Map<String, Serializable> output = csvReader.processCsvFile(resource);

        assertTrue("Key 7860 not found. Sucker", output.containsKey("7860"));
    }
    
    @Test
    public void shouldReturnAnExistingKeyForMarketDataFileTest () {
        File resource = resourceHandler.readResource(MARKET_DATA_RESOURCE_NAME);
        Map<String, Serializable> output = csvReader.processCsvFile(resource);

        assertTrue("Key 7829 not found. Sucker", output.containsKey("7829"));
    }
}