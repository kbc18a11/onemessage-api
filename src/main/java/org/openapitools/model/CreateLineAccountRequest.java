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
 * LINEアカウント登録情報
 */
@ApiModel(description = "LINEアカウント登録情報")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-12T14:17:29.140063Z[Etc/UTC]")
public class CreateLineAccountRequest   {
  @JsonProperty("channelToken")
  private String channelToken;

  public CreateLineAccountRequest channelToken(String channelToken) {
    this.channelToken = channelToken;
    return this;
  }

  /**
   * LINEのチャンネルトークン
   * @return channelToken
  */
  @ApiModelProperty(required = true, value = "LINEのチャンネルトークン")
  @NotNull


  public String getChannelToken() {
    return channelToken;
  }

  public void setChannelToken(String channelToken) {
    this.channelToken = channelToken;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateLineAccountRequest createLineAccountRequest = (CreateLineAccountRequest) o;
    return Objects.equals(this.channelToken, createLineAccountRequest.channelToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(channelToken);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateLineAccountRequest {\n");
    
    sb.append("    channelToken: ").append(toIndentedString(channelToken)).append("\n");
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

