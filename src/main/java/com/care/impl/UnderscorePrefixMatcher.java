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

import com.care.jsontemplate.TemplateKeyNameMatcher;


/**
 * Created 26 Feb 2020
 *
 * @author suraj.kumar
 */
public class UnderscorePrefixMatcher implements TemplateKeyNameMatcher {
    public static final String keyNamePattern = "_.+";
    @Override
    public boolean matches(String keyName) {
        return keyName.matches(keyNamePattern);
    }

    @Override
    public String extractPrefix(String keyName) {
        return keyName.substring(1);
    }
}
