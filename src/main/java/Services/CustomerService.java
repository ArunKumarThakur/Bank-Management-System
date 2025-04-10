package Services;
import Entities.Customer;

import java.util.Set;

public interface CustomerService {

    void addCustomer(Customer customer);
    Set<Customer> getAllCustomer();
    Customer getCustomerById(String customerId);
    boolean removeCustomer(String id);
}
