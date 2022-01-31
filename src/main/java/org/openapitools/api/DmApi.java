/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.4.0-SNAPSHOT).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import org.openapitools.model.GetDmResponse;
import org.openapitools.model.PostDmRequest;
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
@Api(value = "dm", description = "the dm API")
public interface DmApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /dm : dm送信履歴取得
     * dm送信履歴を取得
     *
     * @return OK (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Internal Server Error (status code 500)
     */
    @ApiOperation(
        tags = { "dm" },
        value = "dm送信履歴取得",
        nickname = "getDm",
        notes = "dm送信履歴を取得",
        response = GetDmResponse.class,
        authorizations = {
            @Authorization(value = "Authorization")
         }
    )
    @ApiResponses({
        @ApiResponse(code = 200, message = "OK", response = GetDmResponse.class),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/dm",
        produces = { "application/json" }
    )
    default ResponseEntity<GetDmResponse> getDm(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"messages\" : [ { \"message\" : \"message\", \"postDateTime\" : \"2000-01-23T04:56:07.000+00:00\" }, { \"message\" : \"message\", \"postDateTime\" : \"2000-01-23T04:56:07.000+00:00\" } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /dm : dm送信
     * dmを送信
     *
     * @param postDmRequest  (required)
     * @return OK (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Internal Server Error (status code 500)
     */
    @ApiOperation(
        tags = { "dm" },
        value = "dm送信",
        nickname = "postDm",
        notes = "dmを送信",
        authorizations = {
            @Authorization(value = "Authorization")
         }
    )
    @ApiResponses({
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/dm",
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> postDm(
        @ApiParam(value = "", required = true) @Valid @RequestBody PostDmRequest postDmRequest
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
