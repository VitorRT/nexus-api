package br.com.ninus.rest.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ninus.rest.api.domain.ModelClass;

public interface ModelClassRepository extends JpaRepository<ModelClass, Long> {
    
    Page<ModelClass> findAllByActiveTrue(Pageable pageable);
}
