package com.Oefenen.Test.mock;

import com.Oefenen.Test.models.Enrollment;
import com.Oefenen.Test.models.Game;
import com.Oefenen.Test.repositories.EnrollmentCustomRepository;
import com.Oefenen.Test.repositories.EnrollmentRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class MockEnrollmentRepo implements EnrollmentCustomRepository {
    public List<Enrollment> EnrollmentList;

    public MockEnrollmentRepo(){
        EnrollmentList = new ArrayList<>();
    }

    public void FillDatabase(List<Enrollment> enrollmentList){
        this.EnrollmentList = enrollmentList;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Enrollment> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Enrollment> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Enrollment> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Enrollment getOne(Integer integer) {
        return null;
    }

    @Override
    public Enrollment getById(Integer integer) {
        return null;
    }

    @Override
    public Enrollment getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Enrollment> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Enrollment> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Enrollment> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Enrollment> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Enrollment> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Enrollment> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Enrollment, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Enrollment> S save(S entity) {
        return entity;
    }

    @Override
    public <S extends Enrollment> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Enrollment> findById(Integer integer) {
        for (Enrollment value : EnrollmentList) {
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
    public List<Enrollment> findAll() {
        return EnrollmentList;
    }

    @Override
    public List<Enrollment> findAllById(Iterable<Integer> integers) {
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
    public void delete(Enrollment entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Enrollment> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Enrollment> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Enrollment> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Enrollment> findAllByGame_Id(int id) {
        return null;
    }

    @Override
    public List<Enrollment> findAllByRider_Id(int id) {
        return null;
    }
}
