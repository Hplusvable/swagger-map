package com.lsp.config.swagger;

import com.lsp.entity.Value2;
import io.swagger.models.Model;

import java.util.HashMap;
import java.util.Map;

public class ModelCache {

    static Map<String, Model> extra_cache = new HashMap<>();

    static Map<String, Value2<String,String[]>> specified_cache = new HashMap<>();

}

