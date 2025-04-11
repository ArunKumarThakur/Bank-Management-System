package Services;

import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import Entities.Customer;
import java.util.Map;

public class CustomerServiceImplementation implements CustomerService{
    Set<Customer> customerList = new HashSet<>();
    Map<String, Customer> idToCustomer = new HashMap<>();

    static int customerId = 101;

    @Override
    public void addCustomer(Customer customer) {
        customerList.add(customer);
        idToCustomer.putIfAbsent(customer.getCustomerId(), customer);
    }

    @Override
    public Customer getCustomerById(String id) {
        return idToCustomer.get(id);
    }

    @Override
    public Set<Customer> getAllCustomer() {
        return customerList;
    }

    @Override
    public boolean removeCustomer(String customerId) {

        if(!idToCustomer.containsKey(customerId)) {
            return false;
        }

        Customer customer = idToCustomer.get(customerId);

        idToCustomer.remove(customerId);
        customerList.remove(customer);

        return true;
    }
}