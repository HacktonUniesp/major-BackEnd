package com.majoSports.ApimajoSports.clients;

import com.majoSports.ApimajoSports.model.Customer;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;


@Log4j2
@Component
public class MarjoSportsClient {

    @Autowired
    RestTemplate restTemplate;

    @Value("${url.marjosports}")
    String REQUEST_MARJO_SPORTS_URL;

    ResponseEntity<Customer> dataResponse = null;
    public ResponseEntity<Customer> getCustomerForCPF(String cpf){
        log.info("Buscando dados do cpf {} através da ULR={}",cpf , REQUEST_MARJO_SPORTS_URL);
        String url = REQUEST_MARJO_SPORTS_URL + "/hackathon?cpf=" + cpf;
        try {
            dataResponse = restTemplate.exchange(url, HttpMethod.GET, null, Customer.class);
            log.info("Resposta: {}", dataResponse.getBody());
        }catch (HttpStatusCodeException e) {
            log.error("Error request /hackathon {} ", e);
        }
        return dataResponse;
    }

}
