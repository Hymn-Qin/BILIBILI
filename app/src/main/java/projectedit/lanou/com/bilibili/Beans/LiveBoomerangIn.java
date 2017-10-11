package projectedit.lanou.com.bilibili.Beans;

import java.util.List;

/**
 * Created by lanouhn on 16/10/20.
 */
public class LiveBoomerangIn {

    /**
     * code : 0
     * message : ok
     * data : {"banner":[{"title":"bilibili杯守望先锋季前赛总决赛直播预告","img":"http://i0.hdslb.com/bfs/live/78cfb19ede932ef3472604005b36087c13e501c2.png","remark":"bilibili守望先锋季前赛","link":"http://live.bilibili.com/AppBanner/index?id=319"}],"entranceIcons":[{"id":9,"name":"绘画专区","entrance_icon":{"src":"http://static.hdslb.com/live-static/images/mobile/android/big/xhdpi/9_big.png?2016102002","height":"89","width":"89"}}],"partitions":[{"partition":{"id":9,"name":"绘画专区","area":"draw","sub_icon":{"src":"http://static.hdslb.com/live-static/images/mobile/android/small/xhdpi/9.png?2016102002","height":"42","width":"42"},"count":129},"lives":[{"owner":{"face":"http://i0.hdslb.com/bfs/face/a1939a17881a0ab7446530794eba0b0cb562afa2.jpg","mid":332808,"name":"AKI·7"},"cover":{"src":"http://i0.hdslb.com/bfs/live/cc2f2e159dba4dea3003222c02a82f696e28bdc3.jpg","height":180,"width":320},"title":"血族禁域正篇绘制","room_id":1085873,"check_version":0,"online":150,"area":"绘画专区","area_id":9,"playurl":"http://live-play.acgvideo.com/live/631/live_332808_1439965.flv?wsSecret=967a9580a7d5ede023620020fa2580c2&wsTime=57e10d16","accept_quality":"4","broadcast_type":0,"is_tv":0}]}]}
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
         * title : bilibili杯守望先锋季前赛总决赛直播预告
         * img : http://i0.hdslb.com/bfs/live/78cfb19ede932ef3472604005b36087c13e501c2.png
         * remark : bilibili守望先锋季前赛
         * link : http://live.bilibili.com/AppBanner/index?id=319
         */

        private List<BannerBean> banner;
        /**
         * id : 9
         * name : 绘画专区
         * entrance_icon : {"src":"http://static.hdslb.com/live-static/images/mobile/android/big/xhdpi/9_big.png?2016102002","height":"89","width":"89"}
         */

        private List<EntranceIconsBean> entranceIcons;
        /**
         * partition : {"id":9,"name":"绘画专区","area":"draw","sub_icon":{"src":"http://static.hdslb.com/live-static/images/mobile/android/small/xhdpi/9.png?2016102002","height":"42","width":"42"},"count":129}
         * lives : [{"owner":{"face":"http://i0.hdslb.com/bfs/face/a1939a17881a0ab7446530794eba0b0cb562afa2.jpg","mid":332808,"name":"AKI·7"},"cover":{"src":"http://i0.hdslb.com/bfs/live/cc2f2e159dba4dea3003222c02a82f696e28bdc3.jpg","height":180,"width":320},"title":"血族禁域正篇绘制","room_id":1085873,"check_version":0,"online":150,"area":"绘画专区","area_id":9,"playurl":"http://live-play.acgvideo.com/live/631/live_332808_1439965.flv?wsSecret=967a9580a7d5ede023620020fa2580c2&wsTime=57e10d16","accept_quality":"4","broadcast_type":0,"is_tv":0}]
         */

        private List<PartitionsBean> partitions;

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public List<EntranceIconsBean> getEntranceIcons() {
            return entranceIcons;
        }

        public void setEntranceIcons(List<EntranceIconsBean> entranceIcons) {
            this.entranceIcons = entranceIcons;
        }

        public List<PartitionsBean> getPartitions() {
            return partitions;
        }

        public void setPartitions(List<PartitionsBean> partitions) {
            this.partitions = partitions;
        }

        public static class BannerBean {
            private String title;
            private String img;
            private String remark;
            private String link;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }
        }

        public static class EntranceIconsBean {
            private int id;
            private String name;
            /**
             * src : http://static.hdslb.com/live-static/images/mobile/android/big/xhdpi/9_big.png?2016102002
             * height : 89
             * width : 89
             */

            private EntranceIconBean entrance_icon;

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

            public EntranceIconBean getEntrance_icon() {
                return entrance_icon;
            }

            public void setEntrance_icon(EntranceIconBean entrance_icon) {
                this.entrance_icon = entrance_icon;
            }

            public static class EntranceIconBean {
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

        public static class PartitionsBean {
            /**
             * id : 9
             * name : 绘画专区
             * area : draw
             * sub_icon : {"src":"http://static.hdslb.com/live-static/images/mobile/android/small/xhdpi/9.png?2016102002","height":"42","width":"42"}
             * count : 129
             */

            private PartitionBean partition;
            /**
             * owner : {"face":"http://i0.hdslb.com/bfs/face/a1939a17881a0ab7446530794eba0b0cb562afa2.jpg","mid":332808,"name":"AKI·7"}
             * cover : {"src":"http://i0.hdslb.com/bfs/live/cc2f2e159dba4dea3003222c02a82f696e28bdc3.jpg","height":180,"width":320}
             * title : 血族禁域正篇绘制
             * room_id : 1085873
             * check_version : 0
             * online : 150
             * area : 绘画专区
             * area_id : 9
             * playurl : http://live-play.acgvideo.com/live/631/live_332808_1439965.flv?wsSecret=967a9580a7d5ede023620020fa2580c2&wsTime=57e10d16
             * accept_quality : 4
             * broadcast_type : 0
             * is_tv : 0
             */

            private List<LivesBean> lives;

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

            public static class PartitionBean {
                private int id;
                private String name;
                private String area;
                /**
                 * src : http://static.hdslb.com/live-static/images/mobile/android/small/xhdpi/9.png?2016102002
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
                 * face : http://i0.hdslb.com/bfs/face/a1939a17881a0ab7446530794eba0b0cb562afa2.jpg
                 * mid : 332808
                 * name : AKI·7
                 */

                private OwnerBean owner;
                /**
                 * src : http://i0.hdslb.com/bfs/live/cc2f2e159dba4dea3003222c02a82f696e28bdc3.jpg
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
