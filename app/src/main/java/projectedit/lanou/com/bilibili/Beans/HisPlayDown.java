package projectedit.lanou.com.bilibili.Beans;

import java.util.List;

/**
 * Created by lanouhn on 16/10/27.
 */
public class HisPlayDown {

    /**
     * code : 0
     * message : success
     * result : [{"cover":"http://i0.hdslb.com/bfs/bangumi/51791263b05b9ce4cf49ee30fdb47a8144f04104.jpg","cursor":1477476000358,"desc":"朱丽叶张开了女神的翅膀 罗密欧抱紧了朱丽叶","id":2112,"is_new":1,"link":"http://bangumi.bilibili.com/anime/4779","onDt":"2016-10-26 18:00:00","title":"罗密欧与朱丽叶"}]
     */

    private int code;
    private String message;
    /**
     * cover : http://i0.hdslb.com/bfs/bangumi/51791263b05b9ce4cf49ee30fdb47a8144f04104.jpg
     * cursor : 1477476000358
     * desc : 朱丽叶张开了女神的翅膀 罗密欧抱紧了朱丽叶
     * id : 2112
     * is_new : 1
     * link : http://bangumi.bilibili.com/anime/4779
     * onDt : 2016-10-26 18:00:00
     * title : 罗密欧与朱丽叶
     */

    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        private String cover;
        private long cursor;
        private String desc;
        private int id;
        private int is_new;
        private String link;
        private String onDt;
        private String title;

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public long getCursor() {
            return cursor;
        }

        public void setCursor(long cursor) {
            this.cursor = cursor;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIs_new() {
            return is_new;
        }

        public void setIs_new(int is_new) {
            this.is_new = is_new;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getOnDt() {
            return onDt;
        }

        public void setOnDt(String onDt) {
            this.onDt = onDt;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
