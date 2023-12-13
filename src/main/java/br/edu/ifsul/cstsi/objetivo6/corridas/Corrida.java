package br.edu.ifsul.cstsi.objetivo6.corridas;

import br.edu.ifsul.cstsi.objetivo6.motoristas.Motorista;
import br.edu.ifsul.cstsi.objetivo6.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity(name = "Corrida")
@Table(name = "corrida")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Corrida {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoPagamento;
    private String detalhesPagamento;
    private Date dataInicio;
    private double preco;
    private int attribute9;
    @ManyToOne
    @JoinColumn(name = "Usuario_id", referencedColumnName = "id")
    private Usuario usuario;
    @ManyToOne @JoinColumn(name = "Motorista_id", referencedColumnName = "id")
    private Motorista motorista;


}
