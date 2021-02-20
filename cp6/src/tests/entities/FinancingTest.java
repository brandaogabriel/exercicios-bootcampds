package tests.entities;

import entities.Financing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FinancingTest {

	private Financing financing;

	@BeforeEach
	public void setUp() {
		financing = new Financing(1000.00, 500.00, 4);
	}

	@Test
	public void entryShouldReturnTwentyPercentOfTotalAmount() {
		double expectedValue = 200.00;
		double entry = financing.entry();

		Assertions.assertEquals(expectedValue, entry);
	}

	@Test
	public void quotaShouldReturnEightyPercentOfTotalAmountDividedByMonths() {
		double expectedValue = 200.00;
		double quota = financing.quota();

		Assertions.assertEquals(expectedValue, quota);
	}

	@Test
	public void quotaShouldNotBeGreaterThanHalfIncome() {
		Assertions.assertTrue(financing.quota() <= financing.getIncome() / 2);
	}

	@Test
	public void constructorShouldThrowIllegalArgumentExceptionWhenInvalidData() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Financing(1000.00, 399.00, 2));
	}

	@Test
	public void setTotalAmountShouldSetValueWhenValidData() {
		financing.setTotalAmount(250.00);
		Assertions.assertEquals(250.00, financing.getTotalAmount());
	}

	@Test
	public void setTotalAmountShouldThrowIllegalArgumentExceptionWhenInvalidData() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> financing.setTotalAmount(3000.00));
	}

	@Test
	public void setIncomeShouldSetValueWhenValidData() {
		financing.setIncome(400.00);
		Assertions.assertEquals(400.00, financing.getIncome());
	}

	@Test
	public void setIncomeShouldThrowIllegalArgumentExceptionWhenInvalidData() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> financing.setIncome(100.00));
	}

	@Test
	public void setMonthsShouldSetValueWhenValidData() {
		financing.setMonths(5);
		Assertions.assertEquals(5, financing.getMonths());
	}


	@Test
	public void setMonthsShouldThrowIllegalArgumentExceptionWhenInvalidData() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> financing.setMonths(1));
	}
}
