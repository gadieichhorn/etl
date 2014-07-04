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
    public void canCreateExtractor() {
        ServiceExtractor extractor = new ServiceExtractor();
        assertNotNull(extractor);
    }

    @Test (expected = RuntimeException.class)
    public void cannotExtractDataFromSource() {
        ServiceExtractor extractor = new ServiceExtractor();
        Object result = extractor.process();
    }
    
    @Test
    public void  ExtractDataFromSource() {
        Extractor mock = Mockito.mock(Extractor.class);
        Mockito.when(mock.process()).thenReturn("test");
        assertEquals(mock.process(), "test");
    }    

    @Test(expected = RuntimeException.class)
    public void  ExtractDataFromServiceSource() {
        Extractor instance = new ServiceExtractor();
        instance.process();
    }    

    @Test
    public void  ExtractDataFromServiceSourceWithURL() {
        Extractor instance = new ServiceExtractor("http://apps.shareholder.com/rss/rss.aspx?channels=632&companyid=YHOO&sh_auth=3301454858%2E0%2E0%2E41825%2E640c0b4a5876873d9e17af039237cd42");
        assertFalse(instance.process().isEmpty());
        assertTrue(instance.process().startsWith("<rss"));
    }    
    
}
