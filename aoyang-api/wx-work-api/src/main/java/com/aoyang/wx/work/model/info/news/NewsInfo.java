package com.aoyang.wx.work.model.info.news;

import com.aoyang.wx.work.model.info.Base;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @ClassName : NewsInfo
 * @Description : 图文消息
 *
 * touser	否	成员ID列表（消息接收者，多个接收者用‘|’分隔，最多支持1000个）。特殊情况：指定为@all，则向关注该企业应用的全部成员发送
 * toparty	否	部门ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数
 * totag	否	标签ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数
 * msgtype	是	消息类型，此时固定为：news
 * agentid	是	企业应用的id，整型。企业内部开发，可在应用的设置页面查看；第三方服务商，可通过接口 获取企业授权信息 获取该参数值
 * articles	是	图文消息，一个图文消息支持1到8条图文
 * title	是	标题，不超过128个字节，超过会自动截断（支持id转译）
 * description	否	描述，不超过512个字节，超过会自动截断（支持id转译）
 * url	是	点击后跳转的链接。 最长2048字节，请确保包含了协议头(http/https)
 * picurl	否	图文消息的图片链接，支持JPG、PNG格式，较好的效果为大图 1068*455，小图150*150。
 * enable_id_trans	否	表示是否开启id转译，0表示否，1表示是，默认0
 * enable_duplicate_check	否	表示是否开启重复消息检查，0表示否，1表示是，默认0
 * duplicate_check_interval	否	表示是否重复消息检查的时间间隔，默认1800s，最大不超过4小时
 *
 * {
 *    "touser" : "UserID1|UserID2|UserID3",
 *    "toparty" : "PartyID1 | PartyID2",
 *    "totag" : "TagID1 | TagID2",
 *    "msgtype" : "news",
 *    "agentid" : 1,
 *    "news" : {
 *        "articles" : [
 *            {
 *                "title" : "中秋节礼品领取",
 *                "description" : "今年中秋节公司有豪礼相送",
 *                "url" : "URL",
 *                "picurl" : "http://res.mail.qq.com/node/ww/wwopenmng/images/independent/doc/test_pic_msg1.png"
 *            }
 *                 ]
 *    },
 *    "enable_id_trans": 0,
 *    "enable_duplicate_check": 0,
 *    "duplicate_check_interval": 1800
 * }
 *
 * @Author : GC
 * @Date: 2021-05-19 11:20
 */
@Data
public class NewsInfo extends Base {
    private News news;
    @JsonProperty(value = "agentid")
    private Integer agentId;
}
