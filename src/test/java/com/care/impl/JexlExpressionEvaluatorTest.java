package com.care.impl;

import com.care.jsontemplate.ExpressionEvaluator;
import org.apache.commons.jexl3.MapContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created 26 Feb 2020
 *
 * @author suraj.kumar
 */
public class JexlExpressionEvaluatorTest {

    public static final JexlExpressionEvaluator evaluator = new JexlExpressionEvaluator();

    @Before
    public void setup(){
        Map<String, Object> context = new HashMap<>();
        context.put("name", "Suraj");
        context.put("booleanValue", true);
        evaluator.setContext(new MapContext(context));
    }

    @Test
    public void expressionTest() {

        Assert.assertEquals("Suraj", evaluator.evaluate("name"));
        Assert.assertEquals(true, evaluator.evaluate("booleanValue"));
    }
}
