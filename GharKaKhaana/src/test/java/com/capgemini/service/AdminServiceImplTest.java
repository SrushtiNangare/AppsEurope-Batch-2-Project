package com.capgemini.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.entities.Customer;
import com.capgemini.entities.CustomerAddress;
import com.capgemini.entities.Vendor;
import com.capgemini.entities.VendorAddress;
import com.capgemini.exceptions.NoSuchCustomerException;
import com.capgemini.exceptions.NoSuchVendorException;

@SpringBootTest
class AdminServiceImplTest {

	@Autowired
	private AdminService service;
	@Autowired
	private CustomerService customerService;

	@Test
	void testFindCustomerByCustomerIdShouldReturnCustomerObject() throws NoSuchCustomerException {
		Customer customer = new Customer();
		customer.setFirstName("keval");
		customer.setLastName("chheda");
		customer.setUserName("Keuuval");
		customer.setPassword("kev");
		customer.setContactNo(4545454545L);
		CustomerAddress address = new CustomerAddress();
		// address.setAddressId(11);
		address.setCity("Thane");
		address.setLandmark("dadar");
		address.setState("Maharashtra");
		address.setPincode(400001);
		customer.setCustomerAddress(address);

		Customer expected = customerService.registerCustomer(customer);
		Customer actual = service.findCustomerById(expected.getCustomerId());
		// CustomerAddress expected1 = service.addCustomerAddress(address);
		// CustomerAddress actual1 = service.findAddressById(expected.getAddressId());
		assertEquals(expected.getFirstName(), actual.getFirstName());
		assertEquals(expected.getLastName(), actual.getLastName());
		assertEquals(expected.getCustomerId(), actual.getCustomerId());
		// assertEquals(expected.getAddressId(), actual.getCustomerId());
	}

	@Test
	void testFindVendorByVendorIdShouldReturnVendorObject() throws NoSuchCustomerException, NoSuchVendorException {
		Vendor vendor = new Vendor();
		vendor.setVendorName("keval");
		vendor.setVendorUsername("chheda");
		vendor.setVedorPassword("kev");
		vendor.setVendorContact(4545454545L);
		VendorAddress address = new VendorAddress();
		// address.setAddressId(11);
		address.setVendorCity("Thane");
		address.setVendorState("Maharashtra");
		address.setVendorPincode(400001);
		vendor.setVendorAddress(address);

		Vendor expected = service.addVendor(vendor);
		Vendor actual = service.findVendorById(expected.getVendorId());
		// CustomerAddress expected1 = service.addCustomerAddress(address);
		// CustomerAddress actual1 = service.findAddressById(expected.getAddressId());
		assertEquals(expected.getVendorUsername(), actual.getVendorUsername());
		assertEquals(expected.getVendorName(), actual.getVendorName());
		assertEquals(expected.getVendorId(), actual.getVendorId());
		// assertEquals(expected.getAddressId(), actual.getCustomerId());
	}

	@Test
	void testFindCustomerByCustomerIdShouldThrowNoSuchCustomerException() {
		assertThrows(NoSuchCustomerException.class, () -> {
			service.findCustomerById(-1);

			// @formatter:on

		});

	}

}