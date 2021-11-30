package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * 初期登録時のユーザー情報
 */
@ApiModel(description = "初期登録時のユーザー情報")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-11-30T02:19:55.570490Z[Etc/UTC]")
public class CreateMeRequest   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("email")
  private String email;

  @JsonProperty("password")
  private String password;

  public CreateMeRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * ユーザーネーム
   * @return name
  */
  @ApiModelProperty(required = true, value = "ユーザーネーム")
  @NotNull

@Size(min = 1, max = 32) 
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreateMeRequest email(String email) {
    this.email = email;
    return this;
  }

  /**
   * メールアドレス
   * @return email
  */
  @ApiModelProperty(required = true, value = "メールアドレス")
  @NotNull

@Size(min = 1, max = 255) @javax.validation.constraints.Email
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public CreateMeRequest password(String password) {
    this.password = password;
    return this;
  }

  /**
   * パスワード
   * @return password
  */
  @ApiModelProperty(required = true, value = "パスワード")
  @NotNull

@Pattern(regexp = "^[a-zA-Z0-9.?/-]{8,}$") @Size(min = 8) 
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateMeRequest createMeRequest = (CreateMeRequest) o;
    return Objects.equals(this.name, createMeRequest.name) &&
        Objects.equals(this.email, createMeRequest.email) &&
        Objects.equals(this.password, createMeRequest.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, email, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateMeRequest {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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

