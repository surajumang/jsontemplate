package com.care.jsontemplate;

import com.care.spi.JsonTemplateProvider;

/**
 * Created 26 Feb 2020
 *
 * @author suraj.kumar
 */
public final class JsonTemplate {
    public JsonTemplateProcessor createJsonTreeReader(){
        return JsonTemplateProvider.provider().jsonTreeReader();
    }
}
