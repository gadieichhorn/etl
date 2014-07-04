/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rds.etl.core;

import com.rds.etl.common.Extractor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 *
 * @author Gadi
 */
public class ExtractorTest {
    
    public ExtractorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
        
    @Test
    public void  ExtractDataFromSource() {
        Extractor mock = Mockito.mock(Extractor.class);
        Mockito.when(mock.process()).thenReturn("test");
        assertEquals(mock.process(), "test");
    }    

}
