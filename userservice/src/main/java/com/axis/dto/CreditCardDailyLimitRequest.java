package com.axis.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import io.swagger.annotations.ApiModelProperty;

public class CreditCardDailyLimitRequest {

	@Positive(message = "Id Must be positive")
	  @ApiModelProperty(value = "id  of card", required = true)
	  private Long id;

	  @NotNull(message = "Phone Not Allow empty")
	  @ApiModelProperty(value = "Daily limit of card", required = true, example = "1000.00")
	  private Double dailyLimit;
}
