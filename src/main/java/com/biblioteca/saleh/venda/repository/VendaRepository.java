package com.biblioteca.saleh.venda.repository;

import com.biblioteca.saleh.venda.dto.VendasPorMesDTO;
import com.biblioteca.saleh.venda.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Long> {
    @Query("SELECT NEW com.biblioteca.saleh.venda.dto.VendasPorMesDTO(EXTRACT(MONTH FROM v.dataVenda), SUM(v.valor)) " +
            "FROM Venda v " +
            "GROUP BY EXTRACT(MONTH FROM v.dataVenda)")
    List<VendasPorMesDTO> getTotalVendasPorMes();
}
