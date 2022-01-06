package com.demo.concurrence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

public class HibernateAwareObjectMapper extends ObjectMapper {
    private static final long serialVersionUID = 1L;

    /**
     * @description Función que evita la serializacion recursiva del json. Estandar Arquitectura 2015.
     * @param void
     * @throws nothing
     * @author rvernaez
     * @CreateDate 26/02/2015
     * @ModifiedBy
     * @ModifiedDate
     * @Version 1.0
     */
    public HibernateAwareObjectMapper() {
        Hibernate4Module hm = new Hibernate4Module();
        hm.disable(Hibernate4Module.Feature.USE_TRANSIENT_ANNOTATION);
        registerModule(hm);
    }
}