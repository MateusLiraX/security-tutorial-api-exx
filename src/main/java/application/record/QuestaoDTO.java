package application.record;

import java.util.List;

public record QuestaoDTO(
    Long id,
    String enunciado,
    Long categoriaId,
    List<OpcaoDTO> opcoes
) {}