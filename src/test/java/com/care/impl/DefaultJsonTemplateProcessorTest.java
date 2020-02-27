/*
 * Copyright 2006-2020 (c) Care.com, Inc.
 * 1400 Main Street, Waltham, MA, 02451, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Care.com, Inc. ("Confidential Information").  You shall not disclose
 * such Confidential Information and shall use it only in accordance with
 * the terms of an agreement between you and CZen.
 */
package com.care.impl;

import com.care.data.Attribute;
import com.care.jsontemplate.JsonTemplateProcessor;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.MapContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonValue;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created 26 Feb 2020
 *
 * @author suraj.kumar
 */
public class DefaultJsonTemplateProcessorTest {
    public static final Logger logger = Logger
            .getLogger(DefaultJsonTemplateProcessor.class.getSimpleName());
    public static JexlContext jexlContext;

    private JsonObject testObject;
    private JsonValue expectedValue;

    @Before
    public void setup(){
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Suraj");
        map.put("arrayField", Arrays.asList("Suraj", "Deepak"));
        map.put("booleanValue", true);
        map.put("number", 12);
        map.put("tutoring_location_attributes", Attribute.attributes());
        jexlContext = new MapContext(map);
    }

    @Test
    public void transformSimple() {
        testObject = Json.createObjectBuilder()
                .add("_templateField", Json.createObjectBuilder()
                        .add("_expr", "name")
                        .add("_type", "string"))
                .build();
        expectedValue = Json.createObjectBuilder()
                .add("templateField", "Suraj")
                .build();

        logger.info("Input Json : " + testObject.toString());
        logger.info("Expected Json : " + expectedValue.toString());
        // how to create a JsonTemplate context.
        // use a wrapper to wrap JEXLcontext and delegate calls to it.
        JsonTemplateProcessor jsonTemplateProcessor = new DefaultJsonTemplateProcessor();

        String generated = jsonTemplateProcessor.process(testObject.toString(), jexlContext);
        Assert.assertEquals(expectedValue.toString(), generated);

    }

    @Test
    public void arrayTransform() {
        testObject = Json.createObjectBuilder()
                .add("_templateField", Json.createObjectBuilder()
                        .add("_expr", "arrayField")
                        .add("_type", "array"))
                .build();
        expectedValue = Json.createObjectBuilder()
                .add("templateField", Json.createArrayBuilder()
                        .add("Suraj")
                        .add("Deepak"))
                .build();
        JsonTemplateProcessor jsonTemplateProcessor = new DefaultJsonTemplateProcessor();

        String generated = jsonTemplateProcessor.process(testObject.toString(), jexlContext);
        Assert.assertEquals(expectedValue.toString(), generated);
    }

    @Test
    public void arrayTransform2() {
        testObject = Json.createReader(getClass()
                .getResourceAsStream("/arrays/fill_array_test.json")).readObject();
        expectedValue = Json.createReader(getClass().getResourceAsStream("/arrays/fill_array_expected.json")).readObject();
        JsonTemplateProcessor jsonTemplateProcessor = new DefaultJsonTemplateProcessor();

        logger.info("Input Json : " + testObject.toString());
        logger.info("Expected Json : " + expectedValue.toString());
        String generated = jsonTemplateProcessor.process(testObject.toString(), jexlContext);
        Assert.assertEquals(expectedValue.toString(), generated);
    }
}
