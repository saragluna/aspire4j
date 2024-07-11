package com.microsoft.aspire.resources;

import com.fasterxml.jackson.annotation.*;
import com.microsoft.aspire.resources.traits.SelfAware;
import jakarta.validation.constraints.NotEmpty;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Represents a value resource. Typically used to perform string concatenation (e.g. for connection strings).
 * @param <T>
 */
@JsonPropertyOrder({"connectionString"})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Value<T extends Value<T>> extends Resource<T> implements SelfAware<T> {

    @NotEmpty(message = "Value.properties cannot be empty")
    @JsonIgnore
    private final Map<String, String> properties = new LinkedHashMap<>();

    public Value(String name, String key, String value) {
        super(ResourceType.VALUE, name);
        properties.put(key, value);
    }

//    public T withProperty(String key, String value) {
//        properties.put(key, value);
//        return self();
//    }

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }

    @Override
    public T self() {
        return (T) this;
    }
}
