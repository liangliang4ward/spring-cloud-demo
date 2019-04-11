package com.demo.transaction.sender;

import com.google.common.eventbus.EventBus;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @author gll
 * 2019/4/11 14:46
 */
@Service
@Slf4j
public class MessageSender {

    @Autowired
    private ApplicationContext applicationContext;

    public void send(Object topic,Object object){
        TxMessage txMessage = new TxMessage();
        txMessage.setData(object);
        txMessage.setTarget(topic);
        if(TransactionSynchronizationManager.getCurrentTransactionName()!=null){
            applicationContext.publishEvent(txMessage);
        }else{
            //不存在事务
            txMessage.setInTransaction(false);
            doSend(txMessage);
        }

    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT,classes = {TxMessage.class})
    void doSend(TxMessage txMessage){
        if(txMessage.getTarget() instanceof EventBus){
            ((EventBus)txMessage.getTarget()).post(txMessage.getData());
        }else{
            try{
                System.out.println(txMessage.getTarget()+","+ new Gson().toJson(txMessage.getData()));
            }catch (Exception e){
                if(!txMessage.isInTransaction()){
                    throw e;
                }
                log.error("transaction message occur error,message={}",new Gson().toJson(txMessage));
            }
            //实际调用
        }

    }
}
