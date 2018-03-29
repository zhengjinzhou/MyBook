package zhou.com.mybook.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhou on 2018/3/21.
 */

public class CategoryList implements Serializable{

    /**
     * male : [{"name":"玄幻","bookCount":512424,"monthlyCount":21385,"icon":"/icon/玄幻_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1228859%2F_1228859_441552.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F891697%2F_891697_378164.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F41584%2F_41584_123902.jpg%2F"]},{"name":"奇幻","bookCount":49462,"monthlyCount":2077,"icon":"/icon/奇幻_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1130743%2F_1130743_505316.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1506906%2F_1506906_290408.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F713823%2F_713823_841716.jpg%2F"]},{"name":"武侠","bookCount":42554,"monthlyCount":1615,"icon":"/icon/武侠_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F682805%2F_682805_516722.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2219099%2F2219099_923da06a1a3e4d3ebd775e6264b18c59.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2194747%2F2194747_cbb7d4e028cb467e9fdd290a92e0a259.jpg%2F"]},{"name":"仙侠","bookCount":137472,"monthlyCount":7467,"icon":"/icon/仙侠_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1188355%2F_1188355_363695.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F682770%2F682770_abddc02117024aacb4ae3299cab3eb95.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1127281%2F_1127281_685974.jpg%2F"]},{"name":"都市","bookCount":359369,"monthlyCount":14158,"icon":"/icon/都市_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F857368%2F857368_c92c5211a6504e0889fb1c09dcf4ce06.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F683354%2F_683354_716237.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2078208%2F2078208_b5931e0074c542608ef38c2ba0d961d7.jpg%2F"]},{"name":"职场","bookCount":16418,"monthlyCount":833,"icon":"/icon/职场_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2080563%2F2080563_7ff8c11c387b4517b57a311e57bd5407.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1159594%2F_1159594_169195.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1466377%2F_1466377_886541.jpg%2F"]},{"name":"历史","bookCount":71802,"monthlyCount":2855,"icon":"/icon/历史_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1314571%2F_1314571_289295.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1127342%2F_1127342_276630.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F634346%2F_634346_106373.jpg%2F"]},{"name":"军事","bookCount":15340,"monthlyCount":1292,"icon":"/icon/军事_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2194052%2F2194052_5831cda813fb4c758b90f2fc3ac20227.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1367432%2F_1367432_658946.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1154847%2F_1154847_731980.jpg%2F"]},{"name":"游戏","bookCount":81561,"monthlyCount":2382,"icon":"/icon/游戏_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2044454%2F2044454_75533bb1fdd94ea199c25abb2cd65985.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2208312%2F2208312_8e68612833784d6ca6e0b1875084dec2.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2201513%2F2201513_d5239e575a1d44fd92ea97832f97f73a.jpg%2F"]},{"name":"竞技","bookCount":5848,"monthlyCount":361,"icon":"/icon/竞技_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1478042%2F_1478042_857319.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2096246%2F2096246_4e55a0850e6b46b385ec4b302b82b8fa.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1312764%2F_1312764_438601.jpg%2F"]},{"name":"科幻","bookCount":119084,"monthlyCount":2574,"icon":"/icon/科幻_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2185681%2F2185681_40c9ddb71b0048c394cf58df0dfca732.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2162481%2F2162481_94f413b58701406bbcb49d38bcd45e15.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F42167%2F_42167_949054.jpg%2F"]},{"name":"灵异","bookCount":41531,"monthlyCount":4489,"icon":"/icon/灵异_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2190222%2F2190222_e20dc28831714bf8a67401e414f8d425.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2225869%2F2225869_20e952434e3d4ba2a3db22a71837d8b5.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1496497%2F_1496497_188071.jpg%2F"]},{"name":"同人","bookCount":40325,"monthlyCount":295,"icon":"/icon/同人_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1518279%2F_1518279_096405.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2213453%2F2213453_e5bfe0f131d446069e536497d896fb85.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2204307%2F2204307_496fa1275ce84e6daa62165edb934bf0.jpg%2F"]},{"name":"轻小说","bookCount":4995,"monthlyCount":335,"icon":"/icon/轻小说_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1494992%2F_1494992_119116.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2243879%2F2243879_94ff33910679471bb8060ad1c54663c6.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2206001%2F2206001_c7c857a454ec4a4b9ae4b5637f863a7e.jpg%2F"]}]
     * female : [{"name":"古代言情","bookCount":472683,"monthlyCount":11852,"icon":"/icon/古代言情_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2143521%2F2143521_083a5ac565cd458f9b84fcb88adf33fb.png%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1362823%2F_1362823_256513.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2180518%2F2180518_27bc24dd12f04fde9a7aa05434049afd.jpg%2F"]},{"name":"现代言情","bookCount":605571,"monthlyCount":18013,"icon":"/icon/现代言情_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F84550%2F84550_8767d46cd8e44064b51b4efd6ae08c2e.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1367041%2F_1367041_461002.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2125301%2F2125301_f6c8b69104934f01a3203a28b246270e.jpg%2F"]},{"name":"青春校园","bookCount":116484,"monthlyCount":2887,"icon":"/icon/青春校园_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1200747%2F1200747_7f02bffa6b0b47889293ebc613d883ff.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1131279%2F_1131279_024701.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2080506%2F2080506_7fdff4bf4b7640afb3c9e5d743d441cd.jpg%2F"]},{"name":"纯爱","bookCount":133611,"monthlyCount":1441,"icon":"/icon/耽美_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1174497%2F_1174497_618871.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2180227%2F2180227_4574b4314f5a48de970ecbcdd0ead95d.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F67324%2F_67324_158064.jpg%2F"]},{"name":"玄幻奇幻","bookCount":130498,"monthlyCount":663,"icon":"/icon/玄幻奇幻_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F42127%2F42127_765ca130f8d340558a87e2d5f1fc1301.png%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2045755%2F2045755_7a7a750f61f64703977e72cca5c8dc90.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1527442%2F_1527442_313048.jpg%2F"]},{"name":"武侠仙侠","bookCount":64549,"monthlyCount":1588,"icon":"/icon/武侠仙侠_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2143666%2F2143666_9bea767b345e4bf793060937af6a4c5f.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F44329%2F_44329_593234.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1187773%2F_1187773_659828.jpg%2F"]},{"name":"科幻","bookCount":10525,"monthlyCount":475,"icon":"/icon/科幻_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2175669%2F2175669_f7a71b481eb647d3978b8cceb1fe52e1.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2020880%2F2020880_9aa14120a38e4e34bfa1cf51920c17a1.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2084192%2F2084192_01a08acd65af40d0adabcf78d8ed4764.jpg%2F"]},{"name":"游戏竞技","bookCount":6636,"monthlyCount":139,"icon":"/icon/游戏竞技_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F42014%2F_42014_918695.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F74250%2F74250_eb225d07b43b48a38623bf7817e0fde7.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2079818%2F2079818_0ab43df186ae4a00a6cc20dab422b4a0.jpg%2F"]},{"name":"悬疑灵异","bookCount":14000,"monthlyCount":720,"icon":"/icon/悬疑灵异_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1457026%2F_1457026_237840.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1187707%2F_1187707_130756.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1267576%2F_1267576_273302.jpg%2F"]},{"name":"同人","bookCount":118610,"monthlyCount":204,"icon":"/icon/同人_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2182242%2F2182242_418232fc41054c1f91f0a36b8aae6f2a.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2182241%2F2182241_252c8b2f0302468abe96aabde683c640.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2179097%2F2179097_edeb5dc37ec1464e8f3fd56ca726e989.jpg%2F"]},{"name":"女尊","bookCount":20792,"monthlyCount":1084,"icon":"/icon/女尊_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F851414%2F_851414_740896.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F857217%2F857217_34eea5a4425d4437896b19d2774ac5da.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2148904%2F2148904_418eb43d34aa479087d8092720446b2b.jpg%2F"]},{"name":"莉莉","bookCount":25943,"monthlyCount":81,"icon":"/icon/百合_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2190309%2F2190309_78c7346877924b62a260fb1fc09228fd.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2190667%2F2190667_0bfcccfc6c264980aada08c1b36762b6.jpg%2F","/agent/http://img17.poco.cn/mypoco/myphoto/20150611/19/17826882420150611192656012.jpg"]}]
     * picture : [{"name":"热血","bookCount":665,"monthlyCount":103,"icon":"/icon/热血_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F194607%2F194607_72270909242745fd83336e39b251e874.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F182350%2F41eb45e4c2e740a69140be391ad7cb4a.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F173732%2F173732_2b94610f93794efaa63fc68b999ac8d0.jpg%2F"]},{"name":"魔幻","bookCount":504,"monthlyCount":118,"icon":"/icon/魔幻_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F168407%2F168407_d1492388cfdc4f4c974bc503939edff0.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F184162%2F184162_33ed57ff61704076bfd487393623103b.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F166465%2F166465_5af02a7135da402abd9d4138b3bfa42f.jpg%2F"]},{"name":"科幻","bookCount":78,"monthlyCount":11,"icon":"/icon/科幻_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F195759%2F195759_26346998ba4b48e38127aa7d44d96586.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F176272%2F176272_c231f6803b0040a48dda7b21a73e7629.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F193264%2F193264_4a2059af7c2348f1926a90046a1493b8.jpg%2F"]},{"name":"恋爱","bookCount":1286,"monthlyCount":226,"icon":"/icon/恋爱_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F187006%2F187006_820e3dec9c084d869f353bf3c6ccfca7.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2014698%2F2014698_fcd7ca03f94642f9a8aa14dc4a5a37b1.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F181650%2F181650_1a34cab7f2c84771a36db383d4110086.jpg%2F"]},{"name":"搞笑","bookCount":1711,"monthlyCount":157,"icon":"/icon/搞笑_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2185190%2F2185190_02b51397c05d48b1baefd51fcaaa6023.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2021717%2F2021717_b9c8d4bfbcdb4c649b7cce9478efbb94.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2041415%2F2041415_d145522d952b4c3cabb438c378b8dc56.jpg%2F"]},{"name":"悬疑","bookCount":328,"monthlyCount":72,"icon":"/icon/悬疑_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F191033%2F191033_496b5f1507b9410e8d05e8c2edaa3b49.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F180667%2F180667_71d180052a4341558cad79e1d67d7be9.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2077114%2F2077114_8821d8587b3d42d3a4d87ebc3209a692.jpg%2F"]},{"name":"少儿","bookCount":3334,"monthlyCount":1507,"icon":"/icon/少儿_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F196173%2F4feec11cc5374667b58c4d2ea4cc095a.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F189090%2F7839c7161b544d40b492627281e70492.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2203214%2F2203214_f6c5adc865ae445382c64402e3abbe18.jpg%2F"]}]
     * press : [{"name":"传记名著","bookCount":4835,"monthlyCount":1496,"icon":"/icon/传记名著_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F30771%2F_30771_973261.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F42798%2F_42798_755444.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F53598%2F_53598_122310.jpg%2F"]},{"name":"出版小说","bookCount":13118,"monthlyCount":3427,"icon":"/icon/出版小说_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2202149%2F2202149_4c108c40f4264a4089e977b1830c5a40.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F41574%2F_41574_081848.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2137847%2F2137847_c14e06a41f7c458a932c29c61d810fd5.jpg%2F"]},{"name":"人文社科","bookCount":62406,"monthlyCount":13628,"icon":"/icon/人文社科_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2053642%2F2053642_1675460130664e3295282eeea531f0b9.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1175601%2F_1175601_339438.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2091345%2F2091345_default_cover.png%2F"]},{"name":"生活时尚","bookCount":2894,"monthlyCount":537,"icon":"/icon/生活时尚_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2063886%2F2063886_ee5c3b3bb2cc4332a319c05adea1753f.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2186830%2F2186830_52ad3a388ff14adca060f232526d4227.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1529069%2F_1529069_328412.jpg%2F"]},{"name":"经管理财","bookCount":5442,"monthlyCount":1734,"icon":"/icon/经管理财_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F19087%2F_19087_732103.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F34695%2F_34695_083305.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2111603%2F2111603_default_cover.png%2F"]},{"name":"青春言情","bookCount":12076,"monthlyCount":2047,"icon":"/icon/青春言情_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1419744%2F_1419744_418690.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2144003%2F2144003_0ce9ce7d451c467990617050122914c7.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F48119%2F_48119_388161.jpg%2F"]},{"name":"外文原版","bookCount":1345,"monthlyCount":407,"icon":"/icon/外文原版_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2022998%2F2022998_17ff5053c0344d5db5c892fbd4d9dde6.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1418090%2F_1418090_647350.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2089527%2F2089527_72f22f8f24c24dbe84301be12c75f8f4.jpg%2F"]},{"name":"政治军事","bookCount":728,"monthlyCount":259,"icon":"/icon/政治军事_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F685334%2F_685334_174607.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2043686%2F2043686_f6d7f4a2769245648754943037d2e9aa.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F404822%2F404822_c49ffde621ee45d09a2c2e7e2d31dcd7.jpg%2F"]},{"name":"成功励志","bookCount":10864,"monthlyCount":2735,"icon":"/icon/成功励志_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F577424%2F_577424_901386.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1522490%2F_1522490_091877.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F858627%2F_858627_838818.jpg%2F"]},{"name":"育儿健康","bookCount":11491,"monthlyCount":2728,"icon":"/icon/育儿健康_.png","bookCover":["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2154248%2F2154248_51181588edee4bef8d794a534442fc2d.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1371877%2F_1371877_559378.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2077896%2F2077896_9d45c4efb5734688a31efd793c5cdeb1.jpg%2F"]}]
     * ok : true
     */

