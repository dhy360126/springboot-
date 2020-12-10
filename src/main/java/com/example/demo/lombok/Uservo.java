package com.example.demo.lombok;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Setter
@Getter
@Slf4j
public class Uservo {
    private String id;
    private String name;
}
