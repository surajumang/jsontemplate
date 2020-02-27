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

/**
 * Created 26 Feb 2020
 *
 * @author suraj.kumar
 */

import org.apache.commons.jexl3.JexlContext;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/**
 * This class is to provide the function of reading a Json document and to match template values
 * present in Key(Type 1) or Values(Type 2)
 *
 * This will invoke the corresponding Matchers to find a match and to allow transformation
 * to be performed in case a match is found
 * */
public interface JsonTemplateProcessor {
    /**
     * Main processor method which will be used by the users
     * */
    void process(Reader reader, Writer writer, JexlContext jexlContext);

    String process(String jsonData, JexlContext jexlContext);

    void process(InputStream inputStream, OutputStream outputStream, JexlContext jexlContext);
}
