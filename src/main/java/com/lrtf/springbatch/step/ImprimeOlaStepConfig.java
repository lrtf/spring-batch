package com.lrtf.springbatch.step;

import com.lrtf.springbatch.tasklet.ImprimeOlaStepTasklet;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ImprimeOlaStepConfig {

    @Autowired
    private ImprimeOlaStepTasklet imprimeOlaStepTasklet;

    @Bean
    public Step step(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("step", jobRepository)
                .tasklet(imprimeOlaStepTasklet, transactionManager)
                .build();
    }
}
