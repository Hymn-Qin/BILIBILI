package projectedit.lanou.com.bilibili.Beans;

import java.util.List;

/**
 * Created by lanouhn on 16/10/27.
 */
public class HisPlayUp {

    /**
     * code : 0
     * message : success
     * result : {"ad":{"body":[],"head":[{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/eef4d3e7f71c59630f13e67925aa85da1d4caf36.jpg","is_ad":0,"link":"http://bangumi.bilibili.com/anime/5550","pub_time":"2016-10-26 03:00:00","title":"夏目友人帐 伍"}]},"china":[{"cover":"http://i0.hdslb.com/bfs/bangumi/e3366e021abb45f74bf99c1e140eee45605ec52a.jpg","favourites":"59742","is_finish":0,"last_time":1477454622,"newest_ep_index":"3","pub_time":1475164800,"season_id":5559,"season_status":2,"title":"那年那兔那些事儿 第三季","watching_count":0}],"previous":{"list":[{"cover":"http://i0.hdslb.com/bfs/bangumi/6b4ba7bd59be1f9de225294d18ca5e6819185c06.jpg","favourites":"1405503","is_finish":1,"last_time":1474725610,"newest_ep_index":"13","pub_time":1467468000,"season_id":5017,"season_status":2,"title":"食戟之灵 贰之皿","watching_count":0}],"season":3,"year":2016},"serializing":[{"cover":"http://i0.hdslb.com/bfs/bangumi/eb4f17335f48951945fb9da47e6ee0bc65fa2fbb.jpg","favourites":"664608","is_finish":0,"is_started":1,"last_time":1477526410,"newest_ep_index":"84","pub_time":1467590400,"season_id":5070,"season_status":2,"title":"齐木楠雄的灾难（日播版）","watching_count":2112}]}
     */

    private int code;
    private String message;
    /**
     * ad : {"body":[],"head":[{"id":0,"img":"http://i0.hdslb.com/bfs/bangumi/eef4d3e7f71c59630f13e67925aa85da1d4caf36.jpg","is_ad":0,"link":"http://bangumi.bilibili.com/anime/5550","pub_time":"2016-10-26 03:00:00","title":"夏目友人帐 伍"}]}
     * china : [{"cover":"http://i0.hdslb.com/bfs/bangumi/e3366e021abb45f74bf99c1e140eee45605ec52a.jpg","favourites":"59742","is_finish":0,"last_time":1477454622,"newest_ep_index":"3","pub_time":1475164800,"season_id":5559,"season_status":2,"title":"那年那兔那些事儿 第三季","watching_count":0}]
     * previous : {"list":[{"cover":"http://i0.hdslb.com/bfs/bangumi/6b4ba7bd59be1f9de225294d18ca5e6819185c06.jpg","favourites":"1405503","is_finish":1,"last_time":1474725610,"newest_ep_index":"13","pub_time":1467468000,"season_id":5017,"season_status":2,"title":"食戟之灵 贰之皿","watching_count":0}],"season":3,"year":2016}
     * serializing : [{"cover":"http://i0.hdslb.com/bfs/bangumi/eb4f17335f48951945fb9da47e6ee0bc65fa2fbb.jpg","favourites":"664608","is_finish":0,"is_started":1,"last_time":1477526410,"newest_ep_index":"84","pub_time":1467590400,"season_id":5070,"season_status":2,"title":"齐木楠雄的灾难（日播版）","watching_count":2112}]
     */

    private ResultBean result;

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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private AdBean ad;
        /**
         * list : [{"cover":"http://i0.hdslb.com/bfs/bangumi/6b4ba7bd59be1f9de225294d18ca5e6819185c06.jpg","favourites":"1405503","is_finish":1,"last_time":1474725610,"newest_ep_index":"13","pub_time":1467468000,"season_id":5017,"season_status":2,"title":"食戟之灵 贰之皿","watching_count":0}]
         * season : 3
         * year : 2016
         */

