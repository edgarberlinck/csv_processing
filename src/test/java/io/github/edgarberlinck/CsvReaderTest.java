package io.github.edgarberlinck;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import io.github.edgarberlinck.handlers.*;
import io.github.edgarberlinck.model.Operation;
import io.github.edgarberlinck.readers.*;

public class CsvReaderTest {
    private ResourceHandler resourceHandler = new ResourceHandler();
    private CsvReader csvReader = new CsvReader();
    private final String OPERATION_RESOURCE_NAME = "Operacoes.csv";
    private final String MARKET_DATA_RESOURCE_NAME = "DadosMercado.csv";

    private Map<String, ArrayList<Serializable>> operationList;
    private Map<String, ArrayList<Serializable>> marketDataList;

    @Before
    public void setUpCollections () {
        operationList = csvReader.processCsvFile(resourceHandler.readResource(OPERATION_RESOURCE_NAME));
        marketDataList = csvReader.processCsvFile(resourceHandler.readResource(MARKET_DATA_RESOURCE_NAME));
    }

    @Test
    public void shouldReturnAnExistingKeyForOperationFileTest () {
        assertTrue("Key 7860 not found. Sucker", operationList.containsKey("7860"));
    }
    
    @Test
    public void shouldReturnAnExistingKeyForMarketDataFileTest () {
        assertTrue("Key 7829 not found. Sucker", marketDataList.containsKey("7829"));
    }

    @Test
    public void shouldNotOverrideOperationDataForGivenKey () {
        assertEquals(5, operationList.get("7860").size());
    }

    @Test
    public void shouldHaveTheCorrectOperationDataForTheGivemKey () {
        ArrayList<Serializable> expectedOperations = new ArrayList<>(5);
        expectedOperations.add(new Operation("722778690", "subphhh", "375000000"));
        expectedOperations.add(new Operation("722778711", "subphhh", "-495000000"));
        expectedOperations.add(new Operation("722778718", "subphhh", "-495000000"));
        expectedOperations.add(new Operation("722778743", "subphhh", "375000000"));
        expectedOperations.add(new Operation("722778764", "subphhh", "-125000000"));

        assertArrayEquals("Expected Operations did not match", expectedOperations.toArray(), operationList.get("7860").toArray());
    }

    @Test
    public void shouldNotHaveIncorrectOperationDataForTheGivemKey () {
        Serializable invalidOperation = (new Operation("722778702", "subphhh", "-495000000"));
        assertFalse("Unespected value on your collection, dumbass..", operationList.get("7860").contains(invalidOperation));
    }

}