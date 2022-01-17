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
 * フォロワー情報
 */
@ApiModel(description = "フォロワー情報")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-17T14:17:11.839899Z[Etc/UTC]")
public class GetTwitterAccountFollowersResponseFollowers   {
  @JsonProperty("id")
  private String id;

  @JsonProperty("screenName")
  private String screenName;

  @JsonProperty("accountUrl")
  private String accountUrl;

  public GetTwitterAccountFollowersResponseFollowers id(String id) {
    this.id = id;
    return this;
  }

  /**
   * ユーザーID
   * @return id
  */
  @ApiModelProperty(required = true, value = "ユーザーID")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public GetTwitterAccountFollowersResponseFollowers screenName(String screenName) {
    this.screenName = screenName;
    return this;
  }

  /**
   * アカウント名
   * @return screenName
  */
  @ApiModelProperty(required = true, value = "アカウント名")
  @NotNull


  public String getScreenName() {
    return screenName;
  }

  public void setScreenName(String screenName) {
    this.screenName = screenName;
  }

  public GetTwitterAccountFollowersResponseFollowers accountUrl(String accountUrl) {
    this.accountUrl = accountUrl;
    return this;
  }

  /**
   * アカウントページのURL
   * @return accountUrl
  */
  @ApiModelProperty(required = true, value = "アカウントページのURL")
  @NotNull


  public String getAccountUrl() {
    return accountUrl;
  }

  public void setAccountUrl(String accountUrl) {
    this.accountUrl = accountUrl;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetTwitterAccountFollowersResponseFollowers getTwitterAccountFollowersResponseFollowers = (GetTwitterAccountFollowersResponseFollowers) o;
    return Objects.equals(this.id, getTwitterAccountFollowersResponseFollowers.id) &&
        Objects.equals(this.screenName, getTwitterAccountFollowersResponseFollowers.screenName) &&
        Objects.equals(this.accountUrl, getTwitterAccountFollowersResponseFollowers.accountUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, screenName, accountUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetTwitterAccountFollowersResponseFollowers {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    screenName: ").append(toIndentedString(screenName)).append("\n");
    sb.append("    accountUrl: ").append(toIndentedString(accountUrl)).append("\n");
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

