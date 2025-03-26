package com.exemplo.fatura.fatura.service;

import com.exemplo.fatura.fatura.model.Fatura;
import com.exemplo.fatura.fatura.repository.FaturaRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FaturaService {

    private final FaturaRepository faturaRepository;

    public FaturaService(FaturaRepository faturaRepository) {
        this.faturaRepository = faturaRepository;
    }

    public List<Fatura> listarTodos(){
        return faturaRepository.findAll();
    }

    public Fatura cadastrar(Fatura fatura){
        return faturaRepository.save(fatura);
    }

}
