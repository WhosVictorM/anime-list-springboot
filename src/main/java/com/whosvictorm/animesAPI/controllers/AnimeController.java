package com.whosvictorm.animesAPI.controllers;

import com.whosvictorm.animesAPI.entities.Anime;
import com.whosvictorm.animesAPI.repositories.AnimeRepository;
import com.whosvictorm.animesAPI.services.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animes")
public class AnimeController {

    @Autowired
    private AnimeService animeService;

    @PostMapping
    public Anime create(@RequestBody Anime anime){
        return animeService.create(anime);
    }

    @GetMapping
    public List<Anime> findAll(){
        return animeService.findAll();
    }

    @GetMapping("/{id}")
    public Anime findById(@PathVariable Long id) {
        return animeService.findById(id);
    }

    @PutMapping("/id")
    public Anime update(@PathVariable Long id, @RequestBody Anime anime){
        return animeService.update(id, anime);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        animeService.deleteById(id);
    }


}
