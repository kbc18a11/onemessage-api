package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.model.GetTwitterAccountFollowersResponseFollowers;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.*;

/**
 * Twitterのフォロワー一覧
 */
@ApiModel(description = "Twitterのフォロワー一覧")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-17T14:17:11.839899Z[Etc/UTC]")
public class GetTwitterAccountFollowersResponse   {
  @JsonProperty("total")
  private Integer total;

  @JsonProperty("followers")
  @Valid
  private List<GetTwitterAccountFollowersResponseFollowers> followers = new ArrayList<>();

  public GetTwitterAccountFollowersResponse total(Integer total) {
    this.total = total;
    return this;
  }

  /**
   * 全てのフォロワー数
   * @return total
  */
  @ApiModelProperty(required = true, value = "全てのフォロワー数")
  @NotNull


  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public GetTwitterAccountFollowersResponse followers(List<GetTwitterAccountFollowersResponseFollowers> followers) {
    this.followers = followers;
    return this;
  }

  public GetTwitterAccountFollowersResponse addFollowersItem(GetTwitterAccountFollowersResponseFollowers followersItem) {
    this.followers.add(followersItem);
    return this;
  }

  /**
   * フォロワー一覧
   * @return followers
  */
  @ApiModelProperty(required = true, value = "フォロワー一覧")
  @NotNull

  @Valid

  public List<GetTwitterAccountFollowersResponseFollowers> getFollowers() {
    return followers;
  }

  public void setFollowers(List<GetTwitterAccountFollowersResponseFollowers> followers) {
    this.followers = followers;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetTwitterAccountFollowersResponse getTwitterAccountFollowersResponse = (GetTwitterAccountFollowersResponse) o;
    return Objects.equals(this.total, getTwitterAccountFollowersResponse.total) &&
        Objects.equals(this.followers, getTwitterAccountFollowersResponse.followers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(total, followers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetTwitterAccountFollowersResponse {\n");
    
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    followers: ").append(toIndentedString(followers)).append("\n");
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

