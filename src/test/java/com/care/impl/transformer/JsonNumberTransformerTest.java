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
public class JsonNumberTransformerTest {
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
                .add("_expr", "number")
                .add("_type", "string")
                .build();
        expectedValue = Json.createValue(12);
        JsonValueTransformer transformer = new JsonNumberTransformer(evaluator);
        Assert.assertEquals(expectedValue, transformer.transform(testObject));
    }
}
