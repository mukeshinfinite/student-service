package com.mk.feignclients;

import com.mk.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//after register with eureka server no need to url, access with service name.
@FeignClient( value = "address-service",
    path ="/api/address" )
//@FeignClient(value = "api-gateway")
public interface AddressFeignClient {

  @GetMapping("/getById/{id}")
  public AddressResponse getById (@PathVariable long id);

}
