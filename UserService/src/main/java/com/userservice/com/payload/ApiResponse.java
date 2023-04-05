package com.userservice.com.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {

    private String meassge;
    private boolean sucesss;
    private HttpStatus status;

}