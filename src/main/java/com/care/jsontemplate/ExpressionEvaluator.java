package com.care.jsontemplate;

/**
 * Created 26 Feb 2020
 *
 * @author suraj.kumar
 */

/**
 * Purpose of this class is to decouple the expression evaluation process from a particular
 * implementation, hence multiple evaluations can be created which may use different expression
 * evaluation engines like velocity and jexl*/
public interface ExpressionEvaluator {

    Object evaluate(String expression);
}
