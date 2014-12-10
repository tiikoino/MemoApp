package sample.javaee.memoapp.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import sample.javaee.memoapp.ejb.MemoFacade;
import sample.javaee.memoapp.entity.Memo;

@Named
@ViewScoped
public class MemoBean implements Serializable {

    private String memo;

    private List<Memo> memoList;

    @Inject
    private MemoFacade memoFacade;

    @PostConstruct
    public void init() {
        getAllMemo();
    }

    public void createMemo() {
        if (memo.length() > 0) {
            Memo newMemo = new Memo();
            newMemo.setMemo(memo);
            memoFacade.create(newMemo);
            getAllMemo();
        }
    }

    public String updateMemo(Memo editMemo) {
        Flash flash = FacesContext.getCurrentInstance()
                .getExternalContext().getFlash();
        flash.put("editMemoId", editMemo.getId());
        return "memoEdit.xhtml";
    }

    public void deleteMemo(Memo delMemo) {
        memoFacade.remove(delMemo);
        getAllMemo();
    }

    public void getAllMemo() {
        memoList = memoFacade.findAll();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public List<Memo> getMemoList() {
        return memoList;
    }

    public void setMemoList(List<Memo> memoList) {
        this.memoList = memoList;
    }

}