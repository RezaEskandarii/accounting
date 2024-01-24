package com.accounting.shared;

//@Converter(autoApply = true)
//public class JpaConverterJson implements AttributeConverter<Object, String> {
//
//    private final static ObjectMapper objectMapper = new ObjectMapper();
//
//    @Override
//    public String convertToDatabaseColumn(Object meta) {
//        try {
//            return objectMapper.writeValueAsString(meta);
//        } catch (JsonProcessingException ex) {
//            return null;
//            // or throw an error
//        }
//    }
//
//    @Override
//    public Object convertToEntityAttribute(String dbData) {
//        try {
//            return objectMapper.readValue(dbData, Object.class);
//        } catch (IOException ex) {
//            // logger.error("Unexpected IOEx decoding json from database: " + dbData);
//            return null;
//        }
//    }
//
//}