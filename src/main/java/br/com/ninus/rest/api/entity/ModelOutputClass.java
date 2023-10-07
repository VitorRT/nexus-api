package br.com.ninus.rest.api.entity;

import br.com.ninus.rest.api.controller.impl.ModelOutputClassControllerImpl;
import br.com.ninus.rest.api.entity.dto.modelOutputClass.ModelOutputClassGPTDetails;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.time.LocalDateTime;

@Entity
@Table(name = "model_class")
@Data
@EqualsAndHashCode(of = {"id"})
public class ModelOutputClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "model_input_fk")
    private ModelInputClass modelInputClass;

    @Column(nullable = false)
    @Lob
    @NotBlank(message = "a introdução não pode ser vazia ou nula.")
    private String introduction;

    @Column(name="learning_objective", nullable = false)
    @Lob
    @NotBlank(message = "o objetivo de aprendizagem não pode ser vazio ou nulo.")
    private String learningObjective;

    @Column(nullable = false)
    @Lob
    @NotBlank(message = "o desenvolvimento não pode ser vazio ou nulo.")
    private String deployment;

    @Column(nullable = false)
    @Lob
    @NotBlank(message = "os recursos não podem ser vazios ou nulos.")
    private String resources;

    @Column(nullable = false)
    @Lob
    @NotBlank(message = "as adaptações não podem ser vazias ou nulas.")
    private String adaptions;

    @Column(name = "context_world", nullable = false)
    @Lob
    @JsonProperty(value = "context_world")
    @NotBlank(message = "a relação com o contexto e o mundo não pode ser vazia ou nula.")
    private String contextWorld;

    @Column(name = "valuing_culture_diversity", nullable = false)
    @Lob
    @JsonProperty(value = "valuing_culture_diversity")
    @NotBlank(message = "a valorização da cultura não pode ser vazia ou nula.")
    private String valuingCultureDiversity;

    @Column(nullable = false)
    @Lob
    @NotBlank(message = "os jogos/brincadeiras não podem ser vazios ou nulos.")
    private String games;

    @Column(name = "family_participation", nullable = false)
    @Lob
    @NotBlank(message = "a participação em familia não pode ser vazia ou nula.")
    private String familyParticipation;

    @Column(nullable = false)
    @Lob
    @NotBlank(message = "a conclusão não pode ser vazia ou nula.")
    private String conclusion;

    @Column(name = "final_remarks", nullable = false)
    @Lob
    @JsonProperty(value = "final_remarks")
    @NotBlank(message = "as observações finais não podem ser vazias ou nulas.")
    private String finalRemarks;

    @Column(nullable = false)
    @Lob
    @NotBlank(message = "as metas não podem ser vazias ou nulas.")
    private String goals;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private Boolean active;


    public ModelOutputClass() {
        this.prepare();
    }

    public ModelOutputClass(ModelOutputClassGPTDetails dto) {
        this.prepare();
        this.introduction = dto.getIntroduction();
        this.learningObjective = dto.getLearningObjective();
        this.deployment = dto.getDeployment();
        this.resources = dto.getResources();
        this.adaptions = dto.getAdaptions();
        this.contextWorld = dto.getContextWorld();
        this.valuingCultureDiversity = dto.getValuingCultureDiversity();
        this.games = dto.getGames();
        this.familyParticipation = dto.getFamilyParticipation();
        this.conclusion = dto.getConclusion();
        this.finalRemarks = dto.getFinalRemarks();
        this.goals = dto.getGoals();
    }

    private void prepare() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.active = true;
    }

    public EntityModel<ModelOutputClass> toEntityModel() {
        return EntityModel.of(this,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ModelOutputClassControllerImpl.class).show(this.id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ModelOutputClassControllerImpl.class).findAll(Pageable.unpaged())).withRel("all"));
    }

}
