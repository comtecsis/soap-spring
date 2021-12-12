package pe.company.bean.response;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

@Data
public class ClientResponse implements Serializable {
    private Long clientId;
    private String name;
    private String lastname;
    private String phone;
    private String uuid;
}
