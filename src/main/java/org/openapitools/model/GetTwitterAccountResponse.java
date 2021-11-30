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
 * TwitterのOAuth認可用のURL
 */
@ApiModel(description = "TwitterのOAuth認可用のURL")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-11-30T02:19:55.570490Z[Etc/UTC]")
public class GetTwitterAccountResponse   {
  @JsonProperty("screenName")
  private String screenName;

  @JsonProperty("profileImageURL")
  private String profileImageURL;

  @JsonProperty("accountUrl")
  private String accountUrl;

  public GetTwitterAccountResponse screenName(String screenName) {
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

  public GetTwitterAccountResponse profileImageURL(String profileImageURL) {
    this.profileImageURL = profileImageURL;
    return this;
  }

  /**
   * アカウントアイコン画像
   * @return profileImageURL
  */
  @ApiModelProperty(required = true, value = "アカウントアイコン画像")
  @NotNull


  public String getProfileImageURL() {
    return profileImageURL;
  }

  public void setProfileImageURL(String profileImageURL) {
    this.profileImageURL = profileImageURL;
  }

  public GetTwitterAccountResponse accountUrl(String accountUrl) {
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
    GetTwitterAccountResponse getTwitterAccountResponse = (GetTwitterAccountResponse) o;
    return Objects.equals(this.screenName, getTwitterAccountResponse.screenName) &&
        Objects.equals(this.profileImageURL, getTwitterAccountResponse.profileImageURL) &&
        Objects.equals(this.accountUrl, getTwitterAccountResponse.accountUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(screenName, profileImageURL, accountUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetTwitterAccountResponse {\n");
    
    sb.append("    screenName: ").append(toIndentedString(screenName)).append("\n");
    sb.append("    profileImageURL: ").append(toIndentedString(profileImageURL)).append("\n");
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

