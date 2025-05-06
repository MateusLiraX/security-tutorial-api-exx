package application.record;

public record OpcaoDTO(
    Long id,
    String descricao,
    boolean isCorreta,
    Long questaoId
) {}