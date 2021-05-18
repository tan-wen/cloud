package com.aoyang.bis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;


@Configuration
@EnableScheduling
public class SchedulingConfiguration implements SchedulingConfigurer {
        @Override
        public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
            ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
            taskScheduler.setThreadNamePrefix("scheduling-");
            taskScheduler.setPoolSize(5);
            taskScheduler.initialize();
            scheduledTaskRegistrar.setTaskScheduler(taskScheduler);
        }
}
