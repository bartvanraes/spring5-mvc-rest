package guru.springfamework.api.v1.mapper;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerMapperTest {
    public static final String FIRST_NAME = "Eerst";
    public static final String LAST_NAME = "Laatst";
    public static final String CUSTOMER_URL = "/shop/customers/666";

    public static final long ID = 1L;

    CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @Test
    public void customerToCustomerDTO() throws Exception {
        // given
        Customer customer = new Customer();
        customer.setFirstName(FIRST_NAME);
        customer.setLastName(LAST_NAME);
        customer.setCustomerUrl(CUSTOMER_URL);

        // when
        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

        // them
        assertEquals(customerDTO.getFirstname(), FIRST_NAME);
        assertEquals(customerDTO.getLastname(), LAST_NAME);
        assertEquals(customerDTO.getCustomer_url(), CUSTOMER_URL);
    }
}
