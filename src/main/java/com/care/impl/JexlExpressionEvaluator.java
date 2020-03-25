package com.care.impl;

import com.care.jsontemplate.ExpressionEvaluator;
import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.MapContext;

/**
 * Created 26 Feb 2020
 *
 * @author suraj.kumar
 */
public class JexlExpressionEvaluator implements ExpressionEvaluator {

    public static final JexlEngine ENGINE = new JexlBuilder().create();

    private JexlContext context;

    public JexlExpressionEvaluator() {
        this(new MapContext());
    }

    public JexlExpressionEvaluator(JexlContext context) {
        this.context = context;
    }

    @Override
    public Object evaluate(String expression) {
        return ENGINE.createExpression(expression).evaluate(context);
    }

    public void setContext(JexlContext context) {
        this.context = context;
    }
}
