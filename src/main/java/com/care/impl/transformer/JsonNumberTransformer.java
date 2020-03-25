package com.care.impl.transformer;

import com.care.jsontemplate.ExpressionEvaluator;

import javax.json.Json;
import javax.json.JsonValue;

/**
 * Created 26 Feb 2020
 *
 * @author suraj.kumar
 */
public class JsonNumberTransformer extends AbstractJsonValueTransformer {
    public JsonNumberTransformer(ExpressionEvaluator evaluator) {
        super(evaluator);
    }

    @Override
    boolean validateType(Object object) {
        return object instanceof Number;
    }

    //todo - handle floating point numbers as well.
    @Override
    JsonValue create(Object value) {
        return Json.createValue(Long.parseLong(value.toString()));
    }
}
