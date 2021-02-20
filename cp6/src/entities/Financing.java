package entities;

public class Financing {
	static final double ENTRY_FEE_PERCENTAGE = 0.2;
	static final double QUOTA_FEE_PERCENTAGE = 0.8;

	private Double totalAmount;
	private Double income;
	private Integer months;

	public Financing() {
	}

	public Financing(Double totalAmount, Double income, Integer months) {
		this.totalAmount = totalAmount;
		this.income = income;
		this.months = months;
		validateQuota();
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
		validateQuota();
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
		validateQuota();
	}

	public Integer getMonths() {
		return months;
	}

	public void setMonths(Integer months) {
		this.months = months;
		validateQuota();
	}

	public double entry() {
		return totalAmount * ENTRY_FEE_PERCENTAGE;
	}

	public double quota() {
		return totalAmount * QUOTA_FEE_PERCENTAGE / months;
	}

	private void validateQuota() {
		if (quota() > income / 2.0)
			throw new IllegalArgumentException("Quota should not be greater than half income");
	}
}
