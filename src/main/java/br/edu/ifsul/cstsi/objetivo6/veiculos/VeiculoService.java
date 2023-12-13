package br.edu.ifsul.cstsi.objetivo6.veiculos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository rep;

    public List<Veiculo> getVeiculos() {
        return rep.findAll();
    }
    public List<Veiculo> getVeiculosByPlaca(String placa) {
        return new ArrayList<>(rep.findByPlaca(placa + "%"));
    }
    public Veiculo getVeiculoById(Long id) {
        Optional<Veiculo> optional = rep.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public Veiculo insert(Veiculo Veiculo) {
        Assert.isNull(Veiculo.getId(),"Não foi possível inserir o registro");
        return rep.save(Veiculo);
    }

    public Veiculo update(Veiculo Veiculo) {
        Assert.notNull(Veiculo.getId(),"Não foi possível atualizar o registro");


        Optional<Veiculo> optional = rep.findById(Veiculo.getId());
        if(optional.isPresent()) {
            Veiculo db = optional.get();

            db.setTipo(Veiculo.getTipo());
            db.setPlaca(Veiculo.getPlaca());
            db.setAnoFabricacao(Veiculo.getAnoFabricacao());

            rep.save(db);

            return db;
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }
}
