package com.axis.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.Positive;


@ApiModel(value ="CreditCardDetailRequest")
public class CreditCardDetailRequest {

  @Positive(message = "Id Must be positive")
  @ApiModelProperty(value = "Id of card", required = true)
  private Long id;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}
  
  

}
