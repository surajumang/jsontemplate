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