    private boolean ok;
    private List<MaleBean> male;
    private List<FemaleBean> female;
    private List<PictureBean> picture;
    private List<PressBean> press;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public List<MaleBean> getMale() {
        return male;
    }

    public void setMale(List<MaleBean> male) {
        this.male = male;
    }

    public List<FemaleBean> getFemale() {
        return female;
    }

    public void setFemale(List<FemaleBean> female) {
        this.female = female;
    }

    public List<PictureBean> getPicture() {
        return picture;
    }

    public void setPicture(List<PictureBean> picture) {
        this.picture = picture;
    }

    public List<PressBean> getPress() {
        return press;
    }

    public void setPress(List<PressBean> press) {
        this.press = press;
    }

    public static class MaleBean {
        /**
         * name : 玄幻
         * bookCount : 512424
         * monthlyCount : 21385
         * icon : /icon/玄幻_.png
         * bookCover : ["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1228859%2F_1228859_441552.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F891697%2F_891697_378164.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F41584%2F_41584_123902.jpg%2F"]
         */

        private String name;
        private int bookCount;
        private int monthlyCount;
        private String icon;
        private List<String> bookCover;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getBookCount() {
            return bookCount;
        }

        public void setBookCount(int bookCount) {
            this.bookCount = bookCount;
        }

