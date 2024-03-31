package com.ntt.movie.model.serializer;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.ntt.movie.model.ActorModel;

public class ActorSerializer extends JsonSerializer<List<ActorModel>> {

    @Override
    public void serialize(List<ActorModel> actors, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartArray();
        for (ActorModel actor : actors) {
            gen.writeStartObject();
            gen.writeStringField("id", String.valueOf(actor.getId()));
            gen.writeStringField("name", actor.getName());
            gen.writeEndObject();
        }
        gen.writeEndArray();
    }
}
