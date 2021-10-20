package com.example.onemessageapi.model.response;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ユーザー情報
 */
@ApiModel(description = "ユーザー情報")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
    date = "2021-10-18T03:09:09.476446Z[Etc/UTC]")
public class GetMeResponse {
  @JsonProperty("id")
  private UUID id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("email")
  private String email;

  public GetMeResponse id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * ID
   * 
   * @return id
   */
  @ApiModelProperty(required = true, value = "ID")
  @NotNull

  @Valid

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public GetMeResponse name(String name) {
    this.name = name;
    return this;
  }

  /**
   * ニックネーム
   * 
   * @return name
   */
  @ApiModelProperty(value = "ニックネーム")

  @Size(min = 1, max = 32)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GetMeResponse email(String email) {
    this.email = email;
    return this;
  }

  /**
   * メールアドレス
   * 
   * @return email
   */
  @ApiModelProperty(value = "メールアドレス")

  @Size(min = 1, max = 255)
  @javax.validation.constraints.Email
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetMeResponse getMeResponse = (GetMeResponse) o;
    return Objects.equals(this.id, getMeResponse.id) &&
        Objects.equals(this.name, getMeResponse.name) &&
        Objects.equals(this.email, getMeResponse.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetMeResponse {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
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

