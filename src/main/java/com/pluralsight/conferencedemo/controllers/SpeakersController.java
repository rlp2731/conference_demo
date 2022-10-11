package com.pluralsight.conferencedemo.controllers;

import com.pluralsight.conferencedemo.models.Speakers;
import com.pluralsight.conferencedemo.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {
    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speakers> list(){
        return speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speakers get(@PathVariable Long id){
        return speakerRepository.getReferenceById(id);
    }
    @PostMapping
    public Speakers create(@RequestBody final Speakers speaker) {
        return speakerRepository.saveAndFlush(speaker);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        //Also need to check children records before deleting.
        speakerRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speakers update(@PathVariable Long id, @RequestBody Speakers speaker) {
        // because this is a PUT, we expect all attributes to be passed in. A PATCH would only need what
        //TODO: Add a validation that all attributes are passed in, otherwise return a 400 bad payload
        Speakers existingSpeaker = speakerRepository.getReferenceById(id);
        BeanUtils.copyProperties(speaker, existingSpeaker,"speaker_id");
        return speakerRepository.saveAndFlush(existingSpeaker);
    }

}
