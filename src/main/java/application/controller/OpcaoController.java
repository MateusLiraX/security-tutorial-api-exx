package application.controller;

import application.record.OpcaoDTO;
import application.service.OpcaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/opcoes")
public class OpcaoController {
    @Autowired
    private OpcaoService opcaoService;

    @PostMapping
    public ResponseEntity<?> createOpcao(@RequestBody OpcaoDTO opcaoDTO) {
        try {
            return ResponseEntity.ok(opcaoService.save(opcaoDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOpcao(@PathVariable Long id) {
        opcaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}