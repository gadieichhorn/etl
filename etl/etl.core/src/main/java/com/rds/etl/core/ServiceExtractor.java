/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rds.etl.core;

import com.rds.etl.common.Extractor;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Gadi
 */
class ServiceExtractor implements Extractor {

    private String url;
    private static final Logger logger = LoggerFactory.getLogger(ServiceExtractor.class);

    public ServiceExtractor(String url) {
        this.url = url;
    }

    ServiceExtractor() {
    }

    @Override
    public String process() {
        try (java.util.Scanner s = new java.util.Scanner(new java.net.URL(url).openStream())) {
            return s.useDelimiter("\\A").next();
        } catch (IOException ex) {
            logger.error("IOException", ex);
            throw new RuntimeException(ex);
        }
    }

}
