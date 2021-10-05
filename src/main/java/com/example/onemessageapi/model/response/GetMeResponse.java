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
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-10-05T01:53:15.698503Z[Etc/UTC]")
public class GetMeResponse {
  @JsonProperty("id")
  private UUID id;

  @JsonProperty("displayName")
  private String displayName;

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

  public GetMeResponse displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

  /**
   * ニックネーム
   * 
   * @return displayName
   */
  @ApiModelProperty(required = true, value = "ニックネーム")
  @NotNull

  @Size(min = 1, max = 32)
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
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
    return Objects.equals(this.id, getMeResponse.id) && Objects.equals(this.displayName, getMeResponse.displayName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, displayName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetMeResponse {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
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
