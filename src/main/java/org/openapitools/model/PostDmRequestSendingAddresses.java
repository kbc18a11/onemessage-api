package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.model.PostDmRequestAddresses;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.*;

/**
 * プラットフォームごとの送信先一覧
 */
@ApiModel(description = "プラットフォームごとの送信先一覧")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-12T14:17:29.140063Z[Etc/UTC]")
public class PostDmRequestSendingAddresses   {
  /**
   * プラットフォームの種類
   */
  public enum PlatformTypeEnum {
    TWITTER("twitter");

    private String value;

    PlatformTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PlatformTypeEnum fromValue(String value) {
      for (PlatformTypeEnum b : PlatformTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("platformType")
  private PlatformTypeEnum platformType;

  @JsonProperty("addresses")
  @Valid
  private List<PostDmRequestAddresses> addresses = new ArrayList<>();

  public PostDmRequestSendingAddresses platformType(PlatformTypeEnum platformType) {
    this.platformType = platformType;
    return this;
  }

  /**
   * プラットフォームの種類
   * @return platformType
  */
  @ApiModelProperty(required = true, value = "プラットフォームの種類")
  @NotNull


  public PlatformTypeEnum getPlatformType() {
    return platformType;
  }

  public void setPlatformType(PlatformTypeEnum platformType) {
    this.platformType = platformType;
  }

  public PostDmRequestSendingAddresses addresses(List<PostDmRequestAddresses> addresses) {
    this.addresses = addresses;
    return this;
  }

  public PostDmRequestSendingAddresses addAddressesItem(PostDmRequestAddresses addressesItem) {
    this.addresses.add(addressesItem);
    return this;
  }

  /**
   * 送信先一覧
   * @return addresses
  */
  @ApiModelProperty(required = true, value = "送信先一覧")
  @NotNull

  @Valid

  public List<PostDmRequestAddresses> getAddresses() {
    return addresses;
  }

  public void setAddresses(List<PostDmRequestAddresses> addresses) {
    this.addresses = addresses;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PostDmRequestSendingAddresses postDmRequestSendingAddresses = (PostDmRequestSendingAddresses) o;
    return Objects.equals(this.platformType, postDmRequestSendingAddresses.platformType) &&
        Objects.equals(this.addresses, postDmRequestSendingAddresses.addresses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(platformType, addresses);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostDmRequestSendingAddresses {\n");
    
    sb.append("    platformType: ").append(toIndentedString(platformType)).append("\n");
    sb.append("    addresses: ").append(toIndentedString(addresses)).append("\n");
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

