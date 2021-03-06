package config;

import java.io.FileWriter;
import java.io.IOException;

/** 
* @author miku
* name：支付宝配置类
* @version v0.0.1
* @date 2021年3月3日 下午11:01:40 
*/
public class AlipayConfig {
	

	// 应用ID
	public static String app_id = "2021000117611546";
	
	// 商户私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCi1NtWo9OxoyIChwmNh/zdkG+5ZeI7/20lUpwxIrrrnIDA+QC4A64pseF0cAjefsaPBta9L+vwE3iWfJufIgsmPzP7ZHg/9EgSkkGnj6Egq3QPgsiVrKj2MZr8rmLnNgP8DBRFHFKpClrDfkJnhGNmFI2lzRPz9g+19I95lf+Bc8Dnxd9o6UdCEOX+hNcK3JMGStsRk0UwMXRJeoH4os4TitTthB7zBYH1etVVwvriwkUZh2QlCRR2r68aIcwg8lfUfzhIC2Od1FPVT6O1CfMhbiirZlSRQlywOxod3ovvwrP/tQ+4GTpKRdD49NQ+8A2B2vNIgBKE3Vkf+eO0IJuxAgMBAAECggEBAJ/QDh5w2FrmY4DbjFKuf03ubtkl1+9O+I7DD61iCtcoWW4MddolMpCVl1OyieHlx3elHKm+GPEeCyKX1h1PSmYVbi10JFmQphQkG/AbFed8n4KBt+C+/23yrc0GUufeqfZ83IAgFjj2grKQfxgeZXhQ/90U9FpizHSnPRH2WDlyDQVFXAPtqtXQSfcQXtZKCVXE9Rrv3oQdyxD8uITzYjrA4NcdOkPXFXHt9uQ4A9+SA1NG2gXHF/tJ8sLjhtZAPiGS6zAf8ICK0Wv2kgBQnfEriK+SnLAYuU1R0YjwQCSsjiunhqQM5HfUFRRJGEWbwwbmr6uDrBnvF2T6rP4IfUkCgYEA9TT7E552WLYfx/4P5G7imViuVn5k4XV+HDCITSniT5HO7De6MVZGFVjyMlBkNiFAn8hvrPqTnVHhnavEtOkmZybB1Wq5r7+ErWj079upyzW5ij23aAciUsYl2FNB7mSbfJ3BwIa3MsHC2YmD8pSDBTGziUlljpCAy3gL/Jh0CvcCgYEAqf+o7/CWGpNAqXBXL5JpwBzRl2J8fqpz/HWZzhX0Pr0yyuJbNS0MYD7hGbYJpwbxCKTUo8fm+atmadS8RNhkb3Uh5LobmKjMkNUv2KcEvCC+qjZ1vyIXRveQD0persPlm2gSpYEclbHy624kjSLeKCJksgiDzaInhNP+zUZ1/JcCgYBMraquMel0SE+b7LjviDVYGsE5zwCg+GrdSdf1uVlJ5KC+gZa6Au6bklr6nOUZgECDNtylTR6IHajd827p29bkftwybtNuQAevapjdwOVR5JUGw9Hst/5lwAzpnu+JKvDsgTCrkfUL7EeQW05lt0dZgndQQSF++XUtK3ckIFB5dQKBgQCn5nIcSSp3pOhAcUwrGBiKPexj8Em1cPSNbDk0akqJjKQV7erXYl7O0EvS8RAnf5ugRewettlRzg+ghxRLis3np3CKT6Xh6RXiFizjdlIe3NhzlMZGuIz08p29/F33jlPAYdHI1PQ+hTq/fFFtc/qm+RErJW3IM1eEwTzv0Z/GkQKBgAGRHnSkv74k4irk7YUvyN4YsCQmBCsa9bJYCOBuNTQkEGiwraAbiDutMP888bkABgIGEhxWVrALZO57znq7vNfs59wTiespnOKxU6nkj8yUFaguo5056YNvWrUtXqj5eJwIw3vJ7enP4M41xuL0lD1JxLm43i3272ruvl91JYVp";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAno/ROoyW7nOdP0DeHUOV/tUUVFbi7CfcNVermNdNFoTxXPYE7qfobmC9uj/wg1IcZzWaa2wdTz+36vTFFnj+U4SLpjWRYPKyIF4yNiLszPB0DoikCmo0vNW2hZjNIOd34r9rXTTF+GeDmtwm5OdLAJALl3SntgVbP58V0mU+lM2NPBjJXwJd4RNckgl4FTzpMRe23dFGvuQDLJZUgz6W4EYvnVyF+/Huiy3o5WjFHyu7Spds1yvrpGM3GHxCavGmQP59Xb+vXa5OkGeQYhSEJpiyhpSTs/TPc3iBspOSM2KVFOE5yyCToLPGdqTom5uc4gham1hRj7rq+w8K2BujqQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://cywl.free.idcfengye.com/WebShop/alipay";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/WebShop/shopcart/PayLog.html";

	//返回格式
	public static String FORMAT = "json";
	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";



}

