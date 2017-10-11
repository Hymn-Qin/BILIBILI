package projectedit.lanou.com.bilibili.Beans;

import java.util.List;

/**
 * Created by lanouhn on 16/10/26.
 */
public class SevenSale {

    /**
     * code : 0
     * message : OK
     * data : {"unlogin":0,"uname":"萝神赋","rank":0,"coin":0,"list":[{"uid":7227288,"uname":"不吃薑的梨精","coin":483200,"face":"http://i0.hdslb.com/bfs/face/d87d6b8a05367094689d312a4cb91039e8ad72e5.jpg"}]}
     */

    private int code;
    private String message;
    /**
     * unlogin : 0
     * uname : 萝神赋
     * rank : 0
     * coin : 0
     * list : [{"uid":7227288,"uname":"不吃薑的梨精","coin":483200,"face":"http://i0.hdslb.com/bfs/face/d87d6b8a05367094689d312a4cb91039e8ad72e5.jpg"}]
     */

    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private int unlogin;
        private String uname;
        private int rank;
        private int coin;
        /**
         * uid : 7227288
         * uname : 不吃薑的梨精
         * coin : 483200
         * face : http://i0.hdslb.com/bfs/face/d87d6b8a05367094689d312a4cb91039e8ad72e5.jpg
         */

        private List<ListBean> list;

        public int getUnlogin() {
            return unlogin;
        }

        public void setUnlogin(int unlogin) {
            this.unlogin = unlogin;
        }

        public String getUname() {
            return uname;
        }

        public void setUname(String uname) {
            this.uname = uname;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public int getCoin() {
            return coin;
        }

        public void setCoin(int coin) {
            this.coin = coin;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            private int uid;
            private String uname;
            private int coin;
            private String face;

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public String getUname() {
                return uname;
            }

            public void setUname(String uname) {
                this.uname = uname;
            }

            public int getCoin() {
                return coin;
            }

            public void setCoin(int coin) {
                this.coin = coin;
            }

            public String getFace() {
                return face;
            }

            public void setFace(String face) {
                this.face = face;
            }
        }
    }
}