        public int getMonthlyCount() {
            return monthlyCount;
        }

        public void setMonthlyCount(int monthlyCount) {
            this.monthlyCount = monthlyCount;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public List<String> getBookCover() {
            return bookCover;
        }

        public void setBookCover(List<String> bookCover) {
            this.bookCover = bookCover;
        }

        @Override
        public String toString() {
            return "MaleBean{" +
                    "name='" + name + '\'' +
                    ", bookCount=" + bookCount +
                    ", monthlyCount=" + monthlyCount +
                    ", icon='" + icon + '\'' +
                    ", bookCover=" + bookCover +
                    '}';
        }
    }

    public static class FemaleBean {
        /**
         * name : 古代言情
         * bookCount : 472683
         * monthlyCount : 11852
         * icon : /icon/古代言情_.png
         * bookCover : ["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2143521%2F2143521_083a5ac565cd458f9b84fcb88adf33fb.png%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F1362823%2F_1362823_256513.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F2180518%2F2180518_27bc24dd12f04fde9a7aa05434049afd.jpg%2F"]
         */

        private String name;
        private int bookCount;
        private int monthlyCount;
        private String icon;
        private List<String> bookCover;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getBookCount() {
            return bookCount;
        }

        public void setBookCount(int bookCount) {
            this.bookCount = bookCount;
        }

