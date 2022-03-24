package com.wipro.bankofamerica.estore.singleton;

//Cart-single
public class SingletonCart {

	private static SingletonCart singletonCart;

	private SingletonCart() { //no one will create the object of your class

	}

	public static SingletonCart getSingletonCartObject() {

		//code
		
		//code anyone
		synchronized (SingletonCart.class) {

			if (singletonCart == null) {
				singletonCart = new SingletonCart(); //create new object
			} else {
				return singletonCart;
			}
			return singletonCart;
		}

	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return singletonCart;
	}

}
