package com.demo.transaction.sender;

import lombok.Data;

/**
 * @author gll
 * 2019/4/11 14:47
 */
@Data
public class TxMessage {
    /**
     * 数据内容
     */
    private Object data;
    /**
     * 判断是否存在事务
     */
    private boolean inTransaction;
    /**
     * 1.如果是EventBus,target=事件发布源
     * 2.如果是消息中间件,target=topic
     */
    private Object target;
}
