package com.airhacks.repository;

import com.airhacks.dto.AdmFiscaliaDto;
import com.airhacks.model.AdmFiscalia;
import com.airhacks.model.AdmFiscalia_;

import com.airhacks.model.AdmTypology;
import com.airhacks.model.AdmTypology_;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.criteria.Criteria;
import org.apache.deltaspike.data.api.criteria.CriteriaSupport;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository(forEntity = AdmFiscalia.class)
public abstract class AdmFiscaliaRepository extends AbstractEntityRepository<AdmFiscalia, Long>
        implements CriteriaSupport<AdmFiscalia> {


    @Inject
    EntityManager em;

    public AdmFiscalia  GetById(Long id ){

        Criteria<AdmFiscalia, AdmFiscalia > general = criteria();

        general.eq(AdmFiscalia_.fiscaliaId , id);

         return general.getAnyResult();

    }

    public AdmFiscalia  GetById2(Long id ){

        return  this.findBy(id);
    }

    public Optional<AdmFiscalia> GetById3(Long id){

        StringBuilder query = new StringBuilder();

        query.append(" select * from adm_fiscalia where fiscalia_id = ").append(id);

        Stream<AdmFiscaliaDto>  q = em.createNativeQuery(query.toString(),"admfiscaliadto" ).getResultStream();

        return q.map(x -> new AdmFiscalia(x.fiscalia_id,x.name )).findFirst();

    }


    public List<AdmFiscalia> getAll(Long country, Long state, Long city, Long zone) {
        Criteria<AdmFiscalia, AdmFiscalia> generalQuery = criteria();

        if (country != null)
            generalQuery.join(AdmFiscalia_.country,
                    where(AdmTypology.class)
                            .eq(AdmTypology_.typology_id, country));

        if (state != null)
            generalQuery.join(AdmFiscalia_.country,
                    where(AdmTypology.class)
                            .eq(AdmTypology_.typology_id, state));

        if (city != null)
            generalQuery.join(AdmFiscalia_.country,
                    where(AdmTypology.class)
                            .eq(AdmTypology_.typology_id, city));

        if (zone != null)
            generalQuery.join(AdmFiscalia_.country,
                    where(AdmTypology.class)
                            .eq(AdmTypology_.typology_id, zone));


        List<AdmFiscalia> admFiscalias = generalQuery.getResultList();
        return admFiscalias;
    }


}
