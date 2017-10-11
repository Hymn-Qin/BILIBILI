package projectedit.lanou.com.bilibili.utils;

import java.io.Serializable;

/**
 * Created by lanouhn on 16/10/9.
 */
public class Trans implements Serializable{
    private  String fTran;
    private  String tTran;
    private  int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfTran() {
        return fTran;
    }

    public String setfTran(String fTran) {
        this.fTran = fTran;
        return fTran;
    }

    public String gettTran() {
        return tTran;
    }

    public String settTran(String tTran) {
        this.tTran = tTran;
        return tTran;
    }
}
