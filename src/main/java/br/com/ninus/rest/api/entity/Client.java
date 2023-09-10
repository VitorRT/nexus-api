package br.com.ninus.rest.api.entity;

import br.com.ninus.rest.api.entity.dto.client.ClientPostRequest;
import br.com.ninus.rest.api.utils.constants.SchoolType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "client")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClassNinus> classNinuses;

    @Column(length = 80, nullable = false)
    private String name;

    @Column(length = 80, nullable = false, unique = true)
    private String email;

    @Column(length = 150, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "school_type",length = 40, nullable = false)
    private SchoolType schoolType;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private Boolean active;

    public Client() {
        super();
        this.prepare();
    }

    public Client(ClientPostRequest clientRequest) {
        this.prepare();
        this.name = clientRequest.getName();
        this.email = clientRequest.getEmail();
        this.password = clientRequest.getPassword();
        this.schoolType = clientRequest.getSchoolType();
    }

    /* Um dia irei usar este método ;) */
    public void desactivateAccount() {
        this.active = false;
    }

    private void prepare() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.active = true;
    }

}