        public int getMonthlyCount() {
            return monthlyCount;
        }

        public void setMonthlyCount(int monthlyCount) {
            this.monthlyCount = monthlyCount;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public List<String> getBookCover() {
            return bookCover;
        }

        public void setBookCover(List<String> bookCover) {
            this.bookCover = bookCover;
        }

        @Override
        public String toString() {
            return "FemaleBean{" +
                    "name='" + name + '\'' +
                    ", bookCount=" + bookCount +
                    ", monthlyCount=" + monthlyCount +
                    ", icon='" + icon + '\'' +
                    ", bookCover=" + bookCover +
                    '}';
        }
    }

    public static class PictureBean {
        /**
         * name : 热血
         * bookCount : 665
         * monthlyCount : 103
         * icon : /icon/热血_.png
         * bookCover : ["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F194607%2F194607_72270909242745fd83336e39b251e874.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F182350%2F41eb45e4c2e740a69140be391ad7cb4a.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F173732%2F173732_2b94610f93794efaa63fc68b999ac8d0.jpg%2F"]
         */

        private String name;
        private int bookCount;
        private int monthlyCount;
        private String icon;
        private List<String> bookCover;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getBookCount() {
            return bookCount;
        }

        public void setBookCount(int bookCount) {
            this.bookCount = bookCount;
        }

