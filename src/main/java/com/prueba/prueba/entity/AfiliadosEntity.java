package com.prueba.prueba.entity;


import com.prueba.prueba.dto.AfiliadosDto;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "afiliados", schema = "public")
@XmlRootElement

@SqlResultSetMapping(name = "AfiliadosMapping", classes = {
        @ConstructorResult(targetClass = AfiliadosDto.class, columns = {
                @ColumnResult(name = "id", type = Integer.class),
                @ColumnResult(name = "nombre", type = String.class),
                @ColumnResult(name = "apellido", type = String.class),
                @ColumnResult(name = "documento", type = String.class)})
})

@SqlResultSetMapping(name = "DocumentoExistenteMapping",
        classes = {
                @ConstructorResult(
                        targetClass = Integer.class,
                        columns = {
                                @ColumnResult(name = "total", type = Integer.class)}
                )})


@NamedNativeQueries({

        @NamedNativeQuery(name = "AfiliadosEntity.consultarDocumentoExistente",
                query = " SELECT count(*) AS total "
                        + "FROM afiliados "
                        + "WHERE documento = :documento ",
                resultSetMapping = "DocumentoExistenteMapping"),

        @NamedNativeQuery(name = "AfiliadosEntity.consultarTodosAfiliados",
                query = " SELECT id, nombre,apellido,documento "
                        + "FROM afiliados "
                        + "ORDER BY id ASC",
                resultSetMapping = "AfiliadosMapping"),

        @NamedNativeQuery(name = "AfiliadosEntity.consultarAfiliadoPorDocumento",
                query = " SELECT id, nombre,apellido,documento "
                        + " FROM afiliados WHERE documento = :documento "
                        + " ORDER BY id ASC",
                resultSetMapping = "AfiliadosMapping"),

})

public class AfiliadosEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private int id;

}