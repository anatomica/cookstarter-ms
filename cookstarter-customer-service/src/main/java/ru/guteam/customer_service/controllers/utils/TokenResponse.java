package ru.guteam.customer_service.controllers.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Class representing a JWT token in the application.")
public class TokenResponse {
    @NotNull
    @ApiModelProperty(notes = "Unique token", example = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMDAiLCJyb2xlIjpbIkNVU1RPTUVSIl0sImV4cCI6MTYwMzM4MDUxNywiaWF0IjoxNjAzMzc2OTE3fQ.FCNPs5fKYSqVihxLyFzeriDm7MfaSEynHNpz0AVXN9s", required = true)
    private String token;
}