        public int getMonthlyCount() {
            return monthlyCount;
        }

        public void setMonthlyCount(int monthlyCount) {
            this.monthlyCount = monthlyCount;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public List<String> getBookCover() {
            return bookCover;
        }

        public void setBookCover(List<String> bookCover) {
            this.bookCover = bookCover;
        }

        @Override
        public String toString() {
            return "PictureBean{" +
                    "name='" + name + '\'' +
                    ", bookCount=" + bookCount +
                    ", monthlyCount=" + monthlyCount +
                    ", icon='" + icon + '\'' +
                    ", bookCover=" + bookCover +
                    '}';
        }
    }

    public static class PressBean {
        /**
         * name : 传记名著
         * bookCount : 4835
         * monthlyCount : 1496
         * icon : /icon/传记名著_.png
         * bookCover : ["/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F30771%2F_30771_973261.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F42798%2F_42798_755444.jpg%2F","/agent/http%3A%2F%2Fimg.1391.com%2Fapi%2Fv1%2Fbookcenter%2Fcover%2F1%2F53598%2F_53598_122310.jpg%2F"]
         */

        private String name;
        private int bookCount;
        private int monthlyCount;
        private String icon;
        private List<String> bookCover;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getBookCount() {
            return bookCount;
        }

        public void setBookCount(int bookCount) {
            this.bookCount = bookCount;
        }

        public int getMonthlyCount() {
            return monthlyCount;
        }

        public void setMonthlyCount(int monthlyCount) {
            this.monthlyCount = monthlyCount;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public List<String> getBookCover() {
            return bookCover;
        }

        public void setBookCover(List<String> bookCover) {
            this.bookCover = bookCover;
        }

        @Override
        public String toString() {
            return "PressBean{" +
                    "name='" + name + '\'' +
                    ", bookCount=" + bookCount +
                    ", monthlyCount=" + monthlyCount +
                    ", icon='" + icon + '\'' +
                    ", bookCover=" + bookCover +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "CategoryList{" +
                "ok=" + ok +
                ", male=" + male +
                ", female=" + female +
                ", picture=" + picture +
                ", press=" + press +
                '}';
    }
}
