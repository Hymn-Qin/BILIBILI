package projectedit.lanou.com.bilibili.Beans;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lanouhn on 16/10/25.
 */
public class LiveItemPlay {

    /**
     * code : 0
     * data : {"room_id":5279,"title":"30号世界总决赛","cover":"http://i0.hdslb.com/bfs/live/5279.jpg?10250858","mid":110631,"uname":"宫本·狗雨","face":"http://i1.hdslb.com/bfs/face/2c0799d5e65a56668944d3807405663620b720a3.jpg","m_face":"http://i1.hdslb.com/bfs/face/2c0799d5e65a56668944d3807405663620b720a3.jpg","background_id":1,"attention":322286,"is_attention":0,"online":7676,"create":1417237090,"create_at":"2014-11-29 12:58:10","sch_id":0,"status":"LIVE","area":"电子竞技","area_id":4,"schedule":{"cid":5279,"sch_id":0,"title":"30号世界总决赛","mid":110631,"manager":[],"start":1417237090,"start_at":"2014-11-29 12:58:10","aid":0,"stream_id":774,"online":7676,"status":"LIVE","meta_id":0,"pending_meta_id":0},"meta":{"tag":["英雄联盟","守望麦克雷","黄金矿工","灵魂唱见"],"description":">","typeid":1,"tag_ids":{"0":24},"cover":"http://i0.hdslb.com/bfs/live/5279.jpg?10250858","check_status":"VERIFY","aid":0},"cmt":"dm.live.bilibili.com","cmt_port":88,"cmt_port_goim":788,"recommend":[{"owner":{"face":"http://i2.hdslb.com/bfs/face/7a05af2829536d554a8a837ca87c853cd68e4786.jpg","mid":102571,"name":"里柯"},"cover":{"src":"http://i0.hdslb.com/bfs/live/46228.jpg?10250856"},"title":"二姨 : 小跳蛙的直播间","room_id":46228,"online":36}],"toplist":[{"name":"红叶祭","type":"redleaf"}],"isvip":0,"opentime":2541,"prepare":"主播正在换女装中...","isadmin":0,"hot_word":[{"id":39,"words":"请大家注意弹幕礼仪哦！"}],"roomgifts":[{"id":44,"name":"金鱼胖次","price":19900,"coin_type":{"gold":"gold"},"img":"http://static.hdslb.com/live-static/live-room/images/gift-section/gift-44.png?2016102401","gif_url":"http://static.hdslb.com/live-static/live-room/images/gift-section/mobilegift/xhdpi/44.gif?2016102401","count_set":"1,10,99,188,450,520,1314"}],"ignore_gift":[{"id":1,"num":10}],"msg_length":20,"master_level":39,"master_level_color":16609488,"broadcast_type":0,"activity_gift":[{"id":45,"name":"烤红薯","num":0,"img":"http://static.hdslb.com/live-static/live-room/images/gift-section/gift-45.png?2016102401","gif_url":"http://static.hdslb.com/live-static/live-room/images/gift-section/mobilegift/xhdpi/45.gif?2016102401"}],"check_version":0,"activity_id":0,"event_corner":[]}
     */

