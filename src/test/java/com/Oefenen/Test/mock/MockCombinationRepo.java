package com.Oefenen.Test.mock;

import com.Oefenen.Test.models.Combination;
import com.Oefenen.Test.models.Enrollment;
import com.Oefenen.Test.repositories.CombinationRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class MockCombinationRepo implements CombinationRepository {
    public List<Combination> CombinationList;

    public MockCombinationRepo(){
        CombinationList = new ArrayList<>();
    }

    public void FillDatabase(List<Combination> combinationList){
        this.CombinationList = combinationList;
    }
    @Override
    public void flush() {

    }

    @Override
    public <S extends Combination> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Combination> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Combination> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Combination getOne(Integer integer) {
        return null;
    }

    @Override
    public Combination getById(Integer integer) {
        return null;
    }

    @Override
    public Combination getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Combination> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Combination> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Combination> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Combination> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Combination> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Combination> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Combination, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Combination> S save(S entity) {
        return entity;
    }

    @Override
    public <S extends Combination> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Combination> findById(Integer integer) {
        for (Combination value : CombinationList) {
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
    public List<Combination> findAll() {
        return CombinationList;
    }

    @Override
    public List<Combination> findAllById(Iterable<Integer> integers) {
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
    public void delete(Combination entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Combination> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Combination> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Combination> findAll(Pageable pageable) {
        return null;
    }
}
