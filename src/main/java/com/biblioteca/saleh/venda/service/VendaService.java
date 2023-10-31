package com.biblioteca.saleh.venda.service;

import com.biblioteca.saleh.venda.dto.VendasPorMesDTO;
import com.biblioteca.saleh.venda.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VendaService {
    @Autowired
    VendaRepository vendaRepository;
    public List<VendasPorMesDTO> consultarVendasPorMes(){
        return vendaRepository.getTotalVendasPorMes();
    }
}