    private int code;
    /**
     * room_id : 5279
     * title : 30号世界总决赛
     * cover : http://i0.hdslb.com/bfs/live/5279.jpg?10250858
     * mid : 110631
     * uname : 宫本·狗雨
     * face : http://i1.hdslb.com/bfs/face/2c0799d5e65a56668944d3807405663620b720a3.jpg
     * m_face : http://i1.hdslb.com/bfs/face/2c0799d5e65a56668944d3807405663620b720a3.jpg
     * background_id : 1
     * attention : 322286
     * is_attention : 0
     * online : 7676
     * create : 1417237090
     * create_at : 2014-11-29 12:58:10
     * sch_id : 0
     * status : LIVE
     * area : 电子竞技
     * area_id : 4
     * schedule : {"cid":5279,"sch_id":0,"title":"30号世界总决赛","mid":110631,"manager":[],"start":1417237090,"start_at":"2014-11-29 12:58:10","aid":0,"stream_id":774,"online":7676,"status":"LIVE","meta_id":0,"pending_meta_id":0}
     * meta : {"tag":["英雄联盟","守望麦克雷","黄金矿工","灵魂唱见"],"description":">","typeid":1,"tag_ids":{"0":24},"cover":"http://i0.hdslb.com/bfs/live/5279.jpg?10250858","check_status":"VERIFY","aid":0}
     * cmt : dm.live.bilibili.com
     * cmt_port : 88
     * cmt_port_goim : 788
     * recommend : [{"owner":{"face":"http://i2.hdslb.com/bfs/face/7a05af2829536d554a8a837ca87c853cd68e4786.jpg","mid":102571,"name":"里柯"},"cover":{"src":"http://i0.hdslb.com/bfs/live/46228.jpg?10250856"},"title":"二姨 : 小跳蛙的直播间","room_id":46228,"online":36}]
     * toplist : [{"name":"红叶祭","type":"redleaf"}]
     * isvip : 0
     * opentime : 2541
     * prepare : 主播正在换女装中...
     * isadmin : 0
     * hot_word : [{"id":39,"words":"请大家注意弹幕礼仪哦！"}]
     * roomgifts : [{"id":44,"name":"金鱼胖次","price":19900,"coin_type":{"gold":"gold"},"img":"http://static.hdslb.com/live-static/live-room/images/gift-section/gift-44.png?2016102401","gif_url":"http://static.hdslb.com/live-static/live-room/images/gift-section/mobilegift/xhdpi/44.gif?2016102401","count_set":"1,10,99,188,450,520,1314"}]
     * ignore_gift : [{"id":1,"num":10}]
     * msg_length : 20
     * master_level : 39
     * master_level_color : 16609488
     * broadcast_type : 0
     * activity_gift : [{"id":45,"name":"烤红薯","num":0,"img":"http://static.hdslb.com/live-static/live-room/images/gift-section/gift-45.png?2016102401","gif_url":"http://static.hdslb.com/live-static/live-room/images/gift-section/mobilegift/xhdpi/45.gif?2016102401"}]
     * check_version : 0
     * activity_id : 0
     * event_corner : []
     */

    private DataBean data;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private int room_id;
        private String title;
        private String cover;
        private int mid;
        private String uname;
        private String face;
        private String m_face;
        private int background_id;
        private int attention;
        private int is_attention;
        private int online;
        private int create;
        private String create_at;
        private int sch_id;
        private String status;
        private String area;
        private int area_id;
        /**
         * cid : 5279
         * sch_id : 0
         * title : 30号世界总决赛
         * mid : 110631
         * manager : []
         * start : 1417237090
         * start_at : 2014-11-29 12:58:10
         * aid : 0
         * stream_id : 774
         * online : 7676
         * status : LIVE
         * meta_id : 0
         * pending_meta_id : 0
         */

        private ScheduleBean schedule;
        /**
         * tag : ["英雄联盟","守望麦克雷","黄金矿工","灵魂唱见"]
         * description : >
         * typeid : 1
         * tag_ids : {"0":24}
         * cover : http://i0.hdslb.com/bfs/live/5279.jpg?10250858
         * check_status : VERIFY
         * aid : 0
         */

        private MetaBean meta;
        private String cmt;
        private int cmt_port;
        private int cmt_port_goim;
        private int isvip;
        private int opentime;
        private String prepare;
        private int isadmin;
        private int msg_length;
        private int master_level;
        private int master_level_color;
        private int broadcast_type;
        private int check_version;
        private int activity_id;
        /**
         * owner : {"face":"http://i2.hdslb.com/bfs/face/7a05af2829536d554a8a837ca87c853cd68e4786.jpg","mid":102571,"name":"里柯"}
         * cover : {"src":"http://i0.hdslb.com/bfs/live/46228.jpg?10250856"}
         * title : 二姨 : 小跳蛙的直播间
         * room_id : 46228
         * online : 36
         */

        private List<RecommendBean> recommend;
        /**
         * name : 红叶祭
         * type : redleaf
         */

