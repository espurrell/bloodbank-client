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
    void testGetPersonByIdThrowsException() throws Exception {
        // Arrange: Mock the API client to throw an exception
        when(mockApiClient.getPersonById(1)).thenThrow(new RuntimeException("API error"));

        // Act & Assert: Ensure that the exception is thrown and handled gracefully
        Exception exception = assertThrows(RuntimeException.class, () -> {
            bloodBankClient.getPersonById(1);
        });

        assertEquals("API error", exception.getMessage());
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
