package com.getway.com.models;

import lombok.*;

import java.util.Collection;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private  String     userId;
    private  String accesstoken ;
    private  String refershtoken ;
    private  long expireAt;

    private Collection<String> authorise;


}
