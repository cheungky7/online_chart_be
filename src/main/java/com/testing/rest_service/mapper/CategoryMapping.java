package com.testing.rest_service.mapper;

import com.testing.rest_service.domain.entities.Category;
import com.testing.rest_service.domain.entities.Product;
import com.testing.rest_service.swagger.dto.CategoryDTO;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

//https://www.perplexity.ai/search/modelmapper-custom-mapping-_55jpPbJRwiFlxCUEJ8Wdg

//https://www.perplexity.ai/search/modelmapper-map-set-to-set-gJ.LCsdsTR.jV4aGfkNLTQ

@Component
public class CategoryMapping {

    private final ModelMapper modelMapper;

    public CategoryMapping(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        TypeMap<Category, CategoryDTO> typeMap = modelMapper.createTypeMap(Category.class, CategoryDTO.class);

        /*
        typeMap.addMappings(mapper ->
                mapper.map(source -> source.getProducts().stream().map(elem->elem.getProductId()).collect(Collectors.toSet()),
                        (dest, value) -> dest.setProductIds(new HashSet<>((Set<String>) value))
                )
        );*/
/*
        Converter<Set<Product>, Set<Long>> toProductIds =
                ctx -> ctx== null ? null : ctx.getSource().stream().map(elem->elem.getProductId()).collect(Collectors.toSet());
*/

        Converter<Set<Product>, Set<Long>> toProductIds =  new Converter<Set<Product>, Set<Long>>(){
            public Set<Long> convert(MappingContext<Set<Product>, Set<Long>> ctx) {
                return ctx.getSource() == null ? null : ctx.getSource().stream().map(elem->elem.getProductId()).collect(Collectors.toSet());
            }
        };

        typeMap.addMappings(mapper -> mapper.using(toProductIds).map(Category::getProducts, CategoryDTO::setProductIds));

        // Add more mappings as needed
    }

    public CategoryDTO convertToDTO(Category category) {
        return modelMapper.map(category, CategoryDTO.class);
    }

}
