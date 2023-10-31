package com.biblioteca.saleh.venda.resource;

import com.biblioteca.saleh.venda.dto.VendaDTO;
import com.biblioteca.saleh.venda.dto.VendasPorMesDTO;
import com.biblioteca.saleh.venda.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequestMapping("/vendas")
@RestController
public class VendaResource {
    @Autowired
    VendaService vendaService;

    @GetMapping
    public ResponseEntity<List<VendaDTO>> listarVendas(){
        return this.vendaService.listarVendas();
    }

    @GetMapping("/consulta-vendas-por-mes")
    public ResponseEntity<List<VendasPorMesDTO>> consultarVendasPorMes(){
        List<VendasPorMesDTO> vendasPorMes = vendaService.consultarVendasPorMes();
        return new ResponseEntity<>(vendasPorMes, HttpStatus.OK);
    }
}
