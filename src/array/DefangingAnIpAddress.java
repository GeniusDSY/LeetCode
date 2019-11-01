package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :DengSiYuan
 * @date :2019/11/1 19:35
 * @desc : 1108.IP地址无效化
 * 【题目】
 *      给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 *      所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 * 【示例】
 *      示例 1：
 *          输入：address = "1.1.1.1"
 *          输出："1[.]1[.]1[.]1"
 *      示例 2：
 *          输入：address = "255.100.50.0"
 *          输出："255[.]100[.]50[.]0"
 * 【提示】
 *      给出的 address 是一个有效的 IPv4 地址
 **/
public class DefangingAnIpAddress {

    public String defangIPaddr1(String address) {
        return address.replace(".","[.]");
    }

    public String defangIPaddr2(String address) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if(address.charAt(i) == '.'){
                sb.append("[.]");
                continue;
            }
            sb.append(address.charAt(i));
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        DefangingAnIpAddress anIpAddress = new DefangingAnIpAddress();
        System.out.println(anIpAddress.defangIPaddr1("172.22.4.2"));
    }

}
