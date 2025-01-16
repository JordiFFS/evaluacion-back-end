package com.jordi.publicatios.controler;


import com.jordi.publicatios.model.Publications;
import com.jordi.publicatios.service.PublicationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publication")
@CrossOrigin(origins = "http://localhost:3000")
public class PublicationControler {

    @Autowired
    private PublicationsService publicationsService;

    @GetMapping
    public List<Publications>getAllPublications(){
        return publicationsService.getPublications();
    }

    @GetMapping("/search")
    public List<Publications>getSearchPublications(@RequestParam(required = true)String s){
        return publicationsService.getSearchPublications(s);
    }


}
