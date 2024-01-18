package com.amorim.imagiliteapi.infra.repository;

import com.amorim.imagiliteapi.domain.entity.Image;
import com.amorim.imagiliteapi.domain.enums.ImageExtension;
import com.amorim.imagiliteapi.infra.repository.specs.GenericsSpecs;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.amorim.imagiliteapi.infra.repository.specs.GenericsSpecs.conjunction;
import static com.amorim.imagiliteapi.infra.repository.specs.ImageSpecs.*;
import static org.springframework.data.jpa.domain.Specification.anyOf;
import static org.springframework.data.jpa.domain.Specification.where;

public interface ImageRepository extends JpaRepository<Image, String>, JpaSpecificationExecutor<Image> {


    /**
     *
     * @param extension
     * @param query
     * @return
     *
     * SELECT * FROM IMAGE WHERE 1 = 1 AND EXTENSION = 'PNG'AND ( NAME LIKE 'QUERY'OR TAGS LIJE 'QUERY' )
     */
    default List<Image> findByExtensionAndNameOrTagsLike(ImageExtension extension, String query){
        Specification<Image> spec = where(conjunction());

        if(extension != null){
            spec = spec.and(extensionEqual(extension));
        }

        if(StringUtils.hasText(query)){

            spec = spec.and(anyOf(nameLike(query), tagsLike(query)));
        }

        return findAll(spec);

    }
}
