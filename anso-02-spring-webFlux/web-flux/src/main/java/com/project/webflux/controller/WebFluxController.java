package com.project.webflux.controller;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSONObject;
import com.alibaba.excel.EasyExcel;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.io.File;
import java.util.*;

/**
 * @Package: com.example.springbootwebFlux.controller
 * @Description： WebFluxController
 * @Author: zdy AX1053
 * @Date: Created in 2022/7/5 17:51
 * @Company: ANSO
 * @Copyright: Copyright (c) 2021
 * @Version: 1.2.0
 * @Modified By:
 */
@RestController
@RequestMapping("/flux")
public class WebFluxController {
    @RequestMapping("/greeting")
    public Mono<JSONObject> greeting() {
        return Mono.just(nlp());
    }

    @RequestMapping("/greeting2")
    public Mono<JSONObject> greeting2() {
        return Mono.just(nlp2());
    }

    @RequestMapping("/greeting3")
    public Mono<JSONObject> greeting3() {
        return Mono.just(nlp3());
    }


    private JSONObject nlp() {
        //移除停用词：
        File file = new File("E:\\2项目管理\\202204DMA运营\\昆明金色交响数据(1).xls");
        List<LinkedHashMap<Integer, String>> objectList = EasyExcel.read(file).doReadAllSync();
        JSONObject result = new JSONObject();
        if (CollectionUtil.isNotEmpty(objectList)) {
            //汇总 名词
            Set<String> stringSet = new HashSet<>();
            objectList.stream().forEach(object -> {
                List<Word> words = WordSegmenter.seg(object.get(6));
                //词中包含 栋
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < words.size(); i++) {
                    if (words.get(i).getText().contains("栋") || words.get(i).getText().contains("楼")) {
                        stringBuffer.append(words.get(i - 2).getText());
                        stringBuffer.append(words.get(i - 1).getText());
                        stringBuffer.append(words.get(i).getText());
                        stringSet.add(stringBuffer.toString());
                        stringBuffer = new StringBuffer();
                        break;
                    }
                }
            });
            stringSet.stream().sorted();
            result.putOpt("楼栋列表:", stringSet);
            stringSet.stream().forEach(s -> {
                List<LinkedHashMap> list = new ArrayList<>();

                objectList.stream().forEach(o -> {
                    if (null != o && o.get(6).contains(s)) {
                        list.add(o);
                    }
                });
                result.putOpt("楼栋 【" + s + "】 数据量", list.size());
                result.putOpt("楼栋 【" + s + "]", list);
            });
        }
        return result;
    }

    private JSONObject nlp2() {
        //移除停用词：
        String path = "E:\\2项目管理\\202204DMA运营\\昆明金色交响数据(1).xls";
        File file = new File(path);
        List<LinkedHashMap<Integer, String>> objectList = EasyExcel.read(file).doReadAllSync();
        JSONObject result = new JSONObject();
        if (CollectionUtil.isNotEmpty(objectList)) {
            //汇总 名词
            Set<String> stringSet = new HashSet<>();
            objectList.stream().forEach(object -> {
                List<Word> words = WordSegmenter.seg(object.get(6));
                //词中包含 栋
                StringBuffer stringBuffer = new StringBuffer();
                for (Word word : words) {
                    stringBuffer.append(word.getText());
                    if (word.getText().contains("栋")) {
                        stringSet.add(stringBuffer.toString());
                        stringBuffer = new StringBuffer();
                        break;
                    }
                }
            });
            stringSet.stream().sorted();
            result.putOpt("楼栋列表:", stringSet);
            stringSet.stream().forEach(s -> {
                List<LinkedHashMap> list = new ArrayList<>();

                objectList.stream().forEach(o -> {
                    if (null != o && o.get(6).contains(s)) {
                        list.add(o);
                    }
                });
                result.putOpt("楼栋 【" + s + "】 数据量", list.size());
                result.putOpt("楼栋 【" + s + "]", list);
            });
        }
        return result;
    }


    private JSONObject nlp3() {
        //移除停用词：
        String path = "E:\\project\\JAVA\\anso-work\\anso-02-spring-webFlux\\web-flux\\src\\main\\resources\\昆明金色交响数据(1).xls";
        File file = new File(path);
        List<LinkedHashMap<Integer, String>> objectList = EasyExcel.read(file).doReadAllSync();
        JSONObject result = new JSONObject();
        if (CollectionUtil.isNotEmpty(objectList)) {
            //汇总 名词
            Set<String> stringSet = new HashSet<>();
            objectList.stream().forEach(object -> {
                List<Word> words = WordSegmenter.seg(object.get(6));
                //词中包含 栋
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < words.size(); i++) {
                    if (words.get(i).getText().contains("栋") || words.get(i).getText().contains("楼")) {
                        stringBuffer.append(words.get(i - 3).getText());
                        stringBuffer.append(words.get(i - 2).getText());
                        stringBuffer.append(words.get(i - 1).getText());
                        stringBuffer.append(words.get(i).getText());
                        stringSet.add(stringBuffer.toString());
                        stringBuffer = new StringBuffer();
                        break;
                    }
                }
            });
            stringSet.stream().sorted();
            result.putOpt("楼栋列表:", stringSet);
            stringSet.stream().forEach(s -> {
                List<LinkedHashMap> list = new ArrayList<>();

                objectList.stream().forEach(o -> {
                    if (null != o && o.get(6).contains(s)) {
                        list.add(o);
                    }
                });
                result.putOpt("楼栋 【" + s + "】 数据量", list.size());
                result.putOpt("楼栋 【" + s + "]", list);
            });
        }
        return result;
    }

}
