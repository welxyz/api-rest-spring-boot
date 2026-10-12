package xyz.mvc_crud.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String email,
        LocalDate dataNascimento,
        LocalDateTime dataCadastro,
        boolean ativo
) {}
