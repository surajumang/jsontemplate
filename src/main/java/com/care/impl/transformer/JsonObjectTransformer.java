package com.care.impl.transformer;

import com.care.jsontemplate.ExpressionEvaluator;

import javax.json.JsonValue;

/**
 * Created 26 Feb 2020
 *
 * @author suraj.kumar
 */
public class JsonObjectTransformer extends AbstractJsonValueTransformer {

    public JsonObjectTransformer(ExpressionEvaluator evaluator) {
        super(evaluator);
    }

    @Override
    boolean validateType(Object object) {
        return true;
    }

    @Override
    JsonValue create(Object value) {
        return toJsonValue(toJsonString(value));
    }
}
