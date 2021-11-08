package com.example.onemessageapi.model.request;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * OAuth認可用暗証番号
 */
@ApiModel(description = "OAuth認可用暗証番号")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2021-11-08T04:28:10.768641Z[Etc/UTC]")
public class CreateTwitterAccessTokenRequest {
  @JsonProperty("passwordNumber")
  private BigDecimal passwordNumber;

  public CreateTwitterAccessTokenRequest passwordNumber(BigDecimal passwordNumber) {
    this.passwordNumber = passwordNumber;
    return this;
  }

  /**
   * OAuth認可用暗証番号
   * 
   * @return passwordNumber
   */
  @ApiModelProperty(required = true, value = "OAuth認可用暗証番号")
  @NotNull

  @Valid

  public BigDecimal getPasswordNumber() {
    return passwordNumber;
  }

  public void setPasswordNumber(BigDecimal passwordNumber) {
    this.passwordNumber = passwordNumber;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateTwitterAccessTokenRequest createTwitterAccessTokenRequest =
        (CreateTwitterAccessTokenRequest) o;
    return Objects.equals(this.passwordNumber, createTwitterAccessTokenRequest.passwordNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(passwordNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateTwitterAccessTokenRequest {\n");

    sb.append("    passwordNumber: ").append(toIndentedString(passwordNumber)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

