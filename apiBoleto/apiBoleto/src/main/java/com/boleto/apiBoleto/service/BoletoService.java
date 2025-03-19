package com.boleto.apiBoleto.service;
import com.boleto.apiBoleto.model.Boleto;
import com.boleto.apiBoleto.repository.BoletoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoletoService {
    private final BoletoRepository boletoRepository;

    public BoletoService(BoletoRepository boletoRepository) {
        this.boletoRepository = boletoRepository;
    }

    public List<Boleto> listarTodos(){
        return boletoRepository.findAll();
    }

    public Optional<Boleto> buscarPorId(Long id){
        return boletoRepository.findById(id);
    }

    public Boleto salvar(Boleto boleto){
        return boletoRepository.save(boleto);
    }

    public void deletar(Long id){
         boletoRepository.deleteById(id);
    }
}
