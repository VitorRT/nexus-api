package br.com.ninus.rest.api.repository;

import br.com.ninus.rest.api.domain.Class;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ClassRepository extends JpaRepository<Class, Long> {
    @Query("SELECT c FROM Class c WHERE c.categorie = 'PROGRESS'")
    Page<Class> findAllByCategoriePROGRESS(Pageable pageable);
    @Query("SELECT c FROM Class c WHERE c.categorie = 'FINISHED'")
    Page<Class> findAllByCategorieFINISHED(Pageable pageable);
    @Query("SELECT c FROM Class c WHERE c.categorie = 'FAVORITE'")
    Page<Class> findAllByCategorieFAVORITE(Pageable pageable);
}
