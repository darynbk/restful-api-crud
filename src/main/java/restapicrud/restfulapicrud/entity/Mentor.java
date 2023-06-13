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

@Schema(description = "Информация о менторе")
@Entity
@Table(name = "mentors")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mentor {
    @Schema(description = "ID ментора")
    @Min(1) @Max(999999)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "mentor_id")
    private Long id;

    @Schema(description = "Имя ментора")
    @Size(min = 1, max = 30)
    @NotBlank
    @Column(name = "mentor_name")
    private String name;

    @Schema(description = "Дата рождения ментора")
    @NotBlank
    @Column(name = "birth_date")
    private LocalDate birthDate;
}
