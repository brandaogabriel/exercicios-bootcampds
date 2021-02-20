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
	public void entryShouldBeTwentyPercentOfTotalAmount() {
		double expectedValue = 200.00;
		double entry = financing.entry();

		Assertions.assertEquals(expectedValue, entry);
	}

	@Test
	public void quotaShouldBeEightyPercentOfTotalAmountDividedByMonths() {
		double expectedValue = 200.00;
		double quota = financing.quota();

		Assertions.assertEquals(expectedValue, quota);
	}

	@Test
	public void quotaShouldNotBeGreaterThanHalfIncome() {
		Assertions.assertTrue(financing.quota() <= financing.getIncome() / 2);
	}

	@Test
	public void constructorShouldThrowIllegalArgumentExceptionWhenInsufficientIncome() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Financing(1000.00, 399.00, 2));
	}

	@Test
	public void setTotalAmountShouldBeValid() {
		financing.setTotalAmount(250.00);
		Assertions.assertEquals(250.00, financing.getTotalAmount());
	}

	@Test
	public void setTotalAmountShouldThrowIllegalArgumentExceptionWhenInsufficientAmount() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> financing.setTotalAmount(3000.00));
	}

	@Test
	public void setIncomeShouldBeValid() {
		financing.setIncome(400.00);
		Assertions.assertEquals(400.00, financing.getIncome());
	}

	@Test
	public void setIncomeShouldThrowIllegalArgumentExceptionWhenInsufficientIncome() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> financing.setIncome(100.00));
	}

	@Test
	public void setMonthsShouldBeValid() {
		financing.setMonths(5);
		Assertions.assertEquals(5, financing.getMonths());
	}


	@Test
	public void setMonthsShouldThrowIllegalArgumentExceptionWhenInsufficientMonths() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> financing.setMonths(1));
	}
}
