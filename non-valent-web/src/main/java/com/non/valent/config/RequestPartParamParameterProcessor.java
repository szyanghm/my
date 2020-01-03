//package com.non.valent.config;
//
//import feign.MethodMetadata;
//import org.springframework.cloud.openfeign.AnnotatedParameterProcessor;
//
//import java.lang.annotation.Annotation;
//import java.lang.reflect.Method;
//
//
///**
// * @author haimiyang
// * @date:2020/1/2 16:07
// * @version:1.0
// */
//public class RequestPartParamParameterProcessor implements AnnotatedParameterProcessor {
//
//
//    @Override
//    public Class<? extends Annotation> getAnnotationType() {
//        return null;
//    }
//
//    @Override
//    public boolean processArgument(AnnotatedParameterContext context, Annotation annotation, Method method) {
//        int parameterIndex = context.getParameterIndex();
//        Class<?> parameterType = method.getParameterTypes()[parameterIndex];
//        MethodMetadata data = context.getMethodMetadata();
//
//        if (Map.class.isAssignableFrom(parameterType)) {
//            checkState(data.queryMapIndex() == null, "Query map can only be present once.");
//            data.queryMapIndex(parameterIndex);
//
//            return true;
//        }
//
//        RequestPartParam requestPartParam = ANNOTATION.cast(annotation);
//        String name = requestPartParam.name();
//        checkState(emptyToNull(name) != null,
//                "RequestPartParam.name() was empty on parameter %s",
//                parameterIndex);
//        context.setParameterName(name);
//
//        data.formParams().add(name);
//
//        return true;
//    }
//}
