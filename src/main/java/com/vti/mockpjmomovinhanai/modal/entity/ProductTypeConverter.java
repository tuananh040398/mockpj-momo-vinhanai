package com.vti.mockpjmomovinhanai.modal.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ProductTypeConverter implements AttributeConverter<String, String> {
    @Override
    public String convertToDatabaseColumn(String productType) {
        return ProductType.valueOf(productType).name();
    }

    @Override
    public String convertToEntityAttribute(String s) {
        return ProductType.valueOf(s).productType;
    }
}
