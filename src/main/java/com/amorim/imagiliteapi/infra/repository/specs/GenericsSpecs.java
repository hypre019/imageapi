package com.amorim.imagiliteapi.infra.repository.specs;

import org.springframework.data.jpa.domain.Specification;

public class GenericsSpecs {

    private GenericsSpecs(){}

    public static <T> Specification<T> conjunction(){
        return (root, q, criteriaBuilder) -> criteriaBuilder.conjunction();

    }
}
