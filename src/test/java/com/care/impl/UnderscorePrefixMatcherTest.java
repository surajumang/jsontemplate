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
import org.junit.Assert;
import org.junit.Test;

/**
 * Created 26 Feb 2020
 *
 * @author suraj.kumar
 */
public class UnderscorePrefixMatcherTest {

    private static final TemplateKeyNameMatcher matcher = new UnderscorePrefixMatcher();
    @Test
    public void matches() {
        Assert.assertTrue(matcher.matches("_name"));
    }

    @Test
    public void extractPrefix() {
        Assert.assertEquals("name", matcher.extractPrefix("_name"));
    }
}