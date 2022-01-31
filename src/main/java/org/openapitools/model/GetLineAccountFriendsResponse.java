package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.model.GetLineAccountFriendsResponseFriends;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.*;

/**
 * LINEの友達情報一覧
 */
@ApiModel(description = "LINEの友達情報一覧")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-31T00:47:22.927123Z[Etc/UTC]")
public class GetLineAccountFriendsResponse   {
  @JsonProperty("total")
  private Integer total;

  @JsonProperty("friends")
  @Valid
  private List<GetLineAccountFriendsResponseFriends> friends = new ArrayList<>();

  public GetLineAccountFriendsResponse total(Integer total) {
    this.total = total;
    return this;
  }

  /**
   * 全ての友達情報数
   * @return total
  */
  @ApiModelProperty(required = true, value = "全ての友達情報数")
  @NotNull


  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public GetLineAccountFriendsResponse friends(List<GetLineAccountFriendsResponseFriends> friends) {
    this.friends = friends;
    return this;
  }

  public GetLineAccountFriendsResponse addFriendsItem(GetLineAccountFriendsResponseFriends friendsItem) {
    this.friends.add(friendsItem);
    return this;
  }

  /**
   * 友達情報一覧
   * @return friends
  */
  @ApiModelProperty(required = true, value = "友達情報一覧")
  @NotNull

  @Valid

  public List<GetLineAccountFriendsResponseFriends> getFriends() {
    return friends;
  }

  public void setFriends(List<GetLineAccountFriendsResponseFriends> friends) {
    this.friends = friends;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetLineAccountFriendsResponse getLineAccountFriendsResponse = (GetLineAccountFriendsResponse) o;
    return Objects.equals(this.total, getLineAccountFriendsResponse.total) &&
        Objects.equals(this.friends, getLineAccountFriendsResponse.friends);
  }

  @Override
  public int hashCode() {
    return Objects.hash(total, friends);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetLineAccountFriendsResponse {\n");
    
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    friends: ").append(toIndentedString(friends)).append("\n");
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

