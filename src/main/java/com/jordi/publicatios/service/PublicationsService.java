package com.jordi.publicatios.service;

import java.io.File;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jordi.publicatios.model.Publications;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PublicationsService {

    private List<Publications> publications;

    public PublicationsService() {
        loadPublicationFromJson();
    }

    private void loadPublicationFromJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            publications = objectMapper.readValue(new File("src/main/resources/publications.json"), new TypeReference<List<Publications>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al cargar los datos JSON");
        }
    }

    public List<Publications> getPublications() {
        return publications;
    }

    public List<Publications> getSearchPublications(String s) {
        return publications.stream()
                .filter(publication -> publication.getText() != null && publication.getText().toLowerCase().contains(s.toLowerCase()))
                .toList();
    }
}
