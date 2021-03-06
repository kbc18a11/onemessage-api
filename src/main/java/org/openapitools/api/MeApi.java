/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.4.0-SNAPSHOT).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import org.openapitools.model.GetMeResponse;
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
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-31T00:47:22.927123Z[Etc/UTC]")
@Validated
@Api(value = "me", description = "the me API")
public interface MeApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /me : ユーザー情報取得
     * ユーザー情報を習得
     *
     * @return OK (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Internal Server Error (status code 500)
     */
    @ApiOperation(
        tags = { "user" },
        value = "ユーザー情報取得",
        nickname = "getMe",
        notes = "ユーザー情報を習得",
        response = GetMeResponse.class,
        authorizations = {
            @Authorization(value = "Authorization")
         }
    )
    @ApiResponses({
        @ApiResponse(code = 200, message = "OK", response = GetMeResponse.class),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/me",
        produces = { "application/json" }
    )
    default ResponseEntity<GetMeResponse> getMe(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"name\", \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\", \"email\" : \"email\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
