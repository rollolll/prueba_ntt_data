package com.prueba.prueba.repository;


import com.prueba.prueba.dto.CasosDto;
import com.prueba.prueba.entity.CasosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICasosRepository extends JpaRepository<CasosEntity, Integer> {

    @Query(nativeQuery = true)
    List<CasosDto> consultarTodosCasos();

    @Query(nativeQuery = true)
    List<CasosDto> consultarCasosPorDocumentoAfiliado(
            @Param("documento_afiliado") String documento_afiliado);

    @Query(nativeQuery = true)
    Integer consultarCasoPorAfiliadoExistente(
            @Param("documento_afiliado") String documento_afiliado);

    @Query(value = "INSERT INTO casos(documento_afiliado, descripcion,estado)"
            + "     VALUES (:documento_afiliado,:descripcion, :estado) "
            + "     RETURNING id", nativeQuery = true)
    public String crearCaso(
            @Param("documento_afiliado") String documento_afiliado,
            @Param("descripcion") String descripcion,
            @Param("estado") String estado);

    @Query(value = "UPDATE casos SET documento_afiliado = :documento_afiliado, descripcion = :descripcion, estado = :estado "
            + "     WHERE documento_afiliado = :documento_afiliado "
            + "     RETURNING id", nativeQuery = true)
    public String actualizarCaso(
            @Param("documento_afiliado") String documento_afiliado,
            @Param("descripcion") String descripcion,
            @Param("estado") String estado);

    @Query(value = "DELETE FROM casos WHERE documento_afiliado=:documento_afiliado RETURNING id", nativeQuery = true)
    public String eliminarCaso(@Param("documento_afiliado") String documento_afiliado);

}