        private PreviousBean previous;
        /**
         * cover : http://i0.hdslb.com/bfs/bangumi/e3366e021abb45f74bf99c1e140eee45605ec52a.jpg
         * favourites : 59742
         * is_finish : 0
         * last_time : 1477454622
         * newest_ep_index : 3
         * pub_time : 1475164800
         * season_id : 5559
         * season_status : 2
         * title : 那年那兔那些事儿 第三季
         * watching_count : 0
         */

        private List<ChinaBean> china;
        /**
         * cover : http://i0.hdslb.com/bfs/bangumi/eb4f17335f48951945fb9da47e6ee0bc65fa2fbb.jpg
         * favourites : 664608
         * is_finish : 0
         * is_started : 1
         * last_time : 1477526410
         * newest_ep_index : 84
         * pub_time : 1467590400
         * season_id : 5070
         * season_status : 2
         * title : 齐木楠雄的灾难（日播版）
         * watching_count : 2112
         */

        private List<SerializingBean> serializing;

        public AdBean getAd() {
            return ad;
        }

        public void setAd(AdBean ad) {
            this.ad = ad;
        }

        public PreviousBean getPrevious() {
            return previous;
        }

        public void setPrevious(PreviousBean previous) {
            this.previous = previous;
        }

        public List<ChinaBean> getChina() {
            return china;
        }

        public void setChina(List<ChinaBean> china) {
            this.china = china;
        }

        public List<SerializingBean> getSerializing() {
            return serializing;
        }

        public void setSerializing(List<SerializingBean> serializing) {
            this.serializing = serializing;
        }

        public static class AdBean {
            private List<?> body;
            /**
             * id : 0
             * img : http://i0.hdslb.com/bfs/bangumi/eef4d3e7f71c59630f13e67925aa85da1d4caf36.jpg
             * is_ad : 0
             * link : http://bangumi.bilibili.com/anime/5550
             * pub_time : 2016-10-26 03:00:00
             * title : 夏目友人帐 伍
             */

            private List<HeadBean> head;

            public List<?> getBody() {
                return body;
            }

            public void setBody(List<?> body) {
                this.body = body;
            }

            public List<HeadBean> getHead() {
                return head;
            }

            public void setHead(List<HeadBean> head) {
                this.head = head;
            }

            public static class HeadBean {
                private int id;
                private String img;
                private int is_ad;
                private String link;
                private String pub_time;
                private String title;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public int getIs_ad() {
                    return is_ad;
                }

                public void setIs_ad(int is_ad) {
                    this.is_ad = is_ad;
                }

                public String getLink() {
                    return link;
                }

                public void setLink(String link) {
                    this.link = link;
                }

                public String getPub_time() {
                    return pub_time;
                }

                public void setPub_time(String pub_time) {
                    this.pub_time = pub_time;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
            }
        }

        public static class PreviousBean {
            private int season;
            private int year;
            /**
             * cover : http://i0.hdslb.com/bfs/bangumi/6b4ba7bd59be1f9de225294d18ca5e6819185c06.jpg
             * favourites : 1405503
             * is_finish : 1
             * last_time : 1474725610
             * newest_ep_index : 13
             * pub_time : 1467468000
             * season_id : 5017
             * season_status : 2
             * title : 食戟之灵 贰之皿
             * watching_count : 0
             */

            private List<ListBean> list;

            public int getSeason() {
                return season;
            }

            public void setSeason(int season) {
                this.season = season;
            }

            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                private String cover;
                private String favourites;
                private int is_finish;
                private int last_time;
                private String newest_ep_index;
                private int pub_time;
                private int season_id;
                private int season_status;
                private String title;
                private int watching_count;

                public String getCover() {
                    return cover;
                }

                public void setCover(String cover) {
                    this.cover = cover;
                }

                public String getFavourites() {
                    return favourites;
                }

                public void setFavourites(String favourites) {
                    this.favourites = favourites;
                }

                public int getIs_finish() {
                    return is_finish;
                }

