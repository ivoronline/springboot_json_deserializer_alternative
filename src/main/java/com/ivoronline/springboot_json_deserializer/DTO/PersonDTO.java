package com.ivoronline.springboot_json_deserializer.DTO;

public class PersonDTO {

  //PROPERTIES
  public String name;
  public Float  height;                      //TO STORE FORMATTED FLOAT VALUE 1.67

  //CONSTRUCTOR                              //DESERIALIZATION USES CONSTRUCTOR IF AVAILABLE
  PersonDTO(String name, String height) {    //STRING HEIGHT TO STORE COMMA SEPARATED JSON STRING "1,67"
    this.name = name;                        //DESERIALIZED PROPERTY THAT DOESN'T NEED CUSTOM REFORMATTING
    convertHeight(height);                   //PROPERTY THAT NEEDS CUSTOM DESERIALIZATION
  }

  //CONVERTERS
  public void convertHeight(String height) {
    height      = height.replace(",", ".");  //HEIGHT FROM JSON: REPLACE DOT WITH COMMA
    this.height = Float.parseFloat(height);  //HEIGHT FROM DTO:  PARSE STRING INTO FLOAT
  }

}
