package com.mofancn.ruu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mofancn.common.utils.HttpClientUtil;
import com.mofancn.common.utils.JsonUtils;
import com.mofancn.common.utils.MofancnResult;

import net.sf.json.JSONObject;

/**
 * 
  * @ClassName: UserController  
  * @Description: 用户接口  
  * @author dave.hu  
  * @date 2018年5月15日  
  *
 */
@Controller
public class UserController {

	@RequestMapping("/user_login")
	public MofancnResult userLogin(@RequestParam(value="code", defaultValue="0") String code){
		String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + "wxb859e7141c297580"
				+ "&secret=" + "207b271a6f96ced5b63186cbebb2a533"
				+ "&code=" + code
				+ "&grant_type=authorization_code";
		
		
		String string = HttpClientUtil.doGet(url, null);
		JSONObject jsonObject = JSONObject.fromObject(string);
		String session_key = jsonObject.getString("session_key");
		String openid = jsonObject.getString("openid");
		String unionid = jsonObject.getString("unionid");
		
		
		//String userInfo = "https://api.weixin.qq.com/sns/userinfo?access_token=" + access_token
		//		+ "&openid=" + openid
		//		+ "&lang=zh_CN";
		
	//	String string2 = HttpClientUtil.doGet(userInfo, null);
	//	JSONObject jsonObject2 = JSONObject.fromObject(string2);
	//	System.out.println(JsonUtils.objectToJson(jsonObject2));
		
		return MofancnResult.ok(JsonUtils.objectToJson(jsonObject));
		
	}
	
}
