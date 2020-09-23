package com.airhacks.repository;

import com.airhacks.model.AdmTypology;
import com.airhacks.model.AdmTypology_;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.criteria.Criteria;
import org.apache.deltaspike.data.api.criteria.CriteriaSupport;

import java.util.List;

@Repository(forEntity = AdmTypology.class)
public abstract class AdmTypologyRepository extends AbstractEntityRepository<AdmTypology, Long>
        implements CriteriaSupport<AdmTypology> {

    public List<AdmTypology> getAll(Long parent) {

        Criteria<AdmTypology, AdmTypology> generalQuery = criteria();
        generalQuery.eq(AdmTypology_.parent, parent);
        List<AdmTypology> admTypologies = generalQuery.getResultList();
        return admTypologies;
    }

}
