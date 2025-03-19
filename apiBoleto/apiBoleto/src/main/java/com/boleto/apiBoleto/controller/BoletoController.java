package com.boleto.apiBoleto.controller;

import com.boleto.apiBoleto.model.Boleto;
import com.boleto.apiBoleto.service.BoletoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/boletos")
public class BoletoController {
    private final BoletoService boletoService;

    public BoletoController(BoletoService boletoService) {
        this.boletoService = boletoService;
    }

    @GetMapping
    public List<Boleto> listarBoletos (){
        return boletoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boleto> buscarBoletoPorId (@PathVariable Long id){
        Optional<Boleto> boleto = boletoService.buscarPorId(id);
        return boleto.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Boleto> criarBoleto(@Valid @RequestBody Boleto boleto){
        Boleto novoBoleto = boletoService.salvar(boleto);
        return ResponseEntity.ok(novoBoleto);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarBoleto(@PathVariable Long id){
        if(boletoService.buscarPorId(id).isPresent()){
            boletoService.deletar(id);
        }
        return ResponseEntity.notFound().build();
    }
}
