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

import com.care.jsontemplate.ExpressionEvaluator;
import com.care.jsontemplate.JsonValueTransformer;

/**
 * Created 26 Feb 2020
 *
 * @author suraj.kumar
 */
public class JsonValueTransformerFactory {

    public static final JsonValueTransformerFactory factory = new JsonValueTransformerFactory();

    public static JsonValueTransformerFactory getInstance(){
        return factory;
    }

    public JsonValueTransformer get(String typeName, ExpressionEvaluator evaluator) {
        switch (typeName){
            case "string"  : return new JsonStringTransformer(evaluator);
            case "boolean" : return new JsonBooleanTransformer(evaluator);
            case "array"   : return new JsonArrayTransformer(evaluator);
            case "number"  : return new JsonNumberTransformer(evaluator);
            case "object"  : return new JsonObjectTransformer(evaluator);
            default: throw new IllegalArgumentException("No type found for : " + typeName);
        }
    }
}
