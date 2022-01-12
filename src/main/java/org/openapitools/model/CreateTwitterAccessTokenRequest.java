package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.*;

/**
 * Twitterのアクセストークン
 */
@ApiModel(description = "Twitterのアクセストークン")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-12T14:17:29.140063Z[Etc/UTC]")
public class CreateTwitterAccessTokenRequest   {
  @JsonProperty("accessToken")
  private String accessToken;

  @JsonProperty("secretKey")
  private String secretKey;

  public CreateTwitterAccessTokenRequest accessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

  /**
   * Twitterのアクセストークン
   * @return accessToken
  */
  @ApiModelProperty(required = true, value = "Twitterのアクセストークン")
  @NotNull


  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public CreateTwitterAccessTokenRequest secretKey(String secretKey) {
    this.secretKey = secretKey;
    return this;
  }

  /**
   * Twitterのアクセス用秘密鍵
   * @return secretKey
  */
  @ApiModelProperty(required = true, value = "Twitterのアクセス用秘密鍵")
  @NotNull


  public String getSecretKey() {
    return secretKey;
  }

  public void setSecretKey(String secretKey) {
    this.secretKey = secretKey;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateTwitterAccessTokenRequest createTwitterAccessTokenRequest = (CreateTwitterAccessTokenRequest) o;
    return Objects.equals(this.accessToken, createTwitterAccessTokenRequest.accessToken) &&
        Objects.equals(this.secretKey, createTwitterAccessTokenRequest.secretKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessToken, secretKey);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateTwitterAccessTokenRequest {\n");
    
    sb.append("    accessToken: ").append(toIndentedString(accessToken)).append("\n");
    sb.append("    secretKey: ").append(toIndentedString(secretKey)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

