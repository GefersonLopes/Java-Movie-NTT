package com.ntt.movie.model.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.ntt.movie.model.UserModel;

public class UserSerializer extends JsonSerializer<UserModel> {

    @Override
    public void serialize(UserModel streaming, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("id", String.valueOf(streaming.getId()));
        gen.writeStringField("name", streaming.getName());
        gen.writeStringField("username", streaming.getUsername());
        gen.writeStringField("email", streaming.getEmail());
        gen.writeEndObject();
    }
}
