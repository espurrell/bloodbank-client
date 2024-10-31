package com.keyin.bloodbankclient;

import com.keyin.bloodbankclient.client.BloodBankApiClient;
import com.keyin.bloodbankclient.model.Donation;
import com.keyin.bloodbankclient.model.Person;
import com.keyin.bloodbankclient.model.Stock;
import com.keyin.bloodbankclient.client.BloodBankClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

@ExtendWith(MockitoExtension.class)
public class BloodBankClientTest {

    @Mock
    private BloodBankApiClient mockApiClient;  // Mocking the actual API client

    @InjectMocks
    private BloodBankClient bloodBankClient;   // The client to test

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);    // Initialize mocks
    }

    // Example test for retrieving a person by ID
    @Test
    void testGetPersonById() throws Exception {
        // Arrange: Set up a sample person to return
        Person samplePerson = new Person(1, "John Doe", "123 Main St", new Date(), "555-1234", "Male", "O+");
        when(mockApiClient.getPersonById(1)).thenReturn(samplePerson);

        // Act: Call the method to be tested
        Person result = bloodBankClient.getPersonById(1);

        // Assert: Check the result
        assertNotNull(result);
        assertEquals("John Doe", result.getPName());
        assertEquals("O+", result.getPBloodType());
        verify(mockApiClient, times(1)).getPersonById(1);
    }

    // Example test for retrieving stock by blood type
    @Test
    void testGetStockByBloodType() throws Exception {
        // Arrange: Set up a sample stock object
        Stock sampleStock = new Stock("O-", 10);
        when(mockApiClient.getStockByBloodType("O-")).thenReturn(sampleStock);

        // Act
        Stock result = bloodBankClient.getStockByBloodType("O-");

        // Assert
        assertNotNull(result);
        assertEquals("O-", result.getSBloodType());
        assertEquals(10, result.getQuantity());
        verify(mockApiClient, times(1)).getStockByBloodType("O-");
    }

    // Example test for creating a donation
    @Test
    void testCreateDonation() throws Exception {
        // Arrange
        Donation donation = new Donation(1, new Date(), "12:30", 1, 5);
        when(mockApiClient.createDonation(donation)).thenReturn(true);

        // Act
        boolean isSuccess = bloodBankClient.createDonation(donation);

        // Assert
        assertTrue(isSuccess);
        verify(mockApiClient, times(1)).createDonation(donation);
    }

    // Add more tests for other methods here

}
