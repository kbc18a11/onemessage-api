/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.3.0-SNAPSHOT).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import org.openapitools.model.CreateMeRequest;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-11-30T02:19:55.570490Z[Etc/UTC]")
@Validated
@Api(value = "register", description = "the register API")
public interface RegisterApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /register : ユーザー情報登録
     * ユーザー情報を新規登録
     *
     * @param createMeRequest  (required)
     * @return Created (status code 201)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Internal Server Error (status code 500)
     */
    @ApiOperation(value = "ユーザー情報登録", nickname = "createMe", notes = "ユーザー情報を新規登録", tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 500, message = "Internal Server Error") })
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/register",
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> createMe(@ApiParam(value = "", required = true) @Valid @RequestBody CreateMeRequest createMeRequest) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
