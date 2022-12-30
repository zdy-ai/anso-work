package com.leet.code.anso08leetcode.question;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

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
@Builder
@Data
@ToString
public class Org implements Serializable {

    private Long id;
    private Long parentId;
    private String name;
    private Integer orgSort;
    private List<Org> children;
}
