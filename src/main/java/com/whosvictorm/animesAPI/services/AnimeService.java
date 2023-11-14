package com.whosvictorm.animesAPI.services;

import com.whosvictorm.animesAPI.entities.Anime;
import com.whosvictorm.animesAPI.repositories.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimeService {

    @Autowired
    private AnimeRepository animeRepository;

    public Anime create(Anime anime){
        return animeRepository.save(anime);
    }

    public List<Anime> findAll(){
        Sort sort = Sort.by("nome").descending();
        return animeRepository.findAll(sort);
    }

    public Anime findById(Long id){
        return animeRepository.findById(id).orElse(null);
    }

    public List<Anime> update(Anime anime){
        animeRepository.save(anime);
        return findAll();
    }

    public List<Anime> deleteById(Long id){
        animeRepository.deleteById(id);
        return findAll();
    }

}
