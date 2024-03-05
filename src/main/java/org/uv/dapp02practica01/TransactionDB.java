package org.uv.dapp02practica01;

import java.sql.Connection;

/**
 *
 * @author Codigy
 */
public abstract class TransactionDB<T> {
    protected T pojo;
    
    public TransactionDB(T pojo){
        this.pojo = pojo;
    }
    
    public abstract boolean execute(Connection con);
}
