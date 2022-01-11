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
 * LINEアカウント登録情報
 */
@ApiModel(description = "LINEアカウント登録情報")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-11T14:32:38.605032Z[Etc/UTC]")
public class CreateLineAccountRequest   {
  @JsonProperty("channelToken")
  private String channelToken;

  @JsonProperty("channelSecretKey")
  private String channelSecretKey;

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

  public CreateLineAccountRequest channelSecretKey(String channelSecretKey) {
    this.channelSecretKey = channelSecretKey;
    return this;
  }

  /**
   * LINEのアクセス用秘密鍵
   * @return channelSecretKey
  */
  @ApiModelProperty(required = true, value = "LINEのアクセス用秘密鍵")
  @NotNull


  public String getChannelSecretKey() {
    return channelSecretKey;
  }

  public void setChannelSecretKey(String channelSecretKey) {
    this.channelSecretKey = channelSecretKey;
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
    return Objects.equals(this.channelToken, createLineAccountRequest.channelToken) &&
        Objects.equals(this.channelSecretKey, createLineAccountRequest.channelSecretKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(channelToken, channelSecretKey);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateLineAccountRequest {\n");
    
    sb.append("    channelToken: ").append(toIndentedString(channelToken)).append("\n");
    sb.append("    channelSecretKey: ").append(toIndentedString(channelSecretKey)).append("\n");
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

