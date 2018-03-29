package zhou.com.mybook.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhou on 2018/3/22.
 */

public class HotWord implements Serializable {

    /**
     * hotWords : ["绝世符神","腹黑boss霸宠：逃妻，吻我","重生之绝世武神","腹黑老公宠小妻","超级纨绔系统","首席老公，强势爱！","回到三国的特种狙击手","聿少的暖婚甜妻","都市渡鬼人","嫡女贵凰：重生毒妃狠绝色","末世重生之至尊冰王","废妃狠彪悍","男人禁地2","完了，少将弯了[星际]","最强修仙系统","玉手遮天：邪王独宠小毒妃","都市之无敌修神","夜行歌 上（精）","透视医圣","夜行歌 下（精）","超级农场系统","罗布泊之咒","绝品败家系统","桃运小神农"]
     * newHotWords : [{"word":"绝世符神","book":"58adcb2d0f1d7c491a5832d3"},{"word":"腹黑boss霸宠：逃妻，吻我","book":"5a0561686f3b859d6064f1b2"},{"word":"重生之绝世武神","book":"5630ebe31623b99e3e7b9527"},{"word":"腹黑老公宠小妻","book":"59fc19132655af4561c37727"},{"word":"超级纨绔系统","book":"5885dd221fdab438035f4b5f"},{"word":"首席老公，强势爱！","book":"59f2e64c4316e6ec60e98011"},{"word":"回到三国的特种狙击手","book":"520e4d21ab42b6971b0003f8"},{"word":"聿少的暖婚甜妻","book":"58871aeb8602d1eb0369dd76"},{"word":"都市渡鬼人","book":"594902514ba7bb4102719da5"},{"word":"嫡女贵凰：重生毒妃狠绝色","book":"585342b84ea58ff50213444b"},{"word":"末世重生之至尊冰王","book":"59bf9cd574afca9d150ab71c"},{"word":"废妃狠彪悍","book":"5a0109e0b9383d4103b13dbe"},{"word":"男人禁地2","book":"5a77b07cde809329a670ca52"},{"word":"完了，少将弯了[星际]","book":"594d3d22d41d929846d2899d"},{"word":"最强修仙系统","book":"5a444b3a4e32b61c4fa19367"},{"word":"玉手遮天：邪王独宠小毒妃","book":"582e96344a5530d52c2d5d9e"},{"word":"都市之无敌修神","book":"59f6001084ff820100075450"},{"word":"夜行歌 上（精）","book":"59d86b9ed1fc1a674ebfbeee"},{"word":"透视医圣","book":"571a00397e740345774a4910"},{"word":"夜行歌 下（精）","book":"59d86b9e8658af264c722539"},{"word":"超级农场系统","book":"59fc19156dfc1700473cb221"},{"word":"罗布泊之咒","book":"5a3c5b7f9303381c02a3a522"},{"word":"绝品败家系统","book":"59f304c7219ee393382aa451"},{"word":"桃运小神农","book":"5a15425343e4dfeb288f76f6"}]
     * ok : true
     */

    private boolean ok;
    private List<String> hotWords;
    private List<NewHotWordsBean> newHotWords;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public List<String> getHotWords() {
        return hotWords;
    }

    public void setHotWords(List<String> hotWords) {
        this.hotWords = hotWords;
    }

    public List<NewHotWordsBean> getNewHotWords() {
        return newHotWords;
    }

    public void setNewHotWords(List<NewHotWordsBean> newHotWords) {
        this.newHotWords = newHotWords;
    }

    public static class NewHotWordsBean {
        /**
         * word : 绝世符神
         * book : 58adcb2d0f1d7c491a5832d3
         */

        private String word;
        private String book;

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public String getBook() {
            return book;
        }

        public void setBook(String book) {
            this.book = book;
        }

        @Override
        public String toString() {
            return "NewHotWordsBean{" +
                    "word='" + word + '\'' +
                    ", book='" + book + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "HotWord{" +
                "ok=" + ok +
                ", hotWords=" + hotWords +
                ", newHotWords=" + newHotWords +
                '}';
    }
}
