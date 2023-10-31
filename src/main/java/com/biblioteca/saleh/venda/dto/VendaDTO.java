package com.biblioteca.saleh.venda.dto;

import com.biblioteca.saleh.venda.model.Venda;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public record VendaDTO(Long id, LocalDate dataVenda, BigDecimal valor) {

    public static VendaDTO fromVenda(Venda venda){
        return new VendaDTO(venda.getId(), venda.getDataVenda(), venda.getValor());
    }
    public static List<VendaDTO> converter(List<Venda> vendas){
        return vendas.stream().map(VendaDTO::fromVenda).collect(Collectors.toList());
    }
}
