package com.care.impl;

import com.care.impl.transformer.JsonValueTransformerFactory;
import com.care.jsontemplate.JsonTemplateProcessor;
import org.apache.commons.jexl3.JexlContext;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonParser;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created 26 Feb 2020
 *
 * @author suraj.kumar
 */
public class DefaultJsonTemplateProcessor implements JsonTemplateProcessor {

    //create a JsonTemplateProcessor with a JsonTemplate which can be invoked more that once
    // by providing a different context.
    @Override
    public void process(Reader reader, Writer writer, JexlContext jexlContext) {
        transformStep1(Json.createParser(reader), Json.createGenerator(writer), jexlContext);
    }

    @Override
    public String process(String jsonData, JexlContext jexlContext) {
        StringWriter writer = new StringWriter();
        process(new StringReader(jsonData), writer, jexlContext);
        return writer.toString();
    }

    @Override
    public void process(InputStream inputStream, OutputStream outputStream, JexlContext jexlContext) {
        transformStep1(Json.createParser(inputStream), Json.createGenerator(outputStream), jexlContext);
    }

    private void transformStep1(JsonParser jsonParser, JsonGenerator generator, JexlContext jexlContext){
        while (jsonParser.hasNext()){
            switch (jsonParser.next()){
                case START_OBJECT:
                    generator.writeStartObject();
                    break;
                case START_ARRAY:
                    generator.writeStartArray();
                    break;
                case KEY_NAME:
                    String keyName = jsonParser.getString();
                    if (keyName.matches("_.+")){
                        generator.writeKey(keyName.substring(1));

                        jsonParser.next();
                        JsonValue metadata = jsonParser.getValue();
                        generator.write(transform(metadata.asJsonObject(), jexlContext));
                        break;
                    }
                    generator.writeKey(keyName);
                    break;
                case END_ARRAY:
                case END_OBJECT:
                    generator.writeEnd();
                    break;
                default:
                    generator.write(jsonParser.getValue());
            }
        }
        generator.flush();
    }

    private JsonValue transform(JsonObject metadata, JexlContext jexlContext){
        if (metadata == null){
            return JsonValue.NULL;
        }
        String type = metadata.getString("_type");
        return JsonValueTransformerFactory.getInstance()
                .get(type, new JexlExpressionEvaluator(jexlContext)).transform(metadata);
    }

}
