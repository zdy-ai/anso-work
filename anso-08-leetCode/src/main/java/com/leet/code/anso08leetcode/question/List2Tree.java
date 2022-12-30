package com.leet.code.anso08leetcode.question;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.core.util.ReflectUtil;
import org.assertj.core.util.Lists;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StopWatch;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Package: com.leet.code.anso08leetcode.question
 * @Description： TODO
 * @Author: zdy AX1053
 * @Date: Created in 2022/12/29 17:35
 * @Company: ANSO
 * @Copyright: Copyright (c) 2021
 * @Version: 1.2.0
 * @Modified By:
 */
public class List2Tree {

    public static void main(String[] args) {
        List<Org> orgs = new ArrayList<>();
        orgs.add(Org.builder().id(1L).name("name1").parentId(0L).orgSort(1).build());
        orgs.add(Org.builder().id(1L).name("name10").parentId(0L).orgSort(2).build());
        orgs.add(Org.builder().id(2L).name("name2").parentId(1L).orgSort(3).build());
        orgs.add(Org.builder().id(3L).name("name3").parentId(1L).orgSort(4).build());
        orgs.add(Org.builder().id(4L).name("name4").parentId(2L).orgSort(5).build());
        orgs.add(Org.builder().id(5L).name("name5").parentId(2L).orgSort(6).build());
        orgs.add(Org.builder().id(6L).name("name6").parentId(3L).orgSort(7).build());
        orgs.add(Org.builder().id(7L).name("name7").parentId(3L).orgSort(8).build());
        orgs.add(Org.builder().id(8L).name("name8").parentId(6L).orgSort(9).build());
        orgs.add(Org.builder().id(9L).name("name9").parentId(6L).orgSort(10).build());

        StopWatch stopWatch = new StopWatch("List转Tree");
        for (int i = 0; i < 10; i++) {
            stopWatch.start("使用堆栈进行排序" + i);
//        stopWatch.start("使用堆栈进行排序");
        Deque<Org> deque = new ArrayDeque<>();
        List<Org> result = orgs.stream()
                .filter(orgInfoVO -> orgInfoVO.getParentId().equals(0L))
                .collect(Collectors.toList());
        deque.addAll(result);
        while (!deque.isEmpty()) {
            Org vo = deque.pop();
            List<Org> children = orgs.stream()
                    .filter(orgInfoVO -> vo.getId().equals(orgInfoVO.getParentId()))
                    .collect(Collectors.toList());
            vo.setChildren(children);
            if (!CollectionUtils.isEmpty(children)) {
                deque.addAll(children);
            }
        }
        stopWatch.stop();
//            System.out.println(result);
        }

        for (int i = 0; i < 10; i++) {
            stopWatch.start("for循环" + i);
//        stopWatch.start("for循环");
        List<Org> targetList = Lists.newArrayList();
        Map<Long, List<Org>> orgInfoVoMap = orgs.stream().collect(Collectors.groupingBy(Org::getParentId));
        for (Org orgInfoVO : orgs) {
            if (orgInfoVO.getParentId() == 0L) {
                targetList.add(orgInfoVO);
            }
            Long id = orgInfoVO.getId();
            List<Org> subOrgInfoVOList = orgInfoVoMap.getOrDefault(id, null);
            if (!CollectionUtils.isEmpty(subOrgInfoVOList)) {
                subOrgInfoVOList = subOrgInfoVOList.stream().sorted(Comparator.nullsFirst(Comparator.comparing(Org::getOrgSort))).collect(Collectors.toList());
                List<Org> children = orgInfoVO.getChildren() == null ? Lists.newArrayList() : orgInfoVO.getChildren();
                children.addAll(subOrgInfoVOList);
                orgInfoVO.setChildren(children);
            }
        }
        stopWatch.stop();
//            System.out.println(targetList);
        }


//        stopWatch.start("组装树结构");
//        //组装树结构
//        TreeNodeConfig config = new TreeNodeConfig();
//        config.setWeightKey("orgSort");
//        List<Tree<Long>> list = TreeUtil.build(orgs, 0L, config, (object, tree) -> {
//            Field[] fields = ReflectUtil.getFieldsDirectly(object.getClass(), true);
//            for (Field field : fields) {
//                String fieldName = field.getName();
//                Object fieldValue = ReflectUtil.getFieldValue(object, field);
//                tree.putExtra(fieldName, fieldValue);
//            }
//        });
//        stopWatch.stop();
//        System.out.println(list);
        for (int i = 0; i < 10; i++) {
            stopWatch.start("使用map" + i);
            // 将集合转为map结构，key为parentId，value为其对应的list集合
            Map<Long, List<Org>> menuMap = orgs.stream()
                    .collect(Collectors.groupingBy(Org::getParentId));

            // 遍历集合，设置其子节点
            for (Org nextRouteVO : orgs) {
                if (menuMap.containsKey(nextRouteVO.getId())) {
                    nextRouteVO.setChildren(menuMap.get(nextRouteVO.getId()));
                } else {
                    nextRouteVO.setChildren(new ArrayList<>());
                }
            }

            // 返回根节点的集合
            List<Org> orgs1 = orgs.stream()
                    .filter(nextRouteVO -> nextRouteVO.getParentId().equals(0L))
                    .collect(Collectors.toList());
            stopWatch.stop();
//            System.out.println(orgs1);
        }

//40486
//        stopWatch.start("使用递归");
//        List<Org> orgs2 = recursionNextRoute(0L, orgs);
//        stopWatch.stop();
//        System.out.println(orgs2);

        System.out.println("统计" + stopWatch.prettyPrint());
    }

    private static List<Org> recursionNextRoute(Long parentId, List<Org> orgs) {
        List<Org> list = new ArrayList<>();

        Optional.ofNullable(orgs).ifPresent(l -> orgs.stream()
                .filter(menu -> menu.getParentId().equals(parentId))
                .forEach(menu -> {
                    // 递归获取子节点
                    List<Org> children = recursionNextRoute(menu.getId(), orgs);
                    menu.setChildren(children);
                    list.add(menu);
                }));
        return list;
    }
}
