package com.ivoronline.springboot_json_deserializer_alternative.DTO;

public class PersonDTO {

  //PROPERTIES
  public String propName;
  public Float  propHeight;                      //To store formatted float value 1.67

  //CONSTRUCTOR                                  //Deserialization uses constructor if available
  PersonDTO(String name, String height) {        //String height to store comma separated json string "1,67"
    this.propName = name;                        //Property that doesn't need reformatting
    convertHeight(height);                       //Property that needs        reformatting
  }

  //CONVERTERS
  public void convertHeight(String height) {
    String heightFormatted = height.replace(",", ".");           //Height from json: replace dot with comma
    this.propHeight        = Float.parseFloat(heightFormatted);  //Height from dto:  parse string into float
  }

}
