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
        //todo -> allow arrays to be included as well.
        return value instanceof Iterable<?> ;
    }

    @Override
    JsonValue create(Object value) {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        Iterable<?> iterable = (Iterable<?>) value;
        iterable.forEach(item -> arrayBuilder.add(toJsonValue(toJsonString(item))));

        //toJsonValue(value) //will return a json array since the object is an iterable.
        return toJsonValue(toJsonString(value));
    }
}
