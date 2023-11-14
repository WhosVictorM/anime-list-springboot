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
        Sort sort = Sort.by("id").ascending();
        return animeRepository.findAll(sort);
    }

    public Anime findById(Long id){
        return animeRepository.findById(id).orElse(null);
    }

    public Anime update(Anime anime){
        Anime newAnime = findById(anime.getId());
        updateData(newAnime, anime);
        return animeRepository.save(newAnime);
    }

    public void updateData(Anime newAnime, Anime oldAnime){
        newAnime.setNome(oldAnime.getNome());
        newAnime.setDescricao(oldAnime.getDescricao());
    }

    public void deleteById(Long id){
        animeRepository.deleteById(id);
    }

}
