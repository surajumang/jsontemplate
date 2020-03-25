package com.care.impl.transformer;

import com.care.jsontemplate.ExpressionEvaluator;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonValue;

/**
 * Created 26 Feb 2020
 *
 * @author suraj.kumar
 */
public class JsonStringTransformer extends AbstractJsonValueTransformer {
    public JsonStringTransformer(ExpressionEvaluator evaluator) {
        super(evaluator);
    }

    @Override
    boolean validateType(Object object) {
        return object instanceof String;
    }

    @Override
    JsonValue create(Object value) {
        return Json.createValue(value.toString());
    }

}
