package sample.javaee.memoapp.bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import sample.javaee.memoapp.ejb.MemoFacade;
import sample.javaee.memoapp.entity.Memo;
/**
 * 
 * @author BBC300041
 */
@Named(value = "editMemoBean")
@ViewScoped
public class EditMemoBean implements Serializable {

    private Memo editMemo;

    @Inject
    private MemoFacade memoFacade;

    @PostConstruct
    public void init() {
        Flash flash = FacesContext.getCurrentInstance()
                .getExternalContext().getFlash();
        Integer key = (Integer) flash.get("editMemoId");
        editMemo = memoFacade.find(key);
    }

    public void updateMemo() {
        memoFacade.edit(editMemo);
    }

    public Memo getEditMemo() {
        return editMemo;
    }

    public void setEditMemo(Memo editMemo) {
        this.editMemo = editMemo;
    }
    
}