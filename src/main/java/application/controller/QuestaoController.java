package application.controller;

import application.model.Questao;
import application.record.QuestaoDTO;
import application.service.QuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/questoes")
public class QuestaoController {
    @Autowired
    private QuestaoService questaoService;

    @GetMapping
    public List<Questao> getAllQuestoes() {
        return questaoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Questao> getQuestaoById(@PathVariable Long id) {
        Optional<Questao> questao = questaoService.findById(id);
        return questao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Questao createQuestao(@RequestBody QuestaoDTO questaoDTO) {
        return questaoService.save(questaoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestao(@PathVariable Long id) {
        questaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}