package br.com.ninus.rest.api.repository;

import br.com.ninus.rest.api.entity.ClassNinus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClassNinusRepository extends JpaRepository<ClassNinus, Long> {
    @Query("SELECT c FROM ClassNinus c WHERE c.categorie LIKE 'PROGRESS'")
    Page<ClassNinus> findAllByCategoriePROGRESS(Pageable pageable);

    @Query("SELECT c FROM ClassNinus c WHERE c.categorie LIKE 'FINISHED'")
    Page<ClassNinus> findAllByCategorieFINISHED(Pageable pageable);

    @Query("SELECT c FROM ClassNinus c WHERE c.categorie LIKE 'FAVORITE'")
    Page<ClassNinus> findAllByCategorieFAVORITE(Pageable pageable);
}
