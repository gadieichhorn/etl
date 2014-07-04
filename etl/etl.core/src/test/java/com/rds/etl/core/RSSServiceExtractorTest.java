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

/**
 *
 * @author Gadi
 */
public class RSSServiceExtractorTest {
    
    public RSSServiceExtractorTest() {
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
        RSSFeedExtractor extractor = new RSSFeedExtractor();
        assertNotNull(extractor);
    }

    @Test (expected = RuntimeException.class)
    public void cannotExtractDataFromSource() {
        new RSSFeedExtractor().process();
    }
    
    @Test(expected = RuntimeException.class)
    public void  ExtractDataFromServiceSource() {
        Extractor instance = new RSSFeedExtractor();
        instance.process();
    }    

    @Test
    public void  ExtractDataFromServiceSourceWithURL() {
        Extractor instance = new RSSFeedExtractor("http://apps.shareholder.com/rss/rss.aspx?channels=632&companyid=YHOO&sh_auth=3301454858%2E0%2E0%2E41825%2E640c0b4a5876873d9e17af039237cd42");
        assertFalse(instance.process().isEmpty());
        assertTrue(instance.process().startsWith("<rss"));
    }    
    
}
