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
 * LINEアカウント情報
 */
@ApiModel(description = "LINEアカウント情報")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-17T14:17:11.839899Z[Etc/UTC]")
public class GetLineAccountResponse   {
  @JsonProperty("displayName")
  private String displayName;

  @JsonProperty("pictureUrl")
  private String pictureUrl;

  public GetLineAccountResponse displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

  /**
   * アカウント名
   * @return displayName
  */
  @ApiModelProperty(required = true, value = "アカウント名")
  @NotNull


  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public GetLineAccountResponse pictureUrl(String pictureUrl) {
    this.pictureUrl = pictureUrl;
    return this;
  }

  /**
   * アカウントアイコン画像
   * @return pictureUrl
  */
  @ApiModelProperty(required = true, value = "アカウントアイコン画像")
  @NotNull


  public String getPictureUrl() {
    return pictureUrl;
  }

  public void setPictureUrl(String pictureUrl) {
    this.pictureUrl = pictureUrl;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetLineAccountResponse getLineAccountResponse = (GetLineAccountResponse) o;
    return Objects.equals(this.displayName, getLineAccountResponse.displayName) &&
        Objects.equals(this.pictureUrl, getLineAccountResponse.pictureUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(displayName, pictureUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetLineAccountResponse {\n");
    
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    pictureUrl: ").append(toIndentedString(pictureUrl)).append("\n");
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

