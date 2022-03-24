package com.airhacks.repository;

import com.airhacks.model.AdmCliente;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.criteria.Criteria;
import org.apache.deltaspike.data.api.criteria.CriteriaSupport;

import java.util.List;

@Repository(forEntity = AdmCliente.class)
public abstract class AdmClienteRepository extends AbstractEntityRepository<AdmCliente, Long>
implements CriteriaSupport<AdmCliente> {

    public AdmCliente getClienteById(Long id)
    {
        return this.findBy(id);
    }


    public List<AdmCliente> getAll(){
        Criteria<AdmCliente, AdmCliente> query = criteria();

        List<AdmCliente> clientes = query.getResultList();
        return clientes;
    }
}
