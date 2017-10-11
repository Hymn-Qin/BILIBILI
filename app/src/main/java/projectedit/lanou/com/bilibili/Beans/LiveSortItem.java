package projectedit.lanou.com.bilibili.Beans;

import java.util.List;

/**
 * Created by lanouhn on 16/10/22.
 */
public class LiveSortItem {

    /**
     * code : 0
     * message : ok
     * data : [{"owner":{"face":"http://i1.hdslb.com/bfs/face/588fbe4931923cd26484126e00bf4c1b7f82eb96.jpg","mid":11485536,"name":"不给摘的小橙花"},"cover":{"src":"http://i0.hdslb.com/bfs/live/5860d002d07186d2c70ea11e1f97aa0d2cf4ce34.jpg","height":180,"width":320},"title":"嘿嘿嘿！","room_id":44458,"online":7112,"playurl":"http://live-play.acgvideo.com/live/116/live_11485536_8989799.flv?wsSecret=c61c1355f80775325a5a529d4e3faf8d&wsTime=57e3a2ce","accept_quality":"4","broadcast_type":0,"area":"御宅文化","area_id":2}]
     */

    private int code;
    private String message;
    /**
     * owner : {"face":"http://i1.hdslb.com/bfs/face/588fbe4931923cd26484126e00bf4c1b7f82eb96.jpg","mid":11485536,"name":"不给摘的小橙花"}
     * cover : {"src":"http://i0.hdslb.com/bfs/live/5860d002d07186d2c70ea11e1f97aa0d2cf4ce34.jpg","height":180,"width":320}
     * title : 嘿嘿嘿！
     * room_id : 44458
     * online : 7112
     * playurl : http://live-play.acgvideo.com/live/116/live_11485536_8989799.flv?wsSecret=c61c1355f80775325a5a529d4e3faf8d&wsTime=57e3a2ce
     * accept_quality : 4
     * broadcast_type : 0
     * area : 御宅文化
     * area_id : 2
     */

    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * face : http://i1.hdslb.com/bfs/face/588fbe4931923cd26484126e00bf4c1b7f82eb96.jpg
         * mid : 11485536
         * name : 不给摘的小橙花
         */

        private OwnerBean owner;
        /**
         * src : http://i0.hdslb.com/bfs/live/5860d002d07186d2c70ea11e1f97aa0d2cf4ce34.jpg
         * height : 180
         * width : 320
         */

        private CoverBean cover;
        private String title;
        private int room_id;
        private int online;
        private String playurl;
        private String accept_quality;
        private int broadcast_type;
        private String area;
        private int area_id;

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
