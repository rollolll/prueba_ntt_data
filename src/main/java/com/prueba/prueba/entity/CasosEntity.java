package com.prueba.prueba.entity;

import com.prueba.prueba.dto.CasosDto;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;




@Entity
@Table(name = "casos", schema = "public")
@XmlRootElement

@SqlResultSetMapping(name = "CasosMapping", classes = {
        @ConstructorResult(targetClass = CasosDto.class, columns = {
                @ColumnResult(name = "id", type = Integer.class),
                @ColumnResult(name = "documento_afiliado", type = String.class),
                @ColumnResult(name = "descripcion", type = String.class),
                @ColumnResult(name = "estado", type = String.class)})
})

@SqlResultSetMapping(name = "CasoPorAfiliadoExistenteMapping",
        classes = {
                @ConstructorResult(
                        targetClass = Integer.class,
                        columns = {
                                @ColumnResult(name = "total", type = Integer.class)}
                )})


@NamedNativeQueries({

        @NamedNativeQuery(name = "CasosEntity.consultarCasoPorAfiliadoExistente",
                query = " SELECT count(*) AS total "
                        + "FROM casos "
                        + "WHERE documento_afiliado = :documento_afiliado ",
                resultSetMapping = "CasoPorAfiliadoExistenteMapping"),

        @NamedNativeQuery(name = "CasosEntity.consultarTodosCasos",
                query = " SELECT id,documento_afiliado,descripcion,estado "
                        + "FROM casos "
                        + "ORDER BY id ASC",
                resultSetMapping = "CasosMapping"),

        @NamedNativeQuery(name = "CasosEntity.consultarCasosPorDocumentoAfiliado",
                query = " SELECT id,documento_afiliado,descripcion,estado "
                        + " FROM casos WHERE documento_afiliado = :documento_afiliado "
                        + " ORDER BY id ASC",

                resultSetMapping = "CasosMapping"),

})

public class CasosEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private int id;

}