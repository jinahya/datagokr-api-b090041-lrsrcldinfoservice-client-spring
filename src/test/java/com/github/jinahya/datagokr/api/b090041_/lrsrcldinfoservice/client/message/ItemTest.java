package com.github.jinahya.datagokr.api.b090041_.lrsrcldinfoservice.client.message;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.github.jinahya.datagokr.api.b090041_.lrsrcldinfoservice.client.message.ResponseTest.responses;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class ItemTest {

    static Stream<Item> items() {
        return responses().flatMap(r -> r.getBody().getItems().stream());
    }

    // -----------------------------------------------------------------------------------------------------------------
    @MethodSource({"items"})
    @ParameterizedTest
    void items_Jackson(final Item expected) throws JsonProcessingException {
        final ObjectMapper mapper = JsonMapper.builder()
                .addModule(new ParameterNamesModule())
                .addModule(new Jdk8Module())
                .addModule(new JavaTimeModule())
                .build();
        final String string = mapper.writeValueAsString(expected);
        final Item actual = mapper.readValue(string, Item.class);
        assertThat(actual).isEqualTo(expected);
    }
}