package projectedit.lanou.com.bilibili.Beans;

import java.util.List;

/**
 * Created by lanouhn on 16/10/20.
 */
public class LiveChooseHeadler {


    /**
     * code : 0
     * message : ok
     * data : {"recommend_data":{"lives":[{"owner":{"face":"http://i2.hdslb.com/bfs/face/957e5d73419e56fb170ea5c4ba34931991ba610c.jpg","mid":17149242,"name":"妹抖千"},"cover":{"src":"http://i0.hdslb.com/bfs/live/a239f1f75281be3a70d79cdf1bff85ebac6d4d00.jpg","height":180,"width":320},"room_id":266090,"check_version":0,"online":122,"area":"网络游戏","area_id":3,"title":"来来 正♂经的游戏♂","playurl":"http://live-play.acgvideo.com/live/579/live_17149242_7395324.flv?wsSecret=2a62cddc9623be8f5714cb81289f8959&wsTime=57e10d3c","accept_quality":"4","broadcast_type":0,"is_tv":0}],"partition":{"id":0,"name":"推荐主播","area":"hot","sub_icon":{"src":"http://static.hdslb.com/live-static/images/mobile/android/small/xhdpi/-1.png?2016102002","height":"42","width":"42"},"count":2782},"banner_data":[{"owner":{"face":"http://i0.hdslb.com/bfs/face/e291cb1841606e1907cf63015f633747c331b8c5.jpg","mid":9918434,"name":"哔哩哔哩电台"},"cover":{"src":"http://i0.hdslb.com/bfs/live/4dafc8b4a5be61188e4cc46c05bc7df7e0b24924.png","height":180,"width":320},"title":"【官方】旧番连播智慧版","room_id":5446,"check_version":0,"online":236,"area":"放映厅","area_id":7,"playurl":"http://yf.live-play.acgvideo.com/live-yf/376702/live_9918434_9559396.flv?wsSecret=47c8c54e1a3c4c90eb889010b0e1efd0&wsTime=1476956980","accept_quality":"4","broadcast_type":0,"is_tv":0}]}}
     */

    private int code;
    private String message;
    /**
     * recommend_data : {"lives":[{"owner":{"face":"http://i2.hdslb.com/bfs/face/957e5d73419e56fb170ea5c4ba34931991ba610c.jpg","mid":17149242,"name":"妹抖千"},"cover":{"src":"http://i0.hdslb.com/bfs/live/a239f1f75281be3a70d79cdf1bff85ebac6d4d00.jpg","height":180,"width":320},"room_id":266090,"check_version":0,"online":122,"area":"网络游戏","area_id":3,"title":"来来 正♂经的游戏♂","playurl":"http://live-play.acgvideo.com/live/579/live_17149242_7395324.flv?wsSecret=2a62cddc9623be8f5714cb81289f8959&wsTime=57e10d3c","accept_quality":"4","broadcast_type":0,"is_tv":0}],"partition":{"id":0,"name":"推荐主播","area":"hot","sub_icon":{"src":"http://static.hdslb.com/live-static/images/mobile/android/small/xhdpi/-1.png?2016102002","height":"42","width":"42"},"count":2782},"banner_data":[{"owner":{"face":"http://i0.hdslb.com/bfs/face/e291cb1841606e1907cf63015f633747c331b8c5.jpg","mid":9918434,"name":"哔哩哔哩电台"},"cover":{"src":"http://i0.hdslb.com/bfs/live/4dafc8b4a5be61188e4cc46c05bc7df7e0b24924.png","height":180,"width":320},"title":"【官方】旧番连播智慧版","room_id":5446,"check_version":0,"online":236,"area":"放映厅","area_id":7,"playurl":"http://yf.live-play.acgvideo.com/live-yf/376702/live_9918434_9559396.flv?wsSecret=47c8c54e1a3c4c90eb889010b0e1efd0&wsTime=1476956980","accept_quality":"4","broadcast_type":0,"is_tv":0}]}
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
        /**
         * lives : [{"owner":{"face":"http://i2.hdslb.com/bfs/face/957e5d73419e56fb170ea5c4ba34931991ba610c.jpg","mid":17149242,"name":"妹抖千"},"cover":{"src":"http://i0.hdslb.com/bfs/live/a239f1f75281be3a70d79cdf1bff85ebac6d4d00.jpg","height":180,"width":320},"room_id":266090,"check_version":0,"online":122,"area":"网络游戏","area_id":3,"title":"来来 正♂经的游戏♂","playurl":"http://live-play.acgvideo.com/live/579/live_17149242_7395324.flv?wsSecret=2a62cddc9623be8f5714cb81289f8959&wsTime=57e10d3c","accept_quality":"4","broadcast_type":0,"is_tv":0}]
         * partition : {"id":0,"name":"推荐主播","area":"hot","sub_icon":{"src":"http://static.hdslb.com/live-static/images/mobile/android/small/xhdpi/-1.png?2016102002","height":"42","width":"42"},"count":2782}
         * banner_data : [{"owner":{"face":"http://i0.hdslb.com/bfs/face/e291cb1841606e1907cf63015f633747c331b8c5.jpg","mid":9918434,"name":"哔哩哔哩电台"},"cover":{"src":"http://i0.hdslb.com/bfs/live/4dafc8b4a5be61188e4cc46c05bc7df7e0b24924.png","height":180,"width":320},"title":"【官方】旧番连播智慧版","room_id":5446,"check_version":0,"online":236,"area":"放映厅","area_id":7,"playurl":"http://yf.live-play.acgvideo.com/live-yf/376702/live_9918434_9559396.flv?wsSecret=47c8c54e1a3c4c90eb889010b0e1efd0&wsTime=1476956980","accept_quality":"4","broadcast_type":0,"is_tv":0}]
         */

