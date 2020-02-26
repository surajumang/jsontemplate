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

import javax.json.JsonValue;

/**
 * Created 26 Feb 2020
 *
 * @author suraj.kumar
 */
public class JsonBooleanTransformer extends AbstractJsonValueTransformer {
    public JsonBooleanTransformer(ExpressionEvaluator evaluator) {
        super(evaluator);
    }

    @Override
    boolean validateType(Object object) {
        return object instanceof Boolean;
    }

    @Override
    JsonValue create(Object value) {
        return Boolean.parseBoolean(value.toString()) ? JsonValue.TRUE : JsonValue.FALSE;
    }
}
