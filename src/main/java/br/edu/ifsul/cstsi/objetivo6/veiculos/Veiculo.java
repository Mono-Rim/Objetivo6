package br.edu.ifsul.cstsi.objetivo6.veiculos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity(name = "Veiculo")
@Table(name = "veiculo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Veiculo {
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private String placa;
    private Date anoFabricacao;

    @Override
    public String toString() {
        return "Veiculo{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", placa='" + placa + '\'' +
                ", anoFabricacao=" + anoFabricacao +
                '}';
    }
}
