package com.oklimenko.sampleapp.config;

import brave.Tracing;
import brave.http.HttpTracing;
import brave.propagation.B3Propagation;
import brave.propagation.CurrentTraceContext;
import brave.propagation.ExtraFieldPropagation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.sleuth.sampler.ProbabilityBasedSampler;
import org.springframework.cloud.sleuth.sampler.SamplerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import zipkin2.Span;
import zipkin2.reporter.Reporter;

/**
 * Custom tracer:
 * 1) adds any our attributes through calls, "client-id" in this case.
 * 2) when using @ImportResource then spring.application.name is set to "default" by Spring, this is the fix.
 *
 * @author oklimenko@gmail.com
 */
@Configuration
@Slf4j
public class TracingConfig {

    @Bean
    Tracing tracing(Environment env, Reporter<Span> spanReporter, CurrentTraceContext currentTraceContext) {
        String serviceName = env.getProperty("spring.application.name", "Unnamed");
        Float samplingProbability = env.getProperty("sampleapp.tracing.sampler.probability", Float.class, 0.1f);

        SamplerProperties samplerProperties = new SamplerProperties();
        samplerProperties.setProbability(samplingProbability);
        ProbabilityBasedSampler sampler = new ProbabilityBasedSampler(samplerProperties);
        log.debug("{}; sampleapp.tracing.sampler.probability={}", ProbabilityBasedSampler.class.getName(), samplingProbability);

        return Tracing
                .newBuilder()
                .sampler(sampler)
                .localServiceName(serviceName)
                .propagationFactory(ExtraFieldPropagation
                        .newFactory(B3Propagation.FACTORY, "client-id")) // sample property to propogate
                .currentTraceContext(currentTraceContext)
                .spanReporter(spanReporter)
                .build();
    }

    @Bean
    HttpTracing httpTracing(Tracing tracing) {
        return HttpTracing.create(tracing);
    }

}