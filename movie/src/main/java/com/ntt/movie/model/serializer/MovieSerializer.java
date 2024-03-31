package com.ntt.movie.model.serializer;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.ntt.movie.model.MovieModel;

public class MovieSerializer extends JsonSerializer<List<MovieModel>> {

    @Override
    public void serialize(List<MovieModel> movies, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartArray();
        for (MovieModel movie : movies) {
            gen.writeStartObject();
            gen.writeStringField("id", String.valueOf(movie.getId()));
            gen.writeStringField("title", movie.getTitle());
            gen.writeStringField("franchise_id", String.valueOf(movie.getFranchise().getId()));
            gen.writeStringField("genre_id", String.valueOf(movie.getGenre().getId()));
            gen.writeStringField("studio_id", String.valueOf(movie.getStudio().getId()));
            gen.writeEndObject();
        }
        gen.writeEndArray();
    }
}
