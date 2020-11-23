package com.gl.userManagementApp.actuatorEndPoint;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;


/*
 *  1. @JsonInclude Annotation Overview
The @JsonInclude annotation contains below two values:

    Include.NON_NULL: Indicates that only properties with not null values will be included in JSON.
    Include.NON_EMPTY: Indicates that only properties that are not empty will be included in JSON.

We can configure Include.NON_NULL and Include.NON_EMPTY at property level as well as at class level using @JsonInclude annotation.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserAppInfo {

    private Map<String, Object> healthDetails;

    public Map<String, Object> getHealthDetails() {
        return this.healthDetails;
    }

    public void setHealthDetails(Map<String, Object> healthDetails) {
        this.healthDetails = healthDetails;
    }
}