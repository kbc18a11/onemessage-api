package org.openapitools.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-12-01T03:05:48.192486Z[Etc/UTC]")
@Controller
@RequestMapping("${openapi.oneMessage.base-path:/api/v1}")
public class MeApiController implements MeApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public MeApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
