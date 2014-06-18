package com.webservice.example;
import org.junit.Test;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CalculatorTest {

  
    @Test
    public void test() throws Exception {
        Service calculatorService = Service.create(
                new URL("http://127.0.0.1:8080/ExampleSoapServices/Calculator?wsdl"),
                new QName("http://localhost:8080/ExampleSoapServices/Calculator?wsdl", "CalculatorService"));

        assertNotNull(calculatorService);

        CalculatorWs calculator = calculatorService.getPort(CalculatorWs.class);
        assertEquals(10, calculator.sum(4, 6));
        assertEquals(12, calculator.multiply(3, 4));
    }
}