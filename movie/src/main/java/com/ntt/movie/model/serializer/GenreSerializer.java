package com.ntt.movie.model.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.ntt.movie.model.GenreModel;

public class GenreSerializer extends JsonSerializer<GenreModel> {
    @Override
    public void serialize(GenreModel genre, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("id", String.valueOf(genre.getId()));
        gen.writeStringField("name", genre.getName());
        gen.writeEndObject();
    }
}
