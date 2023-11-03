package br.com.ninus.rest.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ninus.rest.api.entity.ModelOutputClass;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ModelOutputClassRepository extends JpaRepository<ModelOutputClass, Long> {
    Page<ModelOutputClass> findAllByActiveTrue(Pageable pageable);
    @Query(
            "SELECT o FROM ModelOutputClass o WHERE o.modelInputClass.id LIKE :inputModelId "
    )
    ModelOutputClass findByInputModelId(@Param(value = "inputModelId") Long inputModelId);
}
