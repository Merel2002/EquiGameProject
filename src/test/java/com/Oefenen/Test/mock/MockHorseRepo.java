package com.Oefenen.Test.mock;

import com.Oefenen.Test.models.Enrollment;
import com.Oefenen.Test.models.Horse;
import com.Oefenen.Test.repositories.HorseCustomRepository;
import com.Oefenen.Test.repositories.HorseRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class MockHorseRepo implements HorseCustomRepository {
    public List<Horse> HorseList;

    public MockHorseRepo(){
        HorseList = new ArrayList<>();
    }

    public void FillDatabase(List<Horse> horseList){
        this.HorseList = horseList;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Horse> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Horse> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Horse> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Horse getOne(Integer integer) {
        return null;
    }

    @Override
    public Horse getById(Integer integer) {
        return null;
    }

    @Override
    public Horse getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Horse> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Horse> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Horse> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Horse> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Horse> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Horse> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Horse, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Horse> S save(S entity) {
        return entity;
    }

    @Override
    public <S extends Horse> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Horse> findById(Integer integer) {
        for (Horse value : HorseList) {
            if (value.getId() == integer) {
                return Optional.of(value);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Horse> findAll() {
        return HorseList;
    }

    @Override
    public List<Horse> findAllById(Iterable<Integer> integers) {
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
    public void delete(Horse entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Horse> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Horse> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Horse> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Horse findByName(String name) {
        return null;
    }
}
