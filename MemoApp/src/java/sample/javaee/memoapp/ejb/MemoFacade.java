/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.javaee.memoapp.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sample.javaee.memoapp.entity.Memo;

/**
 *
 * @author BBC300041
 */
@Stateless
public class MemoFacade extends AbstractFacade<Memo> {
    @PersistenceContext(unitName = "MemoAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MemoFacade() {
        super(Memo.class);
    }
    
}