                public void setIs_finish(int is_finish) {
                    this.is_finish = is_finish;
                }

                public int getLast_time() {
                    return last_time;
                }

                public void setLast_time(int last_time) {
                    this.last_time = last_time;
                }

                public String getNewest_ep_index() {
                    return newest_ep_index;
                }

                public void setNewest_ep_index(String newest_ep_index) {
                    this.newest_ep_index = newest_ep_index;
                }

                public int getPub_time() {
                    return pub_time;
                }

                public void setPub_time(int pub_time) {
                    this.pub_time = pub_time;
                }

                public int getSeason_id() {
                    return season_id;
                }

                public void setSeason_id(int season_id) {
                    this.season_id = season_id;
                }

                public int getSeason_status() {
                    return season_status;
                }

                public void setSeason_status(int season_status) {
                    this.season_status = season_status;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getWatching_count() {
                    return watching_count;
                }

                public void setWatching_count(int watching_count) {
                    this.watching_count = watching_count;
                }
            }
        }

        public static class ChinaBean {
            private String cover;
            private String favourites;
            private int is_finish;
            private int last_time;
            private String newest_ep_index;
            private int pub_time;
            private int season_id;
            private int season_status;
            private String title;
            private int watching_count;

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getFavourites() {
                return favourites;
            }

            public void setFavourites(String favourites) {
                this.favourites = favourites;
            }

            public int getIs_finish() {
                return is_finish;
            }

            public void setIs_finish(int is_finish) {
                this.is_finish = is_finish;
            }

            public int getLast_time() {
                return last_time;
            }

            public void setLast_time(int last_time) {
                this.last_time = last_time;
            }

            public String getNewest_ep_index() {
                return newest_ep_index;
            }

            public void setNewest_ep_index(String newest_ep_index) {
                this.newest_ep_index = newest_ep_index;
            }

            public int getPub_time() {
                return pub_time;
            }

            public void setPub_time(int pub_time) {
                this.pub_time = pub_time;
            }

            public int getSeason_id() {
                return season_id;
            }

            public void setSeason_id(int season_id) {
                this.season_id = season_id;
            }

            public int getSeason_status() {
                return season_status;
            }

            public void setSeason_status(int season_status) {
                this.season_status = season_status;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getWatching_count() {
                return watching_count;
            }

            public void setWatching_count(int watching_count) {
                this.watching_count = watching_count;
            }
        }

        public static class SerializingBean {
            private String cover;
            private String favourites;
            private int is_finish;
            private int is_started;
            private int last_time;
            private String newest_ep_index;
            private int pub_time;
            private int season_id;
            private int season_status;
            private String title;
            private int watching_count;

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getFavourites() {
                return favourites;
            }

            public void setFavourites(String favourites) {
                this.favourites = favourites;
            }

            public int getIs_finish() {
                return is_finish;
            }

            public void setIs_finish(int is_finish) {
                this.is_finish = is_finish;
            }

            public int getIs_started() {
                return is_started;
            }

            public void setIs_started(int is_started) {
                this.is_started = is_started;
            }

            public int getLast_time() {
                return last_time;
            }

            public void setLast_time(int last_time) {
                this.last_time = last_time;
            }

            public String getNewest_ep_index() {
                return newest_ep_index;
            }

            public void setNewest_ep_index(String newest_ep_index) {
                this.newest_ep_index = newest_ep_index;
            }

            public int getPub_time() {
                return pub_time;
            }

            public void setPub_time(int pub_time) {
                this.pub_time = pub_time;
            }

            public int getSeason_id() {
                return season_id;
            }

            public void setSeason_id(int season_id) {
                this.season_id = season_id;
            }

            public int getSeason_status() {
                return season_status;
            }

            public void setSeason_status(int season_status) {
                this.season_status = season_status;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getWatching_count() {
                return watching_count;
            }

            public void setWatching_count(int watching_count) {
                this.watching_count = watching_count;
            }
        }
    }
}
