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
package com.care.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created 27 Feb 2020
 *
 * @author suraj.kumar
 */
public class Attribute {
    private String id;
    private String label;
    private String type;
    private boolean value;

    public Attribute(String id, String label) {
        this(id, label, "boolean", false);
    }

    public Attribute(String id, String label, String type, boolean value) {
        this.id = id;
        this.label = label;
        this.type = type;
        this.value = value;
    }

    public static List<Attribute> attributes(){
        List<Attribute> attributes = new ArrayList<>();
        attributes.add(new Attribute("TTLOCATON001", "Student's home"));
        attributes.add(new Attribute("TTLOCATON002", "Teacher's home"));
        attributes.add(new Attribute("TTLOCATON003", "Learning center"));
        attributes.add(new Attribute("TTLOCATON004", "Online"));

        return attributes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

}

