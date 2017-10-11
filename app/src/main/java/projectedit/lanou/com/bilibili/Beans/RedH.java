package projectedit.lanou.com.bilibili.Beans;

import java.util.List;

/**
 * Created by lanouhn on 16/10/26.
 */
public class RedH {

    /**
     * code : 0
     * message : OK
     * data : {"unlogin":1,"uname":"","rank":0,"score":0,"list":[{"rank":1,"uid":"2","uname":"烟花队","scorename":"信仰值","score":62434788,"url":"/hd/aki2016#carnival","coin_url":{"src":"http://i0.hdslb.com/bfs/live/504032195cda2fdfe67b2b1f2dd0cd344f180025.png?20160115","height":40,"width":43},"coin1_url":{"src":"http://i0.hdslb.com/bfs/live/33e074f1e3bae9b7b902d7cdaaeae94409d9a260.png","height":33,"width":33}}]}
     */

    private int code;
    private String message;
    /**
     * unlogin : 1
     * uname :
     * rank : 0
     * score : 0
     * list : [{"rank":1,"uid":"2","uname":"烟花队","scorename":"信仰值","score":62434788,"url":"/hd/aki2016#carnival","coin_url":{"src":"http://i0.hdslb.com/bfs/live/504032195cda2fdfe67b2b1f2dd0cd344f180025.png?20160115","height":40,"width":43},"coin1_url":{"src":"http://i0.hdslb.com/bfs/live/33e074f1e3bae9b7b902d7cdaaeae94409d9a260.png","height":33,"width":33}}]
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
        private int score;
        /**
         * rank : 1
         * uid : 2
         * uname : 烟花队
         * scorename : 信仰值
         * score : 62434788
         * url : /hd/aki2016#carnival
         * coin_url : {"src":"http://i0.hdslb.com/bfs/live/504032195cda2fdfe67b2b1f2dd0cd344f180025.png?20160115","height":40,"width":43}
         * coin1_url : {"src":"http://i0.hdslb.com/bfs/live/33e074f1e3bae9b7b902d7cdaaeae94409d9a260.png","height":33,"width":33}
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

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            private int rank;
            private String uid;
            private String uname;
            private String scorename;
            private int score;
            private String url;
            /**
             * src : http://i0.hdslb.com/bfs/live/504032195cda2fdfe67b2b1f2dd0cd344f180025.png?20160115
             * height : 40
             * width : 43
             */

            private CoinUrlBean coin_url;
            /**
             * src : http://i0.hdslb.com/bfs/live/33e074f1e3bae9b7b902d7cdaaeae94409d9a260.png
             * height : 33
             * width : 33
             */

            private Coin1UrlBean coin1_url;

            public int getRank() {
                return rank;
            }

            public void setRank(int rank) {
                this.rank = rank;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getUname() {
                return uname;
            }

            public void setUname(String uname) {
                this.uname = uname;
            }

            public String getScorename() {
                return scorename;
            }

            public void setScorename(String scorename) {
                this.scorename = scorename;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public CoinUrlBean getCoin_url() {
                return coin_url;
            }

            public void setCoin_url(CoinUrlBean coin_url) {
                this.coin_url = coin_url;
            }

            public Coin1UrlBean getCoin1_url() {
                return coin1_url;
            }

            public void setCoin1_url(Coin1UrlBean coin1_url) {
                this.coin1_url = coin1_url;
            }

            public static class CoinUrlBean {
                private String src;
                private int height;
                private int width;

                public String getSrc() {
                    return src;
                }

                public void setSrc(String src) {
                    this.src = src;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }
            }

            public static class Coin1UrlBean {
                private String src;
                private int height;
                private int width;

                public String getSrc() {
                    return src;
                }

                public void setSrc(String src) {
                    this.src = src;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }
            }
        }
    }
}
