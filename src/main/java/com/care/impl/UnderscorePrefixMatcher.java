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
