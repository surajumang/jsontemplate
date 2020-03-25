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
