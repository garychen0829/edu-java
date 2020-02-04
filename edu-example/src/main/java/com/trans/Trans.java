package com.trans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * 事务(可支持分布式)
 *
 * @author echo.weng
 * @since 2018年10月22日
 */
public class Trans implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    /**
     * 执行 事务的传递性，默认为REQUIRES_NEW
     *
     * @param runner
     */
    public static void exe(Runnable runner) {
        exe(runner, null);
    }

    /**
     * 执行事务
     *
     * @param runner
     * @param propagation 事务的传递性，默认为REQUIRES_NEW
     */
    public static void exe(Runnable runner, Propagation propagation) {
        PlatformTransactionManager manager = applicationContext.getBean(PlatformTransactionManager.class);
        if (propagation == null) {
            propagation = Propagation.REQUIRES_NEW;
        }
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition(propagation.value());
        TransactionStatus status = manager.getTransaction(definition);
        try {
            runner.run();
            manager.commit(status);
        } catch (Exception e) {
            manager.rollback(status);
            throw e;
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Trans.applicationContext = applicationContext;
    }

}