        private List<ToplistBean> toplist;
        /**
         * id : 39
         * words : 请大家注意弹幕礼仪哦！
         */

        private List<HotWordBean> hot_word;
        /**
         * id : 44
         * name : 金鱼胖次
         * price : 19900
         * coin_type : {"gold":"gold"}
         * img : http://static.hdslb.com/live-static/live-room/images/gift-section/gift-44.png?2016102401
         * gif_url : http://static.hdslb.com/live-static/live-room/images/gift-section/mobilegift/xhdpi/44.gif?2016102401
         * count_set : 1,10,99,188,450,520,1314
         */

        private List<RoomgiftsBean> roomgifts;
        /**
         * id : 1
         * num : 10
         */

        private List<IgnoreGiftBean> ignore_gift;
        /**
         * id : 45
         * name : 烤红薯
         * num : 0
         * img : http://static.hdslb.com/live-static/live-room/images/gift-section/gift-45.png?2016102401
         * gif_url : http://static.hdslb.com/live-static/live-room/images/gift-section/mobilegift/xhdpi/45.gif?2016102401
         */

        private List<ActivityGiftBean> activity_gift;
        private List<?> event_corner;///////////////////////////////


        public int getRoom_id() {
            return room_id;
        }

        public void setRoom_id(int room_id) {
            this.room_id = room_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public int getMid() {
            return mid;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public String getUname() {
            return uname;
        }

        public void setUname(String uname) {
            this.uname = uname;
        }

        public String getFace() {
            return face;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public String getM_face() {
            return m_face;
        }

        public void setM_face(String m_face) {
            this.m_face = m_face;
        }

        public int getBackground_id() {
            return background_id;
        }

        public void setBackground_id(int background_id) {
            this.background_id = background_id;
        }

        public int getAttention() {
            return attention;
        }

        public void setAttention(int attention) {
            this.attention = attention;
        }

        public int getIs_attention() {
            return is_attention;
        }

        public void setIs_attention(int is_attention) {
            this.is_attention = is_attention;
        }

        public int getOnline() {
            return online;
        }

        public void setOnline(int online) {
            this.online = online;
        }

        public int getCreate() {
            return create;
        }

        public void setCreate(int create) {
            this.create = create;
        }

        public String getCreate_at() {
            return create_at;
        }

        public void setCreate_at(String create_at) {
            this.create_at = create_at;
        }

        public int getSch_id() {
            return sch_id;
        }

        public void setSch_id(int sch_id) {
            this.sch_id = sch_id;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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

        public ScheduleBean getSchedule() {
            return schedule;
        }

        public void setSchedule(ScheduleBean schedule) {
            this.schedule = schedule;
        }

        public MetaBean getMeta() {
            return meta;
        }

        public void setMeta(MetaBean meta) {
            this.meta = meta;
        }

        public String getCmt() {
            return cmt;
        }

        public void setCmt(String cmt) {
            this.cmt = cmt;
        }

        public int getCmt_port() {
            return cmt_port;
        }

        public void setCmt_port(int cmt_port) {
            this.cmt_port = cmt_port;
        }

        public int getCmt_port_goim() {
            return cmt_port_goim;
        }

        public void setCmt_port_goim(int cmt_port_goim) {
            this.cmt_port_goim = cmt_port_goim;
        }

        public int getIsvip() {
            return isvip;
        }

        public void setIsvip(int isvip) {
            this.isvip = isvip;
        }

        public int getOpentime() {
            return opentime;
        }

        public void setOpentime(int opentime) {
            this.opentime = opentime;
        }

        public String getPrepare() {
            return prepare;
        }

        public void setPrepare(String prepare) {
            this.prepare = prepare;
        }

        public int getIsadmin() {
            return isadmin;
        }

        public void setIsadmin(int isadmin) {
            this.isadmin = isadmin;
        }

        public int getMsg_length() {
            return msg_length;
        }

        public void setMsg_length(int msg_length) {
            this.msg_length = msg_length;
        }

        public int getMaster_level() {
            return master_level;
        }

        public void setMaster_level(int master_level) {
            this.master_level = master_level;
        }

        public int getMaster_level_color() {
            return master_level_color;
        }

        public void setMaster_level_color(int master_level_color) {
            this.master_level_color = master_level_color;
        }

        public int getBroadcast_type() {
            return broadcast_type;
        }

        public void setBroadcast_type(int broadcast_type) {
            this.broadcast_type = broadcast_type;
        }

        public int getCheck_version() {
            return check_version;
        }

        public void setCheck_version(int check_version) {
            this.check_version = check_version;
        }

        public int getActivity_id() {
            return activity_id;
        }

        public void setActivity_id(int activity_id) {
            this.activity_id = activity_id;
        }

        public List<RecommendBean> getRecommend() {
            return recommend;
        }

        public void setRecommend(List<RecommendBean> recommend) {
            this.recommend = recommend;
        }

        public List<ToplistBean> getToplist() {
            return toplist;
        }

        public void setToplist(List<ToplistBean> toplist) {
            this.toplist = toplist;
        }

        public List<HotWordBean> getHot_word() {
            return hot_word;
        }

        public void setHot_word(List<HotWordBean> hot_word) {
            this.hot_word = hot_word;
        }

        public List<RoomgiftsBean> getRoomgifts() {
            return roomgifts;
        }

        public void setRoomgifts(List<RoomgiftsBean> roomgifts) {
            this.roomgifts = roomgifts;
        }

        public List<IgnoreGiftBean> getIgnore_gift() {
            return ignore_gift;
        }

        public void setIgnore_gift(List<IgnoreGiftBean> ignore_gift) {
            this.ignore_gift = ignore_gift;
        }

        public List<ActivityGiftBean> getActivity_gift() {
            return activity_gift;
        }

        public void setActivity_gift(List<ActivityGiftBean> activity_gift) {
            this.activity_gift = activity_gift;
        }

        public List<?> getEvent_corner() {
            return event_corner;
        }

        public void setEvent_corner(List<?> event_corner) {
            this.event_corner = event_corner;
        }

        public static class ScheduleBean {
            private int cid;
            private int sch_id;
            private String title;
            private int mid;
            private int start;
            private String start_at;
            private int aid;
            private int stream_id;
            private int online;
            private String status;
            private int meta_id;
            private int pending_meta_id;
            private List<?> manager;///////////////////////



            public int getCid() {
                return cid;
            }

            public void setCid(int cid) {
                this.cid = cid;
            }

            public int getSch_id() {
                return sch_id;
            }

            public void setSch_id(int sch_id) {
                this.sch_id = sch_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getMid() {
                return mid;
            }

            public void setMid(int mid) {
                this.mid = mid;
            }

            public int getStart() {
                return start;
            }

            public void setStart(int start) {
                this.start = start;
            }

            public String getStart_at() {
                return start_at;
            }

            public void setStart_at(String start_at) {
                this.start_at = start_at;
            }

            public int getAid() {
                return aid;
            }

            public void setAid(int aid) {
                this.aid = aid;
            }

            public int getStream_id() {
                return stream_id;
            }

            public void setStream_id(int stream_id) {
                this.stream_id = stream_id;
            }

            public int getOnline() {
                return online;
            }

            public void setOnline(int online) {
                this.online = online;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public int getMeta_id() {
                return meta_id;
            }

            public void setMeta_id(int meta_id) {
                this.meta_id = meta_id;
            }

            public int getPending_meta_id() {
                return pending_meta_id;
            }

            public void setPending_meta_id(int pending_meta_id) {
                this.pending_meta_id = pending_meta_id;
            }

            public List<?> getManager() {
                return manager;
            }

            public void setManager(List<?> manager) {
                this.manager = manager;
            }
        }

        public static class MetaBean {
            private String description;
            private int typeid;
            /**
             * 0 : 24
             */

            private TagIdsBean tag_ids;
            private String cover;
            private String check_status;
            private int aid;
            private List<String> tag;

            public static MetaBean objectFromData(String str) {

                return new Gson().fromJson(str, MetaBean.class);
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getTypeid() {
                return typeid;
            }

            public void setTypeid(int typeid) {
                this.typeid = typeid;
            }

            public TagIdsBean getTag_ids() {
                return tag_ids;
            }

            public void setTag_ids(TagIdsBean tag_ids) {
                this.tag_ids = tag_ids;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getCheck_status() {
                return check_status;
            }

            public void setCheck_status(String check_status) {
                this.check_status = check_status;
            }

            public int getAid() {
                return aid;
            }

            public void setAid(int aid) {
                this.aid = aid;
            }

            public List<String> getTag() {
                return tag;
            }

            public void setTag(List<String> tag) {
                this.tag = tag;
            }

            public static class TagIdsBean {
                @SerializedName("0")
                private int value0;

                public static TagIdsBean objectFromData(String str) {

                    return new Gson().fromJson(str, TagIdsBean.class);
                }

                public int getValue0() {
                    return value0;
                }

                public void setValue0(int value0) {
                    this.value0 = value0;
                }
            }
        }

        public static class RecommendBean {
            /**
             * face : http://i2.hdslb.com/bfs/face/7a05af2829536d554a8a837ca87c853cd68e4786.jpg
             * mid : 102571
             * name : 里柯
             */

            private OwnerBean owner;
            /**
             * src : http://i0.hdslb.com/bfs/live/46228.jpg?10250856
             */

            private CoverBean cover;
            private String title;
            private int room_id;
            private int online;

            public static RecommendBean objectFromData(String str) {

                return new Gson().fromJson(str, RecommendBean.class);
            }

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

            public int getOnline() {
                return online;
            }

            public void setOnline(int online) {
                this.online = online;
            }

            public static class OwnerBean {
                private String face;
                private int mid;
                private String name;

                public static OwnerBean objectFromData(String str) {

                    return new Gson().fromJson(str, OwnerBean.class);
                }

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

                public static CoverBean objectFromData(String str) {

                    return new Gson().fromJson(str, CoverBean.class);
                }

                public String getSrc() {
                    return src;
                }

                public void setSrc(String src) {
                    this.src = src;
                }
            }
        }

        public static class ToplistBean {
            private String name;
            private String type;

            public static ToplistBean objectFromData(String str) {

                return new Gson().fromJson(str, ToplistBean.class);
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public static class HotWordBean {
            private int id;
            private String words;

            public static HotWordBean objectFromData(String str) {

                return new Gson().fromJson(str, HotWordBean.class);
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getWords() {
                return words;
            }

            public void setWords(String words) {
                this.words = words;
            }
        }

        public static class RoomgiftsBean {
            private int id;
            private String name;
            private int price;
            /**
             * gold : gold
             */

            private CoinTypeBean coin_type;
            private String img;
            private String gif_url;
            private String count_set;

            public static RoomgiftsBean objectFromData(String str) {

                return new Gson().fromJson(str, RoomgiftsBean.class);
            }

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

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public CoinTypeBean getCoin_type() {
                return coin_type;
            }

            public void setCoin_type(CoinTypeBean coin_type) {
                this.coin_type = coin_type;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getGif_url() {
                return gif_url;
            }

            public void setGif_url(String gif_url) {
                this.gif_url = gif_url;
            }

            public String getCount_set() {
                return count_set;
            }

            public void setCount_set(String count_set) {
                this.count_set = count_set;
            }

            public static class CoinTypeBean {
                private String gold;

                public static CoinTypeBean objectFromData(String str) {

                    return new Gson().fromJson(str, CoinTypeBean.class);
                }

                public String getGold() {
                    return gold;
                }

                public void setGold(String gold) {
                    this.gold = gold;
                }
            }
        }

        public static class IgnoreGiftBean {
            private int id;
            private int num;


            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }
        }

        public static class ActivityGiftBean {
            private int id;
            private String name;
            private int num;
            private String img;
            private String gif_url;

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

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getGif_url() {
                return gif_url;
            }

            public void setGif_url(String gif_url) {
                this.gif_url = gif_url;
            }
        }
    }
}
