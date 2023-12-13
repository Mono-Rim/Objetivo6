package br.edu.ifsul.cstsi.objetivo6.motoristas;

import br.edu.ifsul.cstsi.objetivo6.corridas.Corrida;
import br.edu.ifsul.cstsi.objetivo6.veiculos.Veiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "Motorista")
@Table(name = "motorista")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Motorista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    @OneToOne
    @JoinColumn(name = "veiculo_id", referencedColumnName = "id", unique = true)
    private Veiculo veiculo;
    @OneToMany(mappedBy = "motorista")
    private List<Corrida> corridas;


}
