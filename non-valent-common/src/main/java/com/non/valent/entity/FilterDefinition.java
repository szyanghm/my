package com.non.valent.entity;

import lombok.*;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author haimiyang
 * @date:2019/12/24 17:17
 * @version:1.0
 */
@EqualsAndHashCode
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilterDefinition {
    private String name;
    private Map<String, String> args = new LinkedHashMap<>();
}
