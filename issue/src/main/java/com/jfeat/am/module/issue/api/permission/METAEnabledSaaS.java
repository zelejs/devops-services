package com.jfeat.am.module.issue.api.permission;

import com.jfeat.crud.plus.META;

import org.springframework.context.annotation.Configuration;

@Configuration
public class METAEnabledSaaS {
    static {
        META.enabledSaaS(false);
    }
}