        private RecommendDataBean recommend_data;

        public RecommendDataBean getRecommend_data() {
            return recommend_data;
        }

        public void setRecommend_data(RecommendDataBean recommend_data) {
            this.recommend_data = recommend_data;
        }

        public static class RecommendDataBean {
            /**
             * id : 0
             * name : 推荐主播
             * area : hot
             * sub_icon : {"src":"http://static.hdslb.com/live-static/images/mobile/android/small/xhdpi/-1.png?2016102002","height":"42","width":"42"}
             * count : 2782
             */

            private PartitionBean partition;
            /**
             * owner : {"face":"http://i2.hdslb.com/bfs/face/957e5d73419e56fb170ea5c4ba34931991ba610c.jpg","mid":17149242,"name":"妹抖千"}
             * cover : {"src":"http://i0.hdslb.com/bfs/live/a239f1f75281be3a70d79cdf1bff85ebac6d4d00.jpg","height":180,"width":320}
             * room_id : 266090
             * check_version : 0
             * online : 122
             * area : 网络游戏
             * area_id : 3
             * title : 来来 正♂经的游戏♂
             * playurl : http://live-play.acgvideo.com/live/579/live_17149242_7395324.flv?wsSecret=2a62cddc9623be8f5714cb81289f8959&wsTime=57e10d3c
             * accept_quality : 4
             * broadcast_type : 0
             * is_tv : 0
             */

            private List<LivesBean> lives;
            /**
             * owner : {"face":"http://i0.hdslb.com/bfs/face/e291cb1841606e1907cf63015f633747c331b8c5.jpg","mid":9918434,"name":"哔哩哔哩电台"}
             * cover : {"src":"http://i0.hdslb.com/bfs/live/4dafc8b4a5be61188e4cc46c05bc7df7e0b24924.png","height":180,"width":320}
             * title : 【官方】旧番连播智慧版
             * room_id : 5446
             * check_version : 0
             * online : 236
             * area : 放映厅
             * area_id : 7
             * playurl : http://yf.live-play.acgvideo.com/live-yf/376702/live_9918434_9559396.flv?wsSecret=47c8c54e1a3c4c90eb889010b0e1efd0&wsTime=1476956980
             * accept_quality : 4
             * broadcast_type : 0
             * is_tv : 0
             */

            private List<BannerDataBean> banner_data;

            public PartitionBean getPartition() {
                return partition;
            }

            public void setPartition(PartitionBean partition) {
                this.partition = partition;
            }

            public List<LivesBean> getLives() {
                return lives;
            }

            public void setLives(List<LivesBean> lives) {
                this.lives = lives;
            }

            public List<BannerDataBean> getBanner_data() {
                return banner_data;
            }

            public void setBanner_data(List<BannerDataBean> banner_data) {
                this.banner_data = banner_data;
            }

            public static class PartitionBean {
                private int id;
                private String name;
                private String area;
                /**
                 * src : http://static.hdslb.com/live-static/images/mobile/android/small/xhdpi/-1.png?2016102002
                 * height : 42
                 * width : 42
                 */

                private SubIconBean sub_icon;
                private int count;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getArea() {
                    return area;
                }

                public void setArea(String area) {
                    this.area = area;
                }

                public SubIconBean getSub_icon() {
                    return sub_icon;
                }

                public void setSub_icon(SubIconBean sub_icon) {
                    this.sub_icon = sub_icon;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public static class SubIconBean {
                    private String src;
                    private String height;
                    private String width;

                    public String getSrc() {
                        return src;
                    }

                    public void setSrc(String src) {
                        this.src = src;
                    }

                    public String getHeight() {
                        return height;
                    }

                    public void setHeight(String height) {
                        this.height = height;
                    }

                    public String getWidth() {
                        return width;
                    }

                    public void setWidth(String width) {
                        this.width = width;
                    }
                }
            }

            public static class LivesBean {
                /**
                 * face : http://i2.hdslb.com/bfs/face/957e5d73419e56fb170ea5c4ba34931991ba610c.jpg
                 * mid : 17149242
                 * name : 妹抖千
                 */

