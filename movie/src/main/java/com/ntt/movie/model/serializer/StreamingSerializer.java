package com.ntt.movie.model.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.ntt.movie.model.StreamingModel;

public class StreamingSerializer extends JsonSerializer<StreamingModel> {

    @Override
    public void serialize(StreamingModel streaming, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("id", String.valueOf(streaming.getId()));
        gen.writeStringField("name", streaming.getName());
        gen.writeStringField("url", streaming.getUrl());
        gen.writeEndObject();
    }
}
