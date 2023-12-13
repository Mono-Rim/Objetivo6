package br.edu.ifsul.cstsi.objetivo6.veiculos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{

    @Query(value = "SELECT v FROM Veiculo v where v.placa like ?1")
    List<Veiculo> findByPlaca(String placa);

    @Query(value = "SELECT v FROM Veiculo v where v.id = ?1")
    Optional<Veiculo> findById(Long id);

}
