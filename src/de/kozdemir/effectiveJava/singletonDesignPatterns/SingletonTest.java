package de.kozdemir.effectiveJava.singletonDesignPatterns;

public class SingletonTest {

	public static void main(String[] args) {

		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println("Hashcode of LazyInitializedSingleton: " + LazyInitializedSingleton.getInstance().hashCode());
				System.out.println("Hashcode of EagerInitializedSingleton: " + EagerInitializedSingleton.getInstance().hashCode());
				System.out.println("Hashcode of EnumSingleton: " + EnumSingleton.INSTANCE.hashCode());

			}

		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Hashcode of LazyInitializedSingleton: " + LazyInitializedSingleton.getInstance().hashCode());
				System.out.println("Hashcode of EagerInitializedSingleton: " + EagerInitializedSingleton.getInstance().hashCode());
				System.out.println("Hashcode of EnumSingleton: " + EnumSingleton.INSTANCE.hashCode());

			}

		}).start();
		

	}

}
