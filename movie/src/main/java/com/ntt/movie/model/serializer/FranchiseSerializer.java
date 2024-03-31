package com.ntt.movie.model.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.ntt.movie.model.FranchiseModel;

public class FranchiseSerializer extends JsonSerializer<FranchiseModel> {

    @Override
    public void serialize(FranchiseModel franchise, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("id", String.valueOf(franchise.getId()));
        gen.writeStringField("name", franchise.getName());
        gen.writeStringField("genre_id", String.valueOf(franchise.getGenre().getId()));
        gen.writeStringField("studio_id", String.valueOf(franchise.getStudio().getId()));
        gen.writeEndObject();
    }
}
