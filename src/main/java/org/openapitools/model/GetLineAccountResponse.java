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
 * LINEアカウント情報
 */
@ApiModel(description = "LINEアカウント情報")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-11T14:32:38.605032Z[Etc/UTC]")
public class GetLineAccountResponse   {
  @JsonProperty("screenName")
  private String screenName;

  @JsonProperty("profileImageURL")
  private String profileImageURL;

  public GetLineAccountResponse screenName(String screenName) {
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

  public GetLineAccountResponse profileImageURL(String profileImageURL) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetLineAccountResponse getLineAccountResponse = (GetLineAccountResponse) o;
    return Objects.equals(this.screenName, getLineAccountResponse.screenName) &&
        Objects.equals(this.profileImageURL, getLineAccountResponse.profileImageURL);
  }

  @Override
  public int hashCode() {
    return Objects.hash(screenName, profileImageURL);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetLineAccountResponse {\n");
    
    sb.append("    screenName: ").append(toIndentedString(screenName)).append("\n");
    sb.append("    profileImageURL: ").append(toIndentedString(profileImageURL)).append("\n");
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

