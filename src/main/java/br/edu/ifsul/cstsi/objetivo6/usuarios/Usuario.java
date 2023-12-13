package br.edu.ifsul.cstsi.objetivo6.usuarios;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity(name = "Usuario")
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private String placa;
    private Date anoFabricacao;



}
