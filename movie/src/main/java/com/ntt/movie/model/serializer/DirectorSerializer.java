package com.ntt.movie.model.serializer;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.ntt.movie.model.DirectorModel;

public class DirectorSerializer extends JsonSerializer<List<DirectorModel>> {

    @Override
    public void serialize(List<DirectorModel> directors, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartArray();
        for (DirectorModel director : directors) {
            gen.writeStartObject();
            gen.writeStringField("id", String.valueOf(director.getId()));
            gen.writeStringField("name", director.getName());
            gen.writeEndObject();
        }
        gen.writeEndArray();
    }
}
