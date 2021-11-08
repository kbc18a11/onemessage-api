package com.example.onemessageapi.model.response;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TwitterのOAuth認可用のURL
 */
@ApiModel(description = "TwitterのOAuth認可用のURL")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2021-11-08T04:28:10.768641Z[Etc/UTC]")
public class GetTwitterAuthUrlResponse {
  @JsonProperty("authUrl")
  private String authUrl;

  public GetTwitterAuthUrlResponse authUrl(String authUrl) {
    this.authUrl = authUrl;
    return this;
  }

  /**
   * ID
   * 
   * @return authUrl
   */
  @ApiModelProperty(required = true, value = "ID")
  @NotNull


  public String getAuthUrl() {
    return authUrl;
  }

  public void setAuthUrl(String authUrl) {
    this.authUrl = authUrl;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetTwitterAuthUrlResponse getTwitterAuthUrlResponse = (GetTwitterAuthUrlResponse) o;
    return Objects.equals(this.authUrl, getTwitterAuthUrlResponse.authUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(authUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetTwitterAuthUrlResponse {\n");

    sb.append("    authUrl: ").append(toIndentedString(authUrl)).append("\n");
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

