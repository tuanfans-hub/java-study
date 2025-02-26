package set_java.set_practice;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Map集合案例-省和市
 * 需求
 * 定义一个Map集合，键用表示省份名称province，值表示市city，但是市会有多个。
 * 添加完毕后，遍历结果格式如下：
 * 江苏省=南京市，扬州市，苏州市，无锡市，常州市
 * 湖北省=武汉市，孝感市，十堰市，宜昌市，鄂州市
 * 河北省=石家庄市，唐山市，邢台市，保定市，张家口市
 * */
public class ProvCityTest {
    @Test
    public void prov_cityMapTest1(){
            Map<String,String[]> prov_cityMap = new HashMap<>();
            prov_cityMap.put("江苏省",new String[]{"南京市","扬州市","苏州市","无锡市","常州市"});
            prov_cityMap.put("湖北省",new String[]{"武汉市","孝感市","十堰市","宜昌市","鄂州市"});
            prov_cityMap.put("河北省",new String[]{"石家庄市","唐山市","邢台市","保定市","张家口市"});

            //Lambda表达式遍历
            prov_cityMap.forEach((prov,city)->{
                StringBuilder cities = new StringBuilder();
                for(int i=0;i<city.length;i++){
                    if(i==city.length-1){
                        cities.append(city[i]);
                    }else{
                        cities.append(city[i]).append(",");
                    }
                }
                System.out.println(prov + " = " + cities);
            });
    }

    @Test
    public void prov_cityMapTest2(){
        Map<String, ArrayList<String>> prov_cityMap = new HashMap<>();
        ArrayList<String> city1 = new ArrayList<>();
        Collections.addAll(city1,"南京市","扬州市","苏州市","无锡市","常州市");
        ArrayList<String> city2 = new ArrayList<>();
        Collections.addAll(city2,"武汉市","孝感市","十堰市","宜昌市","鄂州市");
        ArrayList<String> city3 = new ArrayList<>();
        Collections.addAll(city3,"石家庄市","唐山市","邢台市","保定市","张家口市");
        prov_cityMap.put("江苏省",city1);
        prov_cityMap.put("湖北省",city2);
        prov_cityMap.put("河北省",city3);

        prov_cityMap.forEach((prov,city)->{
            StringJoiner sj = new StringJoiner(","  , "" , "");
            for(String c : city){
                sj.add(c);
            }
            System.out.println(prov + " = " + sj);
        });
    }
}
