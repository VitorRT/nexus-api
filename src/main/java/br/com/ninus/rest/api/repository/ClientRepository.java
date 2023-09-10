package br.com.ninus.rest.api.repository;

import br.com.ninus.rest.api.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    public Page<Client> findAllByActiveTrue(Pageable pageable);
}