                private OwnerBean owner;
                /**
                 * src : http://i0.hdslb.com/bfs/live/a239f1f75281be3a70d79cdf1bff85ebac6d4d00.jpg
                 * height : 180
                 * width : 320
                 */

                private CoverBean cover;
                private int room_id;
                private int check_version;
                private int online;
                private String area;
                private int area_id;
                private String title;
                private String playurl;
                private String accept_quality;
                private int broadcast_type;
                private int is_tv;

                public OwnerBean getOwner() {
                    return owner;
                }

                public void setOwner(OwnerBean owner) {
                    this.owner = owner;
                }

                public CoverBean getCover() {
                    return cover;
                }

                public void setCover(CoverBean cover) {
                    this.cover = cover;
                }

                public int getRoom_id() {
                    return room_id;
                }

                public void setRoom_id(int room_id) {
                    this.room_id = room_id;
                }

                public int getCheck_version() {
                    return check_version;
                }

                public void setCheck_version(int check_version) {
                    this.check_version = check_version;
                }

                public int getOnline() {
                    return online;
                }

                public void setOnline(int online) {
                    this.online = online;
                }

                public String getArea() {
                    return area;
                }

                public void setArea(String area) {
                    this.area = area;
                }

                public int getArea_id() {
                    return area_id;
                }

                public void setArea_id(int area_id) {
                    this.area_id = area_id;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getPlayurl() {
                    return playurl;
                }

                public void setPlayurl(String playurl) {
                    this.playurl = playurl;
                }

                public String getAccept_quality() {
                    return accept_quality;
                }

                public void setAccept_quality(String accept_quality) {
                    this.accept_quality = accept_quality;
                }

                public int getBroadcast_type() {
                    return broadcast_type;
                }

                public void setBroadcast_type(int broadcast_type) {
                    this.broadcast_type = broadcast_type;
                }

                public int getIs_tv() {
                    return is_tv;
                }

                public void setIs_tv(int is_tv) {
                    this.is_tv = is_tv;
                }

                public static class OwnerBean {
                    private String face;
                    private int mid;
                    private String name;

                    public String getFace() {
                        return face;
                    }

                    public void setFace(String face) {
                        this.face = face;
                    }

                    public int getMid() {
                        return mid;
                    }

                    public void setMid(int mid) {
                        this.mid = mid;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }
                }

                public static class CoverBean {
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

            public static class BannerDataBean {
                /**
                 * face : http://i0.hdslb.com/bfs/face/e291cb1841606e1907cf63015f633747c331b8c5.jpg
                 * mid : 9918434
                 * name : 哔哩哔哩电台
                 */

                private OwnerBean owner;
                /**
                 * src : http://i0.hdslb.com/bfs/live/4dafc8b4a5be61188e4cc46c05bc7df7e0b24924.png
                 * height : 180
                 * width : 320
                 */

                private CoverBean cover;
                private String title;
                private int room_id;
                private int check_version;
                private int online;
                private String area;
                private int area_id;
                private String playurl;
                private String accept_quality;
                private int broadcast_type;
                private int is_tv;

                public OwnerBean getOwner() {
                    return owner;
                }

                public void setOwner(OwnerBean owner) {
                    this.owner = owner;
                }

                public CoverBean getCover() {
                    return cover;
                }

                public void setCover(CoverBean cover) {
                    this.cover = cover;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getRoom_id() {
                    return room_id;
                }

                public void setRoom_id(int room_id) {
                    this.room_id = room_id;
                }

                public int getCheck_version() {
                    return check_version;
                }

                public void setCheck_version(int check_version) {
                    this.check_version = check_version;
                }

                public int getOnline() {
                    return online;
                }

                public void setOnline(int online) {
                    this.online = online;
                }

                public String getArea() {
                    return area;
                }

                public void setArea(String area) {
                    this.area = area;
                }

                public int getArea_id() {
                    return area_id;
                }

                public void setArea_id(int area_id) {
                    this.area_id = area_id;
                }

                public String getPlayurl() {
                    return playurl;
                }

                public void setPlayurl(String playurl) {
                    this.playurl = playurl;
                }

                public String getAccept_quality() {
                    return accept_quality;
                }

                public void setAccept_quality(String accept_quality) {
                    this.accept_quality = accept_quality;
                }

                public int getBroadcast_type() {
                    return broadcast_type;
                }

                public void setBroadcast_type(int broadcast_type) {
                    this.broadcast_type = broadcast_type;
                }

                public int getIs_tv() {
                    return is_tv;
                }

                public void setIs_tv(int is_tv) {
                    this.is_tv = is_tv;
                }

                public static class OwnerBean {
                    private String face;
                    private int mid;
                    private String name;

                    public String getFace() {
                        return face;
                    }

                    public void setFace(String face) {
                        this.face = face;
                    }

                    public int getMid() {
                        return mid;
                    }

                    public void setMid(int mid) {
                        this.mid = mid;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }
                }

                public static class CoverBean {
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
}
