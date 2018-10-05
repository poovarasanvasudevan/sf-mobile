package com.caretech.servicefocus.mobile.service

import org.quartz.*
import org.springframework.stereotype.Service
import org.springframework.scheduling.quartz.SchedulerFactoryBean
import org.springframework.beans.factory.annotation.Autowired


@Service
class SchedulerService {
    @Autowired
    lateinit var schedulerFactory: SchedulerFactoryBean

    @Throws(SchedulerException::class)
    fun register(jobClass: Class<out Job>, jobName: String, jobGroup: String, replace: Boolean) {
        val scheduler = schedulerFactory.scheduler
        val jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroup).storeDurably().build()
        scheduler.addJob(jobDetail, replace)
    }

    @Throws(SchedulerException::class)
    fun scheduleJob(jobClass: Class<out Job>, jobName: String, jobGroup: String, cronExpression: String) {

        val scheduler = schedulerFactory.scheduler

        val jobKey = JobKey.jobKey(jobName, jobGroup)
        val triggerKey = TriggerKey.triggerKey(jobName, jobGroup)

        if (!scheduler.checkExists(jobKey)) {
            register(jobClass, jobName, jobGroup, true)
        }

        val jobDetail = scheduler.getJobDetail(jobKey)
        val cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression)
        val cronTrigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).forJob(jobDetail)
                .withSchedule<CronTrigger>(cronScheduleBuilder).build()

        if (!scheduler.checkExists(triggerKey)) {
            scheduler.scheduleJob(cronTrigger)
        } else {
            scheduler.rescheduleJob(triggerKey, cronTrigger)
        }
    }
}