package application.service;

import application.model.Opcao;
import application.model.Questao;
import application.record.OpcaoDTO;
import application.repository.OpcaoRepository;
import application.repository.QuestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OpcaoService {
    @Autowired
    private OpcaoRepository opcaoRepository;
    
    @Autowired
    private QuestaoRepository questaoRepository;

    public Opcao save(OpcaoDTO opcaoDTO) {
        Opcao opcao = new Opcao();
        opcao.setDescricao(opcaoDTO.descricao());
        opcao.setCorreta(opcaoDTO.isCorreta());
        
        Optional<Questao> questao = questaoRepository.findById(opcaoDTO.questaoId());
        questao.ifPresent(opcao::setQuestao);
        
        return opcaoRepository.save(opcao);
    }

    public void deleteById(Long id) {
        opcaoRepository.deleteById(id);
    }
}