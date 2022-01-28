package com.stackinsat.test.repository;


import com.stackinsat.test.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Long> {

    public List<Personne> findAllByOrderByNomAsc();
}
