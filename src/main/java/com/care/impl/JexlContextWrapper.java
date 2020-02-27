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
package com.care.impl;

import com.care.jsontemplate.JsonTemplateContext;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.MapContext;

import java.util.Map;

/**
 * Created 27 Feb 2020
 *
 * @author suraj.kumar
 */
public class JexlContextWrapper implements JsonTemplateContext, JexlContext {

    private final JexlContext jexlContext;

    public JexlContextWrapper(Map<String, Object> map) {
        this(new MapContext(map));
    }

    public JexlContextWrapper(JexlContext jexlContext){
        this.jexlContext = jexlContext;
    }

    @Override
    public Object get(String name) {
        return jexlContext.get(name);
    }

    @Override
    public void set(String name, Object value) {
        jexlContext.set(name, value);
    }

    @Override
    public boolean has(String name) {
        return jexlContext.has(name);
    }
}
