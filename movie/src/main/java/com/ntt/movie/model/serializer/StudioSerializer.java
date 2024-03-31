package com.ntt.movie.model.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.ntt.movie.model.StudioModel;

public class StudioSerializer extends JsonSerializer<StudioModel> {

    @Override
    public void serialize(StudioModel studio, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("id", String.valueOf(studio.getId()));
        gen.writeStringField("name", studio.getName());
        gen.writeStringField("country", studio.getCountry());
        gen.writeEndObject();
    }
}
