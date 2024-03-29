package com.github.yildizmy.repository;

import com.github.yildizmy.repository.NaturalRepository;
import org.hibernate.NaturalIdLoadAccess;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.Map;
import java.util.Optional;

public class NaturalRepositoryImpl<T, ID extends Serializable>
        extends SimpleJpaRepository<T, ID> implements NaturalRepository<T, ID> {

    private final EntityManager entityManager;

    public NaturalRepositoryImpl(JpaEntityInformation entityInformation,
                                 EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Optional<T> findBySimpleNaturalId(ID naturalId) {
        return entityManager.unwrap(Session.class)
                .bySimpleNaturalId(this.getDomainClass())
                .loadOptional(naturalId);
    }

    @Override
    public Optional<T> findByNaturalId(Map<String, Object> naturalIds) {
        NaturalIdLoadAccess<T> loadAccess = entityManager.unwrap(Session.class)
                .byNaturalId(this.getDomainClass());
        naturalIds.forEach(loadAccess::using);
        return loadAccess.loadOptional();
    }
}
