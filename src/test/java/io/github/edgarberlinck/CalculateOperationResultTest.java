package io.github.edgarberlinck;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import io.github.edgarberlinck.handlers.ResourceHandler;
import io.github.edgarberlinck.model.MarketData;
import io.github.edgarberlinck.model.Operation;
import io.github.edgarberlinck.readers.CsvReader;

public class CalculateOperationResultTest {
    private final String OPERATION_RESOURCE_NAME = "Operacoes.csv";
    private final String MARKET_DATA_RESOURCE_NAME = "DadosMercado.csv";
    private Map<String, ArrayList<Serializable>> operationList;
    private Map<String, ArrayList<Serializable>> marketDataList;
    private ResourceHandler resourceHandler = new ResourceHandler();
    private CsvReader csvReader = new CsvReader();
    
    @Before
    public void setUpCollections () {
        operationList = csvReader.processCsvFile(resourceHandler.readResource(OPERATION_RESOURCE_NAME));
        marketDataList = csvReader.processCsvFile(resourceHandler.readResource(MARKET_DATA_RESOURCE_NAME));
    }


    @Test
    public void shoultCalculateOperationResultGivenAExistingIdentifier() {
        final String ID_PRECO = "7829";

        ArrayList<Serializable> marketData = null;
        Operation operation = null;

        for (Serializable given : operationList.get(ID_PRECO)) {
            operation = (Operation) given;            
            marketData = marketDataList.get(ID_PRECO);
        }

        assertNotNull(operation);
        assertNotNull(marketData);
        assertEquals(1, marketData.size());
    }
}