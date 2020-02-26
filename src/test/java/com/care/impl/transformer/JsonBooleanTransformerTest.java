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
package com.care.impl.transformer;

import com.care.impl.JexlExpressionEvaluator;
import com.care.jsontemplate.JsonValueTransformer;
import org.apache.commons.jexl3.MapContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Created 26 Feb 2020
 *
 * @author suraj.kumar
 */
public class JsonBooleanTransformerTest {
    public static final JexlExpressionEvaluator evaluator = new JexlExpressionEvaluator();
    private JsonObject testObject;
    private JsonValue expectedValue;

    @Before
    public void setup(){
        Map<String, Object> context = new HashMap<>();
        context.put("name", "Suraj");
        context.put("booleanValue", true);
        context.put("number", 12);
        evaluator.setContext(new MapContext(context));
    }

    @Test
    public void simpleNumberTest() {
        testObject = Json.createObjectBuilder()
                .add("_expr", "booleanValue")
                .add("_type", "boolean")
                .build();
        expectedValue = JsonValue.FALSE;
        JsonValueTransformer transformer = new JsonBooleanTransformer(evaluator);
        Assert.assertNotEquals(expectedValue, transformer.transform(testObject));
        Assert.assertEquals(JsonValue.TRUE, transformer.transform(testObject));
    }
}
