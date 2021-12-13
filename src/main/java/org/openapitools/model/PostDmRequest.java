package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.model.PostDmRequestSendingAddresses;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DM送信情報
 */
@ApiModel(description = "DM送信情報")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-12-12T07:44:53.201564Z[Etc/UTC]")
public class PostDmRequest   {
  @JsonProperty("message")
  private String message;

  @JsonProperty("sendingAddresses")
  @Valid
  private List<PostDmRequestSendingAddresses> sendingAddresses = new ArrayList<>();

  public PostDmRequest message(String message) {
    this.message = message;
    return this;
  }

  /**
   * メッセージ
   * @return message
  */
  @ApiModelProperty(required = true, value = "メッセージ")
  @NotNull

@Size(min = 1, max = 10000) 
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public PostDmRequest sendingAddresses(List<PostDmRequestSendingAddresses> sendingAddresses) {
    this.sendingAddresses = sendingAddresses;
    return this;
  }

  public PostDmRequest addSendingAddressesItem(PostDmRequestSendingAddresses sendingAddressesItem) {
    this.sendingAddresses.add(sendingAddressesItem);
    return this;
  }

  /**
   * 送信先
   * @return sendingAddresses
  */
  @ApiModelProperty(required = true, value = "送信先")
  @NotNull

  @Valid

  public List<PostDmRequestSendingAddresses> getSendingAddresses() {
    return sendingAddresses;
  }

  public void setSendingAddresses(List<PostDmRequestSendingAddresses> sendingAddresses) {
    this.sendingAddresses = sendingAddresses;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PostDmRequest postDmRequest = (PostDmRequest) o;
    return Objects.equals(this.message, postDmRequest.message) &&
        Objects.equals(this.sendingAddresses, postDmRequest.sendingAddresses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, sendingAddresses);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostDmRequest {\n");
    
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    sendingAddresses: ").append(toIndentedString(sendingAddresses)).append("\n");
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

