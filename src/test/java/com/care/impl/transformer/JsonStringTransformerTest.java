
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

import static org.junit.Assert.*;

/**
 * Created 26 Feb 2020
 *
 * @author suraj.kumar
 */

public class JsonStringTransformerTest {
    public static final JexlExpressionEvaluator evaluator = new JexlExpressionEvaluator();
    private JsonObject testObject;
    private JsonValue expectedValue;

    @Before
    public void setup(){
        Map<String, Object> context = new HashMap<>();
        context.put("name", "Suraj");
        context.put("booleanValue", true);
        evaluator.setContext(new MapContext(context));
    }

    @Test
    public void stringTest() {
        testObject = Json.createObjectBuilder()
                .add("_expr", "name")
                .add("_type", "string")
                .build();
        expectedValue = Json.createValue("Suraj");
        JsonValueTransformer stringTransformer = new JsonStringTransformer(evaluator);
        Assert.assertEquals(expectedValue, stringTransformer.transform(testObject));
    }
}