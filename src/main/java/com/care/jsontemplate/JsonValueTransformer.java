package com.care.jsontemplate;

import javax.json.JsonObject;
import javax.json.JsonValue;

/**
 * Created 26 Feb 2020
 *
 * @author suraj.kumar
 */
public interface JsonValueTransformer {
    /**
    * This does a transformation using the provided JsonValue. The value contains all the
    * relevant information sufficient to produce another Json
    * Specifically, this will contain _type, _expr, _*/
    JsonValue transform(JsonObject jsonObject);
}
