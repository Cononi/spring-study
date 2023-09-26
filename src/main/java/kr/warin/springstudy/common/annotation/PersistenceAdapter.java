package kr.warin.springstudy.common.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;


// 적용 대상 지정 : 클래스, 필드, 메서드, 열거형등 적용 범위 지정가능
@Target({ElementType.TYPE})
// 유지 정책 설정 : 해당 어노테이션이 어느 시점까지 유지되어야 하는지를 나타냄.
@Retention(RetentionPolicy.RUNTIME)
// Javadoc에 포함하도록 지정 : javadoc 문서에 포함되서 주석에 대한 정보를 볼 수 있음.
@Documented
@Component
public @interface PersistenceAdapter {
    @AliasFor(annotation = Component.class)
    String value() default "";

}
