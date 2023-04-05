package com.Oefenen.Test.mock;

import com.Oefenen.Test.models.Rider;
import com.Oefenen.Test.repositories.RiderRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class MockRiderRepo implements RiderRepository {

    public List<Rider> RiderList;

    public MockRiderRepo(){
        RiderList = new ArrayList<>();
    }

    public void FillDatabase(List<Rider> riderList){
        this.RiderList = riderList;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Rider> S saveAndFlush(S entity) {
        return entity;
    }

    @Override
    public <S extends Rider> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Rider> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Rider getOne(Integer integer) {
        return null;
    }

    @Override
    public Rider getById(Integer integer) {
        return null;
    }

    @Override
    public Rider getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Rider> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Rider> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Rider> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Rider> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Rider> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Rider> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Rider, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Rider> S save(S entity) {
        return entity;
    }

    @Override
    public <S extends Rider> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Rider> findById(Integer integer) {
        for (Rider value : RiderList) {
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
    public List<Rider> findAll() {
        return RiderList;
    }

    @Override
    public List<Rider> findAllById(Iterable<Integer> integers) {
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
    public void delete(Rider entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Rider> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Rider> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Rider> findAll(Pageable pageable) {
        return null;
    }
}
