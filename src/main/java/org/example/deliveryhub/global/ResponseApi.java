package org.example.deliveryhub.global;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseApi<T> {

  private String statusCode;
  private String message;
  private T data;

}
