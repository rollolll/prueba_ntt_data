package com.prueba.prueba.repository;

import com.prueba.prueba.dto.AfiliadosDto;
import com.prueba.prueba.entity.AfiliadosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAfiliadosRepository extends JpaRepository<AfiliadosEntity, Integer>  {

    @Query(nativeQuery = true)
    List<AfiliadosDto> consultarTodosAfiliados();

    @Query(nativeQuery = true)
    List<AfiliadosDto> consultarAfiliadoPorDocumento(
            @Param("documento") String documento);

    @Query(nativeQuery = true)
    Integer consultarDocumentoExistente(
            @Param("documento") String documento);


    @Query(value = "INSERT INTO afiliados(nombre, apellido,documento)"
            + "     VALUES (:nombre,:apellido, :documento) "
            + "     RETURNING id", nativeQuery = true)
    public String crearAfiliado(
            @Param("nombre") String nombre,
            @Param("apellido") String apellido,
            @Param("documento") String documento);

    @Query(value = "UPDATE afiliados SET nombre = :nombre, apellido = :apellido, documento = :documento "
            + "     WHERE documento = :documento "
            + "     RETURNING id", nativeQuery = true)
    public String actualizarAfiliado(
            @Param("nombre") String nombre,
            @Param("apellido") String apellido,
            @Param("documento") String documento);


    @Query(value = "DELETE FROM afiliados WHERE documento=:documento RETURNING id", nativeQuery = true)
    public String eliminarAfiliado(@Param("documento") String documento);
}
