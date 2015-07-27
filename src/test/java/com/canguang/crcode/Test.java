package com.canguang.crcode;

public class Test {
	public static void main(String[] args) {
		CouponStatus status=CouponStatus.UNUSED;
		status.setDescription(status.toString());
		System.out.println(status);
		
	}
	public enum CouponStatus {

		USED("已使用"), UNUSED("未使用");

		private String description;

		private CouponStatus(String description) {
			this.description = description;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
		 @Override

	       public String toString() {

	           return String.valueOf ( this . description );

	       }

	    
	}

}
