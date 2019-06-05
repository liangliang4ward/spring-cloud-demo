package com.xzl.agent.service;


import org.springframework.stereotype.Component;

import java.util.concurrent.locks.ReentrantReadWriteLock;

@Component
public class TokenService {

    private volatile String token;

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();


    public void resetToken(String token) {
        ReentrantReadWriteLock.WriteLock writeLock = null;
        try {
            writeLock = readWriteLock.writeLock();
            writeLock.lock();
            this.token = token;
        } catch (Exception e) {
        } finally {
            if (writeLock != null) {
                writeLock.unlock();
            }
        }
    }


    public String getToken() {
        ReentrantReadWriteLock.ReadLock readLock=null;
        try {
             readLock= readWriteLock.readLock();
             return this.token;
        } catch (Exception e) {
        }finally {
            if(readLock!=null){
                readLock.unlock();
            }
        }
        return "";
    }
}
