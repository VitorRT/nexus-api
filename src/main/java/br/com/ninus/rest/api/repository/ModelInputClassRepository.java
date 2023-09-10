package br.com.ninus.rest.api.repository;

import br.com.ninus.rest.api.entity.ModelInputClass;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelInputClassRepository extends JpaRepository<ModelInputClass, Long> {
   Page<ModelInputClass> findAllByActiveTrue(Pageable pageable);
}
