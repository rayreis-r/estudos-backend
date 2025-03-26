package com.exemplo.fatura.fatura.controller;

import com.exemplo.fatura.fatura.model.Fatura;
import com.exemplo.fatura.fatura.service.FaturaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faturas")
public class FaturaController {
    private final FaturaService faturaService;

    public FaturaController(FaturaService faturaService) {
        this.faturaService = faturaService;
    }

    @GetMapping
    public List<Fatura> listarFaturas(){
        return faturaService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Fatura> cadastrarFatura(@Valid @RequestBody Fatura fatura){
        Fatura novaFatura = faturaService.cadastrar(fatura);
        return ResponseEntity.ok(novaFatura);
    }


}
