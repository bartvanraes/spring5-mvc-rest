package guru.springfamework.controllers.v1;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.services.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

public class CustomerControllerTest {
    public static final String FIRST_NAME1 = "Eerst";
    public static final String LAST_NAME1 = "Laatst";
    public static final String CUSTOMER_URL1 = "/shop/customers/666";

    public static final String FIRST_NAME2 = "Tweede";
    public static final String LAST_NAME2 = "NogLaatster";
    public static final String CUSTOMER_URL2 = "/shop/customers/667";

    @Mock
    CustomerService customerService;

    @InjectMocks
    CustomerController customerController;

    MockMvc mockMvc;

    @Before
    public void SetUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    public void testListCustomers() throws Exception {
        CustomerDTO customer1 = new CustomerDTO();
        customer1.setFirstname(FIRST_NAME1);
        customer1.setLastname(LAST_NAME1);
        customer1.setCustomer_url(CUSTOMER_URL1);

        CustomerDTO customer2 = new CustomerDTO();
        customer2.setFirstname(FIRST_NAME2);
        customer2.setLastname(LAST_NAME2);
        customer2.setCustomer_url(CUSTOMER_URL2);

        List<CustomerDTO> customers = Arrays.asList(customer1, customer2);

        when(customerService.getAllCustomers()).thenReturn(customers);

        mockMvc.perform(get("/api/v1/customers/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customers", hasSize(2)));
    }
}
