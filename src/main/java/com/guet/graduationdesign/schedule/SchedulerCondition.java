package com.guet.graduationdesign.schedule;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class SchedulerCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        boolean enable = Boolean.valueOf(context.getEnvironment().getProperty("scheduling.enabled"));
        return enable;
    }
}