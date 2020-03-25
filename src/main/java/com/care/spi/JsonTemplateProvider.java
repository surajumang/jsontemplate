package com.care.spi;

import com.care.jsontemplate.JsonTemplateProcessor;

/**
 * Created 26 Feb 2020
 *
 * @author suraj.kumar
 */
public abstract class JsonTemplateProvider {
    public abstract JsonTemplateProcessor jsonTreeReader();

    public static JsonTemplateProvider provider(){
        return null;
    }
}
