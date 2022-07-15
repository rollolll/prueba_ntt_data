package com.prueba.prueba.services.impl;

import com.prueba.prueba.dto.AfiliadosDto;
import com.prueba.prueba.dto.RpaNuevoAfiliadoDto;
import com.prueba.prueba.repository.IAfiliadosRepository;
import com.prueba.prueba.repository.ICasosRepository;
import com.prueba.prueba.services.IAfiliadosService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class AfiliadosServiceImpl implements IAfiliadosService {

    private IAfiliadosRepository iAfiliadosRepository;
    private ICasosRepository iCasosRepository;

    @Autowired
    public AfiliadosServiceImpl(IAfiliadosRepository iAfiliadosRepository, ICasosRepository iCasosRepository) {
        this.iAfiliadosRepository = iAfiliadosRepository;
        this.iCasosRepository = iCasosRepository;
    }


    @Override
    public List<AfiliadosDto> consultarTodosAfiliados() {
        List<AfiliadosDto> res = new ArrayList<>();
        try {
            res = iAfiliadosRepository.consultarTodosAfiliados();
        } catch (Exception e) {
            log.error("Error al consultar todos los afiliados", e);
        }
        return res;
    }

    @Override
    public List<AfiliadosDto> consultarAfiliadoPorDocumento(String documento) {
        List<AfiliadosDto> res = new ArrayList<>();
        try {
            res = iAfiliadosRepository.consultarAfiliadoPorDocumento(documento);
        } catch (Exception e) {
            log.error("Error al consultar afiliado por documento", e);
        }
        return res;
    }

    @Override
    public String crearAfiliado(RpaNuevoAfiliadoDto rpaNuevoAfiliadoDto) {

        try {
            Integer validarAfiliado = iAfiliadosRepository.consultarDocumentoExistente(rpaNuevoAfiliadoDto.getDocumento());

            if (validarAfiliado == 0) {
                iAfiliadosRepository.crearAfiliado(
                        rpaNuevoAfiliadoDto.getNombre(),
                        rpaNuevoAfiliadoDto.getApellido(),
                        rpaNuevoAfiliadoDto.getDocumento());
            } else {
                return "Ya existe un afiliado con el documento ingresado";
            }
        } catch (Exception e) {
            log.error("Error al crear afiliado", e);
            return "Error al crear afiliado";
        }
        return "Afiliado creado";
    }

    @Override
    public String actualizarAfiliado(RpaNuevoAfiliadoDto rpaNuevoAfiliadoDto) {
        try {
            Integer validarAfiliado = iAfiliadosRepository.consultarDocumentoExistente(rpaNuevoAfiliadoDto.getDocumento());

            if (validarAfiliado > 0) {
                iAfiliadosRepository.actualizarAfiliado(
                        rpaNuevoAfiliadoDto.getNombre(),
                        rpaNuevoAfiliadoDto.getApellido(),
                        rpaNuevoAfiliadoDto.getDocumento());
            } else {
                return "No existe un afiliado con el documento ingresado para ser actualizado";
            }

        } catch (Exception e) {
            log.error("Error al actualizar afiliado", e);
            return "Error al actualizar afiliado";
        }
        return "Afiliado actualizado";
    }

    @Override
    public String eliminarAfiliado(String documento) {
        try{
            Integer validarAfiliado = iAfiliadosRepository.consultarDocumentoExistente(documento);
            Integer validarCasosAfiliado = iCasosRepository.consultarCasoPorAfiliadoExistente(documento);

            if (validarAfiliado > 0) {
                if (validarCasosAfiliado > 0){
                    iCasosRepository.eliminarCaso(documento);
                }
                iAfiliadosRepository.eliminarAfiliado(documento);
            } else {
                return "No existe un afiliado con el documento ingresado para ser eliminado";
            }
        }catch (Exception e) {
            log.error("Error al eliminar afiliado", e);
            return "Error al eliminar afiliado";
        }
        return "Afiliado eliminado";
    }
}
