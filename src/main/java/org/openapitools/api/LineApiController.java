package org.openapitools.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-12T14:17:29.140063Z[Etc/UTC]")
@Controller
@RequestMapping("${openapi.oneMessage.base-path:/api/v1}")
public class LineApiController implements LineApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public LineApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
