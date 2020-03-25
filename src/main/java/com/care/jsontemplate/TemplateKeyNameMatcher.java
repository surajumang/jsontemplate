package com.care.jsontemplate;

/**
 * Created 26 Feb 2020
 *
 * @author suraj.kumar
 */
public interface TemplateKeyNameMatcher {
    boolean matches(String keyName);

    /**
     * This will attempt to convert the key name by stripping any prefixes attached to it.
     * */
    String extractPrefix(String keyName);
}
