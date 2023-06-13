package restapicrud.restfulapicrud.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Schema(description = "Информация о стажере")

@Entity
@Table(name = "trainees")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Trainee {
    @Schema(description = "ID стажера")
    @Min(1) @Max(999999)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "trainee_id")
    private Long id;

    @Schema(description = "Имя стажера")
    @Size(min = 1, max = 30)
    @NotBlank
    @Column(name = "trainee_name")
    private String trName;

    @Schema(description = "Дата рождения стажера")
    @NotBlank
    @Column(name = "birth_date")
    private LocalDate trBirthDate;

    @Schema(description = "Внешний ключ к ID ментора")
    @Min(1) @Max(999999)
    @NotBlank
    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private Mentor trMentorId;

    @Schema(description = "Имя ментора в таблице стажеров")
    @Size(min = 1, max = 30)
    @NotBlank
    @Column(name = "mentors_name")
    private String trMentorsName;
}
