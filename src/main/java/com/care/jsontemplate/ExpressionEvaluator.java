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
