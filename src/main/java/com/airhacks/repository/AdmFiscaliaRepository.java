package com.airhacks.repository;

import com.airhacks.model.AdmFiscalia;
import com.airhacks.model.AdmFiscalia_;

import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.criteria.Criteria;
import org.apache.deltaspike.data.api.criteria.CriteriaSupport;

import java.util.List;

@Repository(forEntity = AdmFiscalia.class)
public abstract class AdmFiscaliaRepository extends AbstractEntityRepository<AdmFiscalia, Long>
        implements CriteriaSupport<AdmFiscalia> {

    public List<AdmFiscalia> getAll() {
        Criteria<AdmFiscalia, AdmFiscalia> generalQuery = criteria();

        List<AdmFiscalia> admFiscalias = generalQuery.getResultList();
        return admFiscalias;
    }
}
