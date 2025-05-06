package application.service;

import application.model.Questao;
import application.record.QuestaoDTO;
import application.repository.CategoriaRepository;
import application.repository.QuestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestaoService {
    @Autowired
    private QuestaoRepository questaoRepository;
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Questao> findAll() {
        return questaoRepository.findAll();
    }

    public Optional<Questao> findById(Long id) {
        return questaoRepository.findById(id);
    }

    public Questao save(QuestaoDTO questaoDTO) {
        Questao questao = new Questao();
        questao.setEnunciado(questaoDTO.enunciado());
        
        categoriaRepository.findById(questaoDTO.categoriaId()).ifPresent(questao::setCategoria);
        
        return questaoRepository.save(questao);
    }

    public void deleteById(Long id) {
        questaoRepository.deleteById(id);
    }
}