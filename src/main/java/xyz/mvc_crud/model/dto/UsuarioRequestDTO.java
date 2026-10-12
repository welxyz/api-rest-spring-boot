package xyz.mvc_crud.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record UsuarioRequestDTO(
    @NotNull
    @NotBlank
    String nome,

    @NotNull
    @Email
    String email,

    @NotNull
    @Past
    LocalDate dataNascimento
) {}
