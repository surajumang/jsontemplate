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
package com.care.jsontemplate;

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
    JsonValue transform(JsonValue jsonValue);
}
