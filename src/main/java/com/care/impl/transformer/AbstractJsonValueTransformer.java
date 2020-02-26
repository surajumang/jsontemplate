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
import com.care.jsontemplate.TypeMismatchException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.json.bind.JsonbBuilder;
import java.io.StringReader;
import java.util.Objects;


/**
 * Created 26 Feb 2020
 *
 * @author suraj.kumar
 */
public abstract class AbstractJsonValueTransformer implements JsonValueTransformer {
    private final ExpressionEvaluator evaluator;
    public static final String EXPRESSION_STR = "_expr";

    public AbstractJsonValueTransformer(ExpressionEvaluator evaluator) {
        this.evaluator = evaluator;
    }

    @Override
    public JsonValue transform(JsonObject jsonObject) {
        Object expressionValue = evaluator.evaluate(jsonObject.getString(EXPRESSION_STR));
        if (! validateType(expressionValue)){
            throw new TypeMismatchException("Incompatible type found, expecting : "
                    + findType(jsonObject));
        }

        return create(expressionValue);
    }

    abstract boolean validateType(Object object);

    abstract JsonValue create(Object value);

    String findType(JsonObject jsonObject){
        return jsonObject.getString("_type");
    }

    // can be improved
    public static String toJsonString(Object value){
        return JsonbBuilder.create().toJson(value);
    }

    public static JsonValue toJsonValue(String jsonString){
        return Json.createReader(new StringReader(jsonString)).readValue();
    }
}
