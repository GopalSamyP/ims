package com.ivm.inventorymanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BaseResponse implements Serializable {

    @Builder.Default
    @JsonProperty("status")
    private HttpStatus status = HttpStatus.OK;

    @JsonProperty("statusCode")
    public Integer getStatusCode() {
        return status != null ? status.value() : null;
    }

    @JsonIgnore
    public void setStatusCode(Integer code) {
    }

    @NonNull
    @Builder.Default
    private String messageCode = "SUCCESS";
    private String message;
    private Long totalElements;
    private Integer totalPages;
    private Integer pageNumber;
    private Integer pageSize;
}
