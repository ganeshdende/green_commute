package com.zemoso.greencommute.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JobErrorResponse {
   private  int status;
   private String message;
   private  long timeStamp;

}
