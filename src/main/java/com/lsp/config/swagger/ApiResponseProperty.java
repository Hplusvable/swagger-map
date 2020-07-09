package com.lsp.config.swagger;

public @interface ApiResponseProperty {

    String name();

    String description() default "";

    String type();

}

