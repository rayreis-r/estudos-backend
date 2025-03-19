package com.boleto.apiBoleto.repository;

import com.boleto.apiBoleto.model.Boleto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoletoRepository extends JpaRepository <Boleto, Long> {
}
