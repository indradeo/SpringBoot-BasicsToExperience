package com.dev.bind;

import java.io.Serializable;

import lombok.Data;

@Data
public class AuthenticationResponse implements Serializable {

	private String jwt;
}
