package com.axis.dto;

import javax.validation.constraints.Positive;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel(value ="CardDeactivateRequest")
public class CreditCardDeactivateRequest {

  @Positive(message = "Id Must be positive")
  @ApiModelProperty(value = "Id of creditcard", required = true)
  private Long id;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

}
