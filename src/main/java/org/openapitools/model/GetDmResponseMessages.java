package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.*;

/**
 * メッセージ送信履歴情報
 */
@ApiModel(description = "メッセージ送信履歴情報")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-31T00:47:22.927123Z[Etc/UTC]")
public class GetDmResponseMessages   {
  @JsonProperty("message")
  private String message;

  @JsonProperty("postDateTime")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime postDateTime;

  public GetDmResponseMessages message(String message) {
    this.message = message;
    return this;
  }

  /**
   * メッセージ送信履歴
   * @return message
  */
  @ApiModelProperty(required = true, value = "メッセージ送信履歴")
  @NotNull


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public GetDmResponseMessages postDateTime(OffsetDateTime postDateTime) {
    this.postDateTime = postDateTime;
    return this;
  }

  /**
   * メッセージ送信日時
   * @return postDateTime
  */
  @ApiModelProperty(required = true, value = "メッセージ送信日時")
  @NotNull

  @Valid

  public OffsetDateTime getPostDateTime() {
    return postDateTime;
  }

  public void setPostDateTime(OffsetDateTime postDateTime) {
    this.postDateTime = postDateTime;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetDmResponseMessages getDmResponseMessages = (GetDmResponseMessages) o;
    return Objects.equals(this.message, getDmResponseMessages.message) &&
        Objects.equals(this.postDateTime, getDmResponseMessages.postDateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, postDateTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetDmResponseMessages {\n");
    
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    postDateTime: ").append(toIndentedString(postDateTime)).append("\n");
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

