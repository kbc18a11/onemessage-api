package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.model.GetDmResponseMessages;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.*;

/**
 * DM送信情報
 */
@ApiModel(description = "DM送信情報")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-31T00:47:22.927123Z[Etc/UTC]")
public class GetDmResponse   {
  @JsonProperty("messages")
  @Valid
  private List<GetDmResponseMessages> messages = new ArrayList<>();

  public GetDmResponse messages(List<GetDmResponseMessages> messages) {
    this.messages = messages;
    return this;
  }

  public GetDmResponse addMessagesItem(GetDmResponseMessages messagesItem) {
    this.messages.add(messagesItem);
    return this;
  }

  /**
   * メッセージ送信履歴一覧
   * @return messages
  */
  @ApiModelProperty(required = true, value = "メッセージ送信履歴一覧")
  @NotNull

  @Valid

  public List<GetDmResponseMessages> getMessages() {
    return messages;
  }

  public void setMessages(List<GetDmResponseMessages> messages) {
    this.messages = messages;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetDmResponse getDmResponse = (GetDmResponse) o;
    return Objects.equals(this.messages, getDmResponse.messages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(messages);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetDmResponse {\n");
    
    sb.append("    messages: ").append(toIndentedString(messages)).append("\n");
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

