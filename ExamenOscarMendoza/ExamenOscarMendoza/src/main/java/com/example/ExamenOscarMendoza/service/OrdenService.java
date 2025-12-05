package com.example.ExamenOscarMendoza.service;

import com.example.ExamenOscarMendoza.dto.OrdenDTO;
import com.example.ExamenOscarMendoza.model.OrdenCompra;
import com.example.ExamenOscarMendoza.repository.OrdenRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrdenService {
    private final OrdenRepository ordenRepository;

    public OrdenService(OrdenRepository ordenRepository) {
        this.ordenRepository = ordenRepository;
    }

    public Map<String, Object> CreateOrden(OrdenDTO ordenDTO) {
        Map<String, Object> respuesta = new HashMap<>();


        if(OrdenRepository.existsByOrden(ordenDTO.getFechaCreacion())){
            respuesta.put("mensaje", "La ya existe");
            respuesta.put("code", 400);
            return respuesta;
        }

        OrdenCompra ordenCompra =  new OrdenCompra();
        ordenCompra.setFechaCreacion(ordenDTO.getFechaCreacion());
        ordenRepository.save(ordenCompra);

        respuesta.put("message", "Cuenta creada con exito");
        respuesta.put("code", 200);
        respuesta.put("producto", ordenCompra);
        return respuesta;
    }
    }
}
