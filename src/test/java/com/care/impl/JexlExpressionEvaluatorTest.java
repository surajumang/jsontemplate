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

import com.care.jsontemplate.ExpressionEvaluator;
import org.apache.commons.jexl3.MapContext;
import org.junit.Assert;
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

    @Test
    public void expressionTest() {
        Map<String, Object> context = new HashMap<>();
        context.put("name", "Suraj");
        context.put("booleanValue", true);
        evaluator.setContext(new MapContext(context));

        Assert.assertEquals("Suraj", evaluator.evaluate("name"));
        Assert.assertEquals(true, evaluator.evaluate("booleanValue"));
    }
}
