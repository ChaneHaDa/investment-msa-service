package com.chan.investment.portfoliocompositionservice.exception;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import jakarta.ws.rs.InternalServerErrorException;

import java.io.IOException;

public class CustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        ObjectMapper mapper = new ObjectMapper();
        String message = null;
        try {
            JsonNode jsonNode = mapper.readTree(response.body().asInputStream());
            message = jsonNode.get("message").asText();
        } catch (IOException e) {
            return new Exception("Error decoding response", e);
        }

        switch (response.status()) {
            case 404:
                return new EntityNotFoundException(message);
            case 500:
                System.out.println("default error");
                return new InternalServerErrorException("feign connection error");
            default:
                System.out.println("default error");
                return defaultErrorDecoder.decode(methodKey, response);
        }
    }

}