package application.model;

import jakarta.persistence.*;

@Entity
public class Opcao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String descricao;
    private boolean isCorreta;
    
    @ManyToOne
    @JoinColumn(name = "questao_id")
    private Questao questao;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isCorreta() {
        return isCorreta;
    }

    public void setCorreta(boolean correta) {
        isCorreta = correta;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }
}