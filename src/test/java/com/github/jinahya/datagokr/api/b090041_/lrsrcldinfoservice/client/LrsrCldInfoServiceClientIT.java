package com.github.jinahya.datagokr.api.b090041_.lrsrcldinfoservice.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(
        classes = {
                AbstractLrsrCldInfoServiceClientIT._Configuration.class,
                LrsrCldInfoServiceClientIT._Configuration.class,
                LrsrCldInfoServiceClient.class
        }
)
@Slf4j
class LrsrCldInfoServiceClientIT
        extends AbstractLrsrCldInfoServiceClientIT<LrsrCldInfoServiceClient> {

    // -----------------------------------------------------------------------------------------------------------------
    @ComponentScan(
            basePackageClasses = {
                    _NoOp.class
            }
    )
    @Configuration
    static class _Configuration {

        @LrsrCldInfoServiceClient.LrsrCldInfoServiceRestTemplate
        @Bean
        RestTemplate lrsrCldInfoServiceRestTemplate() {
            return new RestTemplateBuilder()
                    .additionalCustomizers(
                            t -> {
                                log.debug("1 customizing {}", t);
                            },
                            t -> {
                                log.debug("2 customizing {}", t);
                                t.setRequestFactory(new BufferingClientHttpRequestFactory(t.getRequestFactory()));
                            }
                    )
                    .additionalInterceptors(
                            (r, b, e) -> {
                                log.debug("1 executing with ({}, {})", r, b);
                                return e.execute(r, b);
                            },
                            (r, b, e) -> {
                                log.debug("2 executing with ({}, {})", r, b);
                                return e.execute(r, b);
                            }
                    )
                    .rootUri(AbstractLrsrCldInfoServiceClient.BASE_URL)
                    .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_XML_VALUE)
                    .build();
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance.
     */
    LrsrCldInfoServiceClientIT() {
        super(LrsrCldInfoServiceClient.class);
    }
}
