package br.com.ninus.rest.api.repository;

import br.com.ninus.rest.api.entity.Client;
import br.com.ninus.rest.api.entity.dto.feed.FeedClassesResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Page<Client> findAllByActiveTrue(Pageable pageable);

    @Query(
            "SELECT NEW br.com.ninus.rest.api.entity.dto.feed.FeedClassesResponse(" +
                    "client.id AS clientId, " +
                    "classNinus.id AS classId, " +
                    "classNinus.className AS className, " +
                    "output.introduction AS introduction" +
                    ") " +
                    "FROM Client client " +
                    "INNER JOIN client.classNinus classNinus " +
                    "INNER JOIN client.classNinus.modelInputClass input " +
                    "INNER JOIN client.classNinus.modelInputClass.modelOutputClass output " +
                    "WHERE client.id = :clientId"
    )
    List<FeedClassesResponse> getFeedClassesByClientId(@Param(value = "clientId") Long id);
}
