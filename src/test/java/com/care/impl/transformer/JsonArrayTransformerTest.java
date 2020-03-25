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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created 26 Feb 2020
 *
 * @author suraj.kumar
 */
public class JsonArrayTransformerTest {
    public static final Logger logger = Logger.getLogger(JsonArrayTransformerTest.class.getSimpleName());
    public static final JexlExpressionEvaluator evaluator = new JexlExpressionEvaluator();
    private JsonObject testObject;
    private JsonValue expectedValue;

    @Before
    public void setup(){
        Map<String, Object> context = new HashMap<>();
        context.put("name", Arrays.asList("Suraj", "Sujit", "Deepak"));
        context.put("booleanValue", true);
        evaluator.setContext(new MapContext(context));
    }

    @Test
    public void simpleArrayTest() {
        testObject = Json.createObjectBuilder()
                .add("_expr", "name")
                .add("_type", "array")
                .build();
        expectedValue = Json.createArrayBuilder()
                .add("Suraj")
                .add("Sujit")
                .add("Deepak")
                .build();
        logger.info("Input Json : " + testObject.toString());
        logger.info("Expected Json : " + expectedValue.toString());
        JsonValueTransformer transformer = new JsonArrayTransformer(evaluator);
        Assert.assertEquals(expectedValue, transformer.transform(testObject));
    }
}
