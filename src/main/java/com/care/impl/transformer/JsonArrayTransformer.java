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

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonValue;

/**
 * Created 26 Feb 2020
 *
 * @author suraj.kumar
 */
public class JsonArrayTransformer extends AbstractJsonValueTransformer {

    public JsonArrayTransformer(ExpressionEvaluator evaluator) {
        super(evaluator);
    }

    @Override
    boolean validateType(Object value) {
        return value instanceof Iterable<?> ;
    }

    @Override
    JsonValue create(Object value) {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        Iterable<?> iterable = (Iterable<?>) value;
        iterable.forEach(item -> toJsonValue(toJsonString(item)));

        //toJsonValue(value) //will return a json array since the object is an iterable.
        return arrayBuilder.build();
    }
}
