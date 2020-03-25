package com.care.jsontemplate;

/**
 * Created 26 Feb 2020
 *
 * @author suraj.kumar
 */
public interface EmbeddedTemplateMatcher {
    /**
     * Return if a string value contains one or more embedded template formats*/
    boolean matches(String value);

    void replace(String newValue);
}
