package com.prueba.prueba.services.impl;

import com.prueba.prueba.dto.CasosDto;
import com.prueba.prueba.dto.RpaNuevoCasoDto;
import com.prueba.prueba.repository.IAfiliadosRepository;
import com.prueba.prueba.repository.ICasosRepository;
import com.prueba.prueba.services.ICasosService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class CasosServiceImpl implements ICasosService {

    private ICasosRepository iCasosRepository;
    private IAfiliadosRepository iAfiliadosRepository;

    @Autowired
    public CasosServiceImpl(ICasosRepository iCasosRepository, IAfiliadosRepository iAfiliadosRepository) {
        this.iCasosRepository = iCasosRepository;
        this.iAfiliadosRepository = iAfiliadosRepository;
    }

    @Override
    public List<CasosDto> consultarTodosCasos() {
        List<CasosDto> res = new ArrayList<>();
        try {
            res = iCasosRepository.consultarTodosCasos();
        } catch (Exception e) {
            log.error("Error al consultar todos los casos", e);
        }
        return res;
    }

    @Override
    public List<CasosDto> consultarCasoPorDocumentoAfiliado(String documento) {
        List<CasosDto> res = new ArrayList<>();
        try {
            res = iCasosRepository.consultarCasosPorDocumentoAfiliado(documento);
        } catch (Exception e) {
            log.error("Error al consultar caso por documento afiliado", e);
        }
        return res;
    }

    @Override
    public String crearCaso(RpaNuevoCasoDto rpaNuevoCasoDto) {
        try {
            int validarAfiliado = iAfiliadosRepository.consultarDocumentoExistente(rpaNuevoCasoDto.getDocumento_afiliado());
            int validarCaso = iCasosRepository.consultarCasoPorAfiliadoExistente(rpaNuevoCasoDto.getDocumento_afiliado());
            if (validarAfiliado == 0) {
                return "No se puede crear el caso, el afiliado no existe";
            }
            if (validarCaso == 0) {
                iCasosRepository.crearCaso(
                        rpaNuevoCasoDto.getDocumento_afiliado(),
                        rpaNuevoCasoDto.getDescripcion(),
                        rpaNuevoCasoDto.getEstado());
            } else {
                return "El afiliado ya tiene un caso registrado";
            }
        } catch (Exception e) {
            log.error("Error al crear caso", e);
        }
        return "Caso creado correctamente";
    }

    @Override
    public String actualizarCaso(RpaNuevoCasoDto rpaNuevoCasoDto) {
        try {
            int validarCaso = iCasosRepository.consultarCasoPorAfiliadoExistente(rpaNuevoCasoDto.getDocumento_afiliado());
            if (validarCaso > 0) {
                iCasosRepository.actualizarCaso(
                        rpaNuevoCasoDto.getDocumento_afiliado(),
                        rpaNuevoCasoDto.getDescripcion(),
                        rpaNuevoCasoDto.getEstado());
            } else {
                return "El afiliado no tiene un caso registrado";
            }
        } catch (Exception e) {
            log.error("Error al actualizar caso", e);
        }
        return "Caso actualizado correctamente";
    }

    @Override
    public String eliminarCaso(String documento) {
        try {
            Integer validarCasosAfiliado = iCasosRepository.consultarCasoPorAfiliadoExistente(documento);

            if (validarCasosAfiliado > 0) {
                iCasosRepository.eliminarCaso(documento);
            }

        } catch (Exception e) {
            log.error("Error al eliminar caso", e);
        }
        return "Caso eliminado correctamente";
    }
}
