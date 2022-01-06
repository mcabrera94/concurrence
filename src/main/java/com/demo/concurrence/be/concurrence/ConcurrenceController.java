package com.demo.concurrence.be.concurrence;

import com.demo.concurrence.be.constans.CommonMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsondoc.core.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import static com.demo.concurrence.be.constans.CommonConstans.*;

@Api(name="Concurrence Service", description="Interfaces de Concurrencia", group="Concurrence")
@ApiVersion(since="1.0")
@RestController
@CrossOrigin("*")
@RequestMapping("/concurrence")
public class ConcurrenceController {

    @Autowired
    ConcurrenceService concurrenceService;

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = REQUEST_ACCUMULATE_NUMBERS_DESCRIPTION)
    @RequestMapping(method = RequestMethod.POST, value = REQUEST_ACCUMULATE_NUMBERS_URI)
    @ApiResponseObject
    @ResponseBody
    public Object goCalculateNumbers(HttpServletRequest request, HttpServletResponse response,
                                     @ApiBodyObject(clazz = String.class) @RequestBody String json) {

        Object objectResult = null;

        if (json != null && !json.isEmpty()) {
            try{
                Map<String, Object> params   = new ObjectMapper().readerFor(Map.class).readValue(json);

                String listNumbers = (params.containsKey(LIST_NUMBERS) && params.get(LIST_NUMBERS) != null
                        && !params.get(LIST_NUMBERS).toString().isEmpty()) ? params.get(LIST_NUMBERS).toString() : null;

                String operator = (params.containsKey(OPERATOR) && params.get(OPERATOR) != null
                        && !params.get(OPERATOR).toString().isEmpty()) ? params.get(OPERATOR).toString() : null;

                int[] numbers = concurrenceService.getNumbers(listNumbers);
                String symbol = concurrenceService.getOperator(operator);

                objectResult = concurrenceService.executeThread(ONE, numbers, symbol);

            } catch(IOException e){
                e.printStackTrace();
                objectResult = CommonMessage.commonExceptionErrorMessage(response);
            }
        } else {
            objectResult = CommonMessage.commonErrorMessage(response);
        }

        return objectResult;
    }

}


