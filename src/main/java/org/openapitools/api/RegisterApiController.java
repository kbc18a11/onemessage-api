package org.openapitools.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-08T13:15:06.648144Z[Etc/UTC]")
@Controller
@RequestMapping("${openapi.oneMessage.base-path:/api/v1}")
public class RegisterApiController implements RegisterApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public RegisterApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
