package com.cardealership.service;

import com.cardealership.domain.entity.Customer;
import com.cardealership.domain.model.service.customers.CustomerServiceModel;
import com.cardealership.domain.model.service.customers.CustomerSalesServiceModel;
import com.cardealership.domain.model.view.customers.CustomerViewModel;
import com.cardealership.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final SaleService saleService;

    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, SaleService saleService, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.saleService = saleService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createCustomer(CustomerServiceModel customerServiceModel) {
        Customer customer = new Customer();
        LocalDate customerBirthDate = customerServiceModel.getBirthDate();
        customer.setName(customerServiceModel.getName());
        customer.setBirthDate(customerBirthDate);
        customer.setDriverYoung(LocalDate.now().getYear() - customerBirthDate.getYear() < 19);
        this.customerRepository.save(customer);
    }

    @Override
    public List<CustomerServiceModel> findAllOrderByBirthDateAsc() {
        List<CustomerServiceModel> customerServiceModels = new ArrayList<>();
        this.customerRepository.getCustomersByOrderByBirthDateAsc().forEach(
                customer -> {
                    customerServiceModels.add(this.modelMapper.map(customer, CustomerServiceModel.class));
                }
        );
        return customerServiceModels;
    }

    @Override
    public List<CustomerServiceModel> findAllOrderByBirthDateDesc() {
        List<CustomerServiceModel> customerServiceModels = new ArrayList<>();
        this.customerRepository.getCustomersByOrderByBirthDateDesc().forEach(
                customer -> {
                    customerServiceModels.add(this.modelMapper.map(customer, CustomerServiceModel.class));
                }
        );
        return customerServiceModels;
    }

    @Override
    public CustomerServiceModel findCustomerById(Long id) {
        Customer customerEntity = this.customerRepository.findById(id).orElse(null);
        CustomerServiceModel customerServiceModel = this.modelMapper.map(customerEntity, CustomerServiceModel.class);
        return customerServiceModel;
    }

    @Override
    public CustomerSalesServiceModel findCustomerSales(Long id) {
        CustomerSalesServiceModel customerModel = new CustomerSalesServiceModel();
        Object salesByCustomerId = this.customerRepository.findSalesById(id);

        Object[] objArray = (Object[]) salesByCustomerId;

        String name = (String) objArray[0];
        Double totalResources = (Double) objArray[1];
        BigInteger carsBought = (BigInteger) objArray[2];
        Double resourceMultiplier = 1 - ((Double) objArray[3] / 100);

        customerModel.setName(name);
        customerModel.setTotalResources(totalResources * resourceMultiplier);
        customerModel.setTotalCars(carsBought);

        return customerModel;
    }

    @Override
    public void editCustomer(CustomerServiceModel customerServiceModel, Long id) {
        Customer customer = this.customerRepository.findById(id).get();
        this.modelMapper.map(customerServiceModel, customer);
        customer.setId(id);
        this.customerRepository.save(customer);
    }
}