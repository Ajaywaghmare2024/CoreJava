package com.app.customer;

public enum ServicePlans {
	SILVER(1000),GOLD(2000),DIAMOND(5000),PLATINUM(10000);


	private double ServicePlans;

	ServicePlans(int ServicePlan){
		this.ServicePlans=ServicePlan;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name()+"  "+ ServicePlans;
	}
	public double getServicePlan() {
		return ServicePlans;
	}


}
