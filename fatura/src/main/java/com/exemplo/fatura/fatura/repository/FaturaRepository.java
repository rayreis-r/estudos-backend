package com.exemplo.fatura.fatura.repository;

import com.exemplo.fatura.fatura.model.Fatura;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface FaturaRepository extends JpaRepository<Fatura, Long> {
}
