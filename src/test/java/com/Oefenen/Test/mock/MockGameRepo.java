package com.Oefenen.Test.mock;

import com.Oefenen.Test.models.DTO.GameDTO;
import com.Oefenen.Test.models.Game;
import com.Oefenen.Test.repositories.GameCustomRepository;
import com.Oefenen.Test.repositories.GameRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;


public class MockGameRepo implements GameCustomRepository {

    public List<Game> GameList;

    public MockGameRepo(){
        GameList = new ArrayList<>();
    }

    public void FillDatabase(List<Game> gameList){
        this.GameList = gameList;
    }


    @Override
    public <S extends Game> S save(S entity) {
        return entity;
    }

    @Override
    public List<Game> findAll() {
        return GameList;
    }

    @Override
    public Optional<Game> findById(Integer integer) {
        for (Game value : GameList) {
            if (value.getId() == integer) {
                return Optional.of(value);
            }
        }
        return Optional.empty();
    }
    @Override
    public void flush() {

    }

    @Override
    public <S extends Game> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Game> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Game> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Game getOne(Integer integer) {
        return null;
    }

    @Override
    public Game getById(Integer integer) {
        return null;
    }

    @Override
    public Game getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Game> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Game> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Game> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Game> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Game> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Game> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Game, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }


    @Override
    public <S extends Game> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }


    @Override
    public List<Game> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Game entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Game> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Game> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Game> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Game findByName(String name) {
        Game game = null;
        for (Game value : GameList) {
            if (value.getName() == name) {
                game = value;
                return game;
            }
        }
        return game;
    }

    @Override
    public List<Game> findAllByOrderByDateAsc() {
        return GameList;
    }
}
