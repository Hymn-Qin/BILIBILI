package projectedit.lanou.com.bilibili.Beans;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by lanouhn on 16/10/26.
 */
public class LivePlayDanmaku {

    /**
     * code : 0
     * message : OK
     * data : {"room":[{"text":"右边","uid":8208484,"nickname":"平衡炫影","timeline":"2016-10-26 10:59:20","isadmin":0,"vip":0,"svip":0,"medal":[10,"可樂","可樂C",114,11433699],"title":["ice-dust"],"user_level":[23,0,12108287,">50000"],"rank":10000,"teamid":3,"rnd":1477447558,"user_title":"title-48-1","guard_level":0}],"admin":[]}
     */

    private int code;
    private String message;
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
         * text : 右边
         * uid : 8208484
         * nickname : 平衡炫影
         * timeline : 2016-10-26 10:59:20
         * isadmin : 0
         * vip : 0
         * svip : 0
         * medal : [10,"可樂","可樂C",114,11433699]
         * title : ["ice-dust"]
         * user_level : [23,0,12108287,">50000"]
         * rank : 10000
         * teamid : 3
         * rnd : 1477447558
         * user_title : title-48-1
         * guard_level : 0
         */

        private List<RoomBean> room;
        private List<String> admin;

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public List<RoomBean> getRoom() {
            return room;
        }

        public void setRoom(List<RoomBean> room) {
            this.room = room;
        }

        public List<String> getAdmin() {
            return admin;
        }

        public void setAdmin(List<String> admin) {
            this.admin = admin;
        }

        public static class RoomBean {
            private String text;
            private int uid;
            private String nickname;
            private String timeline;
            private int isadmin;
            private int vip;
            private int svip;
            private int rank;
            private int teamid;
            private int rnd;
            private String user_title;
            private int guard_level;
            private List<String> medal;
            private List<String> title;
            private List<String> user_level;

            public static RoomBean objectFromData(String str) {

                return new Gson().fromJson(str, RoomBean.class);
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getTimeline() {
                return timeline;
            }

            public void setTimeline(String timeline) {
                this.timeline = timeline;
            }

            public int getIsadmin() {
                return isadmin;
            }

            public void setIsadmin(int isadmin) {
                this.isadmin = isadmin;
            }

            public int getVip() {
                return vip;
            }

            public void setVip(int vip) {
                this.vip = vip;
            }

            public int getSvip() {
                return svip;
            }

            public void setSvip(int svip) {
                this.svip = svip;
            }

            public int getRank() {
                return rank;
            }

            public void setRank(int rank) {
                this.rank = rank;
            }

            public int getTeamid() {
                return teamid;
            }

            public void setTeamid(int teamid) {
                this.teamid = teamid;
            }

            public int getRnd() {
                return rnd;
            }

            public void setRnd(int rnd) {
                this.rnd = rnd;
            }

            public String getUser_title() {
                return user_title;
            }

            public void setUser_title(String user_title) {
                this.user_title = user_title;
            }

            public int getGuard_level() {
                return guard_level;
            }

            public void setGuard_level(int guard_level) {
                this.guard_level = guard_level;
            }

            public List<String> getMedal() {
                return medal;
            }

            public void setMedal(List<String> medal) {
                this.medal = medal;
            }

            public List<String> getTitle() {
                return title;
            }

            public void setTitle(List<String> title) {
                this.title = title;
            }

            public List<String> getUser_level() {
                return user_level;
            }

            public void setUser_level(List<String> user_level) {
                this.user_level = user_level;
            }
        }
    }
}
