package com.concurrency;

import java.util.concurrent.locks.ReadWriteLock;

/**
 * Author Bryan.C <br>
 * Date 2018/6/27 18:11
 */
public class Consumer implements Runnable {
  BankCard bc = null;
  ReadWriteLock lock = null;
  Consumer(BankCard bc, ReadWriteLock lock) {
    this.bc = bc;
    this.lock = lock;
  }
  public void run() {
    try {
      while(true){
        lock.writeLock().lock();
        System.out.print("儿子要消费，现在余额：" + bc.getBalance() + "\t");
        bc.setBalance(bc.getBalance() - 2000);
        System.out.println("儿子消费2000元，现在余额：" + bc.getBalance());
//        lock.writeLock().unlock();
        Thread.sleep(3 * 1000);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
