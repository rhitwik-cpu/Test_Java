package com.test.threadPackage;

public class MyThread {
	public static void main(String[] args) throws InterruptedException {
		Thread producer = new Thread(new Producer());
		Thread consumer = new Thread(new Consumer());
		
//		p.setPriority(Thread.MAX_PRIORITY);
//		consumer.setPriority(Thread.MAX_PRIORITY);
		
		producer.start();
		producer.join();
		consumer.start();
		consumer.join();
		
		for(int i=1;i<=5;i++) {
			System.out.println("Now it is : "+Thread.currentThread().getName());
		}
	}
	
	
}

class Producer implements Runnable {
	@Override
	public void run() {
		for(int i=1;i<=5;i++) {
			//System.out.println(Thread.currentThread().getName());
			System.out.println("Now it is : "+Thread.currentThread().getName());
		}
	}
}

class Consumer implements Runnable {
	@Override
	public void run() {
		for(int i=1;i<=5;i++) {
			//System.out.println(Thread.currentThread().getName());
			
			System.out.println("Now it is : "+Thread.currentThread().getName());
		}
	}
}
