package ma.fst.studentapi.dto;

import jakarta.validation.constraints.*;

public record StudentRequestDTO(
        @NotBlank(message = "Le prénom est obligatoire") String firstName,
        @NotBlank(message = "Le nom est obligatoire") String lastName,
        @NotBlank @Email(message = "Email invalide") String email,
        @NotBlank(message = "La filière est obligatoire") String major,
        @NotNull(message = "L'âge est obligatoire") @Min(value = 17) @Max(value = 100) Integer age
) {}