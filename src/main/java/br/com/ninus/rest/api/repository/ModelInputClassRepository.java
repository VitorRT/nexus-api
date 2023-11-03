package br.com.ninus.rest.api.repository;

import br.com.ninus.rest.api.entity.ModelInputClass;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ModelInputClassRepository extends JpaRepository<ModelInputClass, Long> {
   Page<ModelInputClass> findAllByActiveTrue(Pageable pageable);
   @Query("SELECT i FROM ModelInputClass i WHERE i.classNinusFk.id = :classNinusId")
   Optional<ModelInputClass> findInputModelByClassNinusId(@Param(value = "classNinusId") Long classNinusId);
}
