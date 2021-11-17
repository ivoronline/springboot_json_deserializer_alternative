package com.ivoronline.springboot_json_deserializer_alternative.DTO;

public class PersonDTO {

  //PROPERTIES
  public String propName;
  public Float  propHeight;                      //TO STORE FORMATTED FLOAT VALUE 1.67

  //CONSTRUCTOR                                  //DESERIALIZATION USES CONSTRUCTOR IF AVAILABLE
  PersonDTO(String name, String height) {        //STRING HEIGHT TO STORE COMMA SEPARATED JSON STRING "1,67"
    this.propName = name;                        //DESERIALIZED PROPERTY THAT DOESN'T NEED CUSTOM REFORMATTING
    convertHeight(height);                       //PROPERTY THAT NEEDS CUSTOM DESERIALIZATION
  }

  //CONVERTERS
  public void convertHeight(String height) {
    height          = height.replace(",", ".");  //HEIGHT FROM JSON: REPLACE DOT WITH COMMA
    this.propHeight = Float.parseFloat(height);  //HEIGHT FROM DTO:  PARSE STRING INTO FLOAT
  }

